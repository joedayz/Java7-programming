package com.domain;

import com.util.StringUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ShoppingCartJDBCImpl implements ShoppingCart {

    private Connection conn;
    private String url = "jdbc:derby://localhost:1527/ProductsDB";
    private String user = "public";
    private String pwd = "tiger";
    private int cartId;

    public ShoppingCartJDBCImpl(int cartId) {
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException se) {
            System.out.println("Error: " + se);
        }
        this.cartId = cartId;
    }

    // To add an item to the shopping cart:
    // 1. Determine if there is sufficient quantity of the item (SELECT)
    // 2. Decrement the quantity of Items by the number desired (UPDATE)
    // 3. Check if the Cart already has an Item with itemId (SELECT)
    // 4. If yes, add the quantity of items to this itemId in the Cart (UPDATE)
    // 5. Else, add the Item (new) to the Cart (INSERT)
    // Note, these could be done in a single stored procedure, but this code
    // is meant to illustrate transactions.
    @Override
    public void addItem(ItemOrder order) throws CartException {
        int itemId = order.getItemId();
        int quantity = order.getQuantity();
        int itemStock;
        int currCartOrder;
        try {
            // Start a transaction
            conn.setAutoCommit(false);
            // Get the current count of the desired item;
            itemStock = getItemQuantity(itemId);

            // Check if we have enough in stock
            // If not, rollback and return
            if (quantity > itemStock) {
                conn.rollback();
                throw new CartException("Quantity available of Item is less than number ordered");
            }

            // Decrement the available stock by the order amount
            itemStock -= quantity;
            updateItemQuantity(itemStock, itemId);

            // Check - does this item exist already in the cart?
            // -1 return means it does not exist
            currCartOrder = getCartItemQuantity(itemId);

            // If a result set is returned, there is an existing item in the cart
            if (currCartOrder > 0) {
                quantity += currCartOrder;
                // Update the item record in the cart with the new total
                updateCartQuantity(quantity, itemId);
            } else {
                // Add the Item to the cart with the given quantity
                addNewItemToCart(cartId, itemId, quantity);
            }

            // Success! Commit the transactions
            conn.commit();
        } catch (CartException | SQLException se) {
            // Any exception will result in rolling back the entire transaction
            try {
                System.out.println("Rolling back all transactions");
                conn.rollback();
            } catch (SQLException r) {
                throw new CartException("Exception in rollback: " + r.getMessage());
            }
            throw new CartException("addItem exception: " + se.getMessage());
        }
    }

    // Remove an item from a cart and put it back into inventory
    // 1. Select the quanity of the item in the Cart (SELECT)
    // 2. Remove the item from the Cart (DELETE)
    // 3. Read the current Item quantity (SELECT)
    // 4. Add the quantity from the cart to the item quanity (UPDATE)
    @Override
    public void removeItem(int itemId) throws CartException {
        int order;
        int itemStock;
        try {
            // Start a transaction
            conn.setAutoCommit(false);

            // Does the Cart contain any of this item?
            order = getCartItemQuantity(itemId);

            // Remove this item from the Cart
            removeItemFromCart(itemId);

            // Update the quantity of Items
            itemStock = getItemQuantity(itemId);
            itemStock += order;
            updateItemQuantity(itemId, itemStock);

            // Success! Commit the transactions
            conn.commit();
        } catch (CartException | SQLException se) {
            // Any exception is bad
            try {
                System.out.println("Rolling back all transactions");
                conn.rollback();
            } catch (SQLException r) {
                throw new CartException("Exception in rollback: " + r.getMessage());
            }
            throw new CartException("removeItem Exception: " + se.getMessage());
        }
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }

    @Override
    public String getCartContents() throws CartException {
        StringBuilder results = new StringBuilder();
        float cartTotal = 0;
        float unitPrice = 0;
        int quantity = 0;
        results.append("Card ID: ");
        results.append(cartId);
        results.append(" contents\n");
        results.append("Item id  Quantity  Description             Unit Price   Total Cost\n");
        results.append("-------  --------  -----------             ----------   ----------\n");
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT Cart.ItemId, Cart.Quantity, Item.Descrip, Item.Price FROM Cart INNER JOIN Item ON Item.ID=Cart.ITEMID WHERE Cart.ID=" + cartId)) {
            while (rs.next()) {
                results.append(rs.getInt("ItemId"));
                results.append("      ");
                quantity = rs.getInt("Quantity");
                results.append(quantity);
                results.append("         ");
                results.append(StringUtil.padRight(rs.getString("Descrip"), 24));
                unitPrice = rs.getFloat("Price");
                results.append(String.format("$%6.2f", unitPrice));
                results.append("      ");
                results.append(String.format("$%6.2f", unitPrice * quantity));
                cartTotal += quantity * unitPrice;
                results.append("\n");
            }
            results.append("                                               Total:   ");
            results.append(String.format("$%6.2f\n", cartTotal));
        } catch (SQLException se) {
            throw new CartException("Exception in listContents: " + se.getMessage());
        }
        return results.toString();
    }

    // SQL Methods
    private void removeItemFromCart(int itemId) throws SQLException, CartException {
        Statement s = conn.createStatement();
        if (s.executeUpdate("DELETE FROM Cart WHERE ItemId=" + itemId) != 1) {
            throw new CartException("Error in removeItemFromCart");
        }
    }

    private void updateCartQuantity(int quantity, int itemId) throws SQLException, CartException {
        try (PreparedStatement ps = conn.prepareStatement("UPDATE Cart SET Quantity=? WHERE ItemId=?")) {
            ps.setInt(1, quantity);
            ps.setInt(2, itemId);
            if (ps.executeUpdate() != 1) {
                throw new CartException("Error in updateCartQuantity");
            }
        }
    }

    private int getCartItemQuantity(int itemId) throws SQLException {
        try (Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT Quantity FROM Cart WHERE ID=" + cartId + " AND ITEMID=" + itemId)) {
            if (rs.next()) {
                return rs.getInt(1);
            } else {
                return -1;
            }
        }
    }

    private void addNewItemToCart(int cartID, int itemId, int quantity) throws SQLException, CartException {
        try (PreparedStatement ps = conn.prepareStatement("INSERT INTO Cart VALUES (?,?,?)")) {
            ps.setInt(1, cartId);
            ps.setInt(2, itemId);
            ps.setInt(3, quantity);
            if (ps.executeUpdate() != 1) {
                throw new CartException("Error in addNewItemToCart");
            }
        }
    }

    private int getItemQuantity(int itemId) throws SQLException {
        try (Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery("SELECT Quantity FROM Item WHERE ID=" + itemId)) {
            rs.next();
            return (rs.getInt(1));
        }
    }

    private void updateItemQuantity(int itemId, int quantity) throws SQLException, CartException {

        try (PreparedStatement ps = conn.prepareStatement("UPDATE Item SET Quantity=? WHERE ID=?")) {
            ps.setInt(1, quantity);
            ps.setInt(2, itemId);
            if (ps.executeUpdate() != 1) {
                throw new CartException("Error in updateItemQuantity");
            }
        }
    }
}
package com.example;

import com.domain.CartException;
import com.domain.ItemOrder;
import com.domain.ItemStock;
import com.domain.ItemStockJDBCImpl;
import com.domain.ShoppingCart;
import com.domain.ShoppingCartJDBCImpl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.sql.SQLException;
import java.text.ParseException;

public class ShoppingTestInteractive {

    public static void main(String[] args) {
        String action;
        int id;
        ItemOrder order;
        
        // A Factory Pattern: get an instance of a factory and use it to create
        // an instance of the Data Access Object (DAO) we want
        try (ShoppingCart cart = new ShoppingCartJDBCImpl(501);
             ItemStock stock = new ItemStockJDBCImpl()) {

            // Open the standard in
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                try {
                    System.out.println("\nOptions\n[S]how Items  [A]dd Item to Cart | [R]emove Item from Cart | [L]ist Cart | [Q]uit: ");
                    action = in.readLine();
                    if ((action.length() == 0) || action.toUpperCase().charAt(0) == 'Q') {
                        break;
                    }

                    switch (action.toUpperCase().charAt(0)) {
                        // Add an Item to the cart
                        case 'A':
                            try {
                                order = getItemOrder(in);
                                cart.addItem(order);
                                System.out.println("Successfully added " + order.getQuantity() + " of item " + order.getItemId() + " to cart.");
                            } catch (NumberFormatException | ParseException | CartException e) {
                                System.out.println("Exception adding item: " + e);
                            }
                            break;

                        // Remove item from the cart
                        case 'R':
                            System.out.print("Enter item id to remove: ");
                            try {
                                id = new Integer(in.readLine().trim());
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid Employee id: " + e);
                                break;
                            }

                            // Find this Employee record
                            try {
                                cart.removeItem(id);

                            } catch (CartException e) {
                                System.out.println("Exception removing item: " + id + " :" + e);
                            }

                            break;

                        // Update an existing employee record    
                        case 'S':
                            System.out.println("Available items in Stock:");
                            try {
                                System.out.println (stock.getItemList());
                            } catch (SQLException se) {
                                System.out.println("Exception getting Item list: " + se);
                            }
                            break;

                        // Display a list (Read the records) of Employees
                        case 'L':
                            try {
                                System.out.println (cart.getCartContents());
                            } catch (CartException e) {
                                System.out.println("Exception getting cart: " + e);
                            }
                            break;

                        default:
                            continue;
                    }
                } catch (IOException io) {
                    System.out.println("Error reading input, quiting.");
                    break;
                }
            }
        } catch (Exception e) {
            System.out.println("Error closing the connection to the database: " + e);
            System.exit(-1);
        }
    }

    public static ItemOrder getItemOrder (BufferedReader in) throws ParseException, IOException {
        return getItemOrder (in, null, true);
    }
    
    public static ItemOrder getItemOrder (BufferedReader in, ItemOrder existing, boolean newOrder) throws ParseException, IOException {
        int order;
        int itemId;
        if (newOrder) {
            System.out.println ("Enter the item number: ");
                        try {
                itemId = new Integer(in.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return null;
            }
        } else {
            itemId = existing.getItemId();
            System.out.println ("Modify the current quantity of item id: " + itemId);   
        }
        
        System.out.print ("How many of " + itemId + " do you want to order? ");
                    try {
                order = new Integer(in.readLine().trim());
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
                return null;
            }
        return new ItemOrder(itemId, order);
    }
}
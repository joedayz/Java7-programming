package com.example.domain;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 23L;
    private int cartId;
    private ArrayList<Item> items;
    private int itemCount;
    private transient double cartTotal;

    public ShoppingCart(int custID) {
        this.cartId = custID;
        items = new ArrayList<>();
        itemCount = 0;
        cartTotal = 0;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public int getCartId() {
        return cartId;
    }

    public void addItem(Item i) {
        if (items.add(i)) {
            cartTotal += i.getCost();
        }
    }

    public int getCartSize() {
        return items.size();
    }

    public List<Item> getItems() {
        return items;
    }

    // This method is only called during deserialization
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // Recalculate the total if the cart was deserialized
        if (cartTotal == 0 && (items.size() > 0)) {
            for (Item item : items) 
                cartTotal += item.getCost();
        }
        Date date = (Date)ois.readObject();
        System.out.println ("Restored Shopping Cart from: " + DateFormat.getDateInstance().format(date));
    }

    // This method is only called during serialization
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        oos.writeObject(new Date());
    }
}
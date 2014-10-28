package com.example.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Serializable {

    private static final long serialVersionUID = 23L;
    private int cartID;
    private ArrayList<Item> items;
    private int itemCount;
    private transient double cartTotal;

    public ShoppingCart(int custID) {
        this.cartID = custID;
        items = new ArrayList<>();
        itemCount = 0;
        cartTotal = 0;
    }

    public double getCartTotal() {
        return cartTotal;
    }

    public int getCartID() {
        return cartID;
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
}
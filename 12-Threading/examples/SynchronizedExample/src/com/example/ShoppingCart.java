package com.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ShoppingCart {

    private List<Item> cart = new ArrayList<>();

    public synchronized void addItem(Item item) {
        cart.add(item);
    }

    public synchronized void removeItem(int index) {
        cart.remove(index);
    }

    public synchronized void printCart() {
        Iterator<Item> ii = cart.iterator();
        while(ii.hasNext()) {
            Item i = ii.next();
            System.out.println("Item:" + i.getDescription());
        }
    }
    
//    public void printCart() {
//        StringBuilder sb = new StringBuilder();
//        synchronized (this) {
//            Iterator<Item> ii = cart.iterator();
//            while (ii.hasNext()) {
//                Item i = ii.next();
//                sb.append("Item:");
//                sb.append(i.getDescription());
//                sb.append("\n");
//            }
//        }
//        System.out.println(sb.toString());
//    }

}
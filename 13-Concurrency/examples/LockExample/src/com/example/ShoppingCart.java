package com.example;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ShoppingCart {
    private final ReentrantReadWriteLock rwl = 
        new ReentrantReadWriteLock();   
    
    public void addItem(Object o) {
        rwl.writeLock().lock();
        // modify shopping cart
        rwl.writeLock().unlock();
    }
     public String getSummary() {
        String s = "";
        rwl.readLock().lock();
        // read cart, modify s
        rwl.readLock().unlock();
        return s;
    }
    public double getTotal() {
        double total = 0;
        rwl.readLock().lock();
        // read cart, add everything to total
        rwl.readLock().unlock();
        return total;
    }
}
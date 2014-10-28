package com.domain;

public interface ShoppingCart extends AutoCloseable {
    public void addItem(ItemOrder order) throws CartException;
    public void removeItem(int itemId) throws CartException;
    public String getCartContents() throws CartException;
}

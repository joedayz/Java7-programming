package com.domain;

public class ItemOrder {
    private int itemId;
    private int quantity;
    
    public ItemOrder (int itemId, int quantity) {
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public int getItemId() {
        return itemId;
    }

    public int getQuantity() {
        return quantity;
    }
}

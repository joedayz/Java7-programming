package com.example.generics;

public class Shirt implements InventoryCount {

    private String id = "";
    private String description = "";
    private String color = "";
    private String size = "";
    private long count = 0;

    private Shirt() {
    }

    ;

    public Shirt(String id, String description, String color, String size) {
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public String getId() {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public String getColor() {
        return color;
    }

    public String getSize() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(256);
        sb.append("Shirt ID: ").append(this.getId()).append("\n");
        sb.append("Description: ").append(this.getDescription()).append("\n");
        sb.append("Color: ").append(this.getColor()).append("\n");
        sb.append("Size: ").append(this.getSize()).append("\n");
        sb.append("Inventory: ").append(this.getCount()).append("\n");

        return sb.toString();
    }

    @Override
    public long getCount() {
        return count;
    }

    @Override
    public void addItems(long count) {
        this.count = this.count + count;
    }

    @Override
    public void removeItems(long count) {
        if ((this.count - count) > 0) {
            this.count = this.count - count;
        } else {
            System.out.println("Negative inventory number error.");
        }
    }
}
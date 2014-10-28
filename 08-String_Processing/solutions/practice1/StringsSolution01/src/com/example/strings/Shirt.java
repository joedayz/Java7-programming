package com.example.strings;

public class Shirt {

    private String id = "";
    private String description = "";
    private String color = "";
    private String size = "";

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

        return sb.toString();
    }
}
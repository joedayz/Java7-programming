package com.example;

public class Shirt{

    private String id = "";
    private String description = "";
    private String color = "";
    private String size="";

    private Shirt() { };

    public Shirt (String id, String description, String color, String size){
        this.id = id;
        this.description = description;
        this.color = color;
        this.size = size;
    }

    public String getId(){
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
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Shirt ID: ");
        sb.append(getId());
        sb.append("\nDescription: ");
        sb.append(getDescription());
        sb.append("\nColor: ");
        sb.append(getColor());
        sb.append("\nSize: ");
        sb.append(this.getSize());
        sb.append("\n");

        return sb.toString();
    }
}
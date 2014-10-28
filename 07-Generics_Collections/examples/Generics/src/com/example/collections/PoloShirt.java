package com.example.collections;

public enum PoloShirt {
    Blue("1111", "Blue Cotton Polo"),
    Black("2222", "Black Cotton Polo"),
    Maroon("3333", "Maroon Cotton Polo");
    
    private final String partNumber;
    private final String description;
    
    private PoloShirt(String partNumber, String description){
        this.partNumber = partNumber;
        this.description = description;
    }
    public String getPartNumber(){ return this.partNumber; }
    public String getDescription(){ return this.description; }
}

package com.example;

public enum PowerState {

    OFF("The power is off"),
    ON("The usage power is high"),
    SUSPEND("The power usage is low");
    
    private String description;
    
    private PowerState(String d) {
        description = d;
    }
    
    public String getDescription() {
        return description;
    }
    
    @Override
    public String toString() {
        return getDescription();
    }
}
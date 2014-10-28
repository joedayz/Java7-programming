package com.example;

public class AmbulatoryImpl implements Ambulatory {

    private int legs;
    
    public AmbulatoryImpl(int legs) {
        this.legs = legs;
    }

    public void walk() {
        System.out.println("This animal walks on " + legs + " legs.");
    }
}

package com.example;

public class NameableImpl implements Nameable {

    private String name;
    
    @Override
    public void setName(String name) {
        if(name.length() < 20) {
            this.name = name;
        } else {
            System.out.println("Name too long");
        }
    }

    @Override
    public String getName() {
        return name;
    }
    
}
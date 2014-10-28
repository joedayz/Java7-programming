package com.example;

public class Fish extends Animal implements Pet {

    private Nameable nameable = new NameableImpl();

    @Override
    public void eat() {
        System.out.println("Fish eat pond scum.");
    }

    @Override
    public void setName(String name) {
        nameable.setName(name);
    }

    @Override
    public String getName() {
        return nameable.getName();
    }

    @Override
    public void play() {
        System.out.println("Just keep swimming.");
    }

}
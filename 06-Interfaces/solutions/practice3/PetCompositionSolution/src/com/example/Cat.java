package com.example;

public class Cat extends Animal implements Pet, Ambulatory {
    
    private Nameable nameable = new NameableImpl();
    private Ambulatory ambulatory;
    
    public Cat() {
        this("Fluffy");
    }
    
    public Cat(String name) {
        ambulatory = new AmbulatoryImpl(4);
        setName(name);
    }

    @Override
    public void eat() {
        System.out.println("Cats like to eat spiders and fish.");
    }

    @Override
    public String getName() {
        return nameable.getName();
    }

    @Override
    public void setName(String name) {
        nameable.setName(name);
    }

    @Override
    public void play() {
        System.out.println(getName() + " likes to play with string.");
    }

    @Override
    public void walk() {
        ambulatory.walk();
    }
    
}
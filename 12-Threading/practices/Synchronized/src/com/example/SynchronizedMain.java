package com.example;

public class SynchronizedMain {

    public static void main(String[] args) {
        Store store = Store.getInstance();
        store.addShirt(new Shirt("1", "Polo", "Rainbow", "Large"));
        
        PracticeThread p1 = new PracticeThread();
        PracticeThread p2 = new PracticeThread(); 
        p1.start();
        p2.start();
    }
}
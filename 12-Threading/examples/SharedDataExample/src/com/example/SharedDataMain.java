package com.example;

public class SharedDataMain {

    public static void main(String[] args) {
        ExampleRunnable r1 = new ExampleRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
        Thread t2 = new Thread(r1);
        t2.start();
    }
}
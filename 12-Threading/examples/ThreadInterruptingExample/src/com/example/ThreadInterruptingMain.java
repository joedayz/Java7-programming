package com.example;

public class ThreadInterruptingMain {

    public static void main(String[] args) {
        ExampleRunnable r1 = new ExampleRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
        // ...
        t1.interrupt();
    }
}
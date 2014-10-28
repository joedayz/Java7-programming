package com.example;

public class ThreadStoppingMain {

    public static void main(String[] args) {
        ExampleRunnable r1 = new ExampleRunnable();
        Thread t1 = new Thread(r1);
        t1.start();
        // ...
        r1.timeToQuit = true;
    }
}
package com.example;

public class ExampleRunnable implements Runnable {

    private int i;

    @Override
    public void run() {
        for (i = 0; i < 100; i++) {
            System.out.println("i:" + i);
        }
    }
}
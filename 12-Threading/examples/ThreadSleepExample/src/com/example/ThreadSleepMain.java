package com.example;

public class ThreadSleepMain {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            // What to do?
        }
        long time = System.currentTimeMillis() - start;
        System.out.println("Slept for " + time + " ms");
    }
}
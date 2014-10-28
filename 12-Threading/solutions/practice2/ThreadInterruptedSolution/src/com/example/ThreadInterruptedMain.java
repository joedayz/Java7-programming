package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadInterruptedMain {

    public static void main(String[] args) {
        Runnable r = new Counter();
        Thread t = new Thread(r);
        t.start();

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            br.readLine();
        } catch (IOException e) {}
        
        System.out.println("Thread is alive:" + t.isAlive() );
        t.interrupt();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        System.out.println("Thread is alive:" + t.isAlive());
    }
}
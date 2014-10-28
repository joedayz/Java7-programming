package com.example;

public class PracticeThread extends Thread {
    
    @Override
    public void run() {
        PurchasingAgent agent = new PurchasingAgent();
        agent.purchase();
    }
    
}
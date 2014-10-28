package com.example;


public class Car {
    private boolean running = false;
    private Engine engine = new Engine();
    
    private class Engine {
        public void start() {
            running = true;
        }
    }
    
    public void start() {
        engine.start();
    }
}
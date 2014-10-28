package com.example;

public class Television implements ElectronicDevice {

    public void turnOn() {
        changeChannel(1);
        initializeScreen();
    }
    public void turnOff() { }
    
    public void changeChannel(int channel) {}
    private void initializeScreen() {}
    
}
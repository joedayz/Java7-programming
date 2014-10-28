package com.example;

public class Computer extends ElectronicDevice {

    public static final int POWER_OFF = 0;
    public static final int POWER_ON = 1;
    public static final int POWER_SUSPEND = 2;
    
    private int powerState = POWER_OFF;
    
    @Override
    public void turnOn() {
        powerState = POWER_ON;
    }

    @Override
    public void turnOff() {
        powerState = POWER_OFF;
    }
    
    public void suspend() {
        powerState = POWER_SUSPEND;
    }
    
    public void setState(int state) {
        switch(state) {
            case POWER_OFF:
                turnOn();
                break;
            case POWER_ON:
                turnOff();
                break;
            case POWER_SUSPEND:
                suspend();
                break;
            
        }
    }
    
}
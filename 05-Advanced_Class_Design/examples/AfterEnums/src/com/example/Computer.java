package com.example;

import static com.example.PowerState.*;

public class Computer extends ElectronicDevice {
    
    private PowerState powerState = OFF;
    
    @Override
    public void turnOn() {
        powerState = ON;
    }

    @Override
    public void turnOff() {
        powerState = OFF;
    }
    
    public void suspend() {
        powerState = SUSPEND;
    }
    
    public void setState(PowerState state) {
        switch(state) {
            case OFF:
                turnOn();
                break;
            case ON:
                turnOff();
                break;
            case SUSPEND:
                suspend();
                break;
            
        }
    }
    
}
package com.example;

//enumeration pattern before Java 5
//can not use in a switch
public class PowerState {
    public static final PowerState OFF = new PowerState();
    public static final PowerState ON = new PowerState();
    public static final PowerState SUSPEND = new PowerState();
    
    private PowerState() {}
}
package com.example;

public class AmphibiousCar extends BasicCar implements MotorizedBoat, java.io.Serializable {

    @Override
    public void launch() {
        System.out.println("In the water, propeller engaged");
    }
    
}
package example;

public class Caller {
    
    public static void main(String[] args) {
    
        // ElectronicDevice dev = new ElectronicDevice();
        ElectronicDevice dev = new Television();
        dev.turnOn(); // all ElectronicDevices can be turned on

    }
}
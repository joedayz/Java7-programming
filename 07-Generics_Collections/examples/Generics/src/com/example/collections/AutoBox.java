package com.example.collections;

public class AutoBox {
    public static void main(String[] args){
        Integer intObject = new Integer(1);
        int intPrimitive = 2;
        
        Integer tempInteger;
        int tempPrimitive;
        
        tempInteger = new Integer(intPrimitive);
        tempPrimitive = (int) intObject.intValue();
        
        tempInteger = intPrimitive; // Auto unbox and box
        tempPrimitive = intObject;  // Auto unbox and box
        
        System.out.println("Integer: " + tempInteger + " int: " + tempPrimitive);
    }
}

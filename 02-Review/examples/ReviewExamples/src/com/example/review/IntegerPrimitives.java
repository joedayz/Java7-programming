package com.example.review;

public class IntegerPrimitives {

    public static void main(String args[]){
        
        byte b = 1;  // Range -128 to 127
        short s = 2; // Range -32,768 to 32,767
        int i = 1;   // Range -2,147,483,648 to 2,147,483,647
        long l = 11; 
        // Range -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        
        int decVal = 26; 	  // The number 26, in decimal
        int octVal = 032; 	  // The number 26, in octal
        int hexVal = 0x1a;	  // The number 26, in hexadecimal
        int binVal = 0b11010; // The number 26, in binary
        
        System.out.println("Values = " + decVal + " " + octVal + " " + 
                hexVal + " " + binVal);
    }
}

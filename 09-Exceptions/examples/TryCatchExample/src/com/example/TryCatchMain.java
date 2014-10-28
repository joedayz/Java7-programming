package com.example;

import java.io.FileInputStream;
import java.io.InputStream;

public class TryCatchMain {


    public static void main(String[] args) {
        
        try {
            System.out.println("About to open a file");
            InputStream in = new FileInputStream("missingfile.txt");
            System.out.println("File open");
        } catch (Exception e) {
            System.out.println("Something went wrong!");
        }
    }
}

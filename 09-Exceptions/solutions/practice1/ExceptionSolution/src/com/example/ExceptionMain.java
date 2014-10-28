package com.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ExceptionMain {

    public static void main(String[] args) {
        try {
            System.out.println("Reading from file:" + args[0]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("No file specified, quitting!");
            System.exit(1);
        }
        
        try (BufferedReader b = new BufferedReader(new FileReader(args[0]));) {
            String s = null;
            while((s = b.readLine()) != null) {
                System.out.println(s);
            }
        } catch(FileNotFoundException e) {
            System.out.println("File not found:" + args[0]);
            System.exit(1);
        } catch(IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
            System.exit(1);
        }
    }
}
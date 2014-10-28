package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FinallyExampleMain {

    public static void main(String[] args) {
        InputStream in = null;
        try {
            System.out.println("About to open a file");
            in = new FileInputStream("missingfile.txt");
            System.out.println("File open");
            int data = in.read();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e) {
                System.out.println("Failed to close file");
            }
        }
    }
}
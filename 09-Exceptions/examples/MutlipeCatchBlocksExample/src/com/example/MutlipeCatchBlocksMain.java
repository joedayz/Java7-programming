package com.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MutlipeCatchBlocksMain {

public static void main(String[] args) {
        try {
            System.out.println("About to open a file");
            InputStream in = new FileInputStream("missingfile.txt");
            System.out.println("File open");
            int data = in.read();
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getClass().getName());
            System.out.println("Quiting");
        } catch (IOException e) {
            System.out.println(e.getClass().getName());
            System.out.println("Quiting");
        }
    }
}
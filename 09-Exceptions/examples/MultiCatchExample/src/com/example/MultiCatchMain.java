package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MultiCatchMain {

    public static void main(String[] args) {
        System.out.println("About to open a file");
        try (InputStream in = 
                new FileInputStream("missingfile.tx");
                Scanner s = new Scanner(in);) {
            System.out.println("File open");
            int data = s.nextInt();
        } catch (NoSuchElementException|IOException e) {
            System.out.println(e.getClass().getName());
            System.out.println("Quiting");
        }
    }
}
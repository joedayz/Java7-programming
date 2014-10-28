package com.example;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ThrowsMain {

    public static void main(String[] args) {
        try {
            int data = readByteFromFile();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int readByteFromFile() throws IOException {
        try (InputStream in = new FileInputStream("a.txt")) {
            System.out.println("File open");
            return in.read();
        }
    }
}
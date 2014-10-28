package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KeyboardInput {

    public static void main(String[] args) {
        // Wrap the System.in InputStream with a BufferedReader to read
        // each line from the keyboard.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String s = "";
            // Read each input line and echo it to the screen.
            while (s != null) {
                System.out.print("Type xyz to exit: ");
                s = in.readLine().trim();
                System.out.println("Read: " + s);
                if (s.equals("xyz")) {
                    System.exit(0);
                }
            }
        } catch (IOException e) { // Catch any IO exceptions.
            System.out.println("Exception: " + e);
        }
    }
}
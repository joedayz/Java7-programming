package com.example;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestNodeStreams {

    public static void main(String[] args) {
        // Test the arguments - there should be two
        if (args.length < 2) {
            System.out.println("Usage: java TestNodeStreams file1 file2\nBoth file names are required.");
            System.exit(-1);
        }
        try (FileReader input = new FileReader(args[0]);
                FileWriter output = new FileWriter(args[1])) {

            char[] buffer = new char[128];
            int charsRead = 0;

            // read the first buffer
            charsRead = input.read(buffer);
            while (charsRead != -1) {
                // write buffer to the output file
                output.write(buffer, 0, charsRead);

                // read the next buffer
                charsRead = input.read(buffer);
            }
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        System.out.println("Success! Copied " + args[0] + " to " + args[1]);
    }
}
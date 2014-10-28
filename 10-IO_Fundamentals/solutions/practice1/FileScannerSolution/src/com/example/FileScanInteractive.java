package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class FileScanInteractive {

    // Count the number of occurences if the string Search in the String file name
    public int countTokens(String file, String search) throws IOException {
        int instanceCount = 0;
        // Chain a FileReader to a BufferedReader to a Scanner
        try (FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                Scanner s = new Scanner(br)) {
            s.useDelimiter("\\W");
            while (s.hasNext()) {
                if (search.equalsIgnoreCase(s.next().trim())) {
                    instanceCount++;
                }
            }
        } // try-with-resources will close the connections
        return instanceCount;
    }

    // Main method
    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ScanFileInteractive <file to search>");
            System.exit(-1);
        }
        // Save the file name as a string
        String file = args[0];

        // Create an instance of the ScanFileInteractive class
        FileScanInteractive scan = new FileScanInteractive();

        // Wrap the System.in InputStream with a BufferedReader to read
        // each line from the keyboard.
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            // Wrap the System.in InputStream with a BufferedReader to read
            // each line from the keyboard.
            String search = "";
            System.out.println("Searching through the file: " + file);
            while (true) {
                System.out.print("Enter the search string or q to exit: ");
                search = in.readLine().trim();
                if (search.equalsIgnoreCase("q")) {
                    break;
                }
                int count = scan.countTokens(file, search);
                System.out.println("The word \"" + search + "\" appears "
                        + count + " times in the file.");
            }
        } catch (IOException e) { // Catch any IO exceptions.
            System.out.println("Exception: " + e);
            System.exit(-1);
        }
    }
}
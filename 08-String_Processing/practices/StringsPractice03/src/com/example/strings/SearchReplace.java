package com.example.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplace {

    private String fileName = "gettys.html";

    public static void main(String[] args) {
        SearchReplace sr = new SearchReplace();
        sr.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String targetTag = "p";
            String replaceTag = "span";
            String attribute = "class";
            String value = "sentence";
            String line = "";
            int c = 1;
            // Create a Pattern object to match the entire line.

            while ((line = reader.readLine()) != null) {
                // Create a matcher
                // Find a match
                // Replace Start Tag
                // Replace End Tag
                // Replace the attribute
                // Reassemble the new line
                String newLine = "The newly created line goes here";
                System.out.printf("%3d %s\n", c, newLine);
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String replaceTag(String tag, String targetTag, String replaceTag) {
        // Your code here
        return "";
    }

    public String replaceAttribute(String tag, String attribute, String value) {
        // Your code here
        return "";
    }
}

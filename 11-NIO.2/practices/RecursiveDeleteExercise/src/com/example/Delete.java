package com.example;

public class Delete {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Delete <start path> <search string>");
            System.exit(-1);
        }

        // Create a PathMatcher instance using the second argument passed in

        // Check if the starting path is a file that matches the search string

        // else, this is a directory, so traverse the tree looking for this file to delete

    }
}
package com.example;

import com.example.util.DeleteFileTree;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;

public class Delete {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java Delete <start path> <search string>");
            System.exit(-1);
        }

        // Create a PathMatcher instance using the second argument passed in
        PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + args[1]);
        Path root = Paths.get(args[0]);

        // Check if the starting path is a file that matches the search string
        if (!Files.isDirectory(root)) {
            Path name = root.getFileName();
            if (name != null && matcher.matches(name)) {
                try {
                    Files.delete(root);
                    System.out.println("Deleted :" + root);
                    System.exit(0);
                } catch (IOException e) {
                    System.err.println("Exception deleting file: " + root);
                    System.err.println("Exception: " + e);
                    System.exit(-1);
                }
            }
        }

        // else, this is a directory, so traverse the tree looking for this file to delete
        DeleteFileTree deleter = new DeleteFileTree(root, matcher);
        try {
            Files.walkFileTree(root, deleter);
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
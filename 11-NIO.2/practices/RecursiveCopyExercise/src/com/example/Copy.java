package com.example;

import com.example.util.CopyFileTree;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Copy {

    public static void main(String[] args) {
        boolean overwrite = false;
        boolean prompt = false;
        // Check for the appropriate number of arguments
        if (args.length < 2) {
            error("Usage: java Copy <source directory> <target directory");
        } else if (args[0].equals(args[1])) {  // Check if the directories are different
            error("source and target cannot be the same directory");
        }

        // Check: do the directories exist?
        Path source = Paths.get(args[0]);
        Path target = Paths.get(args[1]);
        // Open the standard in for any prompts
        // If the source does not exist, that is an error
        if (Files.notExists(source)) {
            error("The source must exist: " + source);
        }

        // Check the second argument - if it is a relative path, make it absolute
        // and relative to the source
        if (!target.isAbsolute()) {
            Path base = source.subpath(0, source.getNameCount() - 1);
            target = Paths.get(source.getRoot().toString(), base.toString(), target.toString());
        }

        // If the source exists, we need more information about what to do
        if (Files.exists(target)) {
            try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {

                // Ask if we should overwrite the target
                System.out.print("Target directory exists. Overwrite existing files? (yes/no): ");
                String s = in.readLine().trim();
                if (!(s.equalsIgnoreCase("y") || s.equalsIgnoreCase("yes"))) {
                    error("Choose an empty target directory or file.");
                }
            } catch (IOException e) {
                error("Console I/O exception: " + e);
            }
        } else {
            // Create all of the directories needed for this copy
            try {
                target = Files.createDirectories(target);
            } catch (IOException e) {
                error("Exception creating target directory: " + e);
            }
        }

        // OK - recursively copy the source to the target
        // 
        CopyFileTree cft = new CopyFileTree(source, target);
        try {
            Files.walkFileTree(source, cft);
        } catch (IOException e) {
            error("WalkFileTree Exception: " + e);
        }
        System.out.println("Successfully copied " + source + " to " + target);

    }

    // This method writes the message to the standard out and then exits with an error
    public static void error(String message) {
        System.err.println(message);
        System.exit(-1);
    }
}
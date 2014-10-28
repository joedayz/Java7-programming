package com.example;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import static java.nio.file.StandardCopyOption.*;

public class CopyStream {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Usage: java CopyStream <URL> <file>");
            System.err.println("CopyStream copies a web page to a file.");
            System.exit(-1);
        }

        // Open the file to write to
        Path path = Paths.get(args[1]);
        URI u = URI.create(args[0]);
        try (InputStream in = u.toURL().openStream()) {
            Files.copy(in, path, REPLACE_EXISTING);
        } catch (IOException e) {
            System.err.println("Exception: " + e);
        }
    }
}
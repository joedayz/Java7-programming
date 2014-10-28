package com.example;

import com.example.util.PrintTree;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WalkFileTreeTest {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: WalkFileTreeTest <starting directory>");
            System.exit(-1);
        }
        Path path = Paths.get(args[0]);
        if (!Files.isDirectory(path)) {
            System.out.println(args[0] + " must be a directory!");
            System.exit(-1);
        }
        try {
            Files.walkFileTree(path, new PrintTree());
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
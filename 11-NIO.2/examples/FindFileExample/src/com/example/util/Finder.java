package com.example.util;

import java.nio.file.SimpleFileVisitor;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.*;

public class Finder extends SimpleFileVisitor<Path> {

    private Path file;
    private PathMatcher matcher;
    private int numMatches;

    public Finder(Path file, PathMatcher matcher) {
        this.file = file;
        this.matcher = matcher;
    }

    //Compares the glob pattern against the file or directory name.
    private void find(Path file) {
        Path name = file.getFileName();
        if (name != null && matcher.matches(name)) {
            numMatches++;
            System.out.println(file);
        }
    }

    //Prints the total number of matches to standard out.
    public void done() {
        System.out.println("Matched: " + numMatches);
    }

    //Invoke the pattern matching method on each file.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        find(file);
        return CONTINUE;
    }

    //Invoke the pattern matching method on each directory.
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        find(dir);
        return CONTINUE;
    }
}
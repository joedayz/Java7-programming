package com.example.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.*;

public class DeleteFileTree implements FileVisitor<Path> {

    private Path file;
    private PathMatcher matcher;
    private int numMatches;

    public DeleteFileTree(Path file, PathMatcher matcher) {
        this.file = file;
        this.matcher = matcher;
    }

    //Compares the glob pattern against the file or directory name.
    private void delete(Path file) {
        // Your code goes here
    }

    //Invoke the pattern matching method on each file.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        delete(file);
        return CONTINUE;
    }

    //Invoke the pattern matching method on each directory.
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.err.println(exc);
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }
}
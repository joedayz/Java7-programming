package com.example.util;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.FileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import static java.nio.file.FileVisitResult.*;

public class PrintTree implements FileVisitor<Path> {

    //Print information about the root path
    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attr) {
        System.out.print("preVisitDirectory: ");
        if (attr.isDirectory()) {
            System.out.format("Directory: %s ", dir);
        } else {
            System.out.format("Other: %s ", dir);
        }
        System.out.println("(" + attr.size() + " bytes)");
        return CONTINUE;
    }

    //Print information about each type of file.
    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
        System.out.print("visitFile: ");
        if (attr.isSymbolicLink()) {
            System.out.format("Symbolic link: %s ", file);
        } else if (attr.isRegularFile()) {
            System.out.format("Regular file: %s ", file);
        } else {
            System.out.format("Other: %s ", file);
        }
        System.out.println("(" + attr.size() + " bytes)");
        return CONTINUE;
    }

    //Print each directory visited.
    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        System.out.print("postVisitDirectory: ");
        System.out.format("Directory: %s%n", dir);
        return CONTINUE;
    }

    //If there is some error accessing the file, let the user know.
    //If you don't override this method and an error occurs, an IOException 
    //is thrown.
    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        System.out.print("vistiFileFailed: ");
        System.err.println(exc);
        return CONTINUE;
    }
}

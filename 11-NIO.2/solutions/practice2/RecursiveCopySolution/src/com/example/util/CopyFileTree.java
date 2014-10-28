package com.example.util;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Files;
import java.nio.file.Path;
import static java.nio.file.StandardCopyOption.*;
import static java.nio.file.FileVisitResult.*;
import java.nio.file.attribute.BasicFileAttributes;

public class CopyFileTree implements FileVisitor<Path> {

    private Path source;
    private Path target;

    public CopyFileTree(Path source, Path target) {
        this.source = source;
        this.target = target;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
        // Create a path in the target that is relative to the source
        Path newdir = target.resolve(source.relativize(dir));
        try {
            Files.copy(dir, newdir);
        } catch (FileAlreadyExistsException x) {
            // ignore
        } catch (IOException x) {
            System.err.format("Unable to create: %s: %s%n", newdir, x);
            return SKIP_SUBTREE;
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
        Path newdir = target.resolve(source.relativize(file));
        //CopyOption[] options = new CopyOption[]{REPLACE_EXISTING};
        try {
            Files.copy(file, newdir, REPLACE_EXISTING);
        } catch (IOException x) {
            System.err.format("Unable to copy: %s: %s%n", source, x);
        }
        return CONTINUE;
    }

    @Override
    public FileVisitResult postVisitDirectory(Path dir, IOException exc) {
        return CONTINUE;
    }

    @Override
    public FileVisitResult visitFileFailed(Path file, IOException exc) {
        if (exc instanceof FileSystemLoopException) {
            System.err.println("cycle detected: " + file);
        } else {
            System.err.format("Unable to copy: %s: %s%n", file, exc);
        }
        return CONTINUE;
    }
}
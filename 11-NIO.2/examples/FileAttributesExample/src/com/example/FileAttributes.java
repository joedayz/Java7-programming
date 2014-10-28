package com.example;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.FileTime;
import java.text.DateFormat;
import java.util.Date;

public class FileAttributes {

    public static void main(String[] args) {
        DosFileAttributes attrs = null;
        DateFormat df = DateFormat.getInstance();
        if (args.length < 1) {
            System.out.println("Usage: java FileAttributes <path>");
            System.exit(-1);
        }
        Path file = Paths.get(args[0]);
        try {
            attrs = Files.readAttributes(file, DosFileAttributes.class);
        } catch (IOException e) {
            System.out.println("Exception reading attributes of the file: " + e);
        }
        System.out.println(file);
        System.out.println("Creation time: " + toDate(attrs.creationTime()));
        System.out.println("Last Modified: " + toDate(attrs.lastModifiedTime()));
        System.out.println("Last Access:   " + toDate(attrs.lastAccessTime()));
        if (!attrs.isDirectory()) {
            System.out.println("Size (K Bytes):" + (attrs.size() / 1024));
        }
        System.out.println("DOS File information:");
        System.out.format("Archive: %b Hidden: %b ReadOnly: %b System File: %b%n",
                attrs.isArchive(), attrs.isHidden(), attrs.isReadOnly(), attrs.isSystem());
    }

    // Utility method to print a better formatted time stamp
    public static String toDate(FileTime ft) {
        return DateFormat.getInstance().format(new Date(ft.toMillis())).toString();
    }
}
package com.example;

import com.example.util.FileMerge;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FormLetterWriter {
    
    public static void main(String[] args) {
        Path form = null;
        Path list = null;
        // Make sure there are two arguments
        if (args.length < 2) {
            System.out.println("Usage: FormLetter <form template file> <name list file>");
            System.exit(-1);
        }
        // Check that the arguments are file names
        form = Paths.get(args[0]);
        list = Paths.get(args[1]);
        if (!Files.isRegularFile(form) || !Files.isRegularFile(list)) {
            System.out.println("Form template and Name list must be files");
            System.exit(-1);
        }
        // Create an instance of the FormLetter class and then write the forms
        FileMerge fm = new FileMerge(form, list);
        try {
            fm.writeMergedForms();
        } catch (IOException i) {
            System.out.println("Exception: " + i);
        }
    }
}
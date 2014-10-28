package com.example.strings;

import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args){
        PrintWriter pw = new PrintWriter(System.out, true);
        pw.println("This is some output.");
        
    }
}

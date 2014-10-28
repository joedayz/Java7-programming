package com.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanTest {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("ScanTest usage: java ScanTest file");
            System.exit(-1);
        }
        try (FileReader fr = new FileReader(args[0]);
                BufferedReader br = new BufferedReader(fr);
                Scanner s = new Scanner(br)) {
            s.useDelimiter("\\W");
            while (s.hasNext()) {
                System.out.println(s.next().trim());
            }
        } catch (IOException e) {
            System.out.println("Exception: " + e);
        }
    }
}
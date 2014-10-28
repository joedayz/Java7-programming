package com.example.strings;

import java.util.Scanner;

public class ScannerExample {

    public static void main(String[] args) {
        Scanner s = null;
        StringBuilder sb = new StringBuilder(64);
        String line01 = "1.1, 2.2, 3.3";
        float fsum = 0.0f;

        s = new Scanner(line01).useDelimiter(", ");
        try {
            while (s.hasNextFloat()) {
                float f = s.nextFloat();
                fsum += f;
                sb.append(f).append(" ");
            }
            System.out.println("Values found: " + sb.toString());
            System.out.println("FSum: " + fsum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        String line02 = "1 2 3 4";
        int sum = 0;
        sb.setLength(0);
        s = new Scanner(line02);
        try {
            while (s.hasNextInt()) {
                int i = s.nextInt();
                sum += i;
                sb.append(i).append(" ");
            }
            System.out.println("Values found: " + sb.toString());
            System.out.println("Sum: " + sum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

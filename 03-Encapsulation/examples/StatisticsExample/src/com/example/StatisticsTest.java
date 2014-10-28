package com.example;

public class StatisticsTest {

    public static void main(String[] args) {
        Statistics stats = new Statistics ();
        // Test edge cases also
        float avg0 = stats.average();
        float avg1 = stats.average(100);
        float avg2 = stats.average(100, 200);
        float avg3 = stats.average(100, 200, 300);
        float avg4 = stats.average(100, 200, 300, 400);
        float avg5 = stats.average(100, 200, 300, 400, 500);
        System.out.println("Average with no parameters: " + avg0);
        System.out.println("Average of 100 is: " + avg1);
        System.out.println ("Average of 100 and 200 is: " + avg2);
        System.out.println ("Average of 100, 200 and 300 is: " + avg3);
        System.out.println ("Average of 100, 200, 300 and 400 is: " + avg4);
        System.out.println ("Average of 100, 200, 300, 400 and 500 is: " + avg5);
    }
}
package com.example;

public class TestArgs {

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            System.out.println("args[" + i + "] is ’" + args[i] + "’");
        }
    }
}
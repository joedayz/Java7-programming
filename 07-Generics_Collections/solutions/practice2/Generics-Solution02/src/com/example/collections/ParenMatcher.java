package com.example.collections;

import java.util.ArrayDeque;
import java.util.Deque;

public class ParenMatcher {

    private Deque<Character> stack = new ArrayDeque<>();
    private char[] curLine;

    public boolean processLine(String line) {
        stack.clear();
        curLine = line.toCharArray();

        for (char c : curLine) {
            switch (c) {
                case '(':
                    stack.push(c);
                    break;
                case ')': {
                    if (stack.size() > 0) {
                        stack.pop();
                    } else {
                        return false;
                    }
                    break;
                }
            }
        }
        if (stack.size() > 0) {
            return false; // Missing match invalid expression
        } else {
            return true; //  
        }
    }

    public void processArray(String[] lines) {
        int count = 0;
        for (String line : lines) {
            if (this.processLine(line)) {
                System.out.println("Line " + count + " is valid");
            } else {
                System.out.println("Line " + count + " is invalid");
            }
            count++;
        }
    }

    public static void main(String[] args) {
        ParenMatcher pm = new ParenMatcher();
        String[] expressions = new String[4];

        expressions[0] = "if ((a == b) && (x != y));";
        expressions[1] = "if ((a == b) && (x != y)));";
        expressions[2] = "if ((firstName.equals(newFirstName) && (lastName.equals(newLastName));";
        expressions[3] = "if ((firstName.equals(newFirstName) && (lastName.equals(newLastName))));";

        pm.processArray(expressions);
    }
}

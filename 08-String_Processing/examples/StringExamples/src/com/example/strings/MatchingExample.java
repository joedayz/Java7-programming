package com.example.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MatchingExample { 
    public static void main(String[] args){
        String email = "george.washington@example.com";
    
        Pattern p1 = Pattern.compile("(\\S+?)\\.(\\S+?)\\@(\\S+)");
        Matcher m1 = p1.matcher(email);
        if (m1.find()){
            System.out.println("First: " + m1.group(1));
            System.out.println("Last: " + m1.group(2)); 
            System.out.println("Domain: " + m1.group(3)); 
            System.out.println("Everything Matched: " + m1.group(0));
        }
    }
}

package com.example.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GreedinessExample {
    public static void main(String[] args){
        String t = "Longlonglong ago, in a galaxy far far away.";
    
        Pattern p1 = Pattern.compile("ago.*far");
        Matcher m1 = p1.matcher(t);
        if (m1.find()) System.out.println("Found: " + m1.group());
        // Produces: ago, in a galaxy far far
        
        Pattern p2 = Pattern.compile("ago.*?far");
        Matcher m2 = p2.matcher(t);
        if (m2.find()) System.out.println("Found: " + m2.group());
        // Produces: ago, in a galaxy far
    }
}

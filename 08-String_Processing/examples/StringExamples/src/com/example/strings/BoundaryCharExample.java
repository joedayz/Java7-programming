package com.example.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BoundaryCharExample {    
    public static void main(String[] args){
        String t = "it was the best of times or it was the worst of times";
    
        Pattern p1 = Pattern.compile("^it.*?times");
        Matcher m1 = p1.matcher(t);
        if (m1.find()) System.out.println("Found: " + m1.group());
        
        Pattern p2 = Pattern.compile("\\sit.*times$");
        Matcher m2 = p2.matcher(t);
        if (m2.find()) System.out.println("Found: " + m2.group());
        
        Pattern p3 = Pattern.compile("\\bor\\b.{3}");
        Matcher m3 = p3.matcher(t);
        if (m3.find()) System.out.println("Found: " + m3.group());   
    }
}

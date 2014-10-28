package com.example.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BackReferencingExample {
    public static void main(String[] args){
        String header = "<h1>This is an H1</h1>";
    
        Pattern p1 = Pattern.compile("<(.*?)>(.*?)<(/\\1)>");
        Matcher m1 = p1.matcher(header);
        if (m1.find()){
            System.out.println("Opening tag : <" + m1.group(1) + ">");
            System.out.println("Tag contents: " + m1.group(2)); 
            System.out.println("Closing tag: <" + m1.group(3) + ">"); 
        }
    }
}

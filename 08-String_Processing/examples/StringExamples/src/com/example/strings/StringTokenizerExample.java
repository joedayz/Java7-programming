package com.example.strings;

import java.util.StringTokenizer;

public class StringTokenizerExample {
    public static void main(String[] args){
        String shirts = "Blue Shirt, Red Shirt, Black Shirt, Maroon Shirt";
        
        StringTokenizer st = new StringTokenizer(shirts, ", ");
        
        while(st.hasMoreTokens()){
            System.out.println(st.nextToken());
        }
    }
}

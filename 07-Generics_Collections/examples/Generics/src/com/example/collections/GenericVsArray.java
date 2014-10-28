package com.example.collections;

import java.util.ArrayList;
import java.util.List;

public class GenericVsArray {
    public static void main(String[] args){
        
        // Fails at RunTime - ArrayStore Exception
        Object[] objectArr = new Integer[1];
        objectArr[0] = "Don't add me bro";
        
        // Fails at compile time - Incompatible Types Error
        //List<Object> objectList = new ArrayList<Integer>();
        //objectList.add("Don't add me bro");
    }  
}

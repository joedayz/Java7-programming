package com.example.generics;

public class TestCacheAnyDiamond {
    
    public static void main(String args[]){
        //Generics
        CacheAny<String> myGenericMessage = new CacheAny<>(); 
        CacheAny<Shirt> myGenericShirt = new CacheAny<>(); 
 
        // Add data and print
        myGenericMessage.add("Save this for me"); // Generic            
        System.out.println("Message is: " + myGenericMessage.get());        
        
        myGenericShirt.add(Shirt.newShirt(1111, "Blue Shirt", "Blue", "Medium"));
        System.out.println("Shirt Type:" + myGenericShirt.get().toString());
    }
}

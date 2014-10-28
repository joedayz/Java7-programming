
package com.example.generics;

public class TestCacheObject {
    
    public static void main(String args[]){
        CacheString myMessage = new CacheString(); // Type specific
        CacheShirt myShirt = new CacheShirt();     // Type specific

        myMessage.add("Save this for me");
        
        // Print Message
        System.out.println("Message is: " + myMessage.get());
        
        
        myShirt.add(Shirt.newShirt(1111, "Blue Shirt", "Blue", "Medium"));
        System.out.println("Shirt Type:" + myShirt.get().toString());
        
    }
  
}

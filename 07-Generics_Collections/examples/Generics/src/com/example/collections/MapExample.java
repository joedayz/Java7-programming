package com.example.collections;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class MapExample {
    public static void main(String[] args){      
        Map <String, String> partList = new TreeMap<>();
        partList.put("S001", "Blue Polo Shirt");
        partList.put("S002", "Black Polo Shirt");
        partList.put("H002", "Duke Hat");
        
        partList.put("S002", "Black T-Shirt"); // Overwrite value
        Set<String> keys = partList.keySet();
        
        System.out.println("=== Part List ===");
        for (String key:keys){
            System.out.println("Part#: " + key + " " + partList.get(key));
        }
    }
}

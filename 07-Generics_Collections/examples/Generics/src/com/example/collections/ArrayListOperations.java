package com.example.collections;

import java.util.ArrayList;
import java.util.List;

public class ArrayListOperations {
    
  public static void main(String args[]){
    
    List<Integer> partList = new ArrayList<>(2);
    
    partList.add(new Integer(1111));
    partList.add(new Integer(2222));
    partList.add(new Integer(3333)); // Arraylist auto grows

    System.out.println("First Part: " + partList.get(0)); // First item

    partList.add(0, new Integer(5555)); // Insert an item by index
    
    partList.set(1, new Integer(6666));
    
    
    // Print List

    for (Integer partNumberObj:partList){
      int partNumber = partNumberObj; // Demonstrates autoboxing.
      System.out.println("Part number: " + partNumber);  
    } 
    
  }}


package com.example.collections;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class TestLocation {
    public static void main(String[] args){
        Set<Location> locationList = new TreeSet<>();
        locationList.addAll(Arrays.asList(Location.CzechRepublic, Location.Madagascar, Location.Russia));
        
        for(Location l:locationList){
            System.out.println(l.toString() + "--> Code = " + l.getCountry() + " Language = " + l.getLanguage());
        }
    }
}

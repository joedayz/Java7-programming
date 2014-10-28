package com.example.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class TestGrades {
    public void calcGpa(Collection<Grade> c){
        double sum = 0;
        for(Grade g:c){ sum += g.ordinal(); }
        
        System.out.println("GPA: " + sum / c.size());
        System.out.print("Grades [..");
        for(Grade g:c){ 
            System.out.print(g.toString() + "..");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args){
        TestGrades grader = new TestGrades();
        List<Grade> student1 = new ArrayList<>(5);
        student1.addAll(Arrays.asList(Grade.A, Grade.B, Grade.A, Grade.A, Grade.B));        grader.calcGpa(student1);   
    }  
}

package com.example;

public class Statistics {

    public float average(int... nums) {
        int sum = 0;
        float result = 0;
        if (nums.length > 0) {
            for (int x : nums) {  // iterate int array nums
                sum += x;
            }
            result = (float) sum / nums.length;
        }
        return (result);
    }
}
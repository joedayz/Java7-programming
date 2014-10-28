package com.example;


public class AnonymousExampleClass {
    public Object o = new Object() {
        @Override
        public String toString() {
            return "In an anonymous class method";
        }
    };  
}
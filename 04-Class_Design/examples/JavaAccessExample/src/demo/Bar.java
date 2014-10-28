package demo;

import test.Foo;

public class Bar extends Foo {
    private int sum = 10;
    public void reportSum() {
        sum += result;
        sum += value;  // compiler error
    }
}
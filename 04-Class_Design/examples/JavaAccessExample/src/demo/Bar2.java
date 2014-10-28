package demo;

import test.Foo2;

public class Bar2 extends Foo2 {
    private int sum = 10;
    private int result = 30;
    public void reportSum() {
        sum += result;
    }
}
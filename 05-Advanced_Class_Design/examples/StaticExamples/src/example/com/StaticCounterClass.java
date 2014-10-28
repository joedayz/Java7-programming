
package example.com;

public class StaticCounterClass {    
    private static int counter = 0;
    
    {
        System.out.println("Building");
    }
    
    public StaticCounterClass() {
        counter++;
    }
    
    public static int getCount() {
        return counter;
    }
}
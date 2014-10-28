package example.com;

public class StaticCallerClass {

    public static void main(String[] args) {
        double d = Math.random();
        StaticUtilityClass.printMessage();
        StaticUtilityClass sm = new StaticUtilityClass();
        sm.printMessage(); // works but misleading
        sameClassMethod();

        double p = Math.PI;

        new StaticCounterClass();
        new StaticCounterClass();
        System.out.println("count: " + StaticCounterClass.getCount());
    }

    public static void sameClassMethod() {
        System.out.println("running within StaticClaller");
    }
}
package com.example.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomCharClassExamples {
    public static void main(String[] args) {
        String t = "It was the best of times";

        Pattern p1 = Pattern.compile("w.s");
        Matcher m1 = p1.matcher(t);
        if (m1.find()) { System.out.println("Found: " + m1.group());
        }

        Pattern p2 = Pattern.compile("w[abc]s");
        Matcher m2 = p2.matcher(t);
        if (m2.find()) { System.out.println("Found: " + m2.group());
        }

        Pattern p3 = Pattern.compile("t[^eou]mes");
        Matcher m3 = p3.matcher(t);
        if (m3.find()) { System.out.println("Found: " + m3.group());
        }
    }
}

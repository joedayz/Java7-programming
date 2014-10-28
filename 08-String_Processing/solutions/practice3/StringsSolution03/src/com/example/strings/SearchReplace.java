package com.example.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SearchReplace {

    private String fileName = "gettys.html";

    public static void main(String[] args) {
        SearchReplace sr = new SearchReplace();
        sr.run();
    }

    public void run() {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String targetTag = "p";
            String replaceTag = "span";
            String attribute = "class";
            String value = "sentence";
            String line = "";
            int c = 1;
            Pattern pattern1 = Pattern.compile("(<" + targetTag + ".*?>)(.*?)(</" + targetTag + ".*?>)");

            while ((line = reader.readLine()) != null) {
                Matcher m = pattern1.matcher(line);
                if (m.find()) {
                    String newStart = replaceTag(m.group(1), targetTag, replaceTag);
                    newStart = replaceAttribute(newStart, attribute, value);
                    String newEnd = replaceTag(m.group(3), targetTag, replaceTag);

                    String newLine = newStart + m.group(2) + newEnd;
                    System.out.printf("%3d %s\n", c, newLine);
                }
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String replaceTag(String tag, String targetTag, String replaceTag) {
        Pattern p = Pattern.compile(targetTag);  // targetTag is regex
        Matcher m = p.matcher(tag);  // tag is text to replace
        if (m.find()) {
            return m.replaceFirst(replaceTag); // swap target with replace
        }
        return targetTag;
    }

    public String replaceAttribute(String tag, String attribute, String value) {
        Pattern p = Pattern.compile(attribute + "=" + "\".*?\"");  // targetTag is regex
        Matcher m = p.matcher(tag);  // tag is text to replace
        if (m.find()) {
            return m.replaceFirst(attribute + "=" + "\"" + value + "\"");
        }
        return tag;
    }
}

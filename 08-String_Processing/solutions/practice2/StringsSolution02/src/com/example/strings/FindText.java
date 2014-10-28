package com.example.strings;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindText {

    private String fileName = "gettys.html";
    private Pattern pattern;
    private Matcher m;

    public static void main(String[] args) {
        FindText find = new FindText();
        find.execute();
    }

    public void execute() {
        // pattern = Pattern.compile("<h4>");        
        // pattern = Pattern.compile("\\bto\\b");
        // pattern = Pattern.compile("class=\"line\"");
        // pattern = Pattern.compile("\\{.*?\\}");
        // pattern = Pattern.compile("^<[p|d]");
        pattern = Pattern.compile("^</.*?>$");


        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            int c = 1;
            while ((line = reader.readLine()) != null) {
                m = pattern.matcher(line);
                if (m.find()) {
                    System.out.println(" " + c + "  " + line);
                }
                c++;
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.example.strings;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {
    public static void main(String[] args) {

        Properties myProps = new Properties();
        try {
            FileInputStream fis = new FileInputStream("ServerInfo.properties");
            myProps.load(fis);
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        // Print Values
        System.out.println("Server: " + myProps.getProperty("hostName"));
        System.out.println("User: " + myProps.getProperty("userName"));
        System.out.println("Password: " + myProps.getProperty("password"));
    }
}

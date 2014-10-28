package com.example;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class CallableStatementTest {

    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/EmployeeDB";
        String username = "public";
        String password = "tiger";
        String input = "";
        int searchValue;
        int count = 0;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try (Connection con = DriverManager.getConnection(url, username, password)) {
            CallableStatement cStmt = con.prepareCall("{CALL EmplAgeCount (?, ?)}");
            // Loop 
            while (true) {
                System.out.print("Enter age of Employees to search for or Q to quit: ");
                input = in.readLine();
                if (input.equals("q") || input.equals("Q")) {
                    break;
                }
                searchValue = Integer.valueOf(input);
                cStmt.setInt(1, searchValue);
                cStmt.registerOutParameter(2, Types.INTEGER);
                boolean result = cStmt.execute();
                count = cStmt.getInt(2);
                System.out.println("There are " + count + " Employees over the age of " + searchValue);
            }// end of while
        } catch (NumberFormatException n) {
            System.out.println("Please enter a valid number.");
        } catch (IOException | SQLException e) {
            System.out.println("SQLException: " + e);
        } // end of try-with-resources
    }
}
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author tmcginn
 */
public class ResultSetMetaData {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/EmployeeDB";
        String username = "public";
        String password = "tiger";
        String query = "SELECT * FROM Employee";
        try (Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query)){

            // Use the ResultSetMetaData to read this table's information
            int numCols = rs.getMetaData().getColumnCount();
            String [] colNames = new String[numCols];
            String [] colTypes = new String[numCols];
            for (int i= 0; i < numCols; i++) {
                colNames[i] = rs.getMetaData().getColumnName(i+1);
                colTypes[i] = rs.getMetaData().getColumnTypeName(i+1);
            }
            System.out.println ("Number of columns returned: " + numCols);
            System.out.println ("Column names/types returned: ");
            for (int i = 0; i < numCols; i++) System.out.println (colNames[i] + " : " + colTypes[i]);
        } catch (SQLException se) {
            System.out.println ("Exception: " + se);
        }
    }
}
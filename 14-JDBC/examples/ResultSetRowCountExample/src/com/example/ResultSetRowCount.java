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
public class ResultSetRowCount {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/EmployeeDB";
        String username = "public";
        String password = "tiger";
        String query = "SELECT * FROM Employee";
        try (Connection con = DriverManager.getConnection(url, username, password);
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            ResultSet rs = stmt.executeQuery(query)){
            
           System.out.println (rowCount(rs) + " rows returned from the query.");
           
        } catch (SQLException se) {
            System.out.println ("Exception: " + se);
        }
    }
    
    // If the RowSet is not scrollable, a SQLException will be thrown
    public static int rowCount(ResultSet rs) throws SQLException{
        int rowCount = 0;
        // Keep track of the current row
        int currRow = rs.getRow();
        // if this is an invalid RowSet, return an error message
        if (!rs.last()) return -1;     
        rowCount = rs.getRow();
        // Return the cursor to the current position, or before the first row
        if (currRow == 0) rs.beforeFirst();
        else rs.absolute(currRow);
        return rowCount;
    }
}

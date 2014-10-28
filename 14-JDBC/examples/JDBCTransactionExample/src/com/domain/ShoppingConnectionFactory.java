package com.domain;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ShoppingConnectionFactory implements AutoCloseable {

    private static Connection conn = null;
    private static String url = "jdbc:derby://localhost:1527/ProductsDB";
    private static String user = "public";
    private static String pwd = "tiger";

    private ShoppingConnectionFactory() {
    }

    public static Connection getConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(url, user, pwd);
            } catch (SQLException se) {
                System.out.println("Error opening connection with the database: " + se);
            }
        }
        return conn;
    }

    @Override
    public void close() throws Exception {
        conn.close();
    }
}
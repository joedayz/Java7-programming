package com.domain;

import com.util.StringUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ItemStockJDBCImpl implements ItemStock {

    private Connection conn;
    private String url = "jdbc:derby://localhost:1527/ProductsDB";
    private String user = "public";
    private String pwd = "tiger";

    public ItemStockJDBCImpl() {
        try {
            conn = DriverManager.getConnection(url, user, pwd);
        } catch (SQLException se) {
            System.out.println("Error: " + se);
        }

    }

    public String getItemList() throws SQLException {
        StringBuilder results = new StringBuilder();
        results.append("Item id  Description             Price      In Stock\n");
        results.append("-------  -----------             -----      --------\n");
        try (Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("SELECT * FROM Item")) {
            while (rs.next()) {
                results.append(rs.getInt("Id"));
                results.append("      ");
                results.append(StringUtil.padRight(rs.getString("Descrip"), 24));
                results.append(String.format("$%6.2f", rs.getFloat("Price")));
                results.append("    ");
                results.append(rs.getInt("Quantity"));
                results.append("\n");
            }
            return results.toString();
        }
    }

    @Override
    public void close() throws SQLException {
        conn.close();
    }
}

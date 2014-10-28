package test;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.NumberFormat;
import java.util.Date;
import javax.sql.rowset.JdbcRowSet;
import javax.sql.rowset.RowSetProvider;

public class SimpleJDBCRowSetExample {

    public static void main(String[] args) {
        String url = "jdbc:derby://localhost:1527/EmployeeDB";
        String username = "public";
        String password = "tiger";

        try (JdbcRowSet jdbcRs = RowSetProvider.newFactory().createJdbcRowSet()) {

            jdbcRs.setUrl(url);
            jdbcRs.setUsername(username);
            jdbcRs.setPassword(password);

            jdbcRs.setCommand("SELECT id, firstname, lastname, birthdate, salary FROM Employee ORDER BY lastname");
            jdbcRs.execute();

            // Now just treat JDBC Row Set like a ResultSet object
            while (jdbcRs.next()) {
                int empID = jdbcRs.getInt("ID");
                String first = jdbcRs.getString("FIRSTNAME");
                String last = jdbcRs.getString("LASTNAME");
                Date birthDate = jdbcRs.getDate("BIRTHDATE");
                float salary = jdbcRs.getFloat("SALARY");
                System.out.println("Employee ID:   " + empID + "\n"
                        + "Employee Name: " + first.trim() + " " + last.trim() + "\n"
                        + "Birth Date:    " + DateFormat.getDateInstance(DateFormat.MEDIUM).format(birthDate) + "\n"
                        + "Start Date:    " + NumberFormat.getCurrencyInstance().format(salary));
            }

        } catch (SQLException s) {
            System.out.println("SQL Exception: " + s);
        }
    }
}
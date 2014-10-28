// Note: to create a JAR file of this class, perform a Clean and Build
// Then copy the DerbyStoredProcedure.jar file from the dist folder in the
// project file to a location where you will tell Derby to find it: i.e:
// D:\Temp
//
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;

public class DerbyStoredProcedure {

    public static void countAge(int age, int[] count) throws SQLException {
        String url = "jdbc:default:connection";
        Connection con = DriverManager.getConnection(url);
        String query = "SELECT COUNT(DISTINCT ID) " +
                       "AS count FROM Employee " +
                       "WHERE Birthdate <= ?";
        PreparedStatement ps = con.prepareStatement(query);
        // Create an instance of today (now) and subtract the age in years from the date
        Calendar now = Calendar.getInstance();
        now.add(Calendar.YEAR, (age * -1));
        Date past = new Date(now.getTimeInMillis());
        ps.setDate(1, past);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            count[0] = rs.getInt(1);
        } else {
            count[0] = 0;
        }
        con.close();
    }
}

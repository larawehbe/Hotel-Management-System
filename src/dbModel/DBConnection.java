package dbModel;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static Connection con = null;

    private DBConnection() {}
    public static Connection getConnection() {
        if (con == null) {
            String jdbcD = "com.mysql.jdbc.Driver";
            try {
                Class.forName(jdbcD);
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel_db", "root", "");
                return con;
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }


        }
        return con;
    }
}

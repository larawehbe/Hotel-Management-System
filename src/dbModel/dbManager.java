package dbModel;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class dbManager {
public int  verifylogin(String uname, String pass) {
    Connection con = DBConnection.getConnection();
    String query = "Select username,pass from hotel_db.employee where FK_RoleID = 1";
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery(query);
        while (rs.next()) {
            if (rs.getString(1).compareTo(uname) == 0 && rs.getString(2).compareTo(pass) == 0) {
                return 1;
            }
        }
        return 0;
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return 0;
}}

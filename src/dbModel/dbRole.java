package dbModel;

import User.role;

import java.sql.*;
import java.util.ArrayList;

public class dbRole {
    Connection con = DBConnection.getConnection();
    public void addRole(String name,String salary){
        try {
            PreparedStatement stmt = con.prepareStatement("insert into role( RoleName, Salary) values (?,?)");
            stmt.setString(1,name);
            stmt.setString(2,salary);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void Delete(int id){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from role where RoleID =" +id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void update(int id,String name,String salary){
        try {
            PreparedStatement stmt = con.prepareStatement("update role set RoleName=?,Salary=? where RoleID = "+id);
            stmt.setString(1,name);
            stmt.setString(2,salary);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public ArrayList<role> getAllRoles(){
        ArrayList<role> data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from role");
            while(rs.next()){
                role current = new role();
                current.setRoleid(rs.getInt(1));
                current.setRolename(rs.getString(2));
                current.setSalary(rs.getString(3));
                data.add(current);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

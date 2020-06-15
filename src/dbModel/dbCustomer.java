package dbModel;

import User.*;
import sample.Main;

import java.sql.*;
import java.util.ArrayList;

public class dbCustomer {
    Connection con = DBConnection.getConnection();
    public int  verifylogin(String uname, String pass) {
        Connection con = DBConnection.getConnection();
        String query = "Select username,pass from customer";
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
    }
    public void delete(int id){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from customer where CustomerID =" + id);
            customer current = new customer();
            current.setId(id);
            manager mg = new manager();
            mg.deleteCustomer(current);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void update(int id, String fname,String lname, String city, String gender,String phone,String username,String password){
        try {
            PreparedStatement stmt = con.prepareStatement("UPDATE customer set FirstName=?, LastName=?,gender=?,city=?,phone=?,username=?,pass=? where CustomerID="+ id);
            stmt.setString(1,fname);
            stmt.setString(2,lname);
            stmt.setString(3,gender);
            stmt.setString(4,city);
            stmt.setString(5,phone);
            stmt.setString(6,username);
            stmt.setString(7,password);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<customer> getAllCustReview(){
        ArrayList<customer> final_data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer");
            while(rs.next()) {
                customer current_customer = new customer();
                current_customer.setId(rs.getInt(1));
                current_customer.setFname(rs.getString(2));
                current_customer.setLname(rs.getString(3));
                current_customer.setPhone(rs.getString(4));
                current_customer.setCity(rs.getString(5));
                current_customer.setUsername(rs.getString(6));
                current_customer.setPassword(rs.getString(7));
                current_customer.setGender(rs.getString(8));
                final_data.add(current_customer);
            }
            return final_data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  null;
    }
    public void addCustomer(String fname,String lname, String city, String gender,String phone){
        try {
            PreparedStatement stmt = con.prepareStatement("insert into customer( firstname, lastname, phone, city, username, pass, gender) values(?,?,?,?,?,?,?)");
            stmt.setString(1,fname);
            stmt.setString(2,lname);
            stmt.setString(3,phone);
            stmt.setString(4,city);
            stmt.setString(5, fname + Main.c);
            stmt.setString(6,fname + Main.c);
            stmt.setString(7,gender);
            stmt.execute();
            Main.c++;

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

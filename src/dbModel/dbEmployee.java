package dbModel;

import User.employee;
import User.manager;
import User.receptionist;
import sample.Main;

import java.sql.*;
import java.util.ArrayList;

public class dbEmployee {
    Connection con = DBConnection.getConnection();
    manager mg = new manager();
    public int  verifylogin(String uname, String pass) {
        Connection con = DBConnection.getConnection();
        String query = "Select username,pass from employee where FK_ROLEID = 2";
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
    public void add_employee(String fname, String lname, String gender, String age, String phone, String city, String workhours, String roleid, String hotelid, Date bday){

        try {
            PreparedStatement stmt = con.prepareStatement("insert into employee (FirstName, LastName, Age, WorkHours, phone, city, username, pass, birthdate, gender, FK_RoleID, FK_HotelID) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)");
            stmt.setString(1,fname);
            stmt.setString(2,lname);
            stmt.setInt(3, Integer.parseInt(age));
            stmt.setInt(4, Integer.parseInt(workhours));
            stmt.setInt(5, Integer.parseInt(phone));
            stmt.setString(6,city);
            stmt.setString(7, fname);
            stmt.setString(8,fname);
            stmt.setDate(9,bday);
            stmt.setString(10,gender);
            stmt.setInt(11, Integer.parseInt(roleid));
            stmt.setInt(12, 1);
            if (Integer.parseInt(roleid) == 2){
                receptionist r = new receptionist();
                r.assignDetails(fname,lname,phone,city,Main.c+fname,Main.c+fname,age,workhours,hotelid, String.valueOf(bday));

                mg.addReceptionist(mg);
            }
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<employee> getAllEmpReview(){
        ArrayList<employee> final_data = new ArrayList<>();
        Connection con = DBConnection.getConnection();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs =stmt.executeQuery("SELECT * FROM employee");
            while(rs.next()){
                employee current_employee = new employee();
                current_employee.setId(rs.getInt(1));
                current_employee.setLname(rs.getString(3));
                current_employee.setAge(rs.getString(4));
                current_employee.setWorkhours(rs.getString(5));
                current_employee.setPhone(rs.getString(6));
                current_employee.setCity(rs.getString(7));
                current_employee.setUsername(rs.getString(8));

                current_employee.setBday(rs.getString(10));
                current_employee.setGender(rs.getString(11));
                current_employee.setHotelid(rs.getString(13));
                current_employee.setPassword(rs.getString(9));
                current_employee.setFname(rs.getString(2));
                current_employee.setRoleid(rs.getString(12));
                final_data.add(current_employee);
            }

            return final_data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;

    }
    public void update(int id,String fname, String lname, String gender, String age, String phone, String city, String workhours, String username, String password, String roleid, String hotelid,String bday) {
        try {
            PreparedStatement stmt = con.prepareStatement("update employee set FirstName=? , LastName=? , Age =? , WorkHours = ? , city = ?  , phone = ? ,username=? , pass=? , birthdate=?, gender=? , FK_HotelID=? , FK_RoleID=?  where EmployeeID=" + id);
            stmt.setString(1, fname);
            stmt.setString(2, lname);
            stmt.setInt(3, Integer.parseInt(age));
            stmt.setInt(4, Integer.parseInt(workhours));
            stmt.setString(5, city);
            stmt.setInt(6, Integer.parseInt(phone));
            stmt.setString(7, username);
            stmt.setString(8, password);
            stmt.setDate(9, Date.valueOf(bday));
            stmt.setString(10, gender);
            stmt.setInt(11, Integer.parseInt(roleid));
            stmt.setInt(12, Integer.parseInt(hotelid));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("DELETE from employee where EmployeeID=" + id);
            receptionist r = new receptionist();
            r.setId(id);
            mg.deleteReceptionist(r);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}




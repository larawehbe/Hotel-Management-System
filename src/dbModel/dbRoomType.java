package dbModel;

import User.RoomType_Model;

import java.sql.*;
import java.util.ArrayList;

public class dbRoomType {
    Connection con = DBConnection.getConnection();
    public void add(String category,String description){
        try {
            PreparedStatement stmt = con.prepareStatement("inserT INTO roomtype (category,description) VALUES (?,?)");

            stmt.setString(1,category);
            stmt.setString(2,description);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<String> getAllCategories(){
        ArrayList<String> data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from roomtype");
            while(rs.next()){
                data.add(rs.getString(2));
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }

    public ArrayList<RoomType_Model> getAllRoomTypes(){
        ArrayList<RoomType_Model> data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from roomtype");
            while(rs.next()){
                RoomType_Model current = new RoomType_Model();
                current.setId(rs.getInt(1));
                current.setCategory(rs.getString(2));
                current.setDescription(rs.getString(3));

                data.add(current);
            }
            return data;
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }
    public void update(int id, String description, String category){
        try {
            PreparedStatement stmt = con.prepareStatement("update roomtype set category=? , Description=? where RTypeID ="+ id);
             stmt.setString(2,description);
            stmt.setString(1,category);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void delete(int id){
        try {
            PreparedStatement stmt = con.prepareStatement("delete from roomtype where RTypeID=" + id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

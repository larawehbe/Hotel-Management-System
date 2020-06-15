package dbModel;

import User.reservation;
import User.room;
import com.sun.org.apache.bcel.internal.classfile.StackMapType;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;

public class dbRoom {
Connection con = DBConnection.getConnection();
public void ReserveRoom(int id){
    try {
        PreparedStatement stmt = con.prepareStatement("update rooms set status = 1 where RoomID = " + id);
        stmt.executeUpdate();

    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public ArrayList<room> getAllFreeRooms(){
    ArrayList<room> data = new ArrayList<>();

    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("Select * from rooms where status=0");
        while(rs.next()){
            room current = new room();
            current.setRoomid(rs.getInt(1));
            current.setRate(rs.getString(2));
            current.setRoomCost(rs.getString(3));
            current.setStatus(rs.getString(4));
            current.setFeatures(rs.getString(6));
            current.setNbofbeds(Integer.parseInt(rs.getString(5)));
            current.setHotelid(Integer.parseInt(rs.getString(7)));
            current.setPlace(rs.getString(8));
            data.add(current);
        }return data;
    } catch (SQLException e) {
        e.printStackTrace();
    }return null;
}
public ArrayList<room> getAllRooms() throws SQLException {
ArrayList<room> data = new ArrayList<>();
    try {
        Statement stmt = con.createStatement();
        ResultSet rs = stmt.executeQuery("select * from rooms");
        while(rs.next()) {
        room current = new room();
        current.setRoomid(rs.getInt(1));
        current.setRate(rs.getString(2));
        current.setRoomCost(   rs.getString(3));
        current.setStatus(rs.getString(4));
        current.setFeatures(rs.getString(6));
        current.setNbofbeds(rs.getInt(5));
        current.setHotelid(rs.getInt(7));
        current.setPlace(rs.getString(8));
        data.add(current);
        }
        return data;
    } catch (SQLException e) {
        e.printStackTrace();
    }return null;
}

public  void addRoom(String rate,String place,String cost,String status,String features,String beds,String hotelid){
    try {
        PreparedStatement stmt=con.prepareStatement("insert into rooms(rate, roomcost, status, FK_RTypeID, nbofbeds, fk_hotelid, Location)values (?,?,?,?,?,?,?)");
        stmt.setString(1,rate);
        stmt.setString(2,cost);
        stmt.setString(3,status);
        stmt.setString(4,features);
        stmt.setString(5,beds);
        stmt.setString(6,hotelid);
        stmt.setString(7,place);
        stmt.execute();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void Delete(int id){
    try {
        Statement stmt = con.createStatement();
        stmt.executeUpdate("delete from rooms where RoomID = "+id);
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
public void update(String id, String rate, String place, String cost, String status, int beds, String feature, int hotelid){
    try {
        PreparedStatement stmt = con.prepareStatement("update rooms set Rate=?,Location=?,RoomCost=?,status=?,NbOfBeds=?,FK_RTypeID=?,FK_HotelID=? where RoomID = "+ id);
        stmt.setString(1,rate);
        stmt.setString(2,place);
        stmt.setString(3,cost);
        stmt.setString(4,status);
        stmt.setString(5, String.valueOf(beds));
        stmt.setString(6,feature);
        stmt.setString(7, String.valueOf(hotelid));
        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}}



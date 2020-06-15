package dbModel;

import User.invoice_model;
import User.*;

import java.sql.*;
import java.util.ArrayList;

public class dbReservation {
    Connection con = DBConnection.getConnection();
    public ArrayList<invoice_model> getCustReservations(int id , int resid){
        ArrayList<invoice_model> final_data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select checkin,checkout,date,period,FK_RoomID , RoomCost from reservation  join  hotel_db.rooms on reservation.FK_RoomID = rooms.RoomID  where FK_CustID = " + id +" and ReservationID =" + resid);
            while(rs.next()) {
                invoice_model current_reservation = new invoice_model();
                current_reservation.setIn(Date.valueOf(rs.getString(1)));
                current_reservation.setOut(rs.getDate(2));
                current_reservation.setD(rs.getDate(3));
                current_reservation.setPeriod(Integer.parseInt(rs.getString(4)));
                current_reservation.setRoomid(rs.getInt(5));
                current_reservation.setRoomcost(rs.getInt(6));
                final_data.add(current_reservation);
            }
            return final_data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void update(int id, String checkin,String checkout,String date,String period, String customerid,int roomid){
        try {
            PreparedStatement stmt = con.prepareStatement("update reservation set checkin=?,checkout=?,date=?,period=?,FK_CustID=?,FK_RoomID=? where ReservationID="+id);
            stmt.setString(1,checkin);
            stmt.setString(2,checkout);
            stmt.setString(3,date);
            stmt.setString(4,period);
            stmt.setString(5,customerid);
            stmt.setString(6, String.valueOf(roomid));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void delete(int id){
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from reservation where ReservationID =" + id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<reservation> getAllRes(){
        ArrayList<reservation> final_data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from reservation");
            while(rs.next()) {
                reservation current_reservation = new reservation();
                current_reservation.setCheckin(rs.getString(2));
                current_reservation.setId(rs.getInt(1));
                current_reservation.setCheckout(rs.getString(3));
                current_reservation.setCurrent_date(rs.getString(4));
                current_reservation.setPeriod(rs.getString(5));
                current_reservation.setCustomerid(rs.getString(7));
                current_reservation.setRoomid(rs.getString(6));
                final_data.add(current_reservation);
            }
            return final_data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    public void addReservation(Date checkin,Date checkout,Date current_date ,String customerid,int id){
        try {
            PreparedStatement stmt = con.prepareStatement("insert into reservation( checkin, checkout, date,period, fk_custid,FK_RoomID) values(?,?,?,?,?,?)");
            stmt.setString(1, String.valueOf(checkin));
            stmt.setString(2, String.valueOf(checkout));
            stmt.setString(3, String.valueOf(current_date));
            stmt.setString(4, String.valueOf((checkout.getTime() - checkin.getTime())/(24*60*60*1000)));
            stmt.setString(5,customerid);
            stmt.setString(6, String.valueOf(id));
            dbRoom dbroom = new dbRoom();
            dbroom.ReserveRoom(id);
            stmt.execute();


        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

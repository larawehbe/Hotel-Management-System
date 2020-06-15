package dbModel;

import User.RoomService_Model;

import java.sql.*;
import java.util.ArrayList;

public class dbRoomService {
    Connection con = DBConnection.getConnection();
    public void update(int rid,int sid, int cost){
        try {
            PreparedStatement stmt = con.prepareStatement("update roomservices set FK_ServiceID =?, Cost=? where FK_RoomID = ?");
            stmt.setString(1, String.valueOf(rid));
            stmt.setString(2, String.valueOf(sid));
            stmt.setString(3, String.valueOf(cost));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<RoomService_Model> getTotalRoomServiceCost(int id) {
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT  * from roomservices where FK_RoomID = " + id);
            ArrayList<RoomService_Model> final_data = new ArrayList<>();
            while (rs.next()) {
                RoomService_Model current = new RoomService_Model();
                current.setService_id(rs.getInt(2));
                current.setService_cost(rs.getInt(3));
                final_data.add(current);
            }
            return final_data;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArrayList<RoomService_Model> getAllRoomServices() {
        ArrayList<RoomService_Model> data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from roomservices ");
            while (rs.next()) {

                RoomService_Model current = new RoomService_Model();
                current.setRoom_id(rs.getInt(1));
                current.setService_id(Integer.parseInt(rs.getString(2)));
                current.setService_cost(Integer.parseInt(rs.getString(3)));
                data.add(current);
            }
            return data;
        } catch (SQLException e) {
            System.out.println("Error occured while searching for employee of id " + e.getMessage());

        }
        return null;
    }

    public void delete(int rid, int sid) {
        try {
            Statement stmt = con.createStatement();
            stmt.executeUpdate("delete from roomservices where FK_RoomID = " + rid + " and FK_ServiceID = " + sid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public int getServiceCost(int id) {
        dbService dbs = new dbService();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select ServiceCost from services where ServiceID = " + id);
            if (rs.next()) {
                return Integer.parseInt(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addService(int sid, String rid, int nb1, int nb2) {

        switch (sid) {
            case 1:
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into roomservices values (?,?,?)");
                    stmt.setString(1, rid);
                    stmt.setString(2, String.valueOf(sid));
                    stmt.setString(3, String.valueOf(getServiceCost(sid) * nb1));
                    stmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 2:
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into roomservices values (?,?,?)");
                    stmt.setString(1, rid);
                    stmt.setString(2, String.valueOf(sid));
                    stmt.setString(3, String.valueOf(getServiceCost(sid)));
                    stmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 3:
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into roomservices values (?,?,?)");
                    stmt.setString(1, rid);
                    stmt.setString(2, String.valueOf(sid));
                    stmt.setString(3, String.valueOf(getServiceCost(sid)));
                    stmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 4:
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into roomservices values (?,?,?)");
                    stmt.setString(1, rid);
                    stmt.setString(2, String.valueOf(sid));
                    stmt.setString(3, String.valueOf(getServiceCost(sid) * nb2));
                    stmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 5:
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into roomservices values (?,?,?)");
                    stmt.setString(1, rid);
                    stmt.setString(2, String.valueOf(sid));
                    stmt.setString(3, String.valueOf(getServiceCost(sid)));
                    stmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            case 6:
                try {
                    PreparedStatement stmt = con.prepareStatement("insert into roomservices values (?,?,?)");
                    stmt.setString(1, rid);
                    stmt.setString(2, String.valueOf(sid));
                    stmt.setString(3, String.valueOf(getServiceCost(sid)));
                    stmt.execute();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
        }
    }

}


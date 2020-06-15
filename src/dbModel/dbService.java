package dbModel;

import User.service;

import javax.xml.transform.Result;
import java.awt.geom.RectangularShape;
import java.sql.*;
import java.util.ArrayList;

public class dbService {
    Connection con = DBConnection.getConnection();

    public service getService3(){
        service current = new service();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from services where ServiceID = 3");
            if(rs.next()){
            current.setId(String.valueOf(2));
            current.setName(rs.getString(2));
            current.setDescription(rs.getString(3));
            current.setCost(rs.getString(4));}
            return current;
        } catch (SQLException e) {
            e.printStackTrace();
        }return  null;
    }
    public service getService2(){
        service current = new service();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from services where ServiceID = 2");
            if(rs.next()){
            current.setId(rs.getString(1));
            current.setName(rs.getString(2));
            current.setDescription(rs.getString(3));
            current.setCost(rs.getString(4));}
            return current;
        } catch (SQLException e) {
            e.printStackTrace();
        }return  null;
    }
    public void delete(String id){
        try {
           Statement stmt = con.createStatement();
           stmt.executeUpdate("delete from  services where ServiceID = " +id);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public void update(String id,String name,String desc,String cost){
        try {
            PreparedStatement stmt = con.prepareStatement("update services set ServiceName=?,ServiceCost=?,ServiceDesc=? where ServiceID=" + id);
            stmt.setString(1,name);
            stmt.setString(3,desc);
            stmt.setDouble(2, Double.parseDouble(cost));
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void add(String name,String desc,String cost){
        try {
            PreparedStatement stmt = con.prepareStatement("insert into services(servicename, servicedesc, servicecost) values (?,?,?)");
            stmt.setString(1,name);
            stmt.setString(2,desc);
            stmt.setString(3,cost);
            stmt.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public ArrayList<service> getAllServices(){
        ArrayList<service> data = new ArrayList<>();
        try {
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("select * from services");
            while(rs.next()){
                service current = new service();
                current.setId(String.valueOf(rs.getInt(1)));
                current.setName(rs.getString(2));
                current.setDescription(rs.getString(3));
                current.setCost(rs.getString(4));
                data.add(current);
            }return  data;
        } catch (SQLException e) {
            e.printStackTrace();
        }return null;
    }
}

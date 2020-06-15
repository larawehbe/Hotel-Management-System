package employee_controller;

import User.RoomType_Model;
import User.room;
import User.serviceroom;
import dbModel.dbReservation;
import dbModel.dbRoom;
import dbModel.dbRoomType;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;

import java.io.IOException;
import java.sql.Date;

public class add_reservation_emp {
    @FXML
    TableView<room> table;
    @FXML
    TableColumn<room, Integer> roomid;
    @FXML
    TableColumn<room, String> rate;
    @FXML
    TableColumn<room, String> place;
    @FXML
    TableColumn<room, String> cost;
    @FXML
    TableColumn<room, String> status;
    @FXML
    TableColumn<room, String> beds;
    @FXML
    TableColumn<room, String> type;
    @FXML
    TableColumn<room, String> category;

    @FXML
    TableColumn<room, String> hotelid;
    @FXML
    TableView<RoomType_Model> typetable;
    @FXML
    TableColumn<RoomType_Model,String> roomtypeid;
    @FXML
    TableColumn<RoomType_Model,String> roomcat;
    @FXML
    DatePicker checkin;
    @FXML
    DatePicker checkout;
    @FXML
    DatePicker current_date;
//    @FXML
//    TextField period;
    @FXML
    TextField customerid;
    @FXML
    TextField reservedroom;
    @FXML
    Button Add;
    @FXML
    Button avail;
    @FXML
    Button back;
    dbRoom dbroom = new dbRoom();
    ObservableList<room> availableRooms;
    ObservableList<RoomType_Model> roomtypes;
    dbReservation dbr = new dbReservation();
    dbRoomType dbrt = new dbRoomType();
    public void getRoomTypes(){
        roomtypes = FXCollections.observableArrayList(dbrt.getAllRoomTypes());
        roomtypeid.setCellValueFactory(new PropertyValueFactory<>("id"));
        roomcat.setCellValueFactory(new PropertyValueFactory<>("category"));
        typetable.setItems(roomtypes);
    }
    public void AvailableRooms(){
        availableRooms = FXCollections.observableArrayList(dbroom.getAllFreeRooms());
        roomid.setCellValueFactory(new PropertyValueFactory<>("roomid"));
        rate.setCellValueFactory(new PropertyValueFactory<>("rate"));
        place.setCellValueFactory(new PropertyValueFactory<>("place"));
        cost.setCellValueFactory(new PropertyValueFactory<>("roomCost"));
        status.setCellValueFactory(new PropertyValueFactory<>("status"));
        type.setCellValueFactory(new PropertyValueFactory<>("features"));
        beds.setCellValueFactory(new PropertyValueFactory<>("nbofbeds"));
        hotelid.setCellValueFactory(new PropertyValueFactory<>("hotelid"));
        table.setItems(availableRooms);
    }
    public void initialize(){
    getRoomTypes();
    AvailableRooms();
    Add.setOnAction(e->{
        dbr.addReservation(Date.valueOf(checkin.getValue()),Date.valueOf(checkout.getValue()),Date.valueOf(current_date.getValue()),customerid.getText(), Integer.parseInt(reservedroom.getText()));
            AvailableRooms();
            Alert alert =  new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Reservation is successfully done ");
            alert.show();

    });
        back.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../employee_view/res_emp.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }

}

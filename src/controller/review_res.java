package controller;

import User.reservation;
import dbModel.dbReservation;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.Main;

import javax.xml.ws.soap.Addressing;
import java.io.IOException;
import java.sql.Date;

public class review_res {
    @FXML
    TableView<reservation> table;
    @FXML
    TableColumn<reservation, Integer> reservation_id;
    @FXML
    TableColumn<reservation, String> checkin;
    @FXML
    TableColumn<reservation, String> checkout;
    @FXML
    TableColumn<reservation,String> date;
    @FXML
    TableColumn<reservation,String> period;
    @FXML
    TableColumn<reservation,String > roomid;
    @FXML
    TableColumn<reservation,String> customer_id;
    @FXML
    TextField res_id;
    @FXML
    Button back;
    @FXML
    Button update;
    @FXML
    Button delete;
    @FXML
            Button add_reservation;
    @FXML
            TableColumn<reservation,String> features;
    dbReservation dbr = new dbReservation();
    ObservableList<reservation> data;
    public void update_reservation(){
        data = FXCollections.observableArrayList(dbr.getAllRes());
        checkin.setCellValueFactory(new PropertyValueFactory<>("checkin"));
        checkout.setCellValueFactory(new PropertyValueFactory<>("checkout"));
        date.setCellValueFactory(new PropertyValueFactory<>("current_date"));
        period.setCellValueFactory(new PropertyValueFactory<>("period"));
        customer_id.setCellValueFactory(new PropertyValueFactory<>("customerid"));
        reservation_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        roomid.setCellValueFactory(new PropertyValueFactory<>("roomid"));

        table.setItems(data);
        table.setEditable(true);
        roomid.setCellFactory(TextFieldTableCell.forTableColumn());
        roomid.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<reservation, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setRoomid(event.getNewValue());
            }
        });
        checkin.setCellFactory(TextFieldTableCell.forTableColumn());
        checkin.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<reservation, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCheckin(event.getNewValue());
            }
        });
        checkout.setCellFactory(TextFieldTableCell.forTableColumn());
        checkout.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<reservation, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCheckout(event.getNewValue());
            }
        });
        date.setCellFactory(TextFieldTableCell.forTableColumn());
        date.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<reservation, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCurrent_date(event.getNewValue());
            }
        });
        period.setCellFactory(TextFieldTableCell.forTableColumn());
        period.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<reservation, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setPeriod(event.getNewValue());
            }
        });
        customer_id.setCellFactory(TextFieldTableCell.forTableColumn());
        customer_id.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<reservation, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<reservation, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCustomerid(event.getNewValue());
            }
        });
        table.setEditable(true);

    }
    public void initialize(){
        update_reservation();
        add_reservation.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/add_reservation.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        update.setOnAction(e->{
            reservation current = new reservation();
            current = table.getSelectionModel().getSelectedItem();
            dbr.update(Integer.parseInt(res_id.getText()),current.getCheckin(),current.getCheckout(),current.getCurrent_date(),current.getPeriod(),current.getCustomerid(), Integer.parseInt(current.getRoomid()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Reservation with id : " +res_id.getText() +" is successfully updated !");
            alert.show();
            update_reservation();
        });
        delete.setOnAction(e->{
            dbr.delete(Integer.parseInt(res_id.getText()));
            update_reservation();
        });
        back.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/Main_Manager.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }
}

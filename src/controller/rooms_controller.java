package controller;

import User.room;
import dbModel.dbRoom;
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
import java.io.IOException;
import java.sql.SQLException;

public class rooms_controller {
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
    TableColumn<room, String> features;
    @FXML
    TableColumn<room, String> hotelid;
//    @FXML
//    TableColumn<room, String> resid;
    @FXML
    Button back;
    @FXML
    Button add_room;
    @FXML
    Button update;
    @FXML
    Button delete;
    @FXML
    TextField id;
    dbRoom dbr = new dbRoom();
    ObservableList<room> data;

    public void update_rooms() {
        try {
            data = FXCollections.observableArrayList(dbr.getAllRooms());
            roomid.setCellValueFactory(new PropertyValueFactory<>("roomid"));
            rate.setCellValueFactory(new PropertyValueFactory<>("rate"));
            place.setCellValueFactory(new PropertyValueFactory<>("place"));
            cost.setCellValueFactory(new PropertyValueFactory<>("roomCost"));
            status.setCellValueFactory(new PropertyValueFactory<>("status"));
            features.setCellValueFactory(new PropertyValueFactory<>("features"));
            beds.setCellValueFactory(new PropertyValueFactory<>("nbofbeds"));
            hotelid.setCellValueFactory(new PropertyValueFactory<>("hotelid"));
//            resid.setCellValueFactory(new PropertyValueFactory<>("resid"));
            table.setItems(data);
            table.setEditable(true);
            rate.setCellFactory(TextFieldTableCell.forTableColumn());
            rate.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<room, String>>() {
                @Override
                public void handle(TableColumn.CellEditEvent<room, String> event) {
                    event.getTableView().getItems().get(event.getTablePosition().getRow()).setRate(event.getNewValue());
                }
            });
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void initialize() {
        update_rooms();
        add_room.setOnAction(e->
    {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/addRoom.fxml"));
            Main.st.close();
            Main.st.setScene(new Scene(root));
            Main.st.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
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

        update.setOnAction(e->{
            room current = table.getSelectionModel().getSelectedItem();
            dbr.update(id.getText(),current.getRate(),current.getPlace(),current.getRoomCost(),current.getStatus(),current.getNbofbeds(),current.getFeatures(),current.getHotelid());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("room successfully updated");
            alert.show();

        });
        delete.setOnAction(e->{
            dbr.Delete(Integer.parseInt(id.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("room successfully deleted");
            alert.show();
            update_rooms();
        });
    }
}


package controller;

import User.RoomType_Model;
import dbModel.dbRoomType;
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

public class roomType {
@FXML
    TableView<RoomType_Model> table;
@FXML
    TableColumn<RoomType_Model,String> roomtype;
@FXML
    TableColumn<RoomType_Model,String> category;
@FXML
    TextField id;
@FXML
    Button back;
@FXML
    Button delete;
@FXML
    Button update;
@FXML
    Button add;
@FXML
    TableColumn<RoomType_Model,String> descr;
dbRoomType dbr = new dbRoomType();
ObservableList<RoomType_Model> data;
public void update_roomType(){
    data = FXCollections.observableArrayList(dbr.getAllRoomTypes());
    roomtype.setCellValueFactory(new PropertyValueFactory<>("id"));
    category.setCellValueFactory(new PropertyValueFactory<>("category"));
    descr.setCellValueFactory(new PropertyValueFactory<>("description"));
    table.setItems(data);
    table.setEditable(true);
    category.setCellFactory(TextFieldTableCell.forTableColumn());
    category.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<RoomType_Model, String>>() {
        @Override
        public void handle(TableColumn.CellEditEvent<RoomType_Model, String> event) {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setCategory(event.getNewValue());
        }
    });
}
public void initialize(){
    update_roomType();
    update.setOnAction(e->{
        RoomType_Model current = table.getSelectionModel().getSelectedItem();
        dbr.update(Integer.parseInt(current.getId()),current.getCategory(),current.getDescription());

        update_roomType();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Roomtype with id : " + id.getText() + " is added successfully !");
        alert.show();
    });
    delete.setOnAction(e->{
        dbr.delete(Integer.parseInt(id.getText()));
        update_roomType();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Roomtype with id : " + id.getText() + " is deleted successfully !");
        alert.show();
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
    add.setOnAction(e->{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/addRoomType.fxml"));
            Main.st.close();
            Main.st.setScene( new Scene(root));
            Main.st.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
}
}

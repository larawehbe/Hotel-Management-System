package controller;

import User.RoomService_Model;
import dbModel.dbRoomService;
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

public class RoomServiceController {

@FXML
TableView<RoomService_Model> table;
@FXML
    TableColumn<RoomService_Model,String> roomid;
@FXML
    TableColumn<RoomService_Model,String> serviceid;
@FXML
    TableColumn<RoomService_Model,String> cost;
@FXML
    Button delete;
@FXML
    Button back;
@FXML
        Button add;
@FXML
        Button update;
    @FXML
    TextField rid;
dbRoomService dbsr = new dbRoomService();
    ObservableList<RoomService_Model > data ;
public void update_RoomService(){
    data =FXCollections.observableArrayList(dbsr.getAllRoomServices());
    roomid.setCellValueFactory(new PropertyValueFactory<>("Room_id"));
    serviceid.setCellValueFactory(new PropertyValueFactory<>("service_id"));
    cost.setCellValueFactory(new PropertyValueFactory<>("service_cost"));
    table.setItems(data);
}
 public void initialize(){
    update_RoomService();
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
    delete.setOnAction(e->{
        RoomService_Model current = new RoomService_Model();
        dbsr.delete(current.getRoom_id(),current.getService_id());
    });
    update.setOnAction(e->{
        RoomService_Model current = new RoomService_Model();
        current = table.getSelectionModel().getSelectedItem();
        dbsr.update(current.getRoom_id(),current.getService_id(),current.getService_cost());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("update is successfully done !");
        alert.show();
    });
    add.setOnAction(e->{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/AddRoomService.fxml"));
            Main.st.close();
            Main.st.setScene( new Scene(root));
            Main.st.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
 }
}

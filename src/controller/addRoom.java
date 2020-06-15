package controller;

import dbModel.dbRoom;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;

public class addRoom {
    @FXML
    Button back;
    @FXML
    Button add;
    @FXML
    TextField RATE;
    @FXML
    TextField place;
    @FXML
    TextField cost;
//    @FXML
//    TextField status;
    @FXML
    TextField features;
    @FXML
    TextField beds;
    @FXML
    TextField hotelid;
//    @FXML
//    TextField resid;
dbRoom dbr = new dbRoom();
public void initialize(){
    add.setOnAction(e->{
        dbr.addRoom(RATE.getText(),place.getText(),cost.getText(), String.valueOf(0),features.getText(),beds.getText(),hotelid.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("room successfully added");
        alert.show();
    });



 back.setOnAction(e->{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/rooms.fxml"));
            Main.st.close();
            Main.st.setScene( new Scene(root));
            Main.st.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    });
}
}

package controller;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.Loader;
import dbModel.dbRoomService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;

public class AddRoomService {
    @FXML
    TextField roomid;
    @FXML
    TextField nb1;
    @FXML
    TextField nb2;
    @FXML
    CheckBox ironing;
    @FXML
    CheckBox rental;
    @FXML
    CheckBox clean;
    @FXML
    CheckBox laundry;
    @FXML
    CheckBox shoeshine;
    @FXML
    CheckBox valet;
    @FXML
    Button back;
    @FXML
    Button submit;
    dbRoomService dbrs = new dbRoomService();
    public void initialize(){

    submit.setOnAction(e->{
        if(ironing.isSelected()){
            dbrs.addService(1,roomid.getText(), Integer.parseInt(nb1.getText()),0);
        }
        if(rental.isSelected()){
            dbrs.addService(2,roomid.getText(), 0,0);
        }   if(clean.isSelected()){
            dbrs.addService(3,roomid.getText(), 0,0);
        }   if(laundry.isSelected()){
            dbrs.addService(4,roomid.getText(),0,Integer.parseInt(nb2.getText()));
        }   if(shoeshine.isSelected()){
            dbrs.addService(5,roomid.getText(),0,0);
        }   if(valet.isSelected()){
            dbrs.addService(6,roomid.getText(), 0,0);
        }
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Room Service is Successfully Added !");
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
    }


}

package controller;

import dbModel.dbRoomType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;

public class addRoomType {
    @FXML
    Button back;
    @FXML
    Button add;
    @FXML
    TextField category;
    @FXML
    TextArea descr;
    dbRoomType dbr = new dbRoomType();
    public void initialize(){
        add.setOnAction(e->{ dbr.add(category.getText(),descr.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Roomtype  is added successfully !");
            alert.show();});


            back.setOnAction(e -> {
                try {
                    Parent root = FXMLLoader.load(getClass().getResource("../view/roomType.fxml"));
                    Main.st.close();
                    Main.st.setScene(new Scene(root));
                    Main.st.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            });
        }}



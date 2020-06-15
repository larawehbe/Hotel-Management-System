package controller;

import dbModel.dbRole;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;

public class addRole {
@FXML
    Button back;
@FXML
    Button addrole;
@FXML
    TextField rolename;
@FXML
    TextField salary;
dbRole dbr = new dbRole();
public void initialize(){
    addrole.setOnAction(e->{
        dbr.addRole(rolename.getText(),salary.getText());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("role " + rolename.getText() + " is added successfully !");
        alert.show();
    });
    back.setOnAction(e->{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/roles.fxml"));
            Main.st.close();
            Main.st.setScene( new Scene(root));
            Main.st.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
}
}

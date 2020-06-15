package controller;

import dbModel.dbEmployee;
import dbModel.dbManager;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;

public class employee_login {
    @FXML
    TextField username;
    @FXML
    PasswordField password;
    @FXML
    Button login;
    dbEmployee dbe = new dbEmployee();
    public void initialize(){
        login.setOnAction(e->{
            if(dbe.verifylogin(username.getText(),password.getText())==1){
                Parent root = null;
                try {
                    root = FXMLLoader.load(getClass().getResource("../view/Main_Employee.fxml"));
                    Main.st.close();
                    Main.st.setScene(new Scene(root));
                    Main.st.show();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }

            }
            else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setContentText("Username or password are incorrect");
                alert.show();
            }
        });
    }
}

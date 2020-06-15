package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import sample.Main;

import java.io.IOException;

public class MainPage {
    @FXML
    Button manager;
    @FXML
    Button receptionist;
    @FXML
    Button customer;
    public void initialize(){

        manager.setOnAction(e->{
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../view/manager_login.fxml"));
                Main.st.close();
                Main.st.setScene(new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
        receptionist.setOnAction(e->{
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../view/employee_login.fxml"));
                Main.st.close();
                Main.st.setScene(new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        customer.setOnAction(e->{
            Parent root = null;
            try {
                root = FXMLLoader.load(getClass().getResource("../view/customer_login.fxml"));
                Main.st.close();
                Main.st.setScene(new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

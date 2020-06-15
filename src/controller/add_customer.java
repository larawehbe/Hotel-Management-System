package controller;

import dbModel.dbCustomer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import sample.Main;
import User.*;
import java.io.IOException;


public class add_customer {
    @FXML
    TextField fname;
    @FXML
    TextField lname;
    @FXML
    TextField gender;
    @FXML
    TextField city;
    @FXML
    TextField phone;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    Button Add;
    @FXML
    Button back;
    dbCustomer dbc = new dbCustomer();
    public void initialize(){
        Add.setOnAction(e->
        {
         manager mg = new manager();
         dbc.addCustomer(fname.getText(),lname.getText(),city.getText(),gender.getText(),phone.getText());
         customer current = new customer();
         current.assignData(fname.getText(),lname.getText(),city.getText(),gender.getText(),phone.getText());
         mg.addCustomer(current);
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setContentText(fname.getText() + "is added SUCCESFULLY");
        alert.show();
        });
        back.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/review_customer.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }
}

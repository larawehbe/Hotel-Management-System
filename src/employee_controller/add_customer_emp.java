package employee_controller;

import dbModel.dbCustomer;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;


public class add_customer_emp {
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
         dbc.addCustomer(fname.getText(),lname.getText(),city.getText(),gender.getText(),phone.getText());
         Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
         alert.setContentText(fname.getText() + "is added SUCCESFULLY");
        alert.show();
        });
        back.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../employee_view/cust_emp.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }
}

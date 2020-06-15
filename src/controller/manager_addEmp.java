package controller;

import User.EmployeeFactory;
import User.employee;
import User.manager;
import dbModel.dbEmployee;
import javafx.beans.property.Property;
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
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;

public class manager_addEmp {
    @FXML
    TextField fname;
    @FXML
    TextField lname;
    @FXML
    TextField gender;
    @FXML
    TextField age;
    @FXML
    TextField phone;
    @FXML
    TextField city;
    @FXML
    TextField username;
    @FXML
    TextField password;
    @FXML
    TextField workhours;
    @FXML
    TextField roleid;
    @FXML
    TextField hotelid;
    @FXML
    DatePicker bday;
    @FXML
    Button add_employee;
    @FXML
    Button back;

    public void initialize(){
        dbEmployee dbe = new dbEmployee();
    add_employee.setOnAction(e->{
        EmployeeFactory ef = new EmployeeFactory();
        employee current = new employee();
        current = ef.getEmployee(Integer.parseInt(roleid.getText()));
        if(Integer.parseInt(roleid.getText() )== 2 ) {
            manager mg = new manager();
            mg.addReceptionist(current);
        }
        dbe.add_employee(fname.getText(),lname.getText(),gender.getText(),age.getText(),phone.getText(),city.getText(),workhours.getText(),roleid.getText(), String.valueOf(1), Date.valueOf(bday.getValue()));


        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText(fname.getText() +" IS ADDED SUCCESFULLY");
        alert.show();

    });
        back.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/review_employee.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });
    }


}

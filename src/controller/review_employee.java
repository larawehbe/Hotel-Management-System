package controller;

import User.employee;
import dbModel.dbEmployee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.Main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Statement;

public class review_employee {
    @FXML
    TextField id;
    @FXML
    TableView table;
    @FXML
    TableColumn<employee, Integer> empid;
    @FXML
    TableColumn<employee, String> fname;

    @FXML
    TableColumn<employee, String> lname;
    @FXML
    TableColumn<employee, String> gender;
    @FXML
    TableColumn<employee, String> workhours;
    @FXML
    TableColumn<employee, String> phone;
    @FXML
    TableColumn<employee, String> city;
    @FXML
    TableColumn<employee, String> username;
    @FXML
    TableColumn<employee, String> password;
    @FXML
    TableColumn<employee, DatePicker> birthdate;
    @FXML
    TableColumn<employee, String> age;
    @FXML
    TableColumn<employee, String> roleid;
    @FXML
    TableColumn<employee, Integer> hotelid;
    @FXML
    Button update;
    @FXML
    Button delete;
    @FXML
            Button add_employee;
    dbEmployee dbe = new dbEmployee();
    ObservableList<employee> data;

    public void update_employee() {
        data = FXCollections.observableArrayList(dbe.getAllEmpReview());

        empid.setCellValueFactory(new PropertyValueFactory<>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        roleid.setCellValueFactory(new PropertyValueFactory<employee, String>("roleid"));
        hotelid.setCellValueFactory(new PropertyValueFactory<>("hotelid"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        age.setCellValueFactory(new PropertyValueFactory<>("age"));
        workhours.setCellValueFactory(new PropertyValueFactory<>("workhours"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        birthdate.setCellValueFactory(new PropertyValueFactory<>("bday"));
        table.setItems(data);
        fname.setCellFactory(TextFieldTableCell.forTableColumn());
        fname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setFname(event.getNewValue());
            }
        });
        lname.setCellFactory(TextFieldTableCell.forTableColumn());
        lname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setLname(event.getNewValue());
            }
        });
        workhours.setCellFactory(TextFieldTableCell.forTableColumn());
        workhours.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setWorkhours(event.getNewValue());
            }
        });
        age.setCellFactory(TextFieldTableCell.forTableColumn());
        age.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setAge(event.getNewValue());
            }
        });
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setPhone(event.getNewValue());
            }
        });
        city.setCellFactory(TextFieldTableCell.forTableColumn());
        city.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCity(event.getNewValue());
            }
        });
        username.setCellFactory(TextFieldTableCell.forTableColumn());
        username.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setUsername(event.getNewValue());
            }
        });
        password.setCellFactory(TextFieldTableCell.forTableColumn());
        password.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setPassword(event.getNewValue());
            }
        });
        gender.setCellFactory(TextFieldTableCell.forTableColumn());
        gender.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setGender(event.getNewValue());
            }
        });
        roleid.setCellFactory(TextFieldTableCell.forTableColumn());
        roleid.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<employee, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<employee, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setRoleid(event.getNewValue());
            }
        });

    }
    @FXML
    Button back;

    public void initialize() {
        update_employee();
        add_employee.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/add_employee.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        update.setOnAction(e ->
        {

            employee current = (employee) table.getSelectionModel().getSelectedItem();
            dbe.update(Integer.parseInt(id.getText()), current.getFname(), current.getLname(), current.getGender(), current.getAge(), current.getPhone(), current.getCity(), current.getWorkhours(), current.getUsername(), current.getPassword(), current.getRoleid(), current.getHotelid(), current.getBday());
            update_employee();
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Employee with id:"+id.getText()+"is updated");
        alert.show();
        update_employee();

        });
        delete.setOnAction(e->{
            dbe.delete(Integer.parseInt(id.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Employee with id :" + id.getText() + "is successfully deleted!");
            alert.show();
            update_employee();

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







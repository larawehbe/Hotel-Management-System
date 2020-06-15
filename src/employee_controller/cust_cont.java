package employee_controller;

import User.customer;
import dbModel.dbCustomer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import sample.Main;

import java.io.IOException;

public class cust_cont {
    @FXML
    ImageView home;
    @FXML
    TableView<customer> table;
    @FXML
    TableColumn<customer, Integer> id;
    @FXML
    TableColumn<customer,String> fname;
    @FXML
    TableColumn<customer,String> lname;
    @FXML
    TableColumn<customer,String> gender;
    @FXML
    TableColumn<customer,String> city;
    @FXML
    TableColumn<customer,String> phone;
    @FXML
    TableColumn<customer,String> username;
    @FXML
    TableColumn<customer,String> password;
    @FXML
    TextField customer_id;
    @FXML
    Button update;
    @FXML
            Button delete;
    @FXML
            Button back;
    @FXML
            Button add_customer;
    dbCustomer dbc = new dbCustomer();
    ObservableList<customer> data;
    public void update_Customer(){
        data= FXCollections.observableArrayList(dbc.getAllCustReview());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        fname.setCellValueFactory(new PropertyValueFactory<>("fname"));
        lname.setCellValueFactory(new PropertyValueFactory<>("lname"));
        gender.setCellValueFactory(new PropertyValueFactory<>("gender"));
        city.setCellValueFactory(new PropertyValueFactory<>("city"));
        phone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        username.setCellValueFactory(new PropertyValueFactory<>("username"));
        password.setCellValueFactory(new PropertyValueFactory<>("password"));
        table.setItems(data);
        fname.setCellFactory(TextFieldTableCell.forTableColumn());
        fname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<customer, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setFname(event.getNewValue());
            }
        });
        lname.setCellFactory(TextFieldTableCell.forTableColumn());
        lname.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<customer, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setLname(event.getNewValue());
            }
        });
        gender.setCellFactory(TextFieldTableCell.forTableColumn());
        gender.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<customer, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setGender(event.getNewValue());
            }
        });
        city.setCellFactory(TextFieldTableCell.forTableColumn());
        city.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<customer, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCity(event.getNewValue());
            }
        });
        phone.setCellFactory(TextFieldTableCell.forTableColumn());
        phone.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<customer, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setPhone(event.getNewValue());
            }
        });
        username.setCellFactory(TextFieldTableCell.forTableColumn());
        username.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<customer, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setUsername(event.getNewValue());
            }
        });
        password.setCellFactory(TextFieldTableCell.forTableColumn());
        password.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<customer, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<customer, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setPassword(event.getNewValue());
            }
        });
        table.setEditable(true);
    }
    public void initialize(){
        update_Customer();
        add_customer.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../employee_view/add_Customer_emp.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        update.setOnAction(e->{
            customer current_customer = table.getSelectionModel().getSelectedItem();
            dbc.update(Integer.parseInt(customer_id.getText()),current_customer.getFname(),current_customer.getLname(),current_customer.getCity(),current_customer.getGender(),current_customer.getPhone(),current_customer.getUsername(),current_customer.getPassword());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Customer with id :" +customer_id.getText() +" is successfully Updated");
            alert.show();
            update_Customer();
        });
        delete.setOnAction(e->{
            dbc.delete(Integer.parseInt(customer_id.getText()));
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Customer with id :" +customer_id.getText() +" is successfully Deleted!");
            alert.show();
            update_Customer();

        });
        back.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/Main_Employee.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        });

    }

}

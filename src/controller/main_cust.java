package controller;

import User.customer;
import User.employee;
import dbModel.dbCustomer;
import dbModel.dbEmployee;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import sample.Main;

import javax.xml.ws.BindingType;
import java.io.IOException;

public class main_cust {
    @FXML
    Button employee;
    @FXML
    Button customer;
    @FXML
    Button reservation;
    @FXML
    Button rooms;
    @FXML
    Button roomtype;
    @FXML
    Button roles;
    @FXML
    Button services;
    @FXML
    Button invoice;
    @FXML
    Button logout;
    @FXML
    Button roomservice;
    public void initialize(){
        invoice.setOnAction(e->{
            try {
                Parent  root = FXMLLoader.load(getClass().getResource("../customer_view/InvoiceDetails_emp.fxml"));

                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        logout.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/MainPage.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();

            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

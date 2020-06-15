package controller;

import User.service;
import dbModel.dbService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import sample.Main;

import java.io.IOException;

public class services {
    @FXML
    TableView<service> table;
    @FXML
    TableColumn<service,String> id;
    @FXML
    TableColumn<service,String> name;
    @FXML
    TableColumn<service,String> description;
    @FXML
    TableColumn<service,String> cost;
    @FXML
    Button back;
    @FXML
    Button update;
    @FXML
    Button delete;
    @FXML
    Button add;
    dbService dbs = new dbService();
    ObservableList<service> data;
    public void update_service(){
        data = FXCollections.observableArrayList(dbs.getAllServices());
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        description.setCellValueFactory(new PropertyValueFactory<>("description"));
        cost.setCellValueFactory(new PropertyValueFactory<>("cost"));
        table.setEditable(true);
        table.setItems(data);
        name.setCellFactory(TextFieldTableCell.forTableColumn());
        name.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<service, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<service, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setName(event.getNewValue());
            }
        });
        description.setCellFactory(TextFieldTableCell.forTableColumn());
        description.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<service, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<service, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setDescription(event.getNewValue());
            }
        });
        cost.setCellFactory(TextFieldTableCell.forTableColumn());
        cost.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<service, String>>() {
            @Override
            public void handle(TableColumn.CellEditEvent<service, String> event) {
                event.getTableView().getItems().get(event.getTablePosition().getRow()).setCost(event.getNewValue());
            }
        });
    }
    public void initialize(){
        update_service();
        delete.setOnAction(e->{
            service current = table.getSelectionModel().getSelectedItem();
            dbs.delete(current.getId());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.show();
            update_service();
        });
        update.setOnAction(e->{
            service current = table.getSelectionModel().getSelectedItem();
            dbs.update(current.getId(),current.getName(),current.getDescription(),current.getCost());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.show();
            update_service();
        });
        add.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/addService.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }

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
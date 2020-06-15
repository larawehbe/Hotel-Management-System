package controller;

import User.role;
import dbModel.dbRole;
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
import sample.Main;

import java.io.IOException;


public class roles_controller {
@FXML
    TableView<role> table;
@FXML
    TableColumn<role,Integer> roleid;
@FXML
    TableColumn<role,String> rolename;
@FXML
    TableColumn<role,String> salary;
@FXML
    TextField id;
@FXML
    Button back;
@FXML
    Button delete;
@FXML
    Button update;
@FXML
        Button add_role;
dbRole dbr = new dbRole();
ObservableList<role> data;
public void update_roles(){
    data = FXCollections.observableArrayList(dbr.getAllRoles());
    roleid.setCellValueFactory(new PropertyValueFactory<>("roleid"));
    rolename.setCellValueFactory(new PropertyValueFactory<>("rolename"));
    salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
    table.setItems(data);
    table.setEditable(true);
    rolename.setCellFactory(TextFieldTableCell.forTableColumn());
    rolename.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<role, String>>() {
        @Override
        public void handle(TableColumn.CellEditEvent<role, String> event) {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setRolename(event.getNewValue());
        }
    });
    salary.setCellFactory(TextFieldTableCell.forTableColumn());
    salary.setOnEditCommit(new EventHandler<TableColumn.CellEditEvent<role, String>>() {
        @Override
        public void handle(TableColumn.CellEditEvent<role, String> event) {
            event.getTableView().getItems().get(event.getTablePosition().getRow()).setSalary(event.getNewValue());
        }
    });

}
public void initialize(){
    update_roles();
    add_role.setOnAction(e->{
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/addRole.fxml"));
            Main.st.close();
            Main.st.setScene( new Scene(root));
            Main.st.show();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    });
    update.setOnAction(e->{
        role current = new role();
        current = table.getSelectionModel().getSelectedItem();
        dbr.update(Integer.parseInt(id.getText()),current.getRolename(),current.getSalary());
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("role with id " + id.getText() + " is successfully updated ! ");
        alert.show();
        update_roles();
    });
    delete.setOnAction(e->{
        dbr.Delete(Integer.parseInt(id.getText()));
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("role with id " + id.getText() + " is successfully deleted ! ");
        alert.show();
        update_roles();
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

package controller;

import dbModel.dbService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;

public class addService {
    @FXML
    TextField name;
    @FXML
    TextField cost;
    @FXML
    TextArea desc;
    @FXML
    Button back;
    @FXML
    Button add;
    dbService dbs = new dbService();
    public void initialize(){
        add.setOnAction(e->{
            dbs.add(name.getText(),desc.getText(),cost.getText());
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.show();
        });
        back.setOnAction(e->{ try {
            Parent root = FXMLLoader.load(getClass().getResource("../view/services.fxml"));
            Main.st.close();
            Main.st.setScene( new Scene(root));
            Main.st.show();
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        });
    }
}

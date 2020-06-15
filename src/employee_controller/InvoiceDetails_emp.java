package employee_controller;

import User.RoomService_Model;
import User.invoice_model;
import dbModel.dbReservation;
import dbModel.dbRoomService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import sample.Main;

import java.io.IOException;
import java.util.ArrayList;

public class InvoiceDetails_emp {
    @FXML
    Button back;
    @FXML
    Button checkinvoice;
    @FXML
    TextField customerid;
    @FXML
    TextField resid;
    @FXML
    Label cid;
    @FXML
    Label rid;
    @FXML
    Label indate;
    @FXML
    Label outdate;
    @FXML
    Label date;
    @FXML
    Label period;
    @FXML
    Label rc;
    @FXML
    Label trc;
    @FXML
    CheckBox s1;
    @FXML
    CheckBox s2;
    @FXML
    CheckBox s3;
    @FXML
    CheckBox s4;
    @FXML
    CheckBox s5;
    @FXML
    CheckBox s6;
    @FXML
    Label tsc;
    @FXML
    Label ti;

    public void initialize() {
        checkinvoice.setOnAction(e -> {
            ObservableList<invoice_model> data = FXCollections.observableArrayList(new dbReservation().getCustReservations(Integer.parseInt(customerid.getText()), Integer.parseInt(resid.getText())));
            invoice_model current = data.get(0);
            rid.setText(String.valueOf(current.getRoomid()));
            indate.setText(String.valueOf(current.getIn()));
            outdate.setText(String.valueOf(current.getOut()));
            date.setText(String.valueOf(current.getD()));
            period.setText(String.valueOf(current.getPeriod()));
            rc.setText(String.valueOf(current.getRoomcost()));
            trc.setText(String.valueOf(current.getPeriod() * current.getRoomcost()));
            int ts = 0;
            dbRoomService dbrs = new dbRoomService();
            ArrayList<RoomService_Model> rm = dbrs.getTotalRoomServiceCost(current.getRoomid());

            for (RoomService_Model md : rm) {

                if (md.getService_id() == 1) {
                    System.out.println("service 1");
                    if(!s1.isSelected())
                        s1.setSelected(true);
                    ts = ts + md.getService_cost();
                }
                if (md.getService_id() == 2) {

                    if(!s2.isSelected())
                        s2.setSelected(true);
                    ts = ts + md.getService_cost();
                }

                if (md.getService_id() == 3) {
                    if(!s3.isSelected())
                        s3.setSelected(true);
                    ts = ts + md.getService_cost();
                }

                if (md.getService_id() == 4) {
                    if(!s4.isSelected())
                        s4.setSelected(true);
                    ts = ts + md.getService_cost();
                }

                if (md.getService_id() == 5) {
                    if(!s5.isSelected())
                        s5.setSelected(true);
                    ts = ts + md.getService_cost();
                }

                if (md.getService_id() == 6) {
                    if(!s6.isSelected())
                        s6.setSelected(true);
                    ts = ts + md.getService_cost();
                }


            }
            tsc.setText(String.valueOf(ts));
            int total = Integer.parseInt(tsc.getText()) + Integer.parseInt(trc.getText());
            ti.setText(String.valueOf(total));

        });
        back.setOnAction(e->{
            try {
                Parent root = FXMLLoader.load(getClass().getResource("../view/Main_employee.fxml"));
                Main.st.close();
                Main.st.setScene( new Scene(root));
                Main.st.show();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
    }
}

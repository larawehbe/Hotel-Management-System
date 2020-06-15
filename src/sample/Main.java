package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public static int c=9;
    public static Scene se;
    public static Stage st = new Stage();
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../view/MainPage.fxml"));
        se = new Scene(root);
        st.setScene(se);
        st.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}

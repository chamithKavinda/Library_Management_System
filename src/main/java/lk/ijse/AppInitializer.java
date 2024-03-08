package lk.ijse;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AppInitializer extends Application  {
    public static void main(String[] args){launch(args);}

    @Override
    public void start(Stage stage) throws Exception {
        Parent rootNode = FXMLLoader.load(getClass().getResource("/view/LoginDashboard.fxml"));
        Scene scene = new Scene(rootNode);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.initStyle(StageStyle.UNDECORATED);
        stage.show();
    }
}

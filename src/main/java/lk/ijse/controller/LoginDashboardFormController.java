package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginDashboardFormController {
    public void btnAdminOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin/AdminSignInPage.fxml"));
        Scene scene = new Scene(rootNode);

        Stage primaryStage = new Stage();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("User SignIn Form");
        primaryStage.show();
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user/UserSignInPage.fxml"));
        Scene scene = new Scene(rootNode);

        Stage primaryStage = new Stage();

        primaryStage.setScene(scene);
        primaryStage.centerOnScreen();
        primaryStage.setTitle("User SignIn Form");
        primaryStage.show();
    }


}





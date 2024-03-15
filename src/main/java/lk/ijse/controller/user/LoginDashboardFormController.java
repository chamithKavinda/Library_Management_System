package lk.ijse.controller.user;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginDashboardFormController {
    @FXML
    private AnchorPane loginDashboard;

    public void btnAdminOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin/AdminSignInPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("AdminSignInForm");
        stage.centerOnScreen();
    }

    public void btnUserOnAction(ActionEvent actionEvent) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user/UserSignInPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) loginDashboard.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("UserSignInForm");
        stage.centerOnScreen();
    }


}





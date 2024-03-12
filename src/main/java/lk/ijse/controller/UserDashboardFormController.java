package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class UserDashboardFormController {


    @FXML
    private AnchorPane UserDashboard;

    @FXML
    void btnBooksOnAction(ActionEvent event) {

    }

    @FXML
    void btnDashbordOnAction(ActionEvent event) {

    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) {

    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user/UserSignInPage.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Admin SignIn");
        stage.show();

        Stage dashboard= (Stage) UserDashboard.getScene().getWindow();
        dashboard.close();
    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) {

    }

}

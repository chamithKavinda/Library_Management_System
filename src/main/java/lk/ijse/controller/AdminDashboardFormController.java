package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class AdminDashboardFormController {

    @FXML
    private AnchorPane AdminDashbordForm;

    @FXML
    private AnchorPane root;

    @FXML
    private Label date;

    @FXML
    private Label time;

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {

    }

    @FXML
    void btnBranchesOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/admin/BranchesPage.fxml"));
        this.root.getChildren().clear();
        this.root.getChildren().add(anchorPane);
    }

    @FXML
    void btnDashboardOnAction(ActionEvent event) throws IOException {
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/admin/AdminSignInPage.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("Admin SignIn");
        stage.show();

        Stage dashboard= (Stage) AdminDashbordForm.getScene().getWindow();
        dashboard.close();
    }

    @FXML
    void btnRecordsOnAction(ActionEvent event) {

    }

    @FXML
    void btnUsersOnAction(ActionEvent event) {

    }

}

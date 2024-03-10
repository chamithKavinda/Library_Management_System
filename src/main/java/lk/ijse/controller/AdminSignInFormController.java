package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.dto.AdminDto;

import java.io.IOException;
import java.sql.SQLException;

public class AdminSignInFormController {

    @FXML
    private AnchorPane adminSignInPage;

    @FXML
    private TextField txtAdminName;

    @FXML
    private TextField txtAdminPassword;

    AdminBO adminBO = (AdminBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ADMIN_BO);

    @FXML
    void btnAdminSignInOnaction(ActionEvent event) {
        String AdminName = txtAdminName.getText();
        String AdminPassword = txtAdminPassword.getText();


        try{
            boolean adminIsExist = adminBO.isExistAdmin(AdminName,AdminPassword);
            if(adminIsExist){
                navigateToAdminDashboard();
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"Admin Name Password is Wrong").show();
            }
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void navigateToAdminDashboard() throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin/AdminDashboard.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) adminSignInPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("AdminDashboard");
        stage.centerOnScreen();
    }

    @FXML
    void hyperAdminSignUpOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin/AdminSignUpPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) adminSignInPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("UserSignInForm");
        stage.centerOnScreen();
    }

}
package lk.ijse.controller.admin;

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
import lk.ijse.dto.AdminDto;

import java.io.IOException;
import java.sql.SQLException;

public class AdminSignUpFormController {

    @FXML
    private AnchorPane AdminSignUpPage;

    @FXML
    private TextField txtAdminEmail;

    @FXML
    private TextField txtAdminId;

    @FXML
    private TextField txtAdminName;

    @FXML
    private TextField txtAdminPassword;

    AdminBO adminBO = (AdminBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ADMIN_BO);
    @FXML
    void btnAdminSignUpOnAction(ActionEvent event) {
        try {
            boolean adminCheck = txtAdminEmail.getText().equals(adminBO.getEmail(txtAdminEmail.getText()));
            if (!adminCheck) {
                AdminDto dto = new AdminDto();

                dto.setId(txtAdminId.getText());
                dto.setName(txtAdminName.getText());
                dto.setEmail(txtAdminEmail.getText());
                dto.setPassword(txtAdminPassword.getText());

                boolean isSaved = adminBO.saveAdmin(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "Admin Saved").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "Admin not saved").show();
                }
            }
        } catch (SQLException | ClassNotFoundException throwables ){
            throwables.printStackTrace();
        }
        clearFields();

    }

    private void clearFields() {
        txtAdminId.setText("");
        txtAdminName.setText("");
        txtAdminEmail.setText("");
        txtAdminPassword.setText("");
    }

    @FXML
    void hyperAdminSignInOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin/AdminSignInPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) AdminSignUpPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("AdminSignInForm");
        stage.centerOnScreen();
    }

    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/admin/AdminSignInPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) AdminSignUpPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("AdminSignInForm");
        stage.centerOnScreen();
    }

}

package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.bo.custom.impl.UserBOImpl;
import lk.ijse.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;

public class SettingsFormController {

    @FXML
    private AnchorPane root1;
    @FXML
    private Label lblUserEmail;

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblUserPassword;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserPassword;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER_BO);

    public void initialize() {
        setUsernamPassword();
    }
    private void setUsernamPassword() {
        lblUserName.setText(UserBOImpl.logUserEmail);
        lblUserPassword.setText(UserBOImpl.logPassword);
    }
    @FXML
    void btnDeleteOnAction(ActionEvent event) throws IOException {

        try{
            boolean isDeleted = userBO.deleteUser(UserBOImpl.logUserEmail);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"User Account deleted Successfully!" ).show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }

        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user/UserSignUpPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) root1.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User SignUp Form");
        stage.centerOnScreen();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String name = txtUserName.getText();
        String password = txtUserPassword.getText();

        var dto = new UserDto(name,UserBOImpl.logUserEmail,password);

        try{
            boolean isUpdated = userBO.updateUser(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "User Account Updated Successfully!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        clearFields();
    }

    private void clearFields() {
        txtUserName.setText("");
        txtUserEmail.setText("");
        txtUserPassword.setText("");
    }

}

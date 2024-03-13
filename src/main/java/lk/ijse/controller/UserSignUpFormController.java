package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.AdminDto;
import lk.ijse.dto.UserDto;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Pattern;

public class UserSignUpFormController {

    @FXML
    private AnchorPane UserSignUpForm;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserPassword;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER_BO);
    @FXML
    void btnUserSignUpOnAction(ActionEvent event) {
        boolean isValidate = validateFields();
        if (!isValidate) {
            return;
        }

        try {
            boolean adminCheck = txtUserEmail.getText().equals(userBO.getEmail(txtUserEmail.getText()));
            if (!adminCheck) {
                UserDto dto = new UserDto();

                dto.setName(txtUserName.getText());
                dto.setEmail(txtUserEmail.getText());
                dto.setPassword(txtUserPassword.getText());

                boolean isSaved = userBO.saveUser(dto);
                if (isSaved) {
                    new Alert(Alert.AlertType.CONFIRMATION, "User Saved").show();
                } else {
                    new Alert(Alert.AlertType.ERROR, "User not saved").show();
                }
            }
        } catch (SQLException | ClassNotFoundException throwables ){
            throwables.printStackTrace();
        }
        clearFields();
    }

    private boolean validateFields() {
        String userName = txtUserName.getText();
        boolean isUserNameValidated = Pattern.matches("^[A-Za-z\\s]+$",userName);
        if (isUserNameValidated){
            new Alert(Alert.AlertType.ERROR, "Invalid User Name").show();
            return false;
        }

        String userEmail = txtUserEmail.getText();
        boolean isUserEmailValidated = Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$\n",userEmail);
        if (isUserEmailValidated){
            new Alert(Alert.AlertType.ERROR, "Invalid User Email").show();
            return false;
        }

        String userPassword = txtUserPassword.getText();
        boolean isUserPasswordValidated = Pattern.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[!@#$%^&*()_+])[A-Za-z\\d!@#$%^&*()_+]{8,}$\n",userPassword);
        if (isUserPasswordValidated){
            new Alert(Alert.AlertType.ERROR, "Invalid User Password").show();
            return false;
        }
        return true;
    }

    private void clearFields() {
        txtUserName.setText("");
        txtUserEmail.setText("");
        txtUserPassword.setText("");
    }

    @FXML
    void hyperUserSignInOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user/UserSignInPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) UserSignUpForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User SignIn Form");
        stage.centerOnScreen();
    }


    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user/UserSignInPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) UserSignUpForm.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User SignIn Form");
        stage.centerOnScreen();
    }
}

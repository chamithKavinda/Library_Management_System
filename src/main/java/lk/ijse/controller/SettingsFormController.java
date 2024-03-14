package lk.ijse.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public class SettingsFormController {

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

    private static String username;
    private static String password;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER_BO);

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String email = txtUserEmail.getText();

        try{
            boolean isDeleted = userBO.deleteUser(email);
            System.out.println("test");
            if (isDeleted){
                System.out.println("test 1");
                new Alert(Alert.AlertType.CONFIRMATION,"User Account deleted Successfully!" ).show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String name = txtUserName.getText();
        String email = txtUserEmail.getText();
        String password = txtUserPassword.getText();

        var dto = new UserDto(name,email,password);

        try{
            boolean isUpdated = userBO.updateUser(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "User Account Updated Successfully!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}

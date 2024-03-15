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
import lk.ijse.bo.custom.impl.UserBOImpl;

import java.io.IOException;

public class UserSignInFormController {

    @FXML
    private AnchorPane userSignInPage;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtUserPassword;

    @FXML
    private TextField txtUserName;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER_BO);
    @FXML
    void btnUserSignInOnAction(ActionEvent event) {
        String UserEmail = txtUserEmail.getText();
        String UserPassword = txtUserPassword.getText();
        String UserName = txtUserName.getText();
        try{
            boolean userIsExist = userBO.IsExistUser(UserEmail,UserPassword,UserName);
            if(userIsExist){
                navigateToUserDashboard(UserEmail, UserPassword,UserName);

                UserBOImpl.logUserEmail = UserEmail;
                UserBOImpl.logPassword = UserPassword;
                UserBOImpl.logUserName = UserName;

            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"User Eamil Password UserName is Wrong").show();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void navigateToUserDashboard(String email, String password, String UserName) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user/UserDashboard.fxml"));
        AnchorPane anchorPane = loader.load();

        UserDashboardFormController dashboardController = loader.getController();
        dashboardController.setUserCredentials(email, password , UserName);

        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) userSignInPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User Dashboard");
        stage.centerOnScreen();
    }


    @FXML
    void hyperUserSignUpOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/user/UserSignUpPage.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) userSignInPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("User SignUp Form");
        stage.centerOnScreen();
    }


    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane = FXMLLoader.load(getClass().getResource("/view/LoginDashboard.fxml"));
        Scene scene = new Scene(anchorPane);
        Stage stage = (Stage) userSignInPage.getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("LogInDashBoard");
        stage.centerOnScreen();
    }

}

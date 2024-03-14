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
import lk.ijse.bo.custom.UserBO;

import java.io.IOException;
import java.sql.SQLException;

public class UserSignInFormController {

    @FXML
    private AnchorPane userSignInPage;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserPassword;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER_BO);
    @FXML
    void btnUserSignInOnAction(ActionEvent event) {
        String UserName = txtUserName.getText();
        String UserPassword = txtUserPassword.getText();
        try{
            boolean userIsExist = userBO.isExistUser(UserName,UserPassword);
            if(userIsExist){
                navigateToUserDashboard(UserName, UserPassword);
            }else{
                new Alert(Alert.AlertType.CONFIRMATION,"User Name Password is Wrong").show();
            }
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void navigateToUserDashboard(String userName, String password) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/user/UserDashboard.fxml"));
        AnchorPane anchorPane = loader.load();

        UserDashboardFormController dashboardController = loader.getController();
        dashboardController.setUserCredentials(userName, password);

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

package lk.ijse.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.Label;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserDashboardFormController {

    @FXML
    private Label lblUserName;

    @FXML
    private Label lblUserPassword;

    @FXML
    private Label date;
    private volatile boolean stop  = false;

    @FXML
    private Label time;
    private volatile boolean s  = false;

    @FXML
    private AnchorPane pane;

    @FXML
    private AnchorPane UserDashboard;

    public void initialize() {
        TimeNow();
        Date();
    }
    public void setUserCredentials(String userName, String password) {
        lblUserName.setText("" + userName);
        lblUserPassword.setText("" + password);
    }
    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/user/Books.fxml"));
        this.pane.getChildren().clear();
        this.pane.getChildren().add(anchorPane);
    }

    @FXML
    void btnDashbordOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/user/UserHomePage.fxml"));
        this.pane.getChildren().clear();
        this.pane.getChildren().add(anchorPane);
    }

    @FXML
    void btnHistoryOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/user/History.fxml"));
        this.pane.getChildren().clear();
        this.pane.getChildren().add(anchorPane);
    }

    @FXML
    void btnLogOutOnAction(ActionEvent event) throws IOException {
        Parent rootNode = FXMLLoader.load(this.getClass().getResource("/view/user/UserSignInPage.fxml"));
        Scene scene = new Scene(rootNode);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.setTitle("User SignIn");
        stage.show();

        Stage dashboard= (Stage) UserDashboard.getScene().getWindow();
        dashboard.close();
    }

    @FXML
    void btnSettingsOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/user/Settings.fxml"));
        this.pane.getChildren().clear();
        this.pane.getChildren().add(anchorPane);
    }

    private void TimeNow(){
        Thread thread = new Thread(()->{
            SimpleDateFormat sdf = new SimpleDateFormat("hh:mm:ss");
            while(!stop){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }
                final String timeNow = sdf.format(new Date());
                Platform.runLater(()->{
                    time.setText(timeNow);
                });
            }
        });
        thread.start();
    }

    private void Date(){
        Thread thread = new Thread(()->{
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            while (!s){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){
                    new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
                }
                final String dateNow = sdf1.format(new Date());
                Platform.runLater(()->{
                    date.setText(dateNow);
                });
            }
        });
        thread.start();
    }



}

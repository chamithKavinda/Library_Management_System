package lk.ijse.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AdminDashboardFormController {

    @FXML
    private AnchorPane AdminDashbordForm;

    @FXML
    private AnchorPane root;

    @FXML
    private Label date;
    private volatile boolean stop  = false;

    @FXML
    private Label time;
    private volatile boolean s  = false;

    public void initialize() {
        TimeNow();
        Date();
    }

    @FXML
    void btnBooksOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/admin/AdminBooksPage.fxml"));
        this.root.getChildren().clear();
        this.root.getChildren().add(anchorPane);
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
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/admin/AdminHomePage.fxml"));
        this.root.getChildren().clear();
        this.root.getChildren().add(anchorPane);
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
    void btnRecordsOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/admin/AdminRecords.fxml"));
        this.root.getChildren().clear();
        this.root.getChildren().add(anchorPane);
    }

    @FXML
    void btnUsersOnAction(ActionEvent event) throws IOException {
        AnchorPane anchorPane;
        anchorPane = FXMLLoader.<AnchorPane>load(getClass().getResource("/view/admin/AdminUsersPage.fxml"));
        this.root.getChildren().clear();
        this.root.getChildren().add(anchorPane);
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

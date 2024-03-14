package lk.ijse.controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import lk.ijse.bo.custom.impl.UserBOImpl;

import java.text.SimpleDateFormat;
import java.util.Date;

public class UserHomeFormController {

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

    public void initialize() {
        TimeNow();
        Date();
        setUsernamPassword();
    }

    private void setUsernamPassword() {
        lblUserName.setText(UserBOImpl.logUserEmail);
        lblUserPassword.setText(UserBOImpl.logPassword);
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

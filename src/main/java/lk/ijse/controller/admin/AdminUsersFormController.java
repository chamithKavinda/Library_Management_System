package lk.ijse.controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.AdminBO;
import lk.ijse.bo.custom.UserBO;
import lk.ijse.dto.UserDto;
import lk.ijse.dto.tm.UserTm;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.List;
import java.util.regex.Pattern;

public class AdminUsersFormController {

    @FXML
    private TableColumn<?, ?> colUserEmail;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableColumn<?, ?> colUserPassword;

    @FXML
    private TableView<UserTm> tblUser;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtUserName;

    @FXML
    private TextField txtUserPassword;

    UserBO userBO = (UserBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.USER_BO);

    public void initialize() {
        setCellValueFactory();
        loadAllUser();
    }

    private void setCellValueFactory() {
        colUserName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colUserEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colUserPassword.setCellValueFactory(new PropertyValueFactory<>("password"));
    }

    private void loadAllUser(){
        ObservableList<UserTm> obList = FXCollections.observableArrayList();

        try{
            List<UserDto> dtoList = userBO.getAllUsers();

            for (UserDto dto: dtoList){
                obList.add(
                        new UserTm(
                                dto.getName(),
                                dto.getEmail(),
                                dto.getPassword()
                        ));
            }
            tblUser.setItems(obList);
            tblUser.refresh();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields(){
        txtUserName.setText("");
        txtUserEmail.setText("");
        txtUserPassword.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

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



    @FXML
    void btnUpdateOnAction(ActionEvent event) {

    }

}

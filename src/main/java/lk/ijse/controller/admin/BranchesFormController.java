package lk.ijse.controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BooksBO;
import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dto.BooksDto;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;
import lk.ijse.dto.tm.BranchTm;
import lk.ijse.dto.tm.UserTm;

import java.sql.SQLException;
import java.util.List;

public class BranchesFormController {

    @FXML
    private TableColumn<?, ?> colBranchId;

    @FXML
    private TableColumn<?, ?> colBranchName;

    @FXML
    private TableColumn<?, ?> colCity;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableView<BranchTm> tblBranch;

    @FXML
    private TextField txtBranchId;

    @FXML
    private TextField txtBranchName;

    @FXML
    private TextField txtCity;

    @FXML
    private TextField txtContact;

    BranchBO branchBO = (BranchBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BRANCH_BO);

    public void initialize() {
        setCellValueFactory();
        loadAllBranch();
    }

    private void setCellValueFactory() {
        colBranchId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colBranchName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colContact.setCellValueFactory(new PropertyValueFactory<>("contact"));
        colCity.setCellValueFactory(new PropertyValueFactory<>("city"));
    }

    private void loadAllBranch(){
        ObservableList<BranchTm> obList = FXCollections.observableArrayList();

        try{
            List<BranchDto> dtoList = branchBO.getAllBranch();

            for (BranchDto dto: dtoList){
                obList.add(
                        new BranchTm(
                                dto.getId(),
                                dto.getName(),
                                dto.getContact(),
                                dto.getCity()
                        ));
            }
            tblBranch.setItems(obList);
            tblBranch.refresh();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtBranchId.setText("");
        txtBranchName.setText("");
        txtContact.setText("");
        txtCity.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtBranchId.getText();

        try{
            boolean isDeleted = branchBO.deleteBranch(id);

            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Branch deleted!").show();
                loadAllBranch();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try{
            BranchDto dto = new BranchDto();

            dto.setId(txtBranchId.getText());
            dto.setName(txtBranchName.getText());
            dto.setContact(txtContact.getText());
            dto.setCity(txtCity.getText());

            boolean isSaved = branchBO.saveBranch(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Saved").show();
                loadAllBranch();
            }else {
                new Alert(Alert.AlertType.ERROR, "Branch not saved").show();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        clearFields();
        tblBranch.refresh();
    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtBranchId.getText();
        String name = txtBranchName.getText();
        String contact = txtContact.getText();
        String city = txtCity.getText();

        var dto = new BranchDto(id,name,contact,city);

        try{
            boolean isUpdated = branchBO.updateBranch(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Branch Updated!").show();
                loadAllBranch();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}

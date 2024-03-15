package lk.ijse.controller.admin;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RecordsBO;
import lk.ijse.dto.RecordsDto;
import lk.ijse.dto.tm.RecordsTm;

import java.sql.SQLException;
import java.util.List;

public class AdminRecordsFormController {

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colDateTime;

    @FXML
    private TableColumn<?, ?> colReturnDate;

    @FXML
    private TableColumn<?, ?> colTransactionId;

    @FXML
    private TableColumn<?, ?> colUserName;

    @FXML
    private TableView<RecordsTm> tblRecords;

    @FXML
    private TextField txtBookId;

    @FXML
    private DatePicker txtReturnDate;

    @FXML
    private TextField txtUserEmail;

    @FXML
    private TextField txtTransactionId;

    RecordsBO recordsBO = (RecordsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECORDS_BO);

    public void initialize() {
        setCellValueFactory();
        loadAllRecord();
    }

    private void setCellValueFactory() {
        colTransactionId.setCellValueFactory(new PropertyValueFactory<>("t_id"));
        colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colUserName.setCellValueFactory(new PropertyValueFactory<>("email"));
        colReturnDate.setCellValueFactory(new PropertyValueFactory<>("returnDate"));
        colDateTime.setCellValueFactory(new PropertyValueFactory<>("BorrowDateTime"));
    }

    private void loadAllRecord(){
        ObservableList<RecordsTm> obList = FXCollections.observableArrayList();

        try{
            List<RecordsDto> dtoList = recordsBO.getAllRecords();

            for (RecordsDto dto: dtoList){
                obList.add(
                        new RecordsTm(
                                dto.getT_id(),
                                dto.getId(),
                                dto.getEmail(),
                                dto.getReturnDate(),
                                dto.getBorrowDateTime()));
            }
            tblRecords.setItems(obList);
            tblRecords.refresh();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try{
            RecordsDto dto = new RecordsDto();

            dto.setId(txtBookId.getText());
            dto.setEmail(txtUserEmail.getText());
            dto.setReturnDate(txtReturnDate.getAccessibleText());


            boolean isSaved = recordsBO.saveRecord(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Book Borrowed Sucessfully!").show();
                loadAllRecord();
            }else {
                new Alert(Alert.AlertType.ERROR, "Book Borrowed failed!").show();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        clearFields();
        tblRecords.refresh();
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String t_id = txtTransactionId.getText();

        try{
            boolean isDeleted = recordsBO.deleteRecord(t_id);

            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Borrow Record deleted!").show();
                loadAllRecord();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        clearFields1();
        tblRecords.refresh();
    }

    private void clearFields1() {
        txtTransactionId.setText("");
    }

    @FXML
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtBookId.setText("");
        txtUserEmail.setText("");
        txtReturnDate.setId("");
    }

}

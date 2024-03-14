package lk.ijse.controller.admin;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BranchBO;
import lk.ijse.bo.custom.RecordsBO;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.RecordsDto;

import java.sql.SQLException;

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
    private TableView<?> tblRecords;

    @FXML
    private TextField txtBookId;

    @FXML
    private DatePicker txtReturnDate;

    @FXML
    private TextField txtUserEmail;

    RecordsBO recordsBO = (RecordsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECORDS_BO);
    @FXML
    void btnSaveOnAction(ActionEvent event) {
        try{
            RecordsDto dto = new RecordsDto();

            dto.setId(txtBookId.getText());
            dto.setEmail(txtUserEmail.getText());
            dto.setReturnDate(txtReturnDate.getId());


            boolean isSaved = recordsBO.saveRecord(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Book Borrowed Sucessfully!").show();
                //loadAllRecord();
            }else {
                new Alert(Alert.AlertType.ERROR, "Book Borrowed failed!").show();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
      //  clearFields();
        tblRecords.refresh();
    }


    @FXML
    void btnDeleteOnAction(ActionEvent event) {

    }

}

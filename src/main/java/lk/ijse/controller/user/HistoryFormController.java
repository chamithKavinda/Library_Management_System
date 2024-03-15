package lk.ijse.controller.user;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.RecordsBO;
import lk.ijse.bo.custom.impl.UserBOImpl;
import lk.ijse.dto.RecordsDto;
import lk.ijse.dto.tm.RecordsTm;

import java.sql.SQLException;
import java.util.List;

public class HistoryFormController {

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
                if (dto.getEmail().equals(UserBOImpl.logUserEmail)){
                    obList.add(
                            new RecordsTm(
                                    dto.getT_id(),
                                    dto.getId(),
                                    dto.getEmail(),
                                    dto.getReturnDate(),
                                    dto.getBorrowDateTime()));
                }
            }
            tblRecords.setItems(obList);
            tblRecords.refresh();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

}

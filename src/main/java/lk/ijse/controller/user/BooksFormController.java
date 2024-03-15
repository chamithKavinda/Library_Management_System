package lk.ijse.controller.user;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BooksBO;
import lk.ijse.bo.custom.RecordsBO;
import lk.ijse.dto.BooksDto;
import lk.ijse.dto.RecordsDto;
import lk.ijse.dto.tm.BooksTm;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.util.List;

public class BooksFormController {
    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colBookId;

    @FXML
    private TableColumn<?, ?> colGenre;

    @FXML
    private TableColumn<?, ?> colStatus;

    @FXML
    private TableColumn<?, ?> colTitle;

    @FXML
    private TableView<BooksTm> tblBooks;

    @FXML
    private TextField txtBookId;

    @FXML
    private DatePicker txtReturnDate;

    @FXML
    private TextField txtUserEmail;

    BooksBO booksBO = (BooksBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BOOKS_BO);

    RecordsBO recordsBO = (RecordsBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.RECORDS_BO);
    public void initialize() {
        setCellValueFactory();
        loadAllBooks();
    }

    private void setCellValueFactory() {
        colBookId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colAuthor.setCellValueFactory(new PropertyValueFactory<>("author"));
        colGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        colStatus.setCellValueFactory(new PropertyValueFactory<>("status"));
    }

    private void loadAllBooks(){
        ObservableList<BooksTm> obList = FXCollections.observableArrayList();

        try{
            List<BooksDto> dtoList = booksBO.getAllBooks();

            for (BooksDto dto: dtoList){
                obList.add(
                        new BooksTm(
                                dto.getId(),
                                dto.getTitle(),
                                dto.getAuthor(),
                                dto.getGenre(),
                                dto.getStatus()));
            }
            tblBooks.setItems(obList);
            tblBooks.refresh();
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void btnSaveOnAction1(javafx.event.ActionEvent actionEvent) {
        /*try{
            RecordsDto dto = new RecordsDto();

            dto.setId(txtBookId.getText());
            dto.setEmail(txtUserEmail.getText());
            dto.setReturnDate(txtReturnDate.getAccessibleText());

            boolean isSaved = recordsBO.saveRecord(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Book Borrowed Sucessfully!").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Book Borrowed failed!").show();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }*/

    }
}

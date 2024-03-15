package lk.ijse.controller.user;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BooksBO;
import lk.ijse.bo.custom.RecordsBO;
import lk.ijse.dto.BooksDto;
import lk.ijse.dto.RecordsDto;
import lk.ijse.dto.tm.BooksTm;

import java.sql.SQLException;
import java.util.List;

public class BooksFormController {

    @FXML
    private TextField txtBookSearch;

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
    private TextField txtReturnBookId;

    @FXML
    private TextField txtReturnUserEmail;

    @FXML
    private AnchorPane pane;

    @FXML
    private TableView<BooksTm> tblBooks;

    @FXML
    private TextField txtBorrowBookId;

    @FXML
    private TextField txtBorrowUserEmail;

    @FXML
    private DatePicker txtReturnDate;

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
    @FXML
    public void btnSaveOnAction(ActionEvent actionEvent) {
        try{
            RecordsDto dto = new RecordsDto();
            dto.setId(txtBorrowBookId.getText());
            dto.setEmail(txtBorrowUserEmail.getText());
            dto.setReturnDate(String.valueOf(txtReturnDate.getValue()));

            boolean isSaved = recordsBO.saveRecord(dto);

            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Book Borrowed Sucessfully!").show();
            }else {
                new Alert(Alert.AlertType.ERROR, "Book Borrowed failed!").show();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
    }

    @FXML
    void btnReturnBookOnAction(ActionEvent event) throws SQLException {
        String returnBookId = txtReturnBookId.getText();
        String returnUserEmail = txtReturnUserEmail.getText();

        recordsBO.returnBook(returnBookId,returnUserEmail);

    }


    @FXML
    void txtBookSearchOnAction(ActionEvent event) {
        FilteredList<BooksTm> filteredData = new FilteredList<>(tblBooks.getItems(), b -> true);

        txtBookSearch.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredData.setPredicate(booksTm -> {
                if (newValue == null || newValue.isBlank()) {
                    return true;
                }

                String searchKeyword = newValue.toLowerCase();

                return booksTm.getId().toLowerCase().contains(searchKeyword) ||
                        booksTm.getTitle().toLowerCase().contains(searchKeyword) ||
                        booksTm.getAuthor().toLowerCase().contains(searchKeyword) ||
                        booksTm.getGenre().toLowerCase().contains(searchKeyword) ||
                        booksTm.getStatus().toLowerCase().contains(searchKeyword) ;
            });
        });
        tblBooks.setItems(filteredData);
    }

}

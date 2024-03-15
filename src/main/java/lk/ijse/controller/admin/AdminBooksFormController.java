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
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.BooksBO;
import lk.ijse.dto.BooksDto;
import lk.ijse.dto.tm.BooksTm;


import java.sql.SQLException;
import java.util.List;

public class AdminBooksFormController {

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
    private AnchorPane pane;


    @FXML
    private TextField txtAuthor;

    @FXML
    private TextField txtBookId;

    @FXML
    private TextField txtGenre;

    @FXML
    private TextField txtStatus;

    @FXML
    private TextField txtTitle;

    BooksBO booksBO = (BooksBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.BOOKS_BO);

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
    void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    private void clearFields() {
        txtBookId.setText("");
        txtTitle.setText("");
        txtAuthor.setText("");
        txtGenre.setText("");
        txtStatus.setText("");
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        String id = txtBookId.getText();

        try{
            boolean isDeleted = booksBO.deleteBooks(id);

            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION,"Books deleted!").show();
                loadAllBooks();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    @FXML
    void btnSaveOnAction(ActionEvent event) {

        try{
            BooksDto dto = new BooksDto();

            dto.setId(txtBookId.getText());
            dto.setTitle(txtTitle.getText());
            dto.setAuthor(txtAuthor.getText());
            dto.setGenre(txtGenre.getText());
            dto.setStatus(txtStatus.getText());

            boolean isSaved = booksBO.saveBooks(dto);
            if (isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Books Saved").show();
                loadAllBooks();
            }else {
                new Alert(Alert.AlertType.ERROR, "Books not saved").show();
            }
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }
        clearFields();
        tblBooks.refresh();
    }


    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtBookId.getText();
        String title = txtTitle.getText();
        String author = txtAuthor.getText();
        String genre = txtGenre.getText();
        String status = txtStatus.getText();

        var dto = new BooksDto(id,title,author,genre,status);

        try{
            boolean isUpdated = booksBO.updateBooks(dto);
            if (isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, "Books Updated!").show();
                loadAllBooks();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

}

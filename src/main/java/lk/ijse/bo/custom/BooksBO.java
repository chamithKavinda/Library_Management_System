package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BooksDto;

import java.sql.SQLException;
import java.util.List;

public interface BooksBO extends SuperBO {
    List<BooksDto> getAllBooks() throws SQLException;
    boolean saveBooks(BooksDto dto)throws SQLException;
    boolean updateBooks(final BooksDto dto) throws SQLException;
    boolean deleteBooks(String id) throws SQLException;
}

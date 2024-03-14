package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BooksDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface BooksBO extends SuperBO {
    boolean saveBooks(BooksDto dto)throws SQLException;
    boolean updateBooks(final BooksDto dto) throws SQLException;
}

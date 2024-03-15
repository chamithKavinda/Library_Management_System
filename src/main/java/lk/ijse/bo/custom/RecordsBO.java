package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RecordsDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface RecordsBO extends SuperBO {
    List<RecordsDto> getAllRecords() throws SQLException;
    boolean deleteRecord(String t_id) throws SQLException;

    boolean saveRecord(RecordsDto dto) throws SQLException;

    boolean returnBook(String returnBookId, String returnUserEmail) throws SQLException;
}

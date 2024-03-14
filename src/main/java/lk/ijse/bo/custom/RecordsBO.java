package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.RecordsDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface RecordsBO extends SuperBO {

    boolean deleteRecord(String t_id) throws SQLException;

    boolean saveRecord(RecordsDto dto) throws SQLException;
}

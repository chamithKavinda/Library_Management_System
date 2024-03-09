package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.AdminDto;

import java.sql.SQLException;

public interface AdminBO extends SuperBO {
    boolean saveAdmin(AdminDto dto) throws SQLException;
    String getEmail(String Email) throws SQLException, ClassNotFoundException;
    boolean isExistAdmin(String AdminName, String AdminPassword) throws SQLException,ClassNotFoundException;


}

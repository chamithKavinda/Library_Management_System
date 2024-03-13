package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {

    List<UserDto> getAllUsers() throws SQLException;
    boolean saveUser(UserDto dto)throws SQLException;

    boolean deleteUser(String email) throws SQLException;

    boolean updateUser(final UserDto dto) throws SQLException;

    String getEmail(String Email) throws SQLException, ClassNotFoundException;
    boolean isExistUser(String UserName, String UserPassword)throws SQLException, ClassNotFoundException;
}

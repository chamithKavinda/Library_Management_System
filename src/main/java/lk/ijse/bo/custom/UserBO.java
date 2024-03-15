package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;
import java.util.List;

public interface UserBO extends SuperBO {

    List<UserDto> getAllUsers() throws SQLException;
    boolean saveUser(UserDto dto)throws SQLException;

    boolean deleteUser(String email) throws SQLException;

    boolean updateUser( UserDto dto) throws SQLException;

    boolean IsExistUser(String UserEmail,String UserPassword ,String UserName);

    boolean getEmail(String email);

}

package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean saveUser(UserDto dto)throws SQLException {
        return userDAO.save(new User(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()));
    }
    @Override
    public String getEmail(String Email)throws SQLException, ClassNotFoundException{
        return userDAO.getEmail(Email);
    }
    @Override
    public boolean isExistUser(String UserName, String UserPassword)throws SQLException, ClassNotFoundException{
        return userDAO.exist(UserName,UserPassword);
    }
}

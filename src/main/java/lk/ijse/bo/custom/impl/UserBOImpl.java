package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.UserBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserBOImpl implements UserBO {
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

   public static String logUserEmail;
   public static String logPassword;

   public static String logUserName;

    @Override
    public List<UserDto> getAllUsers() throws SQLException {
        List<User> entityList = userDAO.getAll();

        List<UserDto> dtoList = new ArrayList<>();

        for (User user:entityList){
            dtoList.add(new UserDto(
                    user.getName(),
                    user.getEmail(),
                    user.getPassword()));
        }
        return dtoList;
    }

    @Override
    public boolean saveUser(UserDto dto)throws SQLException {
        return userDAO.save(new User(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()));
    }


    @Override
    public boolean deleteUser(String email) throws SQLException {
        return userDAO.delete(email);
    }

    @Override
    public boolean updateUser(UserDto dto) throws SQLException {
        return userDAO.update(new User(
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()));
    }

    @Override
    public boolean IsExistUser(String UserEmail, String UserPassword , String UserName) {
        User search = userDAO.search(UserEmail);
        if (search != null) {
            if (search.getPassword().equals(UserPassword)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getEmail(String email) {
        User search = userDAO.search(email);
        if (search != null) {
           return true;
        }
        return false;
    }

}

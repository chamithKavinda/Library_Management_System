package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends CrudDAO<User> {

    List<User> getAll();

    String getEmail(String Email)throws SQLException, ClassNotFoundException;

    boolean save(User entity);

    boolean exist(String UserName, String UserPassword) throws SQLException, ClassNotFoundException;
}

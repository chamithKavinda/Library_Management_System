package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface UserDAO extends CrudDAO<User> {

    List<User> getAll();

    boolean delete(String email) throws SQLException;

    User search(String email);

    boolean save(User entity);



}

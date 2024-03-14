package lk.ijse.dao;

import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface CrudDAO <T> extends SuperDAO{
    List<T> getAll() throws SQLException;

    boolean save(T t) throws SQLException;

    boolean delete(String email) throws SQLException;

    boolean update(T t) throws SQLException;
}

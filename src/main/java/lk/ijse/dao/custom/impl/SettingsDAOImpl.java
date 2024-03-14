package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.SettingsDAO;
import lk.ijse.dao.custom.UserDAO;

import java.sql.SQLException;
import java.util.List;

public class SettingsDAOImpl implements SettingsDAO {
    @Override
    public List<UserDAO> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(UserDAO userDAO) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String email) throws SQLException {
        return false;
    }

    @Override
    public boolean update(UserDAO userDAO) throws SQLException {
        return false;
    }
}

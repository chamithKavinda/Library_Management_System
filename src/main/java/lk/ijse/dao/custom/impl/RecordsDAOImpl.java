package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.RecordsDAO;
import lk.ijse.entity.Records;

import java.sql.SQLException;
import java.util.List;

public class RecordsDAOImpl implements RecordsDAO {
    @Override
    public List<Records> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Records records) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String email) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Records records) throws SQLException {
        return false;
    }
}

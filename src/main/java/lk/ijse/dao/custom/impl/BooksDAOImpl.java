package lk.ijse.dao.custom.impl;

import lk.ijse.dao.custom.BooksDAO;
import lk.ijse.entity.Books;

import java.sql.SQLException;
import java.util.List;

public class BooksDAOImpl implements BooksDAO {
    @Override
    public List<Books> getAll() {
        return null;
    }

    @Override
    public boolean save(Books books) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String email) throws SQLException {
        return false;
    }

    @Override
    public boolean update(Books books) throws SQLException {
        return false;
    }
}

package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BooksBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BooksDAO;
import lk.ijse.dto.BooksDto;
import lk.ijse.entity.Books;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BooksBOImpl implements BooksBO {

    BooksDAO booksDAO = (BooksDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKS);

    @Override
    public boolean saveBooks(BooksDto dto) throws SQLException {
        return booksDAO.save(new Books(
                dto.getId(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getGenre(),
                dto.getStatus()));
    }

    @Override
    public boolean updateBooks(BooksDto dto) throws SQLException {
        return booksDAO.update(new Books(
                dto.getId(),
                dto.getTitle(),
                dto.getAuthor(),
                dto.getGenre(),
                dto.getStatus()));
    }
}

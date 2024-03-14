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
    public List<BooksDto> getAllBooks() throws SQLException {
        List<Books> entityList = booksDAO.getAll();

        List<BooksDto> dtoList = new ArrayList<>();

        for (Books books:entityList){
            dtoList.add(new BooksDto(
                    books.getId(),
                    books.getTitle(),
                    books.getAuthor(),
                    books.getGenre(),
                    books.getStatus()));
        }
        return dtoList;
    }

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

    @Override
    public boolean deleteBooks(String id) throws SQLException {
        return booksDAO.delete(id);
    }
}

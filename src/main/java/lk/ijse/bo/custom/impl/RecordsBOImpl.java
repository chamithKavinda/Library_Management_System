package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RecordsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BooksDAO;
import lk.ijse.dao.custom.RecordsDAO;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.RecordsDto;
import lk.ijse.entity.Books;
import lk.ijse.entity.Records;
import lk.ijse.entity.User;

import java.sql.SQLException;

public class RecordsBOImpl implements RecordsBO {
    RecordsDAO recordsDAO = (RecordsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECORDS);
    BooksDAO booksDAO = (BooksDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKS);
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);

    @Override
    public boolean deleteRecord(String t_id) throws SQLException {
        return recordsDAO.delete(t_id);
    }

    @Override
    public boolean saveRecord(RecordsDto dto) throws SQLException {

        Books books = booksDAO.search(dto.getId());
        books.setStatus("Not-Available");

        User user = userDAO.search(dto.getEmail());


        return recordsDAO.save(new Records(
                dto.getReturnDate(),
                books,
                user));
    }


}

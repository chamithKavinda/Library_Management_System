package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RecordsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BooksDAO;
import lk.ijse.dao.custom.RecordsDAO;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.dto.RecordsDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Books;
import lk.ijse.entity.Records;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RecordsBOImpl implements RecordsBO {
    RecordsDAO recordsDAO = (RecordsDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.RECORDS);
    BooksDAO booksDAO = (BooksDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BOOKS);
    UserDAO userDAO = (UserDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.USER);


    @Override
    public List<RecordsDto> getAllRecords() throws SQLException {
        List<Records> entityList = recordsDAO.getAll();

        List<RecordsDto> dtoList = new ArrayList<>();

        for (Records records:entityList){

            dtoList.add(new RecordsDto(
                    records.getT_id(),
                    records.getId().getId(),
                    records.getEmail().getEmail(),
                    records.getReturnDate(),
                    records.getBorrowDateTime().toString()));
        }
        return dtoList;
    }

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

    @Override
    public boolean returnBook(String returnBookId, String returnUserEmail) throws SQLException {
        Books search = booksDAO.search(returnBookId);
        search.setStatus("Available");
        boolean update = booksDAO.update(search);
        if (update){
            return true;
        }
        return false;
    }


}

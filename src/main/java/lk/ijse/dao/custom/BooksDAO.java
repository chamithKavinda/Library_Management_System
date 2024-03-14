package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Books;
import lk.ijse.entity.User;

import java.util.List;

public interface BooksDAO extends CrudDAO<Books> {

    List<Books> getAll();
    boolean save(Books entity);
}

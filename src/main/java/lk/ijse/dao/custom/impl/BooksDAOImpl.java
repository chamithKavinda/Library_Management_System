package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dao.custom.BooksDAO;
import lk.ijse.entity.Admin;
import lk.ijse.entity.Books;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class BooksDAOImpl implements BooksDAO {

    @Override
    public boolean save(Books entity) {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.save(entity);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public Books search(String id) {
        Session session = SessionFactoryConfig.getInstance().getSession();

        try {
            Books books= session.get(Books.class, id);
            return books;
        } catch (Exception e) {
            return null;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String id) throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            Books books = session.get(Books.class,id);
            session.delete(books);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean update(Books books) throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(books);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public List<Books> getAll() {
        Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "FROM Books";
        Query query = session.createQuery(sql);
        List<Books> userList = query.list();
        session.close();
        return userList;
    }
}

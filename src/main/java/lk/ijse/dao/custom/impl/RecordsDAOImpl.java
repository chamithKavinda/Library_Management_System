package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dao.custom.RecordsDAO;
import lk.ijse.entity.Books;
import lk.ijse.entity.Records;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;
import java.util.List;

public class RecordsDAOImpl implements RecordsDAO {
    @Override
    public List<Records> getAll() throws SQLException {
        return null;
    }

    @Override
    public boolean save(Records records) throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            session.save(records);
            session.update(records.getId());
            transaction.commit();
            return true;
        } catch (Exception e) {
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }

    @Override
    public boolean delete(String email) throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();

        try{
            Records records = session.get(Records.class,Integer.parseInt(email));
            Books books = records.getId();
            books.setStatus("Available");
            session.update(books);
            session.delete(records);
            transaction.commit();
            return true;
        }catch (Exception e){
            e.printStackTrace();
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }



    @Override
    public boolean update(Records records) throws SQLException {
        return false;
    }
}

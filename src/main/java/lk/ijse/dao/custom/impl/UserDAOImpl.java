package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dao.custom.UserDAO;
import lk.ijse.entity.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    @Override
    public List<User> getAll(){
        Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "FROM User";
        Query query = session.createQuery(sql);
        List<User> userList = query.list();
        session.close();
        return userList;
    }

    @Override
    public String getEmail(String Email) throws SQLException, ClassNotFoundException {
        return null;
    }
    @Override
    public boolean save(User entity){
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
    public boolean update(User user) throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.update(user);
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
    public boolean exist(String UserName, String UserPassword) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        try  {
            String hql = "SELECT COUNT(*) FROM User WHERE user_name = :username AND user_password = :password";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("username", UserName);
            query.setParameter("password", UserPassword);

            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean delete(String email) throws SQLException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try{
            session.delete(email);
            transaction.commit();
            return true;
        }catch (Exception e){
            transaction.rollback();
            return false;
        }finally {
            session.close();
        }
    }


}

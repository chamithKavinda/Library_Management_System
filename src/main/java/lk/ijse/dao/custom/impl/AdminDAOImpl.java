package lk.ijse.dao.custom.impl;

import lk.ijse.config.SessionFactoryConfig;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.entity.Admin;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AdminDAOImpl implements AdminDAO {
    @Override
    public List<Admin> getAll(){
        Session session = SessionFactoryConfig.getInstance().getSession();
        String sql = "FROM Admin";
        Query query = session.createQuery(sql);
        List<Admin> adminList = query.list();
        session.close();
        return adminList;
    }
    @Override
    public boolean save(Admin entity){
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
    public String getEmail(String Email) throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean exist(String AdminName, String AdminPassword) throws SQLException, ClassNotFoundException {
        Session session = SessionFactoryConfig.getInstance().getSession();
        try  {
            String hql = "SELECT COUNT(*) FROM Admin WHERE admin_name = :adminname AND admin_password = :password";
            Query<Long> query = session.createQuery(hql, Long.class);
            query.setParameter("adminname", AdminName);
            query.setParameter("password", AdminPassword);

            Long count = query.uniqueResult();
            return count != null && count > 0;
        } catch (Exception e) {
            // Handle exceptions
            e.printStackTrace();
            return false;
        }
    }



}

package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Admin;

import java.sql.SQLException;
import java.util.List;

public interface AdminDAO extends CrudDAO<Admin> {
    List<Admin> getAll();

    boolean save(Admin dto)throws SQLException ;

    String getEmail(String Email)throws SQLException, ClassNotFoundException;

     boolean exist(String AdminName, String adminPassword)throws SQLException, ClassNotFoundException;
}

package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AdminBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.AdminDAO;
import lk.ijse.dto.AdminDto;
import lk.ijse.entity.Admin;

import java.sql.SQLException;

public class AdminBOImpl implements AdminBO {
    AdminDAO adminDAO = (AdminDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.ADMIN);

    @Override
    public boolean saveAdmin(AdminDto dto)throws SQLException {
        return adminDAO.save(new Admin(
                dto.getId(),
                dto.getName(),
                dto.getEmail(),
                dto.getPassword()));
    }

    @Override
    public String getEmail(String Email)throws SQLException, ClassNotFoundException{
        return adminDAO.getEmail(Email);
    }

    @Override
    public boolean isExistAdmin(String AdminName, String AdminPassword)throws SQLException, ClassNotFoundException{
        return adminDAO.exist(AdminName,AdminPassword);
    }
}

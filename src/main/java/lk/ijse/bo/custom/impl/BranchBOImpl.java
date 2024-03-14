package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BooksDAO;
import lk.ijse.dao.custom.BranchDAO;
import lk.ijse.dto.BranchDto;
import lk.ijse.entity.Branch;

import java.sql.SQLException;

public class BranchBOImpl implements BranchBO {
    BranchDAO branchDAO = (BranchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BRANCH);

    @Override
    public boolean saveBranch(BranchDto dto) throws SQLException {
        return branchDAO.save(new Branch(
                dto.getId(),
                dto.getName(),
                dto.getContact(),
                dto.getCity()
        ));
    }

    @Override
    public boolean deleteBranch(String id) throws SQLException {
        return branchDAO.delete(id);
    }

    @Override
    public boolean updateBranch(BranchDto dto) throws SQLException {
        return branchDAO.update(new Branch(
                dto.getId(),
                dto.getName(),
                dto.getContact(),
                dto.getCity()));
    }
}

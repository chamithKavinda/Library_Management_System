package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.BranchBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.BooksDAO;
import lk.ijse.dao.custom.BranchDAO;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BranchBOImpl implements BranchBO {
    BranchDAO branchDAO = (BranchDAO) DAOFactory.getInstance().getDAO(DAOFactory.DAOTypes.BRANCH);

    @Override
    public List<BranchDto> getAllBranch() throws SQLException {
        List<Branch> entityList = branchDAO.getAll();

        List<BranchDto> dtoList = new ArrayList<>();

        for (Branch branch:entityList){
            dtoList.add(new BranchDto(
                    branch.getId(),
                    branch.getName(),
                    branch.getContact(),
                    branch.getCity()));
        }
        return dtoList;
    }

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

    @Override
    public BranchDto searchBranch(String id) throws SQLException {
        Branch branch = branchDAO.search(id);
        return new BranchDto(branch.getId(), branch.getName(), branch.getContact(), branch.getCity());
    }
}

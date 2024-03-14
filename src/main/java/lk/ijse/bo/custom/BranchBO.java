package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dto.BooksDto;
import lk.ijse.dto.BranchDto;
import lk.ijse.dto.UserDto;

import java.sql.SQLException;

public interface BranchBO extends SuperBO {
    boolean saveBranch(BranchDto dto)throws SQLException;
    boolean updateBranch(final BranchDto dto) throws SQLException;
}

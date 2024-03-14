package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.dao.SuperDAO;
import lk.ijse.entity.Branch;
import lk.ijse.entity.User;

public interface BranchDAO extends CrudDAO<Branch> {
    boolean save(Branch entity);
}

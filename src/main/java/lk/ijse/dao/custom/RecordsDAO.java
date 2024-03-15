package lk.ijse.dao.custom;

import lk.ijse.dao.CrudDAO;
import lk.ijse.entity.Records;
import lk.ijse.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface RecordsDAO extends CrudDAO<Records> {

    List<Records> getAll();
}

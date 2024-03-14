package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;
    private DAOFactory(){}
    public static DAOFactory getInstance(){
        return (daoFactory==null)?daoFactory=new DAOFactory():daoFactory;
    }

    public enum DAOTypes{
        ADMIN , USER , BOOKS ,BRANCH,RECORDS
    }

    public SuperDAO getDAO(DAOTypes daoTypes){
        switch (daoTypes){
            case ADMIN:
                return new AdminDAOImpl();
            case USER:
                return new UserDAOImpl();
            case BOOKS:
                return new BooksDAOImpl();
            case BRANCH:
                return new BranchDAOImpl();
            case RECORDS:
                return new RecordsDAOImpl();
            default:
                return null;
        }
    }
}

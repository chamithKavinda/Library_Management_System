package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory bOFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return (bOFactory==null)?bOFactory=new BOFactory():bOFactory;
    }

    public enum BOTypes{
        ADMIN_BO ,USER_BO ,BOOKS_BO,BRANCH_BO,RECORDS_BO
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case ADMIN_BO:
                return new AdminBOImpl();
            case USER_BO:
                return new UserBOImpl();
            case BOOKS_BO:
                return new BooksBOImpl();
            case BRANCH_BO:
                return new BranchBOImpl();
            case RECORDS_BO:
                return new RecordsBOImpl();
            default:
                return null;
        }
    }
}

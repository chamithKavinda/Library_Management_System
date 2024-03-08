package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;
public class BOFactory {
    private static BOFactory bOFactory;
    private BOFactory(){}

    public static BOFactory getInstance(){
        return (bOFactory==null)?bOFactory=new BOFactory():bOFactory;
    }

    public enum BOTypes{
        ADMIN_BO
    }

    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case ADMIN_BO:
                return new AdminBOImpl();
            default:
                return null;
        }
    }
}

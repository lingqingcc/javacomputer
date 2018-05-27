package com.smart.domain;

public class DAOFactory {
    public static TeacheruserDao getTeacherDaoInstance() {
        return new TeacheruserDaoImpl();
    }
}

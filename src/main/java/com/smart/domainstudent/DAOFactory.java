package com.smart.domainstudent;

public class DAOFactory {
    public static  student_userDao getstudentDaoInstance() {return new student_userDaompl() ;}
}

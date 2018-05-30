package com.smart.domainstudent;

import java.sql.SQLException;
import java.util.List;

public interface student_userDao{
    public void update(student_user student_user);
    public void delete(String student_id);
    public void insert(student_user student_user);
    public student_user  queryById(int student_id) throws SQLException;
    public List queryALL();
}

package com.smart.domain;

import java.util.List;

public interface TeacheruserDao {
    public void insert(teacheruser teacheruser);
    public void update(teacheruser teacheruser);
    public void delete(String userid);
    public teacheruser queryById(String userid);
    public List queryAll();
}

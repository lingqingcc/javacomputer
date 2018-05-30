package com.smart.domainstudent;

public class student_user {
    private int student_id;
    private String student_name;
    private String student_username;
    private String student_userpwd;
    private String student_phonenum;

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_username() {
        return student_username;
    }

    public void setStudent_username(String student_username) {
        this.student_username = student_username;
    }

    public String getStudent_userpwd() {
        return student_userpwd;
    }

    public void setStudent_userpwd(String student_userpwd) {
        this.student_userpwd = student_userpwd;
    }

    public String getStudent_phonenum() {
        return student_phonenum;
    }

    public void setStudent_phonenum(String student_phonenum) {
        this.student_phonenum = student_phonenum;
    }

    @Override
    public String toString() {
        return "student_user{" +
                "student_id=" + student_id +
                ", student_name='" + student_name + '\'' +
                ", student_username='" + student_username + '\'' +
                ", student_userpwd='" + student_userpwd + '\'' +
                ", student_phonenum='" + student_phonenum + '\'' +
                '}';
    }
}


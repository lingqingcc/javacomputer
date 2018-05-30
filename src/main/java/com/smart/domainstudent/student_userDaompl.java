package com.smart.domainstudent;

import com.smart.dao.DBoperator;
import com.smart.domain.teacheruser;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class student_userDaompl implements student_userDao {


    @Override
    public void update(student_user student_user) {
        String sql = "update student_user(student_id,student_name,student_username,student_userpwd,student_phonenum) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        DBoperator db = null;
        db = new DBoperator();
        try {
            pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, student_user.getStudent_id());
            pstmt.setString(2, student_user.getStudent_name());
            pstmt.setString(3, student_user.getStudent_username());
            pstmt.setString(4, student_user.getStudent_userpwd());
            pstmt.setString(5, student_user.getStudent_phonenum());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    @Override
    public void delete(String student_id) {
        String sql="delete from student_user where student_id=?";
        PreparedStatement pstmt = null;
        DBoperator db = null;
        try {
            db= new DBoperator();
            pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, Integer.parseInt(student_id));
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
    }

    @Override
    public void insert(student_user student_user) {
        String sql = "insert into student_user(student_id,student_name,student_username,student_userpwd,student_phonenum) VALUES(?,?,?,?,?)";
        PreparedStatement pstmt = null;
        DBoperator db = null;
        try {
            db = new DBoperator();
            pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, student_user.getStudent_id());
            pstmt.setString(2, student_user.getStudent_name());
            pstmt.setString(3, student_user.getStudent_username());
            pstmt.setString(4, student_user.getStudent_userpwd());
            pstmt.setString(5, student_user.getStudent_phonenum());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

    }

    @Override
    public student_user queryById(int student_id) {
        String sql = "select student_id,student_name,student_username,student_userpwd,student_phonenum" +
                "from studnet_user where studentid=?";
        PreparedStatement pstmt = null;
        DBoperator db = null;
        try {
            db = new DBoperator();
            pstmt = db.getConnection().prepareStatement(sql);
            pstmt.setInt(1, student_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String names = rs.getString(2);
                String usernames = rs.getString(3);
                String pwd = rs.getString(4);
                String num = rs.getString(5);
                student_user stuser = new student_user();
                stuser.setStudent_id(student_id);
                stuser.setStudent_name(names);
                stuser.setStudent_username(usernames);
                stuser.setStudent_userpwd(pwd);
                stuser.setStudent_phonenum(num);
                return stuser;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }
        return null;
    }


    @Override
    public List queryALL() {
        String sql="select * from studnet_user";
        Statement stmt = null;
        DBoperator db = null;
        List list= null;
        try {
            db = new DBoperator();
            stmt = db.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            list = new ArrayList();
            while(rs.next()){
                int student_id=rs.getInt(1);
                String student_name=rs.getString(2);
                String student_username=rs.getString(3);
                String student_userpwd=rs.getString(4);
                String student_phonenum=rs.getString(5);
               student_user stuser= new student_user();
                stuser.setStudent_id(student_id);
                stuser.setStudent_name(student_name);
                stuser.setStudent_username(student_username);
                stuser.setStudent_userpwd(student_userpwd);
                stuser.setStudent_phonenum(student_phonenum);
                list.add(stuser);

            }
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            db.close();
        }

        return null;
    }
}



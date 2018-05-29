package com.smart.domain;

import com.smart.dao.DBoperator;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TeacheruserDaoImpl implements TeacheruserDao {
    @Override
    public void insert(teacheruser teacheruser) {
        String sql="insert into t_teacher(user_id, name, user_name, password, phonenumber) VALUES (?,?,?,?,?)";
       PreparedStatement pstmt = null;
        DBoperator dbc = null;
        try {
            dbc = new DBoperator();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,teacheruser.getUserid());
            pstmt.setString(2,teacheruser.getNames());
            pstmt.setString(3,teacheruser.getUsernames());
            pstmt.setString(4,teacheruser.getPwd());
            pstmt.setString(5,teacheruser.getNumber());
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    @Override
    public void update(teacheruser teacheruser) {
           String sql="update t_teacher set user_id=?,name=?,user_name=?,password=?,phonenumber=? ";
        PreparedStatement pstmt = null;
        DBoperator dbc = null;
        try {
            dbc = new DBoperator();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,teacheruser.getUserid());
            pstmt.setString(2,teacheruser.getNames());
            pstmt.setString(3,teacheruser.getUsernames());
            pstmt.setString(4,teacheruser.getPwd());
            pstmt.setString(5,teacheruser.getNumber());
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    @Override
    public void delete(String userid)  {
        String sql="delete from t_teacher where user_id=?";
        PreparedStatement pstmt = null;
        DBoperator dbc = null;
        try {
            dbc = new DBoperator();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,userid);
            pstmt.executeUpdate();
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
    }

    @Override
    public teacheruser queryById(String userid) {
        String sql="select user_id,name,user_name,password,phonenumber" +
                " from t_teacher where user_id=?";
        PreparedStatement pstmt = null;
        DBoperator dbc = null;
        try {
            dbc = new DBoperator();
            pstmt = dbc.getConnection().prepareStatement(sql);
            pstmt.setString(1,userid);
            ResultSet rs=pstmt.executeQuery();
            if(rs.next()){
                String names=rs.getString(2);
                String usernames=rs.getString(3);
                String pwd=rs.getString(4);
                String num=rs.getString(5);
                teacheruser teuser=new teacheruser();
                teuser.setUserid(userid);
                teuser.setNames(names);
                teuser.setUsernames(usernames);
                teuser.setPwd(pwd);
                teuser.setNumber(num);
                return teuser;
            }
            pstmt.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return null;
    }

    @Override
    public List queryAll() {
        String sql="select * from t_teacher ";
        Statement stmt = null;
        DBoperator dbc = null;
        try {
            dbc = new DBoperator();
            stmt = dbc.getConnection().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            List list=new ArrayList();
            while(rs.next()){
                String id=rs.getString(1);
                String names=rs.getString(2);
                String usernames=rs.getString(3);
                String pwd=rs.getString(4);
                String num=rs.getString(5);
                teacheruser teuser=new teacheruser();
                teuser.setUserid(id);
                teuser.setNames(names);
                teuser.setUsernames(usernames);
                teuser.setPwd(pwd);
                teuser.setNumber(num);
                list.add(teuser);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbc.close();
        }
        return null;
    }
}

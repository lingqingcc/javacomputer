package com.smart.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBoperator {
        final String DRIVER = "com.mysql.jdbc.Driver";
        final String USER = "root";
        final String PWD = "123456";
        final String URL = "jdbc:mysql://localhost:3306/java";
    private Connection conn = null;

    public DBoperator() {
        try {
            Class.forName(DRIVER);
            this.conn = DriverManager.getConnection(URL, USER, PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return conn;
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

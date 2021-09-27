package com.example.demo.mysqlConnector;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection connectToDB() {
        Connection connection=null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","password");
            System.out.println("database connected");
        } catch (Exception ex) {
            System.out.println("there is error in mysql");
            System.out.println(ex);
        }
        return connection;
    }
}

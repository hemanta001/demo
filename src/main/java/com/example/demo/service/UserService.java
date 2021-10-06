package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.mysqlConnector.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserService {

    public User readUserByEmailAndPassword(String email, String password) {
        User user = null;
        try {
            String query = "select * from user where email=? and password=?";
            Connection connection = new DatabaseConnection().connectToDB();
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, email);
            preparedStmt.setString(2, password);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void insertUser(User user) {
        try {
            Connection connection = new DatabaseConnection().connectToDB();
            String query = " insert into user (firstName, lastName, email, username ,password)"
                    + " values (?, ?, ?, ?,?)";
            PreparedStatement preparedStmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStmt.setString(1, user.getFirstName());
            preparedStmt.setString(2, user.getLastName());
            preparedStmt.setString(3, user.getEmail());
            preparedStmt.setString(4, user.getUsername());
            preparedStmt.setString(5, user.getPassword());
            preparedStmt.execute();
            ResultSet rs = preparedStmt.getGeneratedKeys();
            if (rs.next()) {
                user.setId(rs.getLong(1));
            }
            connection.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public List<User> readUsers() {
        List<User> userList = new ArrayList<>();
        try {
            String query = "select * from user order by id desc";
            Connection connection = new DatabaseConnection().connectToDB();
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            ResultSet rs = preparedStatement.executeQuery();
            User user;
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

                userList.add(user);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userList;
    }

    public void updateUser(User user) {
        try {
            String query = "update user set firstName = ?,lastName=?,email=?,username=?,password=? where id = ?";
            Connection connection = new DatabaseConnection().connectToDB();
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setString(1, user.getFirstName());
            preparedStmt.setString(2, user.getLastName());
            preparedStmt.setString(3, user.getEmail());
            preparedStmt.setString(4, user.getUsername());
            preparedStmt.setString(5, user.getPassword());
            preparedStmt.setLong(6, user.getId());
            preparedStmt.execute();
            connection.close();
        } catch (SQLException e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

    public User readUserById(Long id) {
        User user = null;
        try {
            String query = "select * from user where id=?";
            Connection connection = new DatabaseConnection().connectToDB();
            PreparedStatement preparedStmt = connection.prepareStatement(query);
            preparedStmt.setLong(1, id);
            ResultSet rs = preparedStmt.executeQuery();
            while (rs.next()) {
                user = new User();
                user.setId(rs.getLong("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));

            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

}

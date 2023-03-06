/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trainjava.dao;

import com.trainingjava.model.User;
import java.util.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class UserDao {

    public List<User> getAllUsers() {

        List<User> users = new ArrayList<User>();
        Connection conn = JDBCConnection.getJDBConnection();
        try {
            String sql = "SELECT * FROM USERS";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("URNAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("URPASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setRole(rs.getString("URROLE"));
                user.setFavourite(rs.getString("FAVOURITE"));

                users.add(user);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return users;

    }

    public void addUser(User user) {
        try {
            Connection conn = JDBCConnection.getJDBConnection();

            String sql = "INSERT INTO USERS(URNAME, PHONE,USERNAME, URPASSWORD,ABOUT,URROLE,FAVOURITE) VALUES(?,?,?,?,?,?,?)";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setString(7, user.getFavourite());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }

    public User getUserbyID(int id) {
        Connection conn = JDBCConnection.getJDBConnection();
        try {

            String sql = "SELECT * FROM USERS WHERE ID = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("ID"));
                user.setName(rs.getString("URNAME"));
                user.setPhone(rs.getString("PHONE"));
                user.setUsername(rs.getString("USERNAME"));
                user.setPassword(rs.getString("URPASSWORD"));
                user.setAbout(rs.getString("ABOUT"));
                user.setRole(rs.getString("URROLE"));
                user.setFavourite(rs.getString("FAVOURITE"));
                return user;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    public void UpdateUser(User user) {
        Connection conn = JDBCConnection.getJDBConnection();
        try {

            String sql = " UPDATE USERS SET URNAME = ?, PHONE = ?, USERNAME = ?, URPASSWORD = ?, ABOUT = ?, URROLE = ?, FAVOURITE = ? WHERE ID = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setNString(1, user.getName());
            preparedStatement.setNString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setString(7, user.getFavourite());
            preparedStatement.setInt(8, user.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void deleteUser(int id) {
        try {
            Connection conn = JDBCConnection.getJDBConnection();

            String sql = "DELETE FROM USERS WHERE ID = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setInt(1, id);

            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

//    public int checkLogIn(String userString, String passowrdString) {
//        int check = 0;
//        try {
//            Connection conn = JDBCConnection.getJDBConnection();
//
//            String sql = "{call getusers(?,?,?)}";
//            CallableStatement callableStatement = conn.prepareCall(sql);
//
//            callableStatement.setString(1, userString);
//            callableStatement.setString(2, passowrdString);
//            callableStatement.registerOutParameter(3, java.sql.Types.INTEGER);
//            callableStatement.execute();
//            
//             check = callableStatement.getInt(3);
//            if (check == 1) {
//                return check;
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//        }
//        return check;
//    }
    public int checkLogin(String userString, String passwordString) {
        int check = 0;
        Connection conn = JDBCConnection.getJDBConnection();
        try {

            String sql = "SELECT COUNT(*) AS TONG FROM USERS WHERE USERNAME = ? AND URPASSWORD = ?";

            PreparedStatement preparedStatement = conn.prepareStatement(sql);

            preparedStatement.setString(1, userString);
            preparedStatement.setString(2, passwordString);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            check = rs.getInt("TONG");
            if(check == 1){
                return check;
            }else{
                return check;
            }
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
        return check;
    }
}

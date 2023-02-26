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

        String sql = "SELECT * FROM USERS";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            ResultSet rs = preparedStatement.executeQuery();
            
            while(rs.next()){
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
    
    public void addUser(User user){
        
        try {
            Connection conn = JDBCConnection.getJDBConnection();
            
            String sql = "INSERT INTO USERS(URNAME,PHONE,USERNAME,URPASSWORD,ABOUT,URROLE,FAVOURITE) VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = conn.prepareCall(sql);
            
           // preparedStatement.setInt(0, user.getId());
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getPhone());
            preparedStatement.setString(3, user.getUsername());
            preparedStatement.setString(4, user.getPassword());
            preparedStatement.setString(5, user.getAbout());
            preparedStatement.setString(6, user.getRole());
            preparedStatement.setString(7, user.getFavourite());
            
            int rs = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        
    }
    
    public void updateUser(User user){
        try {
            Connection conn = JDBCConnection.getJDBConnection();
            
            String sql = " UPDATE USERS SET URNAME = ?, PHONE = ?, USERNAME = ?, URPASSWORD = ?, ABOUT = ?, URROLE = ?, FAVOURITE = ? WHERE ID = ?";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setNString(0, user.getName());
            preparedStatement.setNString(1, user.getPhone());
            preparedStatement.setString(2, user.getUsername());
            preparedStatement.setString(3, user.getPassword());
            preparedStatement.setString(4, user.getAbout());
            preparedStatement.setString(5, user.getRole());
            preparedStatement.setString(6, user.getFavourite());
            preparedStatement.setInt(7, user.getId());
            
            int rs = preparedStatement.executeUpdate();
            
            System.out.println(rs);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    public void deleteUser(int id){
        try {
            Connection conn = JDBCConnection.getJDBConnection();
            
            String sql = "DELETE FROM USERS WHERE ID = ?";
            
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            
            preparedStatement.setInt(0, id);
            
            int rs  = preparedStatement.executeUpdate();
            System.out.println(rs);
        } catch (SQLException ex) {
           ex.printStackTrace();
        }
    }
}


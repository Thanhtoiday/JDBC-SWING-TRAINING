/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trainingjava.service;

import com.trainingjava.model.User;
import com.trainjava.dao.UserDao;
import java.util.*;
import java.sql.*;
/**
 *
 * @author DELL
 */
public class UserService {
    private UserDao userDao;
    public UserService(){
        userDao = new UserDao();
    }
    
    public List<User> getAllUsers(){
        return userDao.getAllUsers();
    }
    
    public void addUser(User user){
        userDao.addUser(user);
    }
}

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
    
    public void deleteUser(int id){
        userDao.deleteUser(id);
    }
    
    public User getUserbyID(int id){
        return userDao.getUserbyID(id);
    }
    
    public void UpdateUser(User user){
        userDao.UpdateUser(user);
    }
    
//    public int checkLogIn(String userString, String passowrdString){
//        return userDao.checkLogIn(userString, passowrdString);
//    }
    
    public int checkLogin(String userString , String passowrdString){
        return userDao.checkLogin(userString, passowrdString);
    }
}

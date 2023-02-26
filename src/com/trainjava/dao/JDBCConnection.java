/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.trainjava.dao;

import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author DELL
 */
public class JDBCConnection {
    
    public static Connection getJDBConnection() {
            Connection conn = null;
            String dbURL = "jdbc:sqlserver://DESKTOP-PV3OCED\\SQLEXPRESS:1433; databaseName=BAN_HANG; Username=sa; Password=123";
            
         try{
             Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
             return DriverManager.getConnection(dbURL);
            
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        return conn;
       
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 */
public class DBContext {

    static InitialContext initial;
    static Context context;
    static String dbname, serverName, portNumber, image, username, password;
    static String imagePath;
//    static block is executed only once: the first time you make an object of that class 
//    or the first time you access a static member of that class
    static {
        try{
        initial = new InitialContext();
        Object obj = initial.lookup("java:comp/env");
        context = (Context) obj;
        serverName = context.lookup("serverName").toString();
        dbname = context.lookup("dbName").toString();
        portNumber = context.lookup("portNumber").toString();
        username = context.lookup("username").toString();
        password = context.lookup("password").toString();
        imagePath = context.lookup("imagePath").toString();
        }
        catch(Exception ex){
            ex.getMessage();
        }
    }
//    getConnection
    public Connection getConnection() throws SQLException,ClassNotFoundException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }
//    get inmagePath
   public String getImagePath() {
        return imagePath;
    }
//   close connection
    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
    
}

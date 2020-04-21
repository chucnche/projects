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
 * @author Chucnc
 */
public class DBContext {
    InitialContext initial;
    Context context;
    String dbname, serverName, portNumber, image, username, password;
    String imagePath;
//    get data from context.xml
    public DBContext() throws NamingException {
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
//    get connection
    public Connection getConnection() throws SQLException,ClassNotFoundException {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbname;
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, username, password);
    }
//    get inmage path
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class UserDAO {
//get all user
    public ArrayList<User> getUsers() throws Exception {
        DBContext db = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        ArrayList<User> users = new ArrayList<>();
        String sql = "SELECT * FROM Account";
        try {
            db = new DBContext();
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String user = rs.getString("username");
                String pwd = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                // add user to list
                users.add(new User(user, pwd, email, role));
            }
            return users;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pstmt, rs);
        }
    }
//get user by username
    public User getUserbyUsername(String username) throws Exception {
        DBContext db = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Account where username = ?";
        try {
            db = new DBContext();
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String user = rs.getString("username");
                String pwd = rs.getString("password");
                String email = rs.getString("email");
                String role = rs.getString("role");
                return new User(user, pwd, email, role);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pstmt, rs);
        }
        return null;
    }
//get user by email
    public User getUserbyEmail(String email) throws Exception {
        DBContext db = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Account where email = ?";
        try {
            db = new DBContext();
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, email);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String user = rs.getString("username");
                String pwd = rs.getString("password");
                String email1 = rs.getString("email");
                String role = rs.getString("role");
                return new User(user, pwd, email1, role);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pstmt, rs);
        }
        return null;
    }
// add new user(register)
    public void addNewUser(User u) throws Exception {
        DBContext db = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Account (username,password,email,role)"
                + "VALUES(?, ?, ?, ?)";

        try {
            db = new DBContext();
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, u.getUsername());
            pstmt.setString(2, u.getPassword());
            pstmt.setString(3, u.getEmail());
            pstmt.setString(4, u.getRole());
            pstmt.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pstmt, rs);
        }
    }
}

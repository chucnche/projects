/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Account;
import model.Customer;
import model.FormOfRent;
import model.KindOfRoom;
import model.Room;

/**
 *
 * @author dell
 */
public class CustomerDAO extends DBContext {
    public void insertCustomer(Customer c) {
        try {
            String sql = "INSERT INTO [Customer]\n" +
"           ([Username]\n" +
"           ,[RID]\n" +
"           ,[Name]\n" +
"           ,[FID]\n" +
"           ,[Checkin]\n" +
"           ,[Checkout])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,c.getAcc().getUser());
            statement.setString(2, c.getRoom().getRid());
            statement.setString(3,c.getAcc().getName());
            statement.setString(4,c.getFormor().getFid());
            statement.setDate(5,c.getCheckin());
            statement.setDate(6,c.getCheckout());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Customer> getCusByUser(String user) {
        ArrayList<Customer> cus = new ArrayList<>();
        String sql = "SELECT * from Customer Where username = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                Account a = new Account();
                a.setUser(rs.getString("username"));
                a.setName(rs.getString("name"));
                Room r = new Room();
                r.setRid(rs.getString("rid"));
                FormOfRent formor = new FormOfRent();
                formor.setFid(rs.getString("fid"));
                Date from = rs.getDate("checkin");
                Date to = rs.getDate("checkout");
                
                Customer c = new Customer(a, r, from, to, formor);
                cus.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cus;
    }
    public ArrayList<Customer> getCus() {
        ArrayList<Customer> cus = new ArrayList<>();
        String sql = "SELECT * from Customer";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                Account a = new Account();
                a.setUser(rs.getString("username"));
                a.setName(rs.getString("name"));
                Room r = new Room();
                r.setRid(rs.getString("rid"));
                FormOfRent formor = new FormOfRent();
                formor.setFid(rs.getString("fid"));
                Date from = rs.getDate("checkin");
                Date to = rs.getDate("checkout");
                
                Customer c = new Customer(a, r, from, to, formor);
                cus.add(c);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cus;
    }
    public Customer getCustomerDelete(String user,String rid,Date from,Date to) {
        String sql = "SELECT * FROM [Customer] WHERE username = ? and rid = ? and checkin = ? and checkout = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, rid);
            statement.setDate(3, from);
            statement.setDate(4, to);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                Account a = new Account();
                a.setUser(rs.getString("username"));
                a.setName(rs.getString("name"));
                Room r = new Room();
                r.setRid(rs.getString("rid"));
                FormOfRent formor = new FormOfRent();
                formor.setFid(rs.getString("fid"));
                Date from1 = rs.getDate("checkin");
                Date to1 = rs.getDate("checkout");
                
                Customer c = new Customer(a, r, from1, to1, formor);
                return c;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public void deleteCustomers(Customer c)   
    {
        try {
            String sql ="DELETE FROM [Customer]\n"+
                        "WHERE Checkin=? and Checkout = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, c.getCheckin());
            statement.setDate(2, c.getCheckout());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

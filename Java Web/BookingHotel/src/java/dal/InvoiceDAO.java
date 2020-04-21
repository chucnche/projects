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
import model.Invoice;
import model.Room;
import model.Service;

/**
 *
 * @author dell
 */
public class InvoiceDAO extends DBContext {

    public ArrayList<Invoice> getInvoicesByUser(String user) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Invoice i INNER JOIN Account a ON i.username = a.username where a.Username = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setUser(rs.getString("username"));
                Room r = new Room();
                r.setRid(rs.getString("rid"));
                Service s = new Service();
                s.setSid(rs.getString("sid"));
                Date date = rs.getDate("InvoiceDate");
                Invoice i = new Invoice(a, s, r, date);
                invoices.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoices;
    }
    public ArrayList<Invoice> getInvoicesByRid(String rid) {
        ArrayList<Invoice> invoices = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Invoice i where RID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, rid);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                Account a = new Account();
                a.setUser(rs.getString("username"));
                Room r = new Room();
                r.setRid(rs.getString("rid"));
                Service s = new Service();
                s.setSid(rs.getString("sid"));
                Date date = rs.getDate("InvoiceDate");
                Invoice i = new Invoice(a, s, r, date);
                invoices.add(i);
            }
        } catch (SQLException ex) {
            Logger.getLogger(InvoiceDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return invoices;
    }

    public int count(String sid) {
        String sql = "SELECT COUNT(sID) as rownum\n"
                + "FROM Invoice where sid= ?;";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, sid);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("rownum");
            }
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return -1;
    }

    public void deleteCustomers(Invoice i) {
        try {
            String sql = "DELETE FROM [Invoice]\n"
                    + "      WHERE RID = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, i.getRoom().getRid());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

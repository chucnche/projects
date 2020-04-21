/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Invoice;
import model.KindOfRoom;
import model.Room;
import model.Service;

/**
 *
 * @author dell
 */
public class ServiceDAO extends DBContext{
    public ArrayList<Service> getServices() {
        ArrayList<Service> services = new ArrayList<>();
        String sql = "SELECT * FROM [Service]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                String sid = rs.getString("sid");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Service service = new Service(sid, name, price);
                services.add(service);
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return services;
    }
    public void insertInvoice(Invoice c) {
        try {
            String sql = "INSERT INTO [Invoice]\n" +
"           ([Username]\n" +
"           ,[RID]\n" +
"           ,[SID]\n" +
"           ,[InvoiceDate])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,getdate())";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,c.getAcc().getUser());
            statement.setString(2, c.getRoom().getRid());
            statement.setString(3,c.getService().getSid());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Service getServiceBySid(String sid) {
        String sql = "SELECT * FROM [Service] WHERE [sid] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, sid);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String sid1 = rs.getString("sid");
                String name = rs.getString("name");
                int price = rs.getInt("price");
                Service s = new Service(sid1, name, price);
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}

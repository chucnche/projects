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
import modal.HistoryPayment;

/**
 *
 * @author Chucnc
 */
public class HistoryPaymentDAO extends DBContext {

    public ArrayList<HistoryPayment> getHistoryPayments() {
        ArrayList<HistoryPayment> books = new ArrayList<>();
        String sql = "SELECT [stuID]\n" +
"      ,[datePay]\n" +
"      ,[type]\n" +
"      ,[MoneyPay]\n" +
"      ,[roomName]\n" +
"  FROM [HistoryPayment]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                String stuID = rs.getString("stuID");
                Date datePay = rs.getDate("datePay");
                String type = rs.getString("type");
                int moneyPay = rs.getInt("MoneyPay");
                String room = rs.getString("roomName");
                books.add(new HistoryPayment(stuID, datePay, type, moneyPay,room));

            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }

    public HistoryPayment getHistoryPayment(String id) {
        String sql = "SELECT [stuID]\n"
                + "      ,[datePay]\n"
                + "      ,[type]\n"
                + "      ,[MoneyPay]\n"
                +"      ,[roomName]\n"
                + "  FROM [HistoryPayment] WHERE [stuID] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String stuID = rs.getString("stuID");
                Date datePay = rs.getDate("datePay");
                String type = rs.getString("type");
                int moneyPay = rs.getInt("MoneyPay");
                String room = rs.getString("roomName");
                HistoryPayment re = new HistoryPayment(stuID, datePay, type, moneyPay,room);
                return re;
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
        public ArrayList<HistoryPayment> searchHisPays(String room,String from,String to)
    {
        ArrayList<HistoryPayment> emps = new ArrayList<>();
        try {
            int d=1;
            String sql = "SELECT [stuID]\n"
                + "      ,[datePay]\n"
                + "      ,[type]\n"
                + "      ,[MoneyPay]\n"
                +"      ,[roomName]\n"
                + "  FROM [HistoryPayment] WHERE  [roomName] like '%" + room + "%'";
            if(from!=null){
                sql += " AND [dateBook] >= ?";
            }
            if(to!=null){
                sql += " AND [dateBook] <= ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            if(from!=null){
                statement.setString(d,from);
                d++;
            }
            if(to!=null){
                statement.setString(d,to);
                d++;
            }
            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                HistoryPayment e = new HistoryPayment();
                e.setStuID(rs.getString("stuID"));
                e.setDatePay(rs.getDate("datePay"));
                e.setType(rs.getString("type"));
                e.setMoneyPay(rs.getInt("MoneyPay"));
                e.setRoom(rs.getString("roomName"));
                emps.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HistoryPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    } 
    public void insertHistoryPayment(HistoryPayment s) {
        try {
            String sql = "INSERT INTO [dbo].[HistoryPayment]\n" +
"           ([stuID]\n" +
"           ,[datePay]\n" +
"           ,[type]\n" +
"           ,[MoneyPay]\n" +
"           ,[roomName])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getStuID());
            statement.setDate(2, s.getDatePay());
            statement.setString(3, s.getType());
            statement.setInt(4, s.getMoneyPay());
            statement.setString(5, s.getRoom());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HistoryPaymentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

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
import modal.ElectricityWaterBills;

/**
 *
 * @author Chucnc
 */
public class ElectricityWaterBillsDAO extends DBContext {
       public ArrayList<ElectricityWaterBills> getElectricityWaterBills() {
        ArrayList<ElectricityWaterBills> books = new ArrayList<>();
        String sql = "SELECT [roomName]\n" +
"      ,[monthYear]\n" +
"      ,[soDien]\n" +
"      ,[soNuoc]\n" +
"      ,[paid]\n" +
"  FROM [ElectricityWaterBills]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                String roomName = rs.getString("roomName");
                Date monthYear = rs.getDate("monthYear");
                int soDien= rs.getInt("soDien");
                int soNuoc = rs.getInt("soNuoc");
                int paid = rs.getInt("paid");
                books.add(new ElectricityWaterBills(roomName,monthYear,soDien,soNuoc,paid));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityWaterBillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
    public ArrayList<ElectricityWaterBills> searchBills(String room,String from,String to)
    {
        ArrayList<ElectricityWaterBills> emps = new ArrayList<>();
        try {
            int d=1;
            String sql = "SELECT [roomName]\n" +
"      ,[monthYear]\n" +
"      ,[soDien]\n" +
"      ,[soNuoc]\n" +
"      ,[paid]\n" +
"  FROM [ElectricityWaterBills] WHERE  [roomName] like '%" + room + "%'";
            if(from!=null){
                sql += " AND [monthYear] >= ?";
            }
            if(to!=null){
                sql += " AND [monthYear] <= ?";
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
                ElectricityWaterBills e = new ElectricityWaterBills();
                e.setRoomName(rs.getString("roomName"));
                e.setMonthYear(rs.getDate("monthYear"));
                e.setSoDien(rs.getInt("soDien"));
                e.setSoNuoc(rs.getInt("soNuoc"));
                e.setPaid(rs.getInt("paid"));
                emps.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityWaterBillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }  
    public ArrayList<ElectricityWaterBills> getElectricityWaterBill(String room) {
        ArrayList<ElectricityWaterBills> books = new ArrayList<>();
        String sql = "SELECT [roomName]\n" +
"      ,[monthYear]\n" +
"      ,[soDien]\n" +
"      ,[soNuoc]\n" +
"      ,[paid]\n" +
"  FROM [ElectricityWaterBills] WHERE [roomName] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, room);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String roomName = rs.getString("roomName");
                Date monthYear = rs.getDate("monthYear");
                int soDien= rs.getInt("soDien");
                int soNuoc = rs.getInt("soNuoc");
                int paid = rs.getInt("paid");
                books.add(new ElectricityWaterBills(roomName,monthYear,soDien,soNuoc,paid));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityWaterBillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
        public void insertBill(ElectricityWaterBills s) {
        try {
            String sql = "INSERT INTO [ElectricityWaterBills]\n" +
"           ([roomName]\n" +
"           ,[monthYear]\n" +
"           ,[soDien]\n" +
"           ,[soNuoc]\n" +
"           ,[paid])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getRoomName());
            statement.setDate(2, s.getMonthYear());
            statement.setInt(3,s.getSoDien());
            statement.setInt(4,s.getSoNuoc());
            statement.setInt(5,s.getPaid());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityWaterBillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateRequest(ElectricityWaterBills s) {
        try {
            String sql = "UPDATE [ElectricityWaterBills]\n" +
"   SET [monthYear] = ?\n" +
"      ,[soDien] = ?\n" +
"      ,[soNuoc] = ?\n" +
"      ,[paid] = ?\n" +
" WHERE [roomName] =?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDate(1, s.getMonthYear());
            statement.setInt(2,s.getSoDien());
            statement.setInt(3,s.getSoNuoc());
            statement.setInt(4,s.getPaid());
            statement.setString(5, s.getRoomName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ElectricityWaterBillsDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

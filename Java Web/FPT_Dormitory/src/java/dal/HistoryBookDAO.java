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
import modal.HistoryBook;
import modal.RequestStudent;

/**
 *
 * @author Chucnc
 */
public class HistoryBookDAO extends DBContext{
        public ArrayList<HistoryBook> getHistoryBooks() {
        ArrayList<HistoryBook> books = new ArrayList<>();
        String sql = "SELECT [stuID]\n" +
"      ,[dateBook]\n" +
"      ,[roomName]\n" +
"      ,[bedNo]\n" +
"      ,[bookID]\n" +
"      ,[dateExpiry]\n" +
"  FROM [HistoryBook]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                String stuID = rs.getString("stuID");
                Date dateBook = rs.getDate("dateBook");
                String roomName = rs.getString("roomName");
                int bedNo= rs.getInt("bedNo");
                int bookID = rs.getInt("bookID");
                Date dateEx = rs.getDate("dateExpiry");
                books.add(new HistoryBook(bookID,stuID,dateBook,roomName,bedNo,dateEx));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return books;
    }
        
    public ArrayList<HistoryBook> getHistoryBook(String id) {
        ArrayList<HistoryBook> books = new ArrayList<>();
        String sql = "SELECT [stuID]\n" +
"      ,[dateBook]\n" +
"      ,[roomName]\n" +
"      ,[bedNo]\n" +
"      ,[bookID]\n" +
"      ,[dateExpiry]\n" +                
"  FROM [HistoryBook] WHERE [stuID] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, id);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                String stuID = rs.getString("stuID");
                Date dateBook = rs.getDate("dateBook");
                String roomName = rs.getString("roomName");
                int bedNo= rs.getInt("bedNo");
                int bookID = rs.getInt("bookID");
                Date dateEx = rs.getDate("dateExpiry");
                books.add(new HistoryBook(bookID,stuID,dateBook,roomName,bedNo,dateEx));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
        public ArrayList<HistoryBook> searchHisBooks(String room,String from,String to)
    {
        ArrayList<HistoryBook> emps = new ArrayList<>();
        try {
            int d=1;
            String sql = "SELECT [stuID]\n" +
"      ,[dateBook]\n" +
"      ,[roomName]\n" +
"      ,[bedNo]\n" +
"      ,[bookID]\n" +
"      ,[dateExpiry]\n" +                
"  FROM [HistoryBook] WHERE  [roomName] like '%" + room + "%'";
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
                HistoryBook e = new HistoryBook();
                e.setStuID(rs.getString("stuID"));
                e.setDateBook(rs.getDate("dateBook"));
                e.setRoomName(rs.getString("roomName"));
                e.setBedNo(rs.getInt("bedNo"));
                e.setBookID(0);
                e.setDateEx(rs.getDate("dateExpiry"));
                emps.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }  
        public void insertHistoryBook(HistoryBook s) {
        try {
            String sql = "INSERT INTO [HistoryBook]\n" +
"           ([stuID]\n" +
"           ,[dateBook]\n" +
"           ,[roomName]\n" +
"           ,[bedNo]\n" +
"           ,[dateExpiry])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getStuID());
            statement.setDate(2, s.getDateBook());
            statement.setString(3,s.getRoomName());
            statement.setInt(4,s.getBedNo());
            statement.setDate(5,s.getDateEx());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(HistoryBookDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

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
import modal.Room;

/**
 *
 * @author Chucnc
 */
public class RoomDAO extends DBContext{
      public ArrayList<Room> getRooms() {
        ArrayList<Room> rooms = new ArrayList<>();
        String sql = "SELECT [roomName]\n" +
"      ,[gender]\n" +
"      ,[Bed_1]\n" +
"      ,[Bed_2]\n" +
"      ,[Bed_3]\n" +
"      ,[Bed_4]\n" +
"      ,[Bed_5]\n" +
"      ,[Bed_6]\n" +
"      ,[Bed_7]\n" +
"      ,[Bed_8]\n" +
"  FROM [Room]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                String room_Name = rs.getString("roomName");
                int gender = rs.getInt("gender");
                int bed1 = rs.getInt("Bed_1");
                int bed2 = rs.getInt("Bed_2");
                int bed3 = rs.getInt("Bed_3");
                int bed4 = rs.getInt("Bed_4");
                int bed5 = rs.getInt("Bed_5");
                int bed6 = rs.getInt("Bed_6");
                int bed7 = rs.getInt("Bed_7");
                int bed8 = rs.getInt("Bed_8");
                Room s = new Room(room_Name, gender, bed1, bed2, bed3, bed4, bed5, bed6, bed7, bed8);
                rooms.add(s);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return rooms;
    }
    public Room getRoom(String roomName) {
        String sql = "SELECT [roomName]\n" +
"      ,[gender]\n" +
"      ,[Bed_1]\n" +
"      ,[Bed_2]\n" +
"      ,[Bed_3]\n" +
"      ,[Bed_4]\n" +
"      ,[Bed_5]\n" +
"      ,[Bed_6]\n" +
"      ,[Bed_7]\n" +
"      ,[Bed_8]\n" +
"  FROM [Room] WHERE [roomName] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, roomName);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String room_Name = rs.getString("roomName");
                int gender = rs.getInt("Gender");
                int bed1 = rs.getInt("Bed_1");
                int bed2 = rs.getInt("Bed_2");
                int bed3 = rs.getInt("Bed_3");
                int bed4 = rs.getInt("Bed_4");
                int bed5 = rs.getInt("Bed_5");
                int bed6 = rs.getInt("Bed_6");
                int bed7 = rs.getInt("Bed_7");
                int bed8 = rs.getInt("Bed_8");
                Room s = new Room(room_Name, gender, bed1, bed2, bed3, bed4, bed5, bed6, bed7, bed8);
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public void updateRoom(Room s) {
        try {
            String sql = "UPDATE [Room]\n" +
"   SET [gender] =?\n" +
"      ,[Bed_1] =?\n" +
"      ,[Bed_2] =?\n" +
"      ,[Bed_3] =?\n" +
"      ,[Bed_4] =?\n" +
"      ,[Bed_5] =?\n" +
"      ,[Bed_6] =?\n" +
"      ,[Bed_7] =?\n" +
"      ,[Bed_8] =?\n" +
" WHERE [roomName] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, s.getGender());
            statement.setInt(2, s.getBed1());
            statement.setInt(3, s.getBed2());
            statement.setInt(4, s.getBed3());
            statement.setInt(5, s.getBed4());
            statement.setInt(6, s.getBed5());
            statement.setInt(7, s.getBed6());
            statement.setInt(8, s.getBed7());
            statement.setInt(9, s.getBed8());
            statement.setString(10, s.getRoomName());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertRoom(Room s) {
        try {
            String sql = "INSERT INTO [dbo].[Room]\n" +
"           ([roomName]\n" +
"           ,[gender]\n" +
"           ,[Bed_1]\n" +
"           ,[Bed_2]\n" +
"           ,[Bed_3]\n" +
"           ,[Bed_4]\n" +
"           ,[Bed_5]\n" +
"           ,[Bed_6]\n" +
"           ,[Bed_7]\n" +
"           ,[Bed_8])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,0\n" +
"           ,0\n" +
"           ,0\n" +
"           ,0\n" +
"           ,0\n" +
"           ,0\n" +
"           ,0\n" +
"           ,0)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getRoomName());
            statement.setInt(2, s.getGender());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RoomDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

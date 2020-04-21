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
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class StudentDAO extends DBContext {
        public Student getStudent(String username) {
        String sql = "SELECT [stuID]\n" +
"      ,[username]\n" +
"      ,[name]\n" +
"      ,[dob]\n" +
"      ,[gender]\n" +
"      ,[roomName]\n" +
"      ,[bedNo]\n" +
"      ,[bookingDate]\n" +
"      ,[MoneyAccount]\n" +
"      ,[debt]\n" +
"  FROM [Student] WHERE [username] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String stuID = rs.getString("StuID");
                String username1 = rs.getString("username");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int gender = rs.getInt("gender");
                String roomName = rs.getString("roomName");
                int bedNo = rs.getInt("bedNo");
                Date bookingDate = rs.getDate("bookingDate");
                int moneyAccount = rs.getInt("MoneyAccount");
                int debt = rs.getInt("debt");
                Student s = new Student(stuID,username1,name,dob,gender,roomName,bedNo,bookingDate,moneyAccount,debt);

                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
         public Student getStudentById(String username) {
        String sql = "SELECT [stuID]\n" +
"      ,[username]\n" +
"      ,[name]\n" +
"      ,[dob]\n" +
"      ,[gender]\n" +
"      ,[roomName]\n" +
"      ,[bedNo]\n" +
"      ,[bookingDate]\n" +
"      ,[MoneyAccount]\n" +
"      ,[debt]\n" +
"  FROM [Student] WHERE [stuID] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String stuID = rs.getString("StuID");
                String username1 = rs.getString("username");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int gender = rs.getInt("gender");
                String roomName = rs.getString("roomName");
                int bedNo = rs.getInt("bedNo");
                Date bookingDate = rs.getDate("bookingDate");
                int moneyAccount = rs.getInt("MoneyAccount");
                int debt = rs.getInt("debt");
                Student s = new Student(stuID,username1,name,dob,gender,roomName,bedNo,bookingDate,moneyAccount,debt);

                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }       
    public ArrayList<Student> getStudents() {
        ArrayList<Student> students = new ArrayList<>();
        String sql = "SELECT [stuID]\n" +
"      ,[username]\n" +
"      ,[name]\n" +
"      ,[dob]\n" +
"      ,[gender]\n" +
"      ,[roomName]\n" +
"      ,[bedNo]\n" +
"      ,[bookingDate]\n" +
"      ,[MoneyAccount]\n" +
"      ,[debt]\n" +
"  FROM [Student] ";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                String stuID = rs.getString("StuID");
                String username1 = rs.getString("username");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int gender = rs.getInt("gender");
                String roomName = rs.getString("roomName");
                int bedNo = rs.getInt("bedNo");
                Date bookingDate = rs.getDate("bookingDate");
                int moneyAccount = rs.getInt("MoneyAccount");
                int debt = rs.getInt("debt");
                students.add(new Student(stuID,username1,name,dob,gender,roomName,bedNo,bookingDate,moneyAccount,debt));
            }

        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return students;
    }
        public ArrayList<Student> searchStudent(String id,String name,int gender,String room,int bed,String from,String to)
    {
        ArrayList<Student> emps = new ArrayList<>();
        try {
            int d=1;
            String sql = "SELECT [stuID]\n" +
"      ,[username]\n" +                    
"      ,[name]\n" +
"      ,[dob]\n" +
"      ,[gender]\n" +
"      ,[roomName]\n" +
"      ,[bedNo]\n" +
"      ,[bookingDate]\n" +
"      ,[MoneyAccount]\n" +
"      ,[debt]\n" +
"  FROM [Student] WHERE  [name] like '%" + name + "%'" +"AND [roomName] like '%"+room+"%'";
            if(id!=null)
            {
                sql += " AND [stuID] = ?";
            }
            if(gender!=2){
                 sql += " AND [gender] = ?";
            }
            if(bed!=0){
                 sql += " AND [bedNo] = ?";
            }
            if(from!=null){
                sql += " AND [bookingDate] >= ?";
            }
            if(to!=null){
                sql += " AND [bookingDate] <= ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
             if(id !=null){
                statement.setString(d, id);
                d++;
            } 
             if(gender !=2){
                statement.setInt(d,gender);
                d++;
            }
            if(bed!=0){
                statement.setInt(d,bed);
                d++;
            }
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
                Student e = new Student();
                e.setStuID(rs.getString("stuID"));
                e.setUsername(rs.getString("username"));
                e.setName(rs.getString("name"));
                e.setDob(rs.getDate("dob"));
                e.setGender(rs.getInt("gender"));
                e.setRoomName(rs.getString("roomName"));
                e.setBedNo(rs.getInt("bedNo"));
                e.setBookingDate(rs.getDate("bookingDate"));
                e.setMoneyAccount(rs.getInt("MoneyAccount"));
                e.setDebt(rs.getInt("debt"));
                emps.add(e);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }
   public void insertStudent(Student s) {
        try {
            String sql
                    = "INSERT INTO [Student]\n" +
"           ([stuID]\n" +
"           ,[username]\n" +
"           ,[name]\n" +
"           ,[dob]\n" +
"           ,[gender]\n" +
"           ,[roomName]\n" +
"           ,[bedNo]\n" +
"           ,[bookingDate]\n" +
"           ,[MoneyAccount]\n" +
"           ,[debt])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getStuID());
            statement.setString(2, s.getUsername());
            statement.setString(3, s.getName());
            statement.setDate(4, s.getDob());
            statement.setInt(5, s.getGender());
            statement.setString(6, s.getRoomName());
            statement.setInt(7, s.getBedNo());
            statement.setDate(8, s.getBookingDate());
            statement.setInt(9, s.getMoneyAccount());
            statement.setInt(10, s.getDebt());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void updateStudent(Student s) {
        try {
            String sql = "UPDATE [Student]\n" +
"   SET [username] = ?\n" +
"      ,[name] = ?\n" +
"      ,[dob] = ?\n" +
"      ,[gender] = ?\n" +
"      ,[roomName] = ?\n" +
"      ,[bedNo] = ?\n" +
"      ,[bookingDate] = ?\n" +
"      ,[MoneyAccount] = ?\n" +
"      ,[debt] = ?\n" +
" WHERE [stuID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getUsername());
            statement.setString(2, s.getName());
            statement.setDate(3, s.getDob());
            statement.setInt(4, s.getGender());
            statement.setString(5, s.getRoomName());
            statement.setInt(6, s.getBedNo());
            statement.setDate(7, s.getBookingDate());
            statement.setInt(8, s.getMoneyAccount());
            statement.setInt(9, s.getDebt());
            statement.setString(10, s.getStuID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(StudentDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

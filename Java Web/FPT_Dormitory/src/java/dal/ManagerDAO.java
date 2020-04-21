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
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Manager;
import modal.Student;

/**
 *
 * @author Chucnc
 */
public class ManagerDAO extends DBContext{
            public Manager getManager(String username) {
        String sql = "SELECT [maID]\n" +
"      ,[username]\n" +
"      ,[dob]\n" +
"      ,[gender]\n" +
"      ,[mail]\n" +
"      ,[phoneNumber]\n" +
"      ,[name]\n" +
"  FROM [Manager] WHERE [username] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String maID = rs.getString("maID");
                String username1 = rs.getString("username");
                Date dob = rs.getDate("dob");
                int gender = rs.getInt("gender");
                String mail = rs.getString("mail");
                String phoneNumber = rs.getString("phoneNumber");
                String name = rs.getString("name");
                Manager s = new Manager(maID,username1,  name,  dob,  gender,  mail,  phoneNumber);
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(ManagerDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
}

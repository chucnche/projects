/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modal.Account;
import modal.ElectricityWaterBills;

/**
 *
 * @author Chucnc
 */
public class AccountDAO extends DBContext {
    public Account getAccount(String username) {
        String sql = "SELECT [username]\n" +
"      ,[password]\n" +
"      ,[type]\n" +
"  FROM [Account] WHERE [username] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                String username1 = rs.getString("username");
                String password = rs.getString("password");
                int type = rs.getInt("type");
                Account s = new Account(username1, password,type);
                return s;
            }

        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public void insertAccount(Account s) {
        try {
            String sql = "INSERT INTO [Account]\n" +
"           ([username]\n" +
"           ,[password]\n" +
"           ,[type])\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getUsername());
            statement.setString(2, s.getPassword());
            statement.setInt(3, s.getType());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

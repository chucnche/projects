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

/**
 *
 * @author dell
 */
public class AccountDAO extends DBContext{
    public void insertAccount(Account a) {
        try {
            String sql = "INSERT INTO [Account]\n"
                    + "           ([Username]\n"
                    + "           ,[Password]\n"
                    + "           ,[Nickname]\n"
                    + "           ,[Name]\n"
                    + "           ,[Dob]\n"
                    + "           ,[CMND]\n"
                    + "           ,[Address]\n"
                    + "           ,[Phone]\n"
                    + "           ,[Job]\n"
                    + "           ,[Gender]\n"
                    + "           ,[Type]\n"
                    + "           ,[Money])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,  a.getUser());
            statement.setString(2,  a.getPass());
            statement.setString(3,  a.getNick());
            statement.setString(4,  a.getName());
            statement.setDate(5, a.getDob());
            statement.setInt(6, a.getCmnd());
            statement.setString(7,  a.getAddress());
            statement.setInt(8, a.getPhone());
            statement.setString(9,  a.getJob());
            statement.setBoolean(10, a.isGender());
            statement.setInt(11, a.getType());
            statement.setInt(12, a.getMoney());
            
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Account> getAccounts() {
            ArrayList<Account> accounts = new ArrayList<>();
            String sql = "SELECT * FROM [Account]";
            try {
                PreparedStatement statement = connection.prepareStatement(sql);
                ResultSet rs = statement.executeQuery();
                //cursor
                while (rs.next()) {
                String user = rs.getString("username");
                String pass = rs.getString("password");
                String nick = rs.getString("nickname");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int cmnd = rs.getInt("cmnd");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String job = rs.getString("job");
                boolean gender = rs.getBoolean("gender");
                int type = rs.getInt("type");
                int money = rs.getInt("money");
                    Account a = new Account(cmnd, phone, money, type, user, pass, nick, name, address, job, gender, dob);
                    accounts.add(a);
                }

            } catch (SQLException ex) {
                Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
            }

            return accounts;
        }
    public Account getAccount(String user, String pass) {
        String sql = "SELECT * FROM [Account] WHERE [Username] = ? and password = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            statement.setString(2, pass);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nick = rs.getString("nickname");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int cmnd = rs.getInt("cmnd");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String job = rs.getString("job");
                boolean gender = rs.getBoolean("gender");
                int type = rs.getInt("type");
                int money = rs.getInt("money");
                Account a = new Account(cmnd, phone, money, type, user, pass, nick, name, address, job, gender, dob);
                return a;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public Account getAccountByUser(String user) {
        String sql = "SELECT * FROM [Account] WHERE [Username] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, user);
            ResultSet rs = statement.executeQuery();
            //cursor
            if (rs.next()) {
                String username = rs.getString("username");
                String password = rs.getString("password");
                String nick = rs.getString("nickname");
                String name = rs.getString("name");
                Date dob = rs.getDate("dob");
                int cmnd = rs.getInt("cmnd");
                String address = rs.getString("address");
                int phone = rs.getInt("phone");
                String job = rs.getString("job");
                boolean gender = rs.getBoolean("gender");
                int type = rs.getInt("type");
                int money = rs.getInt("money");
                Account a = new Account(cmnd, phone, money, type, username, password, nick, name, address, job, gender, dob);
                return a;
            }

        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    public void updateAccount(Account a) {
        try {
            String sql = "UPDATE [Account]\n" +
                        "   SET [Password] = ?\n" +
                        "      ,[Nickname] = ?\n" +
                        "      ,[Name] = ?\n" +
                        "      ,[Dob] = ?\n" +
                        "      ,[CMND] = ?\n" +
                        "      ,[Address] = ?\n" +
                        "      ,[Phone] = ?\n" +
                        "      ,[Job] = ?\n" +
                        "      ,[Gender] = ?\n" +
                        "      ,[Type] = ?\n" +
                        "      ,[Money] = ?\n" +
                        " WHERE [Username] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,  a.getPass());
            statement.setString(2,  a.getNick());
            statement.setString(3,  a.getName());
            statement.setDate(4, a.getDob());
            statement.setInt(5, a.getCmnd());
            statement.setString(6,  a.getAddress());
            statement.setInt(7, a.getPhone());
            statement.setString(8, a.getJob());
            statement.setBoolean(9, a.isGender());
            statement.setInt(10, a.getType());
            statement.setInt(11, a.getMoney());
            statement.setString(12, a.getUser());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

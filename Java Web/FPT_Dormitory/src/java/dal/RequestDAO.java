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
public class RequestDAO extends DBContext {

    public ArrayList<RequestStudent> getRequests() {
        ArrayList<RequestStudent> requests = new ArrayList<>();
        String sql = "SELECT [requestID]\n"
                + "      ,[stuID]\n"
                + "      ,[dateRequest]\n"
                + "      ,[request]\n"
                + "      ,[maID]\n"
                + "      ,[dateReply]\n"
                + "      ,[reply]\n"
                + "  FROM [Request]";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            //cursor
            while (rs.next()) {
                int requestID = rs.getInt("requestID");
                String stuID = rs.getString("stuID");
                String dateRequest = rs.getString("dateRequest");
                String request = rs.getString("request");
                String maID = rs.getString("maID");
                String dateReply = rs.getString("dateReply");
                String reply = rs.getString("Reply");
                requests.add(new RequestStudent(requestID, stuID, dateRequest, request, maID, dateReply, reply));

            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return requests;
    }

    public RequestStudent getRequest(String da) {
        String sql = "SELECT [requestID]\n"
                + "      ,[stuID]\n"
                + "      ,[dateRequest]\n"
                + "      ,[request]\n"
                + "      ,[maID]\n"
                + "      ,[dateReply]\n"
                + "      ,[reply]\n"
                + "  FROM [Request] WHERE [dateRequest] = ?";
        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, da);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                int requestID = rs.getInt("requestID");
                String stuID = rs.getString("stuID");
                String dateRequest = rs.getString("dateRequest");
                String request = rs.getString("request");
                String maID = rs.getString("maID");
                String dateReply = rs.getString("dateReply");
                String reply = rs.getString("Reply");
                RequestStudent re = new RequestStudent(requestID, stuID, dateRequest, request, maID, dateReply, reply);
                return re;
            }
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void updateRequest(RequestStudent s) {
        try {
            String sql = "UPDATE [Request]\n"
                    + "   SET [maID] = ?\n"
                    + "      ,[dateReply] =?\n"
                    + "      ,[reply] =?\n"
                    + "  WHERE [requestID] = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getMaID());
            statement.setString(2, s.getDateReply());
            statement.setString(3, s.getReply());
            statement.setInt(4, s.getRequestID());
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<RequestStudent> searchRequests(String sid, String from, String to) {
        ArrayList<RequestStudent> emps = new ArrayList<>();
        try {
            int d = 1;
            String sql = "SELECT [requestID]\n"
                    + "      ,[stuID]\n"
                    + "      ,[dateRequest]\n"
                    + "      ,[request]\n"
                    + "      ,[maID]\n"
                    + "      ,[dateReply]\n"
                    + "      ,[reply]\n"
                    + "  FROM [Request] WHERE  [stuID] like '%" + sid + "%'";
            if (from != null) {
                sql += " AND [dateRequest] >= ?";
            }
            if (to != null) {
                sql += " AND [dateRequest] <= ?";
            }
            PreparedStatement statement = connection.prepareStatement(sql);
            if (from != null) {
                statement.setString(d, from);
                d++;
            }
            if (to != null) {
                statement.setString(d, to);
                d++;
            }
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                RequestStudent e = new RequestStudent();
                e.setRequestID(rs.getInt("requestID"));
                e.setStuID(rs.getString("stuID"));
                e.setDateRequest(rs.getString("dateRequest"));
                e.setRequest(rs.getString("request"));
                e.setMaID(rs.getString("maID"));
                e.setDateReply(rs.getString("dateReply"));
                e.setReply(rs.getString("reply"));
                emps.add(e);
            }

        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return emps;
    }

    public void insertRequest(RequestStudent s) {
        try {
            String sql = "INSERT INTO [Request]\n"
                    + "           ([stuID]\n"
                    + "           ,[dateRequest]\n"
                    + "           ,[request]\n"
                    + "           ,[maID]\n"
                    + "           ,[dateReply]\n"
                    + "           ,[reply])\n"
                    + "     VALUES\n"
                    + "           (?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?\n"
                    + "           ,?)";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, s.getStuID());
            statement.setString(2, s.getDateRequest());
            statement.setString(3, s.getRequest());
            statement.setString(4, null);
            statement.setString(5, null);
            statement.setString(6, null);
            statement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RequestDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

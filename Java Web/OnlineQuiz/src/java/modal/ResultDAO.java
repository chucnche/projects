/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Question;
import entity.Result;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 */
public class ResultDAO {
        public void addResult(Result q) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO result\n" +
"           (username\n" +
"           ,score\n" +
"           ,numberQuestion\n" +
"           ,date_take)\n" +
"     VALUES\n" +
"           (?\n" +
"           ,?\n" +
"           ,?\n" +
"           ,?)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, q.getUser());
            ps.setFloat(2,q.getScore());
            ps.setInt(3,q.getNumberQ());
            ps.setString(4, q.getDateTake());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
}

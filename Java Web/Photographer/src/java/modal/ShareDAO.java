/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Share;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chucnc
 */
public class ShareDAO {
    
    public ArrayList<Share> getShare() throws Exception{
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Share";
        ArrayList<Share> list = new ArrayList<>();
        
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                Share sh = new Share(db.getImagePath()+rs.getString("icon"),
                        rs.getString("social_network"), rs.getString("url"));
                
                list.add(sh);
            }
            return list;
            
        } catch (Exception ex) {
            throw ex;
        }finally{
            db.closeConnection(con, ps, rs);
        }
    }
}

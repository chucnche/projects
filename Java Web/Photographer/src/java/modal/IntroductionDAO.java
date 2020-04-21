/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Introduction;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Chucnc
 */
public class IntroductionDAO {
    
    public Introduction getIntroduction() throws Exception{
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Intro";
        
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                String image =db.getImagePath()+rs.getString("image");
                String des = rs.getString("descript");
                String about=rs.getString("aboutme");
                Introduction in = new Introduction(image, des, about);
                return in;
            }
            
        } catch (Exception ex) {
            throw ex;
        }finally{
            db.closeConnection(con, ps, rs);
        }
        
        return null;
    }
}

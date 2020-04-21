/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Information;
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
public class InformationDAO {
    
    public Information getInfor() throws Exception{
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Information";
        
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if(rs.next()){
                String address=rs.getString("address");
                String city= rs.getString("city");
                String country= rs.getString("country");
                String tel =rs.getString("tel");
                String email =rs.getString("email");
                String image =db.getImagePath()+rs.getString("image");
                Information in = new Information(address, city, country, tel, email, image);
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

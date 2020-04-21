/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Gallery;
import entity.ImageGallery;
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
public class ImageGalleryDAO {
        public ArrayList<ImageGallery> getImageGalleryPaging(int id,int pageSize, int pageIndex) throws Exception {
        DBContext db = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM (\n" +
"                SELECT ROW_NUMBER()\n" +
"                OVER(ORDER BY id) as Number,* FROM ImageGallery WHERE gallery_id=? \n" +
"                )as dbNumber where Number between ? and ?";
        ArrayList<ImageGallery> list = new ArrayList<>();
        try {
            db = new DBContext();    
            int from = pageSize * (pageIndex - 1) + 1;
            int to = pageSize * pageIndex;
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1,id);
            pstmt.setInt(2, from);
            pstmt.setInt(3, to);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                String img=db.getImagePath()+rs.getString("image");
                int gaID=rs.getInt("gallery_id");
                ImageGallery im = new ImageGallery(img, gaID);
                list.add(im);
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pstmt, rs);
        }
    }
    public int getNumberPages(int id,int pageSize) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(id) as number FROM ImageGallery where gallery_id = ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1,id);
            rs = ps.executeQuery();

            while (rs.next()) {
                int number = rs.getInt("number");
                if (number % pageSize == 0) {
                    return number / pageSize;
                } else {
                    return number / pageSize + 1;
                }
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return -1;
    }
    public ArrayList<ImageGallery> getImageByGallery(int id) throws Exception{
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from ImageGallery where gallery_id = ?";
        ArrayList<ImageGallery> list = new ArrayList<>();
        
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                String img=db.getImagePath()+rs.getString("image");
                int gaID=rs.getInt("gallery_id");
                ImageGallery im = new ImageGallery(img, gaID);
                list.add(im);
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        }finally{
           db.closeConnection(con, ps, rs);
        }

    }
}

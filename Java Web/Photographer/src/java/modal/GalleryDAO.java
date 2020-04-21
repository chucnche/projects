/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Gallery;
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
public class GalleryDAO {
//get Top 3 gallery(menu)
    public ArrayList<Gallery> getTop3Gallerys() throws Exception {
        DBContext db = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = "Select top 3 * from Gallery";
        ArrayList<Gallery> list = new ArrayList<>();
        try {
            db = new DBContext();    
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                String image =db.getImagePath() + rs.getString("image");
                Gallery ga = new Gallery(id, name, des, image);
                list.add(ga);
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pstmt, rs);
        }
    }
//get Galleries to paging
    public ArrayList<Gallery> getGallerys(int pageSize, int pageIndex) throws Exception {
        DBContext db = null;
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;


        String sql = "SELECT * FROM (\n" +
"                SELECT ROW_NUMBER()\n" +
"                OVER(ORDER BY id) as Number,* FROM Gallery\n" +
"                )as dbNumber where Number between ? and ?";
        ArrayList<Gallery> list = new ArrayList<>();
        try {
            db = new DBContext();    
            int from = pageSize * (pageIndex - 1) + 1;
            int to = pageSize * pageIndex;
            conn = db.getConnection();
            pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, from);
            pstmt.setInt(2, to);
            rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                String image =db.getImagePath() + rs.getString("image");
                Gallery ga = new Gallery(id, name, des, image);
                list.add(ga);
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(conn, pstmt, rs);
        }
    }
//get numberPage
    public int getNumberPages(int pageSize) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(id) as number FROM Gallery";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
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
//get gallery by id
    public Gallery getGalleryByID(int id) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from Gallery where id = ?";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String name = rs.getString("name");
                String des = rs.getString("description");
                String image =db.getImagePath() + rs.getString("image");
                Gallery ga = new Gallery(id1, name, des, image);
                return ga;
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }

        return null;
    }
}

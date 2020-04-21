/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Article;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.naming.NamingException;

/**
 *
 * @author Chucnc
 */
public class ArticleDAO {

    public Article getArticleById(int id) throws Exception{
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT title, image, content, date, author,description FROM Article WHERE id = ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            while (rs.next()) {
                String title = rs.getString("title");
                String image = db.getImagePath() + rs.getString("image");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                String des = rs.getString("description");
                return new Article(id, title, image, content, date, author,des);
            }

        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }

    public ArrayList<Article> recentArticle(int numberArticle) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT TOP (?) * "
                + "FROM Article \n"
                + "ORDER BY Date DESC";

        ArrayList<Article> listArticle = new ArrayList<>();
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, numberArticle);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String image = db.getImagePath() + rs.getString("image");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                String des = rs.getString("description");
                Article article = new Article(id, title, image, content, date, author,des);
                listArticle.add(article);
            }
            return listArticle;

        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    public ArrayList<Article> getListSearch(int pageSize, int pageIndex, String search) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Article> listArticle = new ArrayList<>();

        String sql = "SELECT * FROM (\n"
                + "SELECT ROW_NUMBER()\n"
                + "OVER(ORDER BY id) as Number,* FROM Article WHERE content LIKE ? OR title LIKE ? \n"
                + ")as dbNumber where Number between ? and ?";
        try {
            db = new DBContext();

            int from = pageSize * (pageIndex - 1) + 1;
            int to = pageSize * pageIndex;

            con = db.getConnection();
            ps = con.prepareStatement(sql);
            search = "%" + search + "%";
            ps.setString(1, search);
            ps.setString(2, search);
            ps.setInt(3, from);
            ps.setInt(4, to);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String title = rs.getString("title");
                String image = db.getImagePath() + rs.getString("image");
                String content = rs.getString("content");
                Date date = rs.getDate("date");
                String author = rs.getString("author");
                String des = rs.getString("description");
                Article article = new Article(id, title, image, content, date, author,des);
                listArticle.add(article);
            }
            return listArticle;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }

    public int getNumberPages(int pageSize, String search) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(id) as number FROM Article \n"
                + "WHERE content LIKE ? OR title LIKE ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            search = "%" + search + "%";
            ps.setString(1, search);
            ps.setString(2, search);
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
}

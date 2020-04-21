/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modal;

import db.DBContext;
import entity.Question;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.Calendar;
import java.util.List;

/**
 *
 */
public class QuestionDAO {
//get question rand to take quiz
    public ArrayList<Question> getQuestionsRand(int number) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> list = new ArrayList<>();
        String sql = "SELECT TOP (?) * FROM Question\n" +
"ORDER BY NEWID()";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, number);
            rs = ps.executeQuery();
            int i=1;
            while (rs.next()) {
                int id = rs.getInt("id");
                String q_name = rs.getString("q_name");
                DateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                String d = simpleDateFormat.format(rs.getDate("date_created"));
                String ans_1 = rs.getString("ans_1");
                String ans_2 = rs.getString("ans_2");
                String ans_3 = rs.getString("ans_3");
                String ans_4 = rs.getString("ans_4");
                String true_ans = rs.getString("true_answer");
                String author = rs.getString("created_by");
                int index = i;
                // add question to list
                list.add(new Question(id, q_name, d, ans_1, ans_2, ans_3, ans_4, true_ans, author,index));
                i++;
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
//get questions by username
    public ArrayList<Question> getQuestionsByUser(String user) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> list = new ArrayList<>();
        String sql = "SELECT * FROM Question where created_by = ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String q_name = rs.getString("q_name");
                DateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                String d = simpleDateFormat.format(rs.getDate("date_created"));
                String ans_1 = rs.getString("ans_1");
                String ans_2 = rs.getString("ans_2");
                String ans_3 = rs.getString("ans_3");
                String ans_4 = rs.getString("ans_4");
                String true_ans = rs.getString("true_answer");
                String author = rs.getString("created_by");
                // add question to list
                list.add(new Question(id, q_name, d, ans_1, ans_2, ans_3, ans_4, true_ans, author));
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
//get question by id
    public Question getQuestionsByID(int id) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT * FROM Question where id = ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                String q_name = rs.getString("q_name");
                DateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                String d = simpleDateFormat.format(rs.getDate("date_created"));
                String ans_1 = rs.getString("ans_1");
                String ans_2 = rs.getString("ans_2");
                String ans_3 = rs.getString("ans_3");
                String ans_4 = rs.getString("ans_4");
                String true_ans = rs.getString("true_answer");
                String author = rs.getString("created_by");
                return new Question(id, q_name, d, ans_1, ans_2, ans_3, ans_4, true_ans, author);
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return null;
    }
//count all question have in database
    public int countQuestions() throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select count(*) as c from Question";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt("c");
            }
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
        return 0;
    }
//insert question to database
    public void addQuestion(Question q) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "INSERT INTO Question(q_name,date_created,ans_1, ans_2, ans_3, ans_4, true_answer, created_by)"
                + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, q.getQ_name());
            ps.setDate(2, Date.valueOf(q.getDate_created()));
            ps.setString(3, q.getAns_1());
            ps.setString(4, q.getAns_2());
            ps.setString(5, q.getAns_3());
            ps.setString(6, q.getAns_4());
            ps.setString(7, q.getTrue_answer());
            ps.setString(8, q.getCreate_by());
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
//delete question by id
    public void deleteQuestion(int id) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "DELETE FROM Question WHERE id = ?";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
//get question paging
    public ArrayList<Question> getQuestionPaging(int pageSize, int pageIndex, String user) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ArrayList<Question> listQuestion = new ArrayList<>();

        String sql = "SELECT * FROM (\n"
                + "SELECT ROW_NUMBER()\n"
                + "OVER(ORDER BY id) as Number,* FROM Question WHERE created_by = ? \n"
                + ")as dbNumber where Number between ? and ?";
        try {
            db = new DBContext();

            int from = pageSize * (pageIndex - 1) + 1;
            int to = pageSize * pageIndex;

            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
            ps.setInt(2, from);
            ps.setInt(3, to);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("id");
                String q_name = rs.getString("q_name");
                DateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
                String d = simpleDateFormat.format(rs.getDate("date_created"));
                String ans_1 = rs.getString("ans_1");
                String ans_2 = rs.getString("ans_2");
                String ans_3 = rs.getString("ans_3");
                String ans_4 = rs.getString("ans_4");
                String true_ans = rs.getString("true_answer");
                String author = rs.getString("created_by");
                // add question to list
                listQuestion.add(new Question(id, q_name, d, ans_1, ans_2, ans_3, ans_4, true_ans, author));
            }
            return listQuestion;
        } catch (Exception ex) {
            throw ex;
        } finally {
            db.closeConnection(con, ps, rs);
        }
    }
//get max page in paging
    public int getNumberPages(int pageSize, String user) throws Exception {
        DBContext db = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT COUNT(id) as number FROM Question \n"
                + "WHERE created_by = ? ";
        try {
            db = new DBContext();
            con = db.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, user);
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

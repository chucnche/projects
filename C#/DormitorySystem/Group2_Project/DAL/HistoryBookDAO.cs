using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
namespace Group2_Project.DAL
{
    class HistoryBookDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from HistoryBook";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableByStuID(string stuID)
        {
            string cmd = "select * from HistoryBook where stuID = '" + stuID + "'";
            return DAO.GetDataTable(cmd);
        }
        public static List<HistoryBook> GetHistoryBooks()
        {
            List<HistoryBook> historyBooks = new List<HistoryBook>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from HistoryBook";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID = da.GetValue(0).ToString();
                DateTime dateBook = DateTime.Parse(da.GetValue(1).ToString());
                string roomName = da.GetValue(2).ToString();
                int bedNo = int.Parse(da.GetValue(3).ToString());
                int bookID = int.Parse(da.GetValue(4).ToString());
                int status = int.Parse(da.GetValue(5).ToString());
                DateTime dateExpiry = DateTime.Parse(da.GetValue(6).ToString());
                HistoryBook historyBook = new HistoryBook(stuID, dateBook, roomName, bedNo, bookID, status, dateExpiry);
                historyBooks.Add(historyBook);
            }
            conn.Close();
            return historyBooks;
        }
        public static List<HistoryBook> GetHistoryBooksByStuID(string stuID)
        {
            List<HistoryBook> historyBooks = new List<HistoryBook>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from HistoryBook where stuID = '" + stuID + "'";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                DateTime dateBook = DateTime.Parse(da.GetValue(1).ToString());
                string roomName = da.GetValue(2).ToString();
                int bedNo = int.Parse(da.GetValue(3).ToString());
                int bookID = int.Parse(da.GetValue(4).ToString());
                int status = int.Parse(da.GetValue(5).ToString());
                DateTime dateExpiry = DateTime.Parse(da.GetValue(6).ToString());
                HistoryBook historyBook = new HistoryBook(stuID1, dateBook, roomName, bedNo, bookID, status, dateExpiry);
                historyBooks.Add(historyBook);
            }
            conn.Close();
            return historyBooks;
        }
        //them
        public static HistoryBook GetHistoryBooksByBookID(int bookID)
        {
            List<HistoryBook> historyBooks = new List<HistoryBook>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from HistoryBook where bookID = " + bookID;
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                DateTime dateBook = DateTime.Parse(da.GetValue(1).ToString());
                string roomName = da.GetValue(2).ToString();
                int bedNo = int.Parse(da.GetValue(3).ToString());
                int bookID1 = int.Parse(da.GetValue(4).ToString());
                int status = int.Parse(da.GetValue(5).ToString());
                DateTime dateExpiry = DateTime.Parse(da.GetValue(6).ToString());
                HistoryBook historyBook = new HistoryBook(stuID1, dateBook, roomName, bedNo, bookID1, status, dateExpiry);
                return historyBook;
            }
            conn.Close();
            return null;
        }
        //them
        public static List<HistoryBook> GetHistoryBooksByRoomNameStatus(string roomName, int bedNo)
        {
            List<HistoryBook> historyBooks = new List<HistoryBook>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from HistoryBook where status=1 AND roomName = '" + roomName + "' AND bedNo = " + bedNo;
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                DateTime dateBook = DateTime.Parse(da.GetValue(1).ToString());
                string roomName1 = da.GetValue(2).ToString();
                int bedNo1 = int.Parse(da.GetValue(3).ToString());
                int bookID = int.Parse(da.GetValue(4).ToString());
                int status = int.Parse(da.GetValue(5).ToString());
                DateTime dateExpiry = DateTime.Parse(da.GetValue(6).ToString());
                HistoryBook historyBook = new HistoryBook(stuID1, dateBook, roomName1, bedNo1, bookID, status, dateExpiry);
                historyBooks.Add(historyBook);
            }
            conn.Close();
            return historyBooks;
        }
        public static HistoryBook GetHistoryBooksByStuIDStatus(string stuID)
        {
            List<HistoryBook> historyBooks = new List<HistoryBook>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from HistoryBook where status=1 AND stuID = '" + stuID + "'";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                DateTime dateBook = DateTime.Parse(da.GetValue(1).ToString());
                string roomName = da.GetValue(2).ToString();
                int bedNo = int.Parse(da.GetValue(3).ToString());
                int bookID = int.Parse(da.GetValue(4).ToString());
                int status = int.Parse(da.GetValue(5).ToString());
                DateTime dateExpiry = DateTime.Parse(da.GetValue(6).ToString());
                HistoryBook historyBook = new HistoryBook(stuID1, dateBook, roomName, bedNo, bookID, status, dateExpiry);
                return historyBook;
            }
            conn.Close();
            return null;
        }
        public static bool Insert(HistoryBook hb)
        {
            string sql = "insert into HistoryBook (stuID, dateBook, roomName, bedNo, [status], dateExpiry) values (@stuID, @dateBook, @roomName, @bedNo, @status, @dateExpiry)";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@stuID", hb.StuID);
            cmd.Parameters.AddWithValue("@dateBook", hb.DateBook);
            cmd.Parameters.AddWithValue("@roomName", hb.RoomName);
            cmd.Parameters.AddWithValue("@bedNo", hb.BedNo);
            cmd.Parameters.AddWithValue("@status", hb.Status);
            cmd.Parameters.AddWithValue("@dateExpiry", hb.DateExpiry);
            return DAO.UpdateTable(cmd);
        }
        public static bool Update(HistoryBook hb)
        {
            string sql = "update HistoryBook set stuID = @stuID, dateBook = @dateBook, roomName = @roomName, bedNo = @bedNo, [status] = @status, dateExpiry = @dateExpiry where bookID = @bookID";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@stuID", hb.StuID);
            cmd.Parameters.AddWithValue("@dateBook", hb.DateBook);
            cmd.Parameters.AddWithValue("@roomName", hb.RoomName);
            cmd.Parameters.AddWithValue("@bedNo", hb.BedNo);
            cmd.Parameters.AddWithValue("@status", hb.Status);
            cmd.Parameters.AddWithValue("@dateExpiry", hb.DateExpiry);
            cmd.Parameters.AddWithValue("@bookID", hb.BookID);
            return DAO.UpdateTable(cmd);
        }
        public static bool Delete(HistoryBook hb)
        {
            string sql = "delete HistoryBook where bookID = @bookID";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@bookID", hb.BookID);
            return DAO.UpdateTable(cmd);
        }
        //them new
        public static HistoryBook GetHistoryBooksByRoomNameStatus2(string stuID)
        {
            List<HistoryBook> historyBooks = new List<HistoryBook>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select Top 1 * from HistoryBook where status=2 AND stuID = '" + stuID + "' order by dateBook desc";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                DateTime dateBook = DateTime.Parse(da.GetValue(1).ToString());
                string roomName1 = da.GetValue(2).ToString();
                int bedNo = int.Parse(da.GetValue(3).ToString());
                int bookID = int.Parse(da.GetValue(4).ToString());
                int status = int.Parse(da.GetValue(5).ToString());
                DateTime dateExpiry = DateTime.Parse(da.GetValue(6).ToString());
                HistoryBook historyBook = new HistoryBook(stuID1, dateBook, roomName1, bedNo, bookID, status, dateExpiry);
                return historyBook;
            }
            conn.Close();
            return null;
        }

        public static DataTable GetDataTableBySmth(string roomName, int bedNo, int status)
        {
            string cmd = "select * from HistoryBook where roomName = '" + roomName + "' and bedNo = " + bedNo + " and status = " + status;
            return DAO.GetDataTable(cmd);
        }

        public static DataTable GetDataTableByStatus(int status)
        {
            string cmd = "select * from HistoryBook where status = " + status;
            return DAO.GetDataTable(cmd);
        }

        public static DataTable GetDataTableByRoomName(string roomName, int status)
        {
            string cmd = "select * from HistoryBook where roomName = '" + roomName + "' and status = " + status;
            return DAO.GetDataTable(cmd);
        }

    }
}
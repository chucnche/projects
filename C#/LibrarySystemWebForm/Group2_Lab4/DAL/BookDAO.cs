using Group2_Lab4.DTL;
using System;
using System.Data;
using System.Data.SqlClient;

namespace Group2_Lab4.DAL
{
    public class BookDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Book";
            return DAO.GetDataTable(cmd);
        }

        public static int GetBookNumberMax()
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(bookNumber)", ""));
        }
        public static Book GetBook(int bookNumber)
        {
            SqlConnection conn = DAO.getConnections();
            string sql = "SELECT * FROM Book WHERE bookNumber = @bookNumber";
            SqlCommand command = new SqlCommand(sql, conn);
            command.Parameters.Add(new SqlParameter("@bookNumber", bookNumber));
            conn.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Book s = new Book();
                s.BookNumber = Int32.Parse(reader["bookNumber"].ToString());
                s.Title = reader["title"].ToString();
                s.Authors = reader["authors"].ToString();
                s.Publisher = reader["publisher"].ToString();
                conn.Close();
                return s;
            }
            return null;
        }
        public static bool Insert(Book b)
        {
            try
            {
                SqlConnection conn = DAO.getConnections();
                SqlCommand cmd = new SqlCommand("insert into book( title, authors, publisher) values( @title, @authors, @publisher)");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@title", b.Title);
                cmd.Parameters.AddWithValue("@authors", b.Authors);
                cmd.Parameters.AddWithValue("@publisher", b.Publisher);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;
            }
            catch (Exception)
            {
                return false;
            }
        }

        public static bool Update(Book b)
        {
            SqlCommand cmd = new SqlCommand("update Book set title=@title, authors = @authors, publisher = @publisher where bookNumber=@bookNumber");
            cmd.Parameters.AddWithValue("@bookNumber", b.BookNumber);
            cmd.Parameters.AddWithValue("@title", b.Title);
            cmd.Parameters.AddWithValue("@authors", b.Authors);
            cmd.Parameters.AddWithValue("@publisher", b.Publisher);
            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(Book b)
        {

            SqlCommand cmd = new SqlCommand("delete Book where bookNumber=@bookNumber");
            cmd.Parameters.AddWithValue("@bookNumber", b.BookNumber);
            return DAO.UpdateTable(cmd);

        }

    }
}

using GROUP2_LAB3.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace GROUP2_LAB3.DAL
{
    class BookDAO
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
                SqlCommand cmd = new SqlCommand("insert into book(bookNumber, title, authors, publisher) values(@bookNumber, @title, @authors, @publisher)");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@bookNumber", b.BookNumber);
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
                SqlConnection conn = DAO.getConnections();
                SqlCommand cmd = new SqlCommand("SET IDENTITY_INSERT Book ON;" +
                "insert into book(bookNumber, title, authors, publisher)" +
                    "values (@bookNumber, @title, @authors, @publisher);" +
                    "SET IDENTITY_INSERT Book OFF");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@bookNumber", b.BookNumber);
                cmd.Parameters.AddWithValue("@title", b.Title);
                cmd.Parameters.AddWithValue("@authors", b.Authors);
                cmd.Parameters.AddWithValue("@publisher", b.Publisher);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;
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

        public static Boolean Delete(int bookNumber)
        {

                SqlCommand cmd = new SqlCommand("delete Book where bookNumber=@bookNumber");
                cmd.Parameters.AddWithValue("@bookNumber", bookNumber);
                return DAO.UpdateTable(cmd);

        }

    }
}

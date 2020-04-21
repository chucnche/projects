using Group2_Lab4.DTL;
using System;
using System.Data;
using System.Data.SqlClient;

namespace Group2_Lab4.DAL
{
    class CopyDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Copy";
            return DAO.GetDataTable(cmd);
        }
        public static Copy GetCopy(int copyNumber) 
        {
            SqlConnection conn = DAO.getConnections();
            string sql = "SELECT * FROM Copy WHERE copyNumber = @copyNumber";
            SqlCommand command = new SqlCommand(sql,conn);
            command.Parameters.Add(new SqlParameter("@copyNumber", copyNumber));
            conn.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Copy s = new Copy(
                Convert.ToInt32(reader["bookNumber"].ToString())
                , Convert.ToInt32(reader["copyNumber"].ToString())
                
                , Convert.ToInt32(reader["sequenceNumber"].ToString())
                ,Char.Parse(reader["type"].ToString())
                ,float.Parse(reader["price"].ToString()) );
                conn.Close();
                return s;
            }
            return null;
        }
        public static Copy GetCopyByBookNumber(int bookNumber) 
        {
            SqlConnection conn = DAO.getConnections();
            string sql = "SELECT * FROM Copy WHERE type='A' AND bookNumber = @bookNumber";
            SqlCommand command = new SqlCommand(sql, conn);
            command.Parameters.Add(new SqlParameter("@bookNumber", bookNumber));
            conn.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Copy s = new Copy(
                Convert.ToInt32(reader["bookNumber"].ToString())
                , Convert.ToInt32(reader["copyNumber"].ToString())

                , Convert.ToInt32(reader["sequenceNumber"].ToString())
                , Char.Parse(reader["type"].ToString())
                , float.Parse(reader["price"].ToString()));
                conn.Close();
                return s;
            }
            return null;
        }
        public static int GetCopyNumberMax() 
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(copyNumber)", ""));
        }
        public static int GetSequenceNumberMax(int copyBookNumber) 
        {
            string cmd = "select * from Copy where bookNumber="+ copyBookNumber.ToString();
            DataTable dt = DAO.GetDataTable(cmd);
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(sequenceNumber)", ""));
        }
        public static bool Insert(Copy c)
        {
            try
            {
                SqlConnection conn = DAO.getConnections();
                SqlCommand cmd = new SqlCommand("insert into Copy(copyNumber,bookNumber,sequenceNumber,type,price)" +
                        "values (@copyNumber,@bookNumber, @sequenceNumber, @type, @price)");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@copyNumber", c.CopyNumber);
                cmd.Parameters.AddWithValue("@bookNumber", c.BookNumber);
                cmd.Parameters.AddWithValue("@sequenceNumber", c.SequenceNumber);
                cmd.Parameters.AddWithValue("@type", c.Type);
                cmd.Parameters.AddWithValue("@price", c.Price);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;
            }
            catch (Exception)
            {
                SqlConnection conn = DAO.getConnections();
                SqlCommand cmd = new SqlCommand("SET IDENTITY_INSERT Copy ON;" +
                        "insert into Copy(copyNumber,bookNumber,sequenceNumber,type,price)" +
                        "values (@copyNumber,@bookNumber, @sequenceNumber, @type, @price)" +
                        "SET IDENTITY_INSERT Copy OFF");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@copyNumber", c.CopyNumber);
                cmd.Parameters.AddWithValue("@bookNumber", c.BookNumber);
                cmd.Parameters.AddWithValue("@sequenceNumber", c.SequenceNumber);
                cmd.Parameters.AddWithValue("@type", c.Type);
                cmd.Parameters.AddWithValue("@price", c.Price);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;
            }
        }

        public static bool Update(Copy c) 
        {
            SqlCommand cmd = new SqlCommand("update Copy set type=@type, price = @price where copyNumber=@copyNumber");
            cmd.Parameters.AddWithValue("@type", c.Type);
            cmd.Parameters.AddWithValue("@price", c.Price);
            cmd.Parameters.AddWithValue("@copyNumber", c.CopyNumber);
            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(Copy c)
        {
            SqlCommand cmd = new SqlCommand("delete Copy where copyNumber=@copyNumber");
            cmd.Parameters.AddWithValue("@copyNumber", c.CopyNumber);
            return DAO.UpdateTable(cmd);
        }
    }
}

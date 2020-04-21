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
    class BorrowerDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Borrower";
            return DAO.GetDataTable(cmd);
        }

        public static int GetBorrowerNumberMax()
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(borrowerNumber)", ""));
        }
        public static Borrower GetBorrower(int borrowerNumber)
        {
            SqlConnection conn = DAO.getConnections();
            string sql = "SELECT * FROM Borrower WHERE borrowerNumber = @borrowerNumber";
            SqlCommand command = new SqlCommand(sql, conn);
            command.Parameters.Add(new SqlParameter("@borrowerNumber", borrowerNumber));
            conn.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Borrower s = new Borrower();
                s.BorrowerNumber = Int32.Parse(reader["borrowerNumber"].ToString());
                s.Name = reader["name"].ToString();
                s.Sex = Char.Parse(reader["sex"].ToString());
                s.Address = reader["address"].ToString();
                s.Telephone = reader["telephone"].ToString();
                s.Email = reader["email"].ToString();
                conn.Close();
                return s;
            }
            return null;
        }

        public static bool Insert(Borrower b)
        {

 
            try
            {
                SqlConnection conn = DAO.getConnections();
                SqlCommand cmd = new SqlCommand("insert into Borrower(borrowerNumber, name, sex, address,telephone,email) " +
                    "values(@borrowerNumber, @name, @sex, @address,@telephone,@email)");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
                cmd.Parameters.AddWithValue("@name", b.Name);
                cmd.Parameters.AddWithValue("@sex", b.Sex);
                cmd.Parameters.AddWithValue("@address", b.Address);
                cmd.Parameters.AddWithValue("@telephone", b.Telephone);
                cmd.Parameters.AddWithValue("@email", b.Email);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;
            }
            catch (Exception)
            {
                SqlConnection conn = DAO.getConnections();
                SqlCommand cmd = new SqlCommand("SET IDENTITY_INSERT Borrower ON;" +
                        "insert into Borrower(borrowerNumber, name, sex, address,telephone,email) " +
                    "values(@borrowerNumber, @name, @sex, @address,@telephone,@email)" +
                        "SET IDENTITY_INSERT Borrower OFF");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
                cmd.Parameters.AddWithValue("@name", b.Name);
                cmd.Parameters.AddWithValue("@sex", b.Sex);
                cmd.Parameters.AddWithValue("@address", b.Address);
                cmd.Parameters.AddWithValue("@telephone", b.Telephone);
                cmd.Parameters.AddWithValue("@email", b.Email);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;
            }

        }

        public static bool Update(Borrower b)
        {
            SqlCommand cmd = new SqlCommand("update Borrower set name=@name, sex = @sex, address = @address, telephone = @telephone, email = @email where borrowerNumber=@borrowerNumber");
            cmd.Parameters.AddWithValue("@name", b.Name);
            cmd.Parameters.AddWithValue("@sex", b.Sex);
            cmd.Parameters.AddWithValue("@address", b.Address);
            cmd.Parameters.AddWithValue("@telephone", b.Telephone);
            cmd.Parameters.AddWithValue("@email", b.Email);
            cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(int borrowerNumber)
        {
            SqlCommand cmd = new SqlCommand("delete Borrower where borrowerNumber=@borrowerNumber");
            cmd.Parameters.AddWithValue("@borrowerNumber", borrowerNumber);
            return DAO.UpdateTable(cmd);
        }

    }
}

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
    class ReserveDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Reservation";
            return DAO.GetDataTable(cmd);
        }

        public static int GetIDMax() 
        {
            DataTable dt = GetDataTable();
            if (dt.Rows.Count == 0) return 0;
            else return (int)(dt.Compute("max(ID)", ""));
        }
        public static Reservation GetFirstReservation(int bookNumber) 
        {
            SqlConnection conn = DAO.getConnections();
            string sql = "SELECT TOP 1 * FROM Reservation WHERE status='R' AND bookNumber = @bookNumber";
            SqlCommand command = new SqlCommand(sql, conn);
            command.Parameters.Add(new SqlParameter("@bookNumber", bookNumber));
            conn.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                Reservation s = new Reservation();
                s.Id = Int32.Parse(reader["ID"].ToString());
                s.BorrowerNumber = Int32.Parse(reader["borrowerNumber"].ToString());
                s.BookNumber = Int32.Parse(reader["bookNumber"].ToString());
                s.Date = Convert.ToDateTime(reader["date"]);
                s.Status =Char.Parse(reader["status"].ToString());
                conn.Close();
                return s;
            }
            return null;
        }
        public static DataTable GetReservation(int borrowerNumber)
        {
            string cmd = "select * from Reservation where status='R' AND borrowerNumber=" + borrowerNumber.ToString();
            return DAO.GetDataTable(cmd);
        }
        public static bool Insert(Reservation b)
        {
            SqlCommand cmd = new SqlCommand("insert into Reservation(borrowerNumber, bookNumber, date, status) " +
                "values(@borrowerNumber, @bookNumber, @date, @status)");
            cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
            cmd.Parameters.AddWithValue("@bookNumber", b.BookNumber);
            cmd.Parameters.AddWithValue("@date", b.Date);
            cmd.Parameters.AddWithValue("@status", b.Status);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(Reservation b)
        {
            SqlCommand cmd = new SqlCommand("update Reservation set status=@status  where ID=@id");
            cmd.Parameters.AddWithValue("@status", b.Status);
            cmd.Parameters.AddWithValue("@id", b.Id);
            return DAO.UpdateTable(cmd);
        }

    }
}

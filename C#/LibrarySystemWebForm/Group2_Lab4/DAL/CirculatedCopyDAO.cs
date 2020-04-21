using Group2_Lab4.DTL;
using System;
using System.Data;
using System.Data.SqlClient;

namespace Group2_Lab4.DAL
{
    class CirculatedCopyDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from CirculatedCopy";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetBorrowedCopies(int borrowerNumber)
        {
            string cmd = "select * from CirculatedCopy where returnedDate IS NULL AND borrowerNumber=" + borrowerNumber.ToString();
            return DAO.GetDataTable(cmd);
        }
        public static CirculatedCopy GetCirculatedCopy(Borrower borrower) 
        {
            SqlConnection conn = DAO.getConnections();
            string sql = "SELECT * FROM CirculatedCopy WHERE borrowerNumber = @borrowerNumber";
            SqlCommand command = new SqlCommand(sql, conn);
            command.Parameters.Add(new SqlParameter("@borrowerNumber", borrower.BorrowerNumber));
            conn.Open();
            SqlDataReader reader = command.ExecuteReader();
            while (reader.Read())
            {
                CirculatedCopy s = new CirculatedCopy();
                s.Id= Int32.Parse(reader["ID"].ToString());
                s.CopyNumber = Int32.Parse(reader["copyNumber"].ToString());
                s.BorrowerNumber = Int32.Parse(reader["borrowerNumber"].ToString());
                s.BorrowedDate= Convert.ToDateTime(reader["borrowedDate"]);
                s.DueDate = Convert.ToDateTime(reader["dueDate"]);
                s.ReturnedDate= Convert.ToDateTime(reader["returnedDate"]);
                s.FineAmount = float.Parse(reader["fineAmount"].ToString());
                conn.Close();
                return s;
            }
            return null;
        }

        public static bool Insert(CirculatedCopy b)
        {
            SqlCommand cmd = new SqlCommand("insert into CirculatedCopy(copyNumber,borrowerNumber, borrowedDate, dueDate) values(@copyNumber,@borrowerNumber,@borrowedDate,@dueDate)");
            cmd.Parameters.AddWithValue("@copyNumber", b.CopyNumber);
            cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
            cmd.Parameters.AddWithValue("@borrowedDate", b.BorrowedDate);
            cmd.Parameters.AddWithValue("@dueDate", b.DueDate);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(CirculatedCopy b)
        {
            SqlCommand cmd = new SqlCommand("update CirculatedCopy set copyNumber=@copyNumber, borrowerNumber = @borrowerNumber, borrowedDate = @borrowedDate, dueDate = @dueDate, returnedDate = @returnedDate,fineAmount = @fineAmount where ID=@id");
            cmd.Parameters.AddWithValue("@copyNumber", b.CopyNumber);
            cmd.Parameters.AddWithValue("@borrowerNumber", b.BorrowerNumber);
            cmd.Parameters.AddWithValue("@borrowedDate", b.BorrowedDate);
            cmd.Parameters.AddWithValue("@dueDate", b.DueDate);
            cmd.Parameters.AddWithValue("@returnedDate", b.ReturnedDate);
            cmd.Parameters.AddWithValue("@fineAmount", b.FineAmount);
            cmd.Parameters.AddWithValue("@ID", b.Id);
            return DAO.UpdateTable(cmd);
        }

        public static Boolean Delete(Borrower borrower)
        {
            SqlCommand cmd = new SqlCommand("delete CirculatedCopy where borrowerNumber=@borrowerNumber");
            cmd.Parameters.AddWithValue("@borrowerNumber", borrower.BorrowerNumber);
            return DAO.UpdateTable(cmd);
        }

    }
}

using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class HistoryPaymentDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from HistoryPayment";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableByStuId(string stuId)
        {
            string cmd = "select * from HistoryPayment where stuID = '" + stuId +"'";
            return DAO.GetDataTable(cmd);
        }
        public static List<HistoryPayment> getHistoryPayments()
        {
            List<HistoryPayment> list = new List<HistoryPayment>();
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("select * from HistoryPayment");
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int id = int.Parse(da.GetValue(0).ToString());
                string stuId = da.GetValue(1).ToString();
                DateTime datePay = DateTime.Parse(da.GetValue(2).ToString());
                string type = da.GetValue(3).ToString();
                int moneyPay = int.Parse(da.GetValue(4).ToString());
                string roomName = da.GetValue(5).ToString();
                HistoryPayment hp = new HistoryPayment(id, stuId, datePay, type, moneyPay, roomName);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }
        public static List<HistoryPayment> getHistoryPaymentsByStuID(string stuId)
        {
            List<HistoryPayment> list = new List<HistoryPayment>();
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select * from HistoryPayment where stuID = '" + stuId + "'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int id = int.Parse(da.GetValue(0).ToString());
                string stuId1 = da.GetValue(1).ToString();
                DateTime datePay = DateTime.Parse(da.GetValue(2).ToString());
                string type = da.GetValue(3).ToString();
                int moneyPay = int.Parse(da.GetValue(4).ToString());
                string roomName = da.GetValue(5).ToString();
                HistoryPayment hp = new HistoryPayment(id, stuId1, datePay, type, moneyPay, roomName);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }
        public static bool Insert(HistoryPayment b)
        {
                SqlConnection conn = DAO.getConnections();
                SqlCommand cmd = new SqlCommand("insert into HistoryPayment(stuId,datePay, type,moneyPay,roomName) values(@stuId, @datePay, @type, @moneyPay,@roomName)");
                cmd.Connection = conn;
                cmd.Parameters.AddWithValue("@stuId", b.StuID);
                cmd.Parameters.AddWithValue("@datePay", b.DatePay);
                cmd.Parameters.AddWithValue("@type", b.Type);
                cmd.Parameters.AddWithValue("@moneyPay", b.MoneyPay);
                cmd.Parameters.AddWithValue("@roomName", b.RoomName);
                conn.Open();
                cmd.ExecuteNonQuery();
                conn.Close();
                return true;
        }
        public static bool Update(HistoryPayment b)
        {
            SqlCommand cmd = new SqlCommand("update HistoryPayment set datePay=@datePay, type = @type, moneyPay = @moneyPay,roomName = @roomName where id=@id");
            cmd.Parameters.AddWithValue("@datePay", b.DatePay);
            cmd.Parameters.AddWithValue("@type", b.Type);
            cmd.Parameters.AddWithValue("@moneyPay", b.MoneyPay);
            cmd.Parameters.AddWithValue("@roomName", b.RoomName);
            cmd.Parameters.AddWithValue("@id", b.Id);
            return DAO.UpdateTable(cmd);
        }
        public static Boolean Delete(int id)
        {

            SqlCommand cmd = new SqlCommand("delete HistoryPayment where id=@id");
            cmd.Parameters.AddWithValue("@id", id);
            return DAO.UpdateTable(cmd);

        }
    }
}

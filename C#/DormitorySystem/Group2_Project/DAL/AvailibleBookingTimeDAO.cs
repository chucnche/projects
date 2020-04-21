using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class AvailibleBookingTimeDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select top 1 * from AvailibleBookingTime";
            return DAO.GetDataTable(cmd);
        }

        public static AvailibleBookingTime GetLatestDate()
        {
            AvailibleBookingTime abt = new AvailibleBookingTime();
            SqlConnection conn = DAO.getConnections();
            string sql = "select top 1 * from AvailibleBookingTime";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int adID = int.Parse(da.GetValue(0).ToString());
                DateTime from = DateTime.Parse(da.GetValue(1).ToString());
                DateTime to = DateTime.Parse(da.GetValue(2).ToString());

                abt = new AvailibleBookingTime(adID, from, to);
            }
            conn.Close();
            return abt;
        }

        public static bool Update(AvailibleBookingTime abt)
        {
            string sql = "update AvailibleBookingTime set [from] = @from, [to] = @to where adID = @adID";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@from", abt.From);
            cmd.Parameters.AddWithValue("@to", abt.To);
            cmd.Parameters.AddWithValue("@adID", abt.AdID);

            return DAO.UpdateTable(cmd);
        }

        public static bool Delete(AvailibleBookingTime abt)
        {
            //string sql = "delete from AvailibleBookingTime where adID = @adID";
            //SqlCommand cmd = new SqlCommand(sql);
            //cmd.Parameters.AddWithValue("@adID", abt.AdID);

            //return DAO.UpdateTable(cmd);
            return true;
        }

    }
}

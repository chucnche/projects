using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class ElectricityWaterBillsDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from ElectricityWaterBills";
            return DAO.GetDataTable(cmd);
        }

        public static DataTable GetDataTableByRoom(string roomName)
        {
            string cmd = "select * from ElectricityWaterBills where roomName = '" + roomName + "'";
            return DAO.GetDataTable(cmd);
        }

        public static List<ElectricityWaterBills> GetElectricityWaterBills()
        {
            List<ElectricityWaterBills> electricityWaterBills = new List<ElectricityWaterBills>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from ElectricityWaterBills";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int id = int.Parse(da.GetValue(0).ToString());
                string roomName = da.GetValue(1).ToString();
                DateTime monthYear = DateTime.Parse(da.GetValue(2).ToString());
                int soDien = int.Parse(da.GetValue(3).ToString());
                int soNuoc = int.Parse(da.GetValue(4).ToString());
                int paid = int.Parse(da.GetValue(5).ToString());

                ElectricityWaterBills account = new ElectricityWaterBills(id, roomName, monthYear, soDien, soNuoc, paid);
                electricityWaterBills.Add(account);
            }
            conn.Close();

            return electricityWaterBills;
        }

        public static List<ElectricityWaterBills> GetElectricityWaterBillsByRoom(string roomName)
        {
            List<ElectricityWaterBills> electricityWaterBills = new List<ElectricityWaterBills>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from ElectricityWaterBills where roomName = '" + roomName + "'";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int id = int.Parse(da.GetValue(0).ToString());
                string roomName1 = da.GetValue(1).ToString();
                DateTime monthYear = DateTime.Parse(da.GetValue(2).ToString());
                int soDien = int.Parse(da.GetValue(3).ToString());
                int soNuoc = int.Parse(da.GetValue(4).ToString());
                int paid = int.Parse(da.GetValue(5).ToString());

                ElectricityWaterBills account = new ElectricityWaterBills(id, roomName1, monthYear, soDien, soNuoc, paid);
                electricityWaterBills.Add(account);
            }
            conn.Close();

            return electricityWaterBills;
        }

        // Get by month year??

        public static bool Insert(ElectricityWaterBills ewb)
        {
            string sql = "insert into ElectricityWaterBills (roomName, monthYear, soDien, soNuoc, paid) values (@roomName, @monthYear, @soDien, @soNuoc, @paid)";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@roomName", ewb.RoomName);
            cmd.Parameters.AddWithValue("@monthYear", ewb.MonthYear);
            cmd.Parameters.AddWithValue("@soDien", ewb.SoDien);
            cmd.Parameters.AddWithValue("@soNuoc", ewb.SoNuoc);
            cmd.Parameters.AddWithValue("@paid", ewb.Paid);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(ElectricityWaterBills ewb)
        {
            string sql = "update ElectricityWaterBills set soDien = @soDien, soNuoc = @soNuoc, paid = @paid where id = @id";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@id", ewb.Id);
            cmd.Parameters.AddWithValue("@soDien", ewb.SoDien);
            cmd.Parameters.AddWithValue("@soNuoc", ewb.SoNuoc);
            cmd.Parameters.AddWithValue("@paid", ewb.Paid);
            return DAO.UpdateTable(cmd);
        }

        public static bool Delete(ElectricityWaterBills ewb)
        {
            string sql = "delete ElectricityWaterBills where id = @id";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@id", ewb.Id);
            return DAO.UpdateTable(cmd);
        }

    }
}

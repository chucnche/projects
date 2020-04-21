using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class RequestDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Request";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableByRequestID(int requestID)
        {
            string cmd = "select * from Request where requestID = " + requestID;
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableByStuID(string stuID)
        {
            string cmd = "select * from Request where stuID = '" + stuID + "'";
            return DAO.GetDataTable(cmd);
        }
        public static List<Request> getRequests()
        {
            List<Request> list = new List<Request>();
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("select * from Request");
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID = da.GetValue(0).ToString();
                string dateRequest =da.GetValue(1).ToString();
                string requestContent = da.GetValue(2).ToString();
                string maID = da.GetValue(3).ToString();
                string dateReply =da.GetValue(4).ToString();
                string reply = da.GetValue(5).ToString();
                int requestID = int.Parse(da.GetValue(6).ToString());
                Request hp = new Request(stuID, dateRequest, requestContent, maID, dateReply, reply, requestID);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }
        public static List<Request> getRequestByStuID(string stuID)
        {
            List<Request> list = new List<Request>();
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select * from Request where stuID = '" + stuID + "'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                string dateRequest = da.GetValue(1).ToString();
                string requestContent = da.GetValue(2).ToString();
                string maID = da.GetValue(3).ToString();
                string dateReply = da.GetValue(4).ToString();
                string reply = da.GetValue(5).ToString();
                int requestID = int.Parse(da.GetValue(6).ToString());
                Request hp = new Request(stuID1, dateRequest, requestContent, maID, dateReply, reply, requestID);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }
        public static Request getRequestByRequestID(int requestID)
        {
            List<Request> list = new List<Request>();
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select * from Request where requestID = " + requestID;
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                string dateRequest = da.GetValue(1).ToString();
                string requestContent = da.GetValue(2).ToString();
                string maID = da.GetValue(3).ToString();
                string dateReply = da.GetValue(4).ToString();
                string reply = da.GetValue(5).ToString();
                int requestID1 = int.Parse(da.GetValue(6).ToString());
                Request hp = new Request(stuID1, dateRequest, requestContent, maID, dateReply, reply, requestID1);
                return hp;
            }
            conn.Close();
            return null;
        }
        public static bool Insert(Request b)
        {
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("insert into Request(stuID,dateRequest, requestContent) values(@stuID,@dateRequest, @requestContent)");
            cmd.Connection = conn;
            cmd.Parameters.AddWithValue("@stuID", b.StuID);
            cmd.Parameters.AddWithValue("@dateRequest", b.DateRequest);
            cmd.Parameters.AddWithValue("@requestContent", b.RequestContent);
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            return true;
        }
        public static bool Update(Request b)
        {
            SqlCommand cmd = new SqlCommand("update Request set maID=@maID,dateReply=@dateReply,reply=@reply where requestID=@requestID");
            cmd.Parameters.AddWithValue("@maID", b.MaID);
            cmd.Parameters.AddWithValue("@dateReply", b.DateReply);
            cmd.Parameters.AddWithValue("@reply", b.Reply);
            cmd.Parameters.AddWithValue("@requestID", b.RequestID);
            return DAO.UpdateTable(cmd);
        }
        public static Boolean Delete(int requestID)
        {

            SqlCommand cmd = new SqlCommand("delete Request where requestID=@requestID");
            cmd.Parameters.AddWithValue("@requestID", requestID);
            return DAO.UpdateTable(cmd);

        }
    }
}

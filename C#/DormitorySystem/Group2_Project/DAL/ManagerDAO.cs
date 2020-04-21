using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class ManagerDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Manager";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableByUsername(string username)
        {
            string cmd = "select * from Manager where username = '" + username + "'";
            return DAO.GetDataTable(cmd);
        }
        public static List<Manager> getManagers()
        {
            List<Manager> list = new List<Manager>();
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("select * from Manager");
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string maID = da.GetValue(0).ToString();
                string username = da.GetValue(1).ToString();
                DateTime dob = DateTime.Parse(da.GetValue(2).ToString());
                int gender = int.Parse(da.GetValue(3).ToString());
                string mail = da.GetValue(4).ToString();
                string phoneNumber = da.GetValue(5).ToString();
                string name = da.GetValue(6).ToString();
                Manager hp = new Manager(maID, username, dob, gender, mail, phoneNumber, name);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }
        public static Manager getManagerByUsername(string username)
        {
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select * from Manager where username = '" + username + "'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string maID = da.GetValue(0).ToString();
                string username1 = da.GetValue(1).ToString();
                DateTime dob = DateTime.Parse(da.GetValue(2).ToString());
                int gender = int.Parse(da.GetValue(3).ToString());
                string mail = da.GetValue(4).ToString();
                string phoneNumber = da.GetValue(5).ToString();
                string name = da.GetValue(6).ToString();
                Manager hp = new Manager(maID, username1, dob, gender, mail, phoneNumber, name);
                return hp;
            }
            conn.Close();
            return null;
        }
        public static Manager getManagerByMaID(string maID)
        {
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select * from Manager where maID = '" + maID + "'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string maID1 = da.GetValue(0).ToString();
                string username1 = da.GetValue(1).ToString();
                DateTime dob = DateTime.Parse(da.GetValue(2).ToString());
                int gender = int.Parse(da.GetValue(3).ToString());
                string mail = da.GetValue(4).ToString();
                string phoneNumber = da.GetValue(5).ToString();
                string name = da.GetValue(6).ToString();
                Manager hp = new Manager(maID1, username1, dob, gender, mail, phoneNumber, name);
                return hp;
            }
            conn.Close();
            return null;
        }
        public static bool Insert(Manager b)
        {
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("insert into Manager(maID,username, dob,gender,mail,phoneNumber,name) values(@maID,@username, @dob,@gender,@mail,@phoneNumber,@name)");
            cmd.Connection = conn;
            cmd.Parameters.AddWithValue("@maID", b.MaID);
            cmd.Parameters.AddWithValue("@username", b.Username);
            cmd.Parameters.AddWithValue("@dob", b.Dob);
            cmd.Parameters.AddWithValue("@gender", b.Gender);
            cmd.Parameters.AddWithValue("@mail", b.Mail);
            cmd.Parameters.AddWithValue("@phoneNumber", b.PhoneNumber);
            cmd.Parameters.AddWithValue("@name", b.Name);
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            return true;
        }
        public static bool Update(Manager b)
        {
            SqlCommand cmd = new SqlCommand("update Manager set dob=@dob,gender=@gender,mail=@mail,phoneNumber=@phoneNumber,name=@name where maID=@maID");
            cmd.Parameters.AddWithValue("@dob", b.Dob);
            cmd.Parameters.AddWithValue("@gender", b.Gender);
            cmd.Parameters.AddWithValue("@mail", b.Mail);
            cmd.Parameters.AddWithValue("@phoneNumber", b.PhoneNumber);
            cmd.Parameters.AddWithValue("@name", b.Name);
            cmd.Parameters.AddWithValue("@maID", b.MaID);
            return DAO.UpdateTable(cmd);
        }
        public static Boolean Delete(string maID)
        {

            SqlCommand cmd = new SqlCommand("delete Manager where maID=@maID");
            cmd.Parameters.AddWithValue("@maID", maID);
            return DAO.UpdateTable(cmd);

        }
    }
}

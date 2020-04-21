using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class AdminDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Admin";
            return DAO.GetDataTable(cmd);
        }

        public static DataTable GetDataTableByUsername(string username)
        {
            string cmd = "select * from Account where username = '" + username + "'";
            return DAO.GetDataTable(cmd);
        }

        public static List<Admin> GetAccounts()
        {
            List<Admin> admins = new List<Admin>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from Admin";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int id = int.Parse(da.GetValue(0).ToString());
                string username = da.GetValue(1).ToString();

                Admin admin = new Admin(id, username);
                admins.Add(admin);
            }
            conn.Close();
            return admins;
        }

        public static Admin GetAccountByUsername(string username)
        {
            Admin admin;
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from Admin where username = '" + username + "'";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int id = int.Parse(da.GetValue(0).ToString());
                string username1 = da.GetValue(1).ToString();

                admin = new Admin(id, username1);
                return admin;
            }
            conn.Close();
            return null;
        }


        // Unused
        public static bool Insert(Account a)
        {
            string sql = "insert into Account (username, [password], [type]) values(@username, @password, @type)";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@username", a.Username);
            cmd.Parameters.AddWithValue("@password", a.Password);
            cmd.Parameters.AddWithValue("@type", a.Type);
            return DAO.UpdateTable(cmd);
        }

        public static bool Update(Account a) // Co update quyen cua user ko?
        {
            string sql = "update Account set [password] = @password where username = @username and type = @type";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@password", a.Password);
            cmd.Parameters.AddWithValue("@username", a.Username);
            cmd.Parameters.AddWithValue("@type", a.Type);
            return DAO.UpdateTable(cmd);
        }

        public static bool Delete(Account a)
        {
            string sql = "delete Account where username = @username and type = @type";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Parameters.AddWithValue("@username", a.Username);
            cmd.Parameters.AddWithValue("@type", a.Type);
            return DAO.UpdateTable(cmd);
        }
    }
}

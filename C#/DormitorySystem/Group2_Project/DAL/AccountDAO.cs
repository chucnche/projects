using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class AccountDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Account";
            return DAO.GetDataTable(cmd);
        }

        public static DataTable GetDataTableByUsername(string username)
        {
            string cmd = "select * from Account where username = '" + username + "'";
            return DAO.GetDataTable(cmd);
        }

        public static List<Account> GetAccounts()
        {
            List<Account> accounts = new List<Account>();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from Account";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string username = da.GetValue(0).ToString();
                string password = da.GetValue(1).ToString();
                int type = int.Parse(da.GetValue(2).ToString());

                Account account = new Account(username, password, type);
                accounts.Add(account);
            }
            conn.Close();
            return accounts;
        }

        public static Account GetAccountByUsername(string username)
        {
            Account account = new Account();
            SqlConnection conn = DAO.getConnections();
            string sql = "select * from Account where username = '" + username + "'";
            SqlCommand cmd = new SqlCommand(sql);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string username1 = da.GetValue(0).ToString();
                string password = da.GetValue(1).ToString();
                int type = int.Parse(da.GetValue(2).ToString());

                account = new Account(username1, password, type);
                return account;
            }
            conn.Close();
            return null;
        }

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

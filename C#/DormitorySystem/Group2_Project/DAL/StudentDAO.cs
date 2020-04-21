using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class StudentDAO
    {
        public static DataTable GetDataTable()
        {
            string cmd = "select * from Student";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableByUsername(string username)
        {
            string cmd = "select * from Student where username = '" + username + "'";
            return DAO.GetDataTable(cmd);
        }
        public static List<Student> getStudents()
        {
            List<Student> list = new List<Student>();
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("select * from Student");
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID = da.GetValue(0).ToString();
                string username = da.GetValue(1).ToString();
                string name = da.GetValue(2).ToString();
                DateTime dob = DateTime.Parse(da.GetValue(3).ToString());
                int gender = int.Parse(da.GetValue(4).ToString());
                string roomName = da.GetValue(5).ToString();
                int bedNo = int.Parse(da.GetValue(6).ToString());
                DateTime bookingDate = DateTime.Parse(da.GetValue(7).ToString());
                int moneyAccount = int.Parse(da.GetValue(8).ToString());
                int debt = int.Parse(da.GetValue(9).ToString());
                Student hp = new Student(stuID, username, name, dob, gender, roomName, bedNo, bookingDate, moneyAccount, debt);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }
        public static Student getStudentByUsername(string username)
        {
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select * from Student where username = '" + username + "'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID = da.GetValue(0).ToString();
                string username1 = da.GetValue(1).ToString();
                string name = da.GetValue(2).ToString();
                DateTime dob = DateTime.Parse(da.GetValue(3).ToString());
                int gender = int.Parse(da.GetValue(4).ToString());
                string roomName = da.GetValue(5).ToString();
                int bedNo = int.Parse(da.GetValue(6).ToString());
                DateTime bookingDate = DateTime.Parse(da.GetValue(7).ToString());
                int moneyAccount = int.Parse(da.GetValue(8).ToString());
                int debt = int.Parse(da.GetValue(9).ToString());
                Student hp = new Student(stuID, username1, name, dob, gender, roomName, bedNo, bookingDate, moneyAccount, debt);
                return hp;
            }
            conn.Close();
            return null;
        }
        public static Student getStudentByStuID(string stuID)
        {
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select * from Student where stuID = '" + stuID + "'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string stuID1 = da.GetValue(0).ToString();
                string username1 = da.GetValue(1).ToString();
                string name = da.GetValue(2).ToString();
                DateTime dob = DateTime.Parse(da.GetValue(3).ToString());
                int gender = int.Parse(da.GetValue(4).ToString());
                string roomName = da.GetValue(5).ToString();
                int bedNo = int.Parse(da.GetValue(6).ToString());
                DateTime bookingDate = DateTime.Parse(da.GetValue(7).ToString());
                int moneyAccount = int.Parse(da.GetValue(8).ToString());
                int debt = int.Parse(da.GetValue(9).ToString());
                Student hp = new Student(stuID1, username1, name, dob, gender, roomName, bedNo, bookingDate, moneyAccount, debt);
                return hp;
            }
            conn.Close();
            return null;
        }
        public static bool Insert(Student b)
        {
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("insert into Student(stuID,username,name, dob,gender,roomName,bedNo,bookingDate,moneyAccount,debt) values(@stuID,@username,@name, @dob,@gender,@roomName,@bedNo,@bookingDate,@moneyAccount,@debt)");
            cmd.Connection = conn;
            cmd.Parameters.AddWithValue("@stuID", b.StuID);
            cmd.Parameters.AddWithValue("@username", b.Username);
            cmd.Parameters.AddWithValue("@name", b.Name);
            cmd.Parameters.AddWithValue("@dob", b.Dob);
            cmd.Parameters.AddWithValue("@gender", b.Gender);
            cmd.Parameters.AddWithValue("@roomName", b.RoomName);
            cmd.Parameters.AddWithValue("@bedNo", b.BedNo);
            cmd.Parameters.AddWithValue("@bookingDate", b.BookingDate);
            cmd.Parameters.AddWithValue("@moneyAccount", b.MoneyAccount);
            cmd.Parameters.AddWithValue("@debt", b.Debt);
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            return true;
        }
        public static bool Update(Student b)
        {
            SqlCommand cmd = new SqlCommand("update Student set name=@name, dob=@dob,gender=@gender,roomName=@roomName,bedNo=@bedNo,bookingDate=@bookingDate,moneyAccount=@moneyAccount,debt=@debt where stuID=@stuID");
            cmd.Parameters.AddWithValue("@name", b.Name);
            cmd.Parameters.AddWithValue("@dob", b.Dob);
            cmd.Parameters.AddWithValue("@gender", b.Gender);
            cmd.Parameters.AddWithValue("@roomName", b.RoomName);
            cmd.Parameters.AddWithValue("@bedNo", b.BedNo);
            cmd.Parameters.AddWithValue("@bookingDate", b.BookingDate);
            cmd.Parameters.AddWithValue("@moneyAccount", b.MoneyAccount);
            cmd.Parameters.AddWithValue("@debt", b.Debt);
            cmd.Parameters.AddWithValue("@stuID", b.StuID);
            return DAO.UpdateTable(cmd);
        }
        public static Boolean Delete(string stuID)
        {

            SqlCommand cmd = new SqlCommand("delete Student where stuID=@stuID");
            cmd.Parameters.AddWithValue("@stuID", stuID);
            return DAO.UpdateTable(cmd);

        }
    }
}

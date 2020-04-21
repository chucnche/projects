using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Data.SqlClient;
using System.Linq;
using System.Text;

namespace Group2_Project.DAL
{
    class RoomDAO
    {
        public static DataTable GetDataTableRoom()
        {
            string cmd = "select * from Room";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableRoomBeds()
        {
            string cmd = "select Room.roomName,Room.gender,Bed.bedNo,Bed.status from Room,Bed where Room.roomName=Bed.roomName";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableByRoomName(string room)
        {
            string cmd = "select Room.roomName,Room.gender,Bed.bedNo,Bed.status from Room,Bed where Room.roomName=Bed.roomName AND  Room.roomName = '" + room + "'";
            return DAO.GetDataTable(cmd); 
        }
        public static List<Room> getRoomBeds()
        {
            List<Room> list = new List<Room>();
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("select Room.roomName,Room.gender,Bed.bedNo,Bed.status from Room,Bed where Room.roomName=Bed.roomName");
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string roomName = da.GetValue(0).ToString();
                int gender = int.Parse(da.GetValue(1).ToString());
                int bedNo = int.Parse(da.GetValue(2).ToString());
                int status = int.Parse(da.GetValue(3).ToString());
                Room hp = new Room(roomName, gender, bedNo, status);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }
        public static List<Room> getRoomBedByRoomName(string room)
        {
            List<Room> list = new List<Room>();
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select Room.roomName,Room.gender,Bed.bedNo,Bed.status from Room,Bed where Room.roomName=Bed.roomName AND  Room.roomName = '" + room + "'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string roomName = da.GetValue(0).ToString();
                int gender = int.Parse(da.GetValue(1).ToString());
                int bedNo = int.Parse(da.GetValue(2).ToString());
                int status = int.Parse(da.GetValue(3).ToString());
                Room hp = new Room(roomName, gender, bedNo, status);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }


        public static bool Insert(Room b)
        {
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("insert into Room(roomName,gender,price) values(@roomName,@gender,@price);insert into Bed(roomName,bedNo,status) values(@roomName1,@bedNo,@status)");
            cmd.Connection = conn;
            cmd.Parameters.AddWithValue("@roomName", b.RoomName);
            cmd.Parameters.AddWithValue("@gender", b.Gender);
            cmd.Parameters.AddWithValue("@price", b.Price);
            cmd.Parameters.AddWithValue("@roomName1", b.RoomName);
            cmd.Parameters.AddWithValue("@bedNo", b.BedNo);
            cmd.Parameters.AddWithValue("@status", b.BedStatus);
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            return true;
        }

        public static bool InsertBed(Room b) // Minh them
        {
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("insert into Bed(roomName,bedNo,status) values(@roomName,@bedNo,@status)");
            cmd.Connection = conn;
            cmd.Parameters.AddWithValue("@roomName", b.RoomName);
            cmd.Parameters.AddWithValue("@bedNo", b.BedNo);
            cmd.Parameters.AddWithValue("@status", b.BedStatus);
            conn.Open();
            cmd.ExecuteNonQuery();
            conn.Close();
            return true;
        }

        public static bool Update(Room b)
        {
            SqlCommand cmd = new SqlCommand("update Room set gender=@gender,price=@price where roomName=@roomName;update Bed set status=@status where roomName=@roomName1 AND bedNo=@bedNo;");
            cmd.Parameters.AddWithValue("@roomName", b.RoomName);
            cmd.Parameters.AddWithValue("@gender", b.Gender);
            cmd.Parameters.AddWithValue("@price", b.Price);
            cmd.Parameters.AddWithValue("@roomName1", b.RoomName);
            cmd.Parameters.AddWithValue("@bedNo", b.BedNo);
            cmd.Parameters.AddWithValue("@status", b.BedStatus);
            return DAO.UpdateTable(cmd);
        }
        public static Boolean DeleteBedNo(string roomName,int bedNo)
        {
            SqlCommand cmd = new SqlCommand("delete Bed where bedNo=@bedNo AND roomName=@roomName");
            cmd.Parameters.AddWithValue("@bedNo", bedNo);
            cmd.Parameters.AddWithValue("@roomName", roomName);
            return DAO.UpdateTable(cmd);

        }
        public static Boolean DeleteRoom(string roomName)
        {
            SqlCommand cmd = new SqlCommand("delete Room where roomName=@roomName");
            cmd.Parameters.AddWithValue("@roomName", roomName);
            return DAO.UpdateTable(cmd);

        }


        //them
        public static Room getRoomBedByRoomNameBedNo(string room,int bed)
        {
            List<Room> list = new List<Room>();
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select Room.roomName,Room.gender,Bed.bedNo,Bed.status from Room,Bed where Room.roomName=Bed.roomName AND  Room.roomName = '" + room + "' AND Bed.bedNo = " + bed  ;
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string roomName = da.GetValue(0).ToString();
                int gender = int.Parse(da.GetValue(1).ToString());
                int bedNo = int.Parse(da.GetValue(2).ToString());
                int status = int.Parse(da.GetValue(3).ToString());
                Room hp = new Room(roomName, gender, bedNo, status);
                return hp;
            }
            conn.Close();
            return null;
        }
        public static Room getRoomBedByRoomNameBedNoPrice(string room, int bed)
        {
            List<Room> list = new List<Room>();
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "select Room.roomName,Room.gender,Room.price,Bed.bedNo,Bed.status from Room,Bed where Room.roomName=Bed.roomName AND  Room.roomName = '" + room + "' AND Bed.bedNo = " + bed;
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string roomName = da.GetValue(0).ToString();
                int gender = int.Parse(da.GetValue(1).ToString());
                int price = int.Parse(da.GetValue(2).ToString());
                int bedNo = int.Parse(da.GetValue(3).ToString());
                int status = int.Parse(da.GetValue(4).ToString());
                Room hp = new Room(roomName, gender, bedNo, status,price);
                return hp;
            }
            conn.Close();
            return null;
        }
        public static int getRoomPrice(string room)
        {
            List<Room> list = new List<Room>();
            SqlConnection conn = DAO.getConnections();
            string cmd1 = "SELECT price FROM Room where roomName = '"+room +"'";
            SqlCommand cmd = new SqlCommand(cmd1);
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                int price = int.Parse(da.GetValue(0).ToString());
                return price;
            }
            conn.Close();
            return 0;
        }
        //them nha
        public static DataTable GetDataTableRoomGroupBy()
        {
            string cmd = "select roomName from Room group by roomName";
            return DAO.GetDataTable(cmd);
        }


        public static DataTable GetDataTableRoomGenderGroupBy(int gender)
        {
            string cmd = "select roomName from Room where gender=" + gender;
            return DAO.GetDataTable(cmd);
        }


        public static DataTable GetDataTableBedNoStatus(string roomName)
        {
            string cmd = "select bedNo from Bed where status = 0 AND roomName='" + roomName + "'";
            return DAO.GetDataTable(cmd);
        }
        public static DataTable GetDataTableAvailibleBedNoByRoomName(string roomName)  // Minh them
        {
            string cmd = "select bedNo from Bed where roomName = '" + roomName + "' and [status] = 0";
            return DAO.GetDataTable(cmd);
        } // -------------
        public static DataTable GetDataTableBedNoByRoomName(string roomName)  // Minh them
        {
            string cmd = "select bedNo from Bed where roomName = '" + roomName + "'";
            return DAO.GetDataTable(cmd);
        } // -------------
        public static List<Room> GetRoomBedPrices() // Minh them
        {
            List<Room> list = new List<Room>();
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("select Room.roomName,Room.gender,Bed.bedNo,Bed.status, Room.price from Room,Bed where Room.roomName=Bed.roomName");
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string roomName = da.GetValue(0).ToString();
                int gender = int.Parse(da.GetValue(1).ToString());
                int bedNo = int.Parse(da.GetValue(2).ToString());
                int status = int.Parse(da.GetValue(3).ToString());
                int price = int.Parse(da.GetValue(4).ToString());
                Room hp = new Room(roomName, gender, bedNo, status, price);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }

        public static List<Room> GetRoomBedPricesByRoomName(string roomName) // Minh them
        {
            List<Room> list = new List<Room>();
            SqlConnection conn = DAO.getConnections();
            SqlCommand cmd = new SqlCommand("select Room.roomName,Room.gender,Bed.bedNo,Bed.status, Room.price from Room,Bed where Room.roomName=Bed.roomName and Room.roomName = '" + roomName + "'");
            cmd.Connection = conn;
            conn.Open();
            SqlDataReader da = cmd.ExecuteReader();
            while (da.Read())
            {
                string roomName1 = da.GetValue(0).ToString();
                int gender = int.Parse(da.GetValue(1).ToString());
                int bedNo = int.Parse(da.GetValue(2).ToString());
                int status = int.Parse(da.GetValue(3).ToString());
                int price = int.Parse(da.GetValue(4).ToString());
                Room hp = new Room(roomName1, gender, bedNo, status, price);
                list.Add(hp);
            }
            conn.Close();
            return list;
        }

    }
}

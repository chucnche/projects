using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class Student
    {
        private string stuID;
        private string username;
        private string name;
        private DateTime dob;
        private int gender;
        private String roomName;
        private int bedNo;
        private DateTime bookingDate;
        private int moneyAccount;
        private int debt;

        public Student()
        {
        }

        public Student(string stuID, string username, string name, DateTime dob, int gender, string roomName, int bedNo, DateTime bookingDate, int moneyAccount, int debt)
        {
            this.stuID = stuID;
            this.username = username;
            this.name = name;
            this.dob = dob;
            this.gender = gender;
            this.roomName = roomName;
            this.bedNo = bedNo;
            this.bookingDate = bookingDate;
            this.moneyAccount = moneyAccount;
            this.debt = debt;
        }

        public string StuID { get => stuID; set => stuID = value; }
        public string Username { get => username; set => username = value; }
        public string Name { get => name; set => name = value; }
        public DateTime Dob { get => dob; set => dob = value; }
        public int Gender { get => gender; set => gender = value; }
        public string RoomName { get => roomName; set => roomName = value; }
        public int BedNo { get => bedNo; set => bedNo = value; }
        public DateTime BookingDate { get => bookingDate; set => bookingDate = value; }
        public int MoneyAccount { get => moneyAccount; set => moneyAccount = value; }
        public int Debt { get => debt; set => debt = value; }
    }
}

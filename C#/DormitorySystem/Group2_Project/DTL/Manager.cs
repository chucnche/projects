using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class Manager
    {
        private string maID;
        private string username;
        private DateTime dob;
        private int gender;
        private string mail;
        private string phoneNumber;
        private string name;

        public Manager()
        {
        }

        public Manager(string maID, string username, DateTime dob, int gender, string mail, string phoneNumber, string name)
        {
            this.maID = maID;
            this.username = username;
            this.dob = dob;
            this.gender = gender;
            this.mail = mail;
            this.phoneNumber = phoneNumber;
            this.name = name;
        }

        public string MaID { get => maID; set => maID = value; }
        public string Username { get => username; set => username = value; }
        public DateTime Dob { get => dob; set => dob = value; }
        public int Gender { get => gender; set => gender = value; }
        public string Mail { get => mail; set => mail = value; }
        public string PhoneNumber { get => phoneNumber; set => phoneNumber = value; }
        public string Name { get => name; set => name = value; }
    }
}

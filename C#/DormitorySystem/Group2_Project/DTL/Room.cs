using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class Room
    {
        private string roomName;
        private int gender;
        private int bedNo;
        private int bedStatus;
        private int price;
        public Room()
        {
        }

        public Room(string roomName, int gender, int bedNo, int bedStatus)
        {
            this.roomName = roomName;
            this.gender = gender;
            this.bedNo = bedNo;
            this.bedStatus = bedStatus;
        }

        public Room(string roomName, int gender, int bedNo, int bedStatus, int price) : this(roomName, gender, bedNo, bedStatus)
        {
            this.price = price;
        }

        public string RoomName { get => roomName; set => roomName = value; }
        public int Gender { get => gender; set => gender = value; }
        public int BedNo { get => bedNo; set => bedNo = value; }
        public int BedStatus { get => bedStatus; set => bedStatus = value; }
        public int Price { get => price; set => price = value; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class ElectricityWaterBills
    {
        int id;
        string roomName;
        DateTime monthYear;
        int soDien;
        int soNuoc;
        int paid;

        public string RoomName { get => roomName; set => roomName = value; }
        public DateTime MonthYear { get => monthYear; set => monthYear = value; }
        public int SoDien { get => soDien; set => soDien = value; }
        public int SoNuoc { get => soNuoc; set => soNuoc = value; }
        public int Paid { get => paid; set => paid = value; }
        public int Id { get => id; set => id = value; }

        public ElectricityWaterBills(int id, string roomName, DateTime monthYear, int soDien, int soNuoc, int paid)
        {
            this.id = id;
            this.roomName = roomName;
            this.monthYear = monthYear;
            this.soDien = soDien;
            this.soNuoc = soNuoc;
            this.paid = paid;
        }

        public ElectricityWaterBills()
        {
        }
    }
}

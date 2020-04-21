using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class HistoryPayment
    {
        private int id;
        private string stuID;
        private DateTime datePay;
        private string type;
        private int moneyPay;
        private string roomName;

        public HistoryPayment()
        {
        }

        public HistoryPayment(int id, string stuID, DateTime datePay, string type, int moneyPay, string roomName)
        {
            this.id = id;
            this.stuID = stuID;
            this.datePay = datePay;
            this.type = type;
            this.moneyPay = moneyPay;
            this.roomName = roomName;
        }

        public int Id { get => id; set => id = value; }
        public string StuID { get => stuID; set => stuID = value; }
        public DateTime DatePay { get => datePay; set => datePay = value; }
        public string Type { get => type; set => type = value; }
        public int MoneyPay { get => moneyPay; set => moneyPay = value; }
        public string RoomName { get => roomName; set => roomName = value; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class HistoryBook
    {
        private string stuID;
        private DateTime dateBook;
        private string roomName;
        private int bedNo;
        private int bookID;
        private int status;
        private DateTime dateExpiry;

        public HistoryBook()
        {
        }

        public HistoryBook(string stuID, DateTime dateBook, string roomName, int bedNo, int bookID, int status, DateTime dateExpiry)
        {
            this.stuID = stuID;
            this.dateBook = dateBook;
            this.roomName = roomName;
            this.bedNo = bedNo;
            this.bookID = bookID;
            this.status = status;
            this.dateExpiry = dateExpiry;
        }

        public string StuID { get => stuID; set => stuID = value; }
        public DateTime DateBook { get => dateBook; set => dateBook = value; }
        public string RoomName { get => roomName; set => roomName = value; }
        public int BedNo { get => bedNo; set => bedNo = value; }
        public int BookID { get => bookID; set => bookID = value; }
        public int Status { get => status; set => status = value; }
        public DateTime DateExpiry { get => dateExpiry; set => dateExpiry = value; }
    }
}

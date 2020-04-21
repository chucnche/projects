using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class Request
    {
        private string stuID;
        private string dateRequest;
        private string requestContent;
        private string maID;
        private string dateReply;
        private string reply;
        private int requestID;

        public Request()
        {
        }

        public Request(string stuID, string dateRequest, string request, string maID, string dateReply, string reply, int requestID)
        {
            this.stuID = stuID;
            this.dateRequest = dateRequest;
            this.requestContent = request;
            this.maID = maID;
            this.dateReply = dateReply;
            this.reply = reply;
            this.requestID = requestID;
        }

        public string StuID { get => stuID; set => stuID = value; }
        public string DateRequest { get => dateRequest; set => dateRequest = value; }
        public string RequestContent { get => requestContent; set => requestContent = value; }
        public string MaID { get => maID; set => maID = value; }
        public string DateReply { get => dateReply; set => dateReply = value; }
        public string Reply { get => reply; set => reply = value; }
        public int RequestID { get => requestID; set => requestID = value; }
    }
}

using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class AvailibleBookingTime
    {
        int adID;
        DateTime from;
        DateTime to;

        public AvailibleBookingTime(int adID, DateTime from, DateTime to)
        {
            this.adID = adID;
            this.from = from;
            this.to = to;
        }

        public int AdID { get => adID; set => adID = value; }
        public DateTime From { get => from; set => from = value; }
        public DateTime To { get => to; set => to = value; }

        public AvailibleBookingTime()
        {
        }
    }
}

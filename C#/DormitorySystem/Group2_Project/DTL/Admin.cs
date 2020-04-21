using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    public class Admin
    {
        int id;
        string username;

        public int Id { get => id; set => id = value; }
        public string Username { get => username; set => username = value; }

        public Admin(int id, string username)
        {
            this.id = id;
            this.username = username;
        }

        public Admin()
        {
        }
    }
}

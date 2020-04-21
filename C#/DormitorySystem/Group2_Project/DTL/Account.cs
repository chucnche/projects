using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Group2_Project.DTL
{
    class Account
    {
        string username;
        string password;
        int type;

        public string Username { get => username; set => username = value; }
        public string Password { get => password; set => password = value; }
        public int Type { get => type; set => type = value; }

        public Account(string username, string password, int type)
        {
            this.username = username;
            this.password = password;
            this.type = type;
        }

        public Account()
        {
        }



    }
}

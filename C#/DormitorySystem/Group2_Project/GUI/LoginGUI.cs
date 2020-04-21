using Group2_Project.DAL;
using Group2_Project.DTL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace Group2_Project.GUI
{
    public partial class LoginGUI : Form
    {
        public LoginGUI()
        {
            InitializeComponent();
        }

        private void btnLogin_Click(object sender, EventArgs e)
        {
         
            string user = txtUsername.Text;
            string pass = txtPassword.Text;
            Account a = AccountDAO.GetAccountByUsername(user);
            if (a == null)
            {
                lblNotify.Text = "**username not exist**";

            }
            else
            {
                if (a.Password == pass)
                {
                    if (a.Type == 0)
                    {
                        StudentMainGUI s = new StudentMainGUI(user);
                        s.ShowDialog();
            
                        this.Dispose();
                    }
                    if (a.Type == 1)
                    {
                        ManagerMainGUI m = new ManagerMainGUI(user);
                        m.ShowDialog();

                        this.Dispose();
                    }
                    if (a.Type == 2)
                    {
                        updateStudent();
                        AdminMainGUI ad = new AdminMainGUI(user);
                        ad.ShowDialog();

                        this.Dispose();
                    }
                }
                else
                {
                    lblNotify.Text = "**wrong password**";
                }
            }
        }
        private void updateStudent()
        {
            List<Student> list = StudentDAO.getStudents();
            for (int i = 0; i < list.Count; i++)
            {
                Student s = list[i];
                if (s.BookingDate.AddDays(30)<DateTime.Now && !String.IsNullOrEmpty(s.RoomName) && s.BedNo!=0)
                {
                    Room r = RoomDAO.getRoomBedByRoomNameBedNoPrice(s.RoomName, s.BedNo);
                    r.BedStatus = 0;
                    RoomDAO.Update(r);
                    s.BedNo = 0;
                    StudentDAO.Update(s);
                }
            }
        }
    }
}

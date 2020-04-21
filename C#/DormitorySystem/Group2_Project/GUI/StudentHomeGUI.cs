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
    public partial class StudentHomeGUI : Form
    {
        string username;
        public StudentHomeGUI(string user)
        {
            InitializeComponent();
            username = user;
            Student s = StudentDAO.getStudentByUsername(username);
            txtStuID.Text = s.StuID;
            txtUsername.Text = s.Username;
            txtName.Text = s.Name;
            txtDob.Text = s.Dob.ToString();
            if (s.Gender == 0)
                txtGender.Text = "Female";
            if (s.Gender == 1)
                txtGender.Text = "Male";
            if (s.BedNo != 0) { 
            txtRoomName.Text = s.RoomName;
            txtBedNo.Text = s.BedNo.ToString();
            txtBookingDate.Text = s.BookingDate.ToString();
            }
            txtMoneyAccount.Text = s.MoneyAccount.ToString();
            txtDebt.Text = s.Debt.ToString();
        }
    }
}

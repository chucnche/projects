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
    public partial class StudentBookingDialog : Form
    {
        Student s;
        AvailibleBookingTime a = AvailibleBookingTimeDAO.GetLatestDate();
        public StudentBookingDialog(string user)
        {
            InitializeComponent();
            s = StudentDAO.getStudentByUsername(user);
            txtStuID.Text = s.StuID;
            txtDateExpiry.Text = a.To.AddDays(30).ToString("dd/MM/yyyy");
            DataTable dt = RoomDAO.GetDataTableRoomGenderGroupBy(s.Gender);
            comboBoxRoom.DataSource = dt;
            comboBoxRoom.ValueMember = "roomName";
            comboBoxRoom.DisplayMember = "roomName";
            comboBoxRoom.SelectedIndex = 0;
            txtPrice.Text = RoomDAO.getRoomPrice(comboBoxRoom.SelectedValue.ToString()).ToString();

            DataTable dt1 = RoomDAO.GetDataTableBedNoStatus(comboBoxRoom.SelectedValue.ToString());
            comboBoxBedNo.DataSource = dt1;
            comboBoxBedNo.ValueMember = "bedNo";
            comboBoxBedNo.DisplayMember = "bedNo";
        }

        private void button1_Click(object sender, EventArgs e)
        {
            string room = comboBoxRoom.SelectedValue.ToString();
            int bedNo = int.Parse(comboBoxBedNo.SelectedValue.ToString());
            if (RoomDAO.getRoomPrice(room) > s.MoneyAccount)
            {
                MessageBox.Show("MoneyAccount is not enough to book room");
            }
            else
            {
                HistoryBook h = new HistoryBook(s.StuID, DateTime.Now, room, bedNo, 1, 1, a.To.AddDays(30));
                HistoryBookDAO.Insert(h);
                this.Dispose();
                StudentMainGUI stu = new StudentMainGUI(s.Username);
                stu.ShowDialog();
            }
        }

        private void comboBoxRoom_SelectedIndexChanged(object sender, EventArgs e)
        {
            txtPrice.Text = RoomDAO.getRoomPrice(comboBoxRoom.SelectedValue.ToString()).ToString();
            DataTable dt1 = RoomDAO.GetDataTableBedNoStatus(comboBoxRoom.SelectedValue.ToString());
            comboBoxBedNo.DataSource = dt1;
            comboBoxBedNo.ValueMember = "bedNo";
            comboBoxBedNo.DisplayMember = "bedNo";
        }
    }
}

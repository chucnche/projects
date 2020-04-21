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
    public partial class StudentViewRoomInforGUI : Form
    {
        public StudentViewRoomInforGUI(string user)
        {
            InitializeComponent();
            DataTable dt = RoomDAO.GetDataTableRoomGroupBy();
            comboBox1.DataSource = dt;
            comboBox1.ValueMember = "roomName";
            comboBox1.DisplayMember = "roomName";
            
            comboBox1.SelectedIndex = 0;
          
            List<Room> list = RoomDAO.getRoomBedByRoomName("P101");
            dataGridView1.DataSource = list;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            List<Room> list = RoomDAO.getRoomBedByRoomName(comboBox1.SelectedValue.ToString());
            dataGridView1.DataSource = list;
        }
    }
}

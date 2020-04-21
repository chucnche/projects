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
    public partial class StudentElectricityWaterBillGUI : Form
    {
        public StudentElectricityWaterBillGUI(string user)
        {
            InitializeComponent();
            Student s = StudentDAO.getStudentByUsername(user);
            DataTable dt = ElectricityWaterBillsDAO.GetDataTableByRoom(s.RoomName);
            dataGridView1.DataSource = dt;

        }
    }
}

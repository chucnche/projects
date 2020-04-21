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
    public partial class StudentPaymentHistoryGUI : Form
    {
        public StudentPaymentHistoryGUI(String user)
        {
            InitializeComponent();
            Student s = StudentDAO.getStudentByUsername(user);
            DataTable dt = HistoryPaymentDAO.GetDataTableByStuId(s.StuID);
            dataGridView1.DataSource = dt;
        }
    }
}

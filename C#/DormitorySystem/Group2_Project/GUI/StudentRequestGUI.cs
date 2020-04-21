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
    public partial class StudentRequestGUI : Form
    {
        Student s;
        public StudentRequestGUI(string user)
        {
            InitializeComponent();
            s = StudentDAO.getStudentByUsername(user);
            DataTable dt = RequestDAO.GetDataTableByStuID(s.StuID);
            DataView dv = new DataView(dt);
            string filter = "maID is not null";
            dv.RowFilter = filter;
            dataGridView1.DataSource = dv;
            List<string> l = new List<string>();
            l.Add("responded");
            l.Add("No Response yet");
            comboBox1.DataSource = l;
            comboBox1.SelectedIndex = 0;
            btnSave.Enabled = false;
            txtRequestContent.Enabled = false;
            btnCancel.Enabled = false;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dt = RequestDAO.GetDataTableByStuID(s.StuID);
            DataView dv = new DataView(dt);
            string filter = "";
            if (comboBox1.SelectedIndex == 0)
            {
                filter = "maID is not null";
            }
            if (comboBox1.SelectedIndex == 1)
            {
                filter = "maID is null";
            }
            dv.RowFilter = filter;
            dataGridView1.DataSource = dv;
        }

        private void btnRequest_Click(object sender, EventArgs e)
        {
            btnSave.Enabled = true;
            txtRequestContent.Enabled = true;
            btnCancel.Enabled = true;
            btnRequest.Enabled = false;
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            btnSave.Enabled = false;
            txtRequestContent.Enabled = false;
            btnCancel.Enabled = false;
            btnRequest.Enabled = true;
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (!string.IsNullOrEmpty(txtRequestContent.Text))
            {
                string content = txtRequestContent.Text;
                Request hp = new Request(s.StuID, DateTime.Now.ToString(), content, "", "", "", 1);
                RequestDAO.Insert(hp);
                MessageBox.Show("Request Success");
                DataTable dt = RequestDAO.GetDataTableByStuID(s.StuID);
                DataView dv = new DataView(dt);
                string filter = "";
                if (comboBox1.SelectedIndex == 0)
                {
                    filter = "maID is not null";
                }
                if (comboBox1.SelectedIndex == 1)
                {
                    filter = "maID is null";
                }
                dv.RowFilter = filter;
                dataGridView1.DataSource = dv;
                btnSave.Enabled = false;
                txtRequestContent.Enabled = false;
                txtRequestContent.Text = "";
                btnCancel.Enabled = false;
                btnRequest.Enabled = true;
            }
            else
            {
                MessageBox.Show("TextFiled is not empty");
            }
        }
    }
}

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
    public partial class ManagerStudentRequestGUI : Form
    {
        Manager m;
        public ManagerStudentRequestGUI(string user)
        {
            InitializeComponent();
            m = ManagerDAO.getManagerByUsername(user);
            DataTable dt = RequestDAO.GetDataTable();
            DataView dv = new DataView(dt);
            string filter = "maID is null";
            dv.RowFilter = filter;
            dataGridView1.DataSource = dv;
            List<string> l = new List<string>();
            l.Add("No Response yet");
            l.Add("responded");
            comboBox1.DataSource = l;
            comboBox1.SelectedIndex = 0;
            btnSave.Enabled = false;
            txtReplyContent.Enabled = false;
            btnCancel.Enabled = false;
        }

        private void comboBox1_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dt = RequestDAO.GetDataTable();
            DataView dv = new DataView(dt);
            string filter = "";
            if (comboBox1.SelectedIndex == 1)
            {
                filter = "maID is not null";
            }
            if (comboBox1.SelectedIndex == 0)
            {
                filter = "maID is null";
            }
            dv.RowFilter = filter;
            dataGridView1.DataSource = dv;
        }

        private void btnReply_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("please select one row");
            }
            else
            {
                btnSave.Enabled = true;
                txtReplyContent.Enabled = true;
                btnCancel.Enabled = true;
                btnReply.Enabled = false;
            }
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            int id = int.Parse(dataGridView1.SelectedRows[0].Cells["requestID"].Value.ToString());
            Request re = RequestDAO.getRequestByRequestID(id);
            re.MaID = m.MaID;
            re.DateReply = DateTime.Now.ToString();
            re.Reply= txtReplyContent.Text;
            RequestDAO.Update(re);
            MessageBox.Show("Reply Success");
            DataTable dt = RequestDAO.GetDataTable();
            DataView dv = new DataView(dt);
            string filter = "";
            if (comboBox1.SelectedIndex == 1)
            {
                filter = "maID is not null";
            }
            if (comboBox1.SelectedIndex == 0)
            {
                filter = "maID is null";
            }
            dv.RowFilter = filter;
            dataGridView1.DataSource = dv;
            btnSave.Enabled = false;
            txtReplyContent.Enabled = false;
            txtReplyContent.Text = "";
            btnCancel.Enabled = false;
            btnReply.Enabled = true;
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            btnSave.Enabled = false;
            txtReplyContent.Enabled = false;
            btnCancel.Enabled = false;
            btnReply.Enabled = true;
        }
    }
}

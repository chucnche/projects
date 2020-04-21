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
    public partial class StudentMainGUI : Form
    {
        string username;
        public StudentMainGUI(string user)
        {
            InitializeComponent();
            username = user;
        }
        private void embed(Panel panel, Form f)
        {
            panel.Controls.Clear();
            f.FormBorderStyle = FormBorderStyle.None;
            f.TopLevel = false;
            f.Show();

            panel.Controls.Add(f);

        }

        private void memberToolStripMenuItem_Click(object sender, EventArgs e)
        {

        }

        private void homeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StudentHomeGUI f = new StudentHomeGUI(username);
       
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void ElectricityWaterBillToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StudentElectricityWaterBillGUI f = new StudentElectricityWaterBillGUI(username);

            embed(toolStripContainer1.ContentPanel, f);
        }

        private void PaymentHistoryToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StudentPaymentHistoryGUI f = new StudentPaymentHistoryGUI(username);

            embed(toolStripContainer1.ContentPanel, f);
        }

        private void ViewRoomInforToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StudentViewRoomInforGUI f = new StudentViewRoomInforGUI(username);
            embed(toolStripContainer1.ContentPanel, f);

        }

        private void requestToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StudentRequestGUI f = new StudentRequestGUI(username);
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LoginGUI l = new LoginGUI();
            this.Dispose();
            l.ShowDialog();
        }

        private void bookBedToolStripMenuItem_Click(object sender, EventArgs e)
        {
            StudentBookBedGUI f = new StudentBookBedGUI(username);
            embed(toolStripContainer1.ContentPanel, f);
        }
    }
}

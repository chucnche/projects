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
    public partial class ManagerMainGUI : Form
    {
        string username;
        public ManagerMainGUI(string user)
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
        private void bookRequestToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerBookRequestGUI f = new ManagerBookRequestGUI(username);
            embed(toolStripContainer1.ContentPanel, f); 
        }

        private void studentRequestToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerStudentRequestGUI f = new ManagerStudentRequestGUI(username);
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void ElectricityWaterToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerElectricityWaterGUI f = new ManagerElectricityWaterGUI(username);
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void viewRoomInfoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerViewRoomInforGUI f = new ManagerViewRoomInforGUI();
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void studentToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerStudentGUI f = new ManagerStudentGUI();
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void logoutToolStripMenuItem1_Click(object sender, EventArgs e)
        {
            LoginGUI l = new LoginGUI();
            this.Dispose();
            l.ShowDialog();
        }
    }
}

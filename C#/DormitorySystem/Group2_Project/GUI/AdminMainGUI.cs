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
    public partial class AdminMainGUI : Form
    {
        string user;
        public AdminMainGUI(string user)
        {
            this.user = user;
            InitializeComponent();
        }

        private void embed(Panel panel, Form f)
        {
            panel.Controls.Clear();
            f.FormBorderStyle = FormBorderStyle.None;
            f.TopLevel = false;
            f.Show();

            panel.Controls.Add(f);

        }

        private void managerToolStripMenuItem_Click(object sender, EventArgs e)
        {
            AdminManagerGUI f = new AdminManagerGUI();
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void availBookTimeToolStripMenuItem_Click(object sender, EventArgs e)
        {
            Admin a = AdminDAO.GetAccountByUsername(user);
            AdminAvailibleBookingTimeGUI f = new AdminAvailibleBookingTimeGUI(a);
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void studentToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerStudentGUI f = new ManagerStudentGUI();
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void viewRoomInfoToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerViewRoomInforGUI f = new ManagerViewRoomInforGUI();
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void electricityWaterBillToolStripMenuItem_Click(object sender, EventArgs e)
        {
            ManagerElectricityWaterGUI f = new ManagerElectricityWaterGUI(user);
            embed(toolStripContainer1.ContentPanel, f);
        }

        private void logoutToolStripMenuItem_Click(object sender, EventArgs e)
        {
            LoginGUI l = new LoginGUI();
            this.Dispose();
            l.ShowDialog();
        }
    }
}

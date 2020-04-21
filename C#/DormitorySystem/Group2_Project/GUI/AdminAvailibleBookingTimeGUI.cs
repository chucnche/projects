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
    public partial class AdminAvailibleBookingTimeGUI : Form
    {
        Admin a;
        public AdminAvailibleBookingTimeGUI(Admin a)
        {
            this.a = a;
            InitializeComponent();
        }

        public AdminAvailibleBookingTimeGUI()
        {
            InitializeComponent();
        }

        private void AdminAvailibleBookingTimeGUI_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void LoadData()
        {
            AvailibleBookingTime abt = AvailibleBookingTimeDAO.GetLatestDate();
            dateFrom.Value = abt.From;
            dateTo.Value = abt.To;
         }

        private void btnSave_Click(object sender, EventArgs e)
        {
            AvailibleBookingTime abt = new AvailibleBookingTime(a.Id, dateFrom.Value, dateTo.Value);
            AvailibleBookingTimeDAO.Update(abt);
            MessageBox.Show("Successfuly updated!");
        }
    }
}

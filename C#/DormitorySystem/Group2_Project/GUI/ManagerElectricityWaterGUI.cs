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
    public partial class ManagerElectricityWaterGUI : Form
    {
        public ManagerElectricityWaterGUI(string user)
        {
            InitializeComponent();
            DataTable dt = RoomDAO.GetDataTableRoomGroupBy();
            comboBoxRoom.DataSource = dt;
            comboBoxRoom.DisplayMember = "roomName";
            comboBoxRoom.ValueMember = "roomName";

            DataTable dt1 = ElectricityWaterBillsDAO.GetDataTable();
            dataGridView1.DataSource = dt1;
            
        }

        private void button1_Click(object sender, EventArgs e)
        {
            if(string.IsNullOrEmpty(txtElectric.Text) || string.IsNullOrEmpty(txtWater.Text))
            {
                MessageBox.Show("TextField is not empty");
            }
            else
            {
                int el = int.Parse(txtElectric.Text);
                int wt = int.Parse(txtElectric.Text);
                List<Room> list = RoomDAO.getRoomBedByRoomName(comboBoxRoom.SelectedValue.ToString());
                int count = 0;
                for (int i = 0; i < list.Count; i++)
                {
                    if (list[i].BedStatus == 1)
                        count++;
                }
                if (count != 0)
                {
                    int  moneyEL = 0;
                    int moneyWt = 0;
                    if ((el - count * 36) < 0) moneyEL = count * 36 - el;
                    if ((wt - count * 6) < 0)  moneyWt = count * 6 - wt;
                    int total = (moneyEL * 2000 + moneyWt * 5000)/count;
                    List<Student> ls = StudentDAO.getStudents();
                    for (int i = 0; i < ls.Count; i++)
                    {
                        Student stu = ls[i];
                        if(stu.RoomName== comboBoxRoom.SelectedValue.ToString() && stu.BedNo != 0)
                        {
                            stu.Debt = stu.Debt+ total;
                            StudentDAO.Update(stu);
                        }
                    }
                    ElectricityWaterBills eee = new ElectricityWaterBills(1,comboBoxRoom.SelectedValue.ToString(), dateTimePicker1.Value, el, wt, 1);
                    ElectricityWaterBillsDAO.Insert(eee);
                }
                else
                {
                    ElectricityWaterBills eee = new ElectricityWaterBills(1, comboBoxRoom.SelectedValue.ToString(), dateTimePicker1.Value, el, wt,0);
                    ElectricityWaterBillsDAO.Insert(eee);
                }
                DataTable dt1 = ElectricityWaterBillsDAO.GetDataTable();
                dataGridView1.DataSource = dt1;
            }
        }
    }
}

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
    public partial class StudentBookBedGUI : Form
    {
        Student s;
        AvailibleBookingTime a = AvailibleBookingTimeDAO.GetLatestDate();
        public StudentBookBedGUI(string user)
        {
            InitializeComponent();
            s = StudentDAO.getStudentByUsername(user);
            List<HistoryBook> list = HistoryBookDAO.GetHistoryBooksByStuID(s.StuID);

            //DataGridViewTextBoxColumn dgvButton = new DataGridViewTextBoxColumn();
            //dgvButton.HeaderText = "Status";
            //dgvButton.ValueType = typeof(string);
            //dgvButton.Name = "Status";
            //dataGridView1.Columns.Add(dgvButton);
            DataTable dt = HistoryBookDAO.GetDataTableByStuID(s.StuID);
            dataGridView1.DataSource = dt;
            dataGridView1.Columns[0].HeaderText = "Status";
     
            for (int i = 0; i < list.Count; i++)
            {

                if (list[i].Status == 0) dataGridView1.Rows[i].Cells[0].Value = "rejected";
                if (list[i].Status == 1) dataGridView1.Rows[i].Cells[0].Value = "in progess";
                if (list[i].Status == 2) dataGridView1.Rows[i].Cells[0].Value = "accepted";
            }
            txtFrom.Text = a.From.ToString();
            txtTo.Text = a.To.ToString();
            lblMoneyAccount.Text ="Money Account:" + s.MoneyAccount.ToString() +"vnđ";
            check();
        }

        private void btnPay_Click(object sender, EventArgs e)
        {
            if (s.MoneyAccount < s.Debt)
            {
                MessageBox.Show("Not enough money");
            }
            else
            {
                s.MoneyAccount = s.MoneyAccount - s.Debt;
                s.Debt = 0;
                StudentDAO.Update(s);
                MessageBox.Show("Pay success");
                check();
            }
        }

        private void StudentBookBedGUI_Load(object sender, EventArgs e)
        {
        }
        private void check()
        {
            if (HistoryBookDAO.GetHistoryBooksByStuIDStatus(s.StuID)!=null || s.BedNo!=0)
            {
                lblNotify.Text = "You've already request book a room";
                btnPay.Visible = false;
                btnBook.Enabled = false;
            }
            else
            {
                if (s.Debt != 0)
                {
                    lblNotify.Text = "You owe money(" + s.Debt + "nvđ). Please pay";
                    btnPay.Visible = true;
                    btnBook.Enabled = false;
                }
                else
                {
                    if (DateTime.Now < a.From || DateTime.Now > a.To)
                    {
                        lblNotify.Text = "This is not a booking time";
                        btnPay.Visible = false;
                        btnBook.Enabled = false;
                    }
                    else
                    {
                            btnBook.Enabled = true;
                            lblNotify.Text = "";
                            btnPay.Visible = false;
                    }
                }
            }
        }

        private void btnBook_Click(object sender, EventArgs e)
        {
            StudentBookingDialog sDialog = new StudentBookingDialog(s.Username);
            sDialog.ShowDialog();
        }
    }
}

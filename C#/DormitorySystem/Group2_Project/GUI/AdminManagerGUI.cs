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
    public partial class AdminManagerGUI : Form
    {
        string choice;
        public AdminManagerGUI()
        {
            InitializeComponent();
            rbtnMale.Select();
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            ReNewData();
            choice = "ADD";
            AdjustGUI(choice);
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            choice = "EDIT";
            AdjustGUI(choice);
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Sure u wanna delete this manager?", "Confirm!", MessageBoxButtons.YesNo);
            if (result == DialogResult.Yes)
            {
                Manager m = (Manager)dataGridViewManager.CurrentRow.DataBoundItem;
                Account a = AccountDAO.GetAccountByUsername(m.Username);
                ManagerDAO.Delete(m.MaID);
                AccountDAO.Delete(a);
            } else
            {
                return;
            }
            LoadData();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (choice.Equals("ADD"))
            {
                // Check
                if (string.IsNullOrEmpty(txtMaId.Text) 
                    || string.IsNullOrEmpty(txtUsername.Text)
                    || string.IsNullOrEmpty(txtPassword.Text)
                    || string.IsNullOrEmpty(txtFullName.Text)
                    || string.IsNullOrEmpty(txtMail.Text)
                    || string.IsNullOrEmpty(txtPhoneNo.Text))
                {
                    MessageBox.Show("Must fill all information to add!");
                    return;
                }
                if (ManagerDAO.getManagerByMaID(txtMaId.Text) != null)
                {
                    lblError.Text = "ID of manager already existed!";
                    return;
                }
                if (ManagerDAO.getManagerByUsername(txtUsername.Text) != null)
                {
                    lblError.Text = "Username already existed!";
                    return;
                }
                //------------

                // Add acount
                Account a = new Account(txtUsername.Text, txtPassword.Text, 1);
                AccountDAO.Insert(a);
                // -----------

                // Add manager
                int gender = 1;
                if (rbtnFemale.Checked == true)
                {
                    gender = 0;
                }
                Manager m = new Manager(txtMaId.Text, txtUsername.Text, dateDOB.Value, gender, txtMail.Text, txtPhoneNo.Text, txtFullName.Text);
                ManagerDAO.Insert(m);
            }
            if (choice.Equals("EDIT"))
            {
                // Check
                if (string.IsNullOrEmpty(txtFullName.Text)
                    || string.IsNullOrEmpty(txtMail.Text)
                    || string.IsNullOrEmpty(txtPhoneNo.Text))
                {
                    MessageBox.Show("Must fill all information to add!");
                    return;
                }

                int gender = 1;
                if (rbtnFemale.Checked == true)
                {
                    gender = 0;
                }

                if (chkChangePass.Checked == true)
                {
                    if (string.IsNullOrEmpty(txtPassword.Text))
                    {
                        MessageBox.Show("Must fill all information to add!");
                        return;
                    }
                    Account a = new Account(txtUsername.Text, txtPassword.Text, 1);
                    AccountDAO.Update(a);
                }
                Manager m = new Manager(txtMaId.Text, txtUsername.Text, dateDOB.Value, gender, txtMail.Text, txtPhoneNo.Text, txtFullName.Text);
                ManagerDAO.Update(m);
            }

            LoadData();
            choice = "SAVE";
            AdjustGUI(choice);
        }

        private void btnCancel_Click(object sender, EventArgs e)
        {
            choice = "CANCEL";
            AdjustGUI(choice);
            LoadForm();
        }

        private void ReNewData()
        {
            txtMaId.Text = "";
            txtUsername.Text = "";
            txtPassword.Text = "";
            txtFullName.Text = "";
            rbtnMale.Select();
            dateDOB.Value = DateTime.Now;
            txtMail.Text = "";
            txtPhoneNo.Text = "";
        }

        private void AdjustGUI(string choice)
        {
            switch (choice)
            {
                case "ADD":
                    dataGridViewManager.Enabled = false;

                    // btn add edit delete
                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    // Stu info
                    txtMaId.Enabled = true;
                    txtUsername.Enabled = true;
                    txtUsername.ReadOnly = false;
                    txtPassword.Enabled = true;
                    chkChangePass.Enabled = false;
                    txtFullName.Enabled = true;
                    rbtnMale.Enabled = true;
                    rbtnFemale.Enabled = true;
                    dateDOB.Enabled = true;
                    txtMail.Enabled = true;
                    txtPhoneNo.Enabled = true;
                    // ------

                    // btn save cancel
                    btnSave.Enabled = true;
                    btnCancel.Enabled = true;
                    break;
                case "EDIT":
                    dataGridViewManager.Enabled = false;

                    // btn add edit delete
                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    // Stu info
                    txtMaId.Enabled = true;
                    txtMaId.ReadOnly = true;
                    txtUsername.Enabled = true;
                    txtUsername.ReadOnly = true;
                    txtPassword.Enabled = false;
                    chkChangePass.Enabled = true;
                    txtFullName.Enabled = true;
                    rbtnMale.Enabled = true;
                    rbtnFemale.Enabled = true;
                    dateDOB.Enabled = true;
                    txtMail.Enabled = true;
                    txtPhoneNo.Enabled = true;
                    // ------

                    // btn save cancel
                    btnSave.Enabled = true;
                    btnCancel.Enabled = true;
                    break;
                case "SAVE":
                    // btn add edit delete
                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;
                    btnDelete.Enabled = true;

                    // Stu info
                    txtMaId.Enabled = false;
                    txtMaId.ReadOnly = false;
                    txtUsername.Enabled = false;
                    txtUsername.ReadOnly = false;
                    txtPassword.Enabled = false;
                    chkChangePass.Enabled = false;
                    txtFullName.Enabled = false;
                    rbtnMale.Enabled = false;
                    rbtnFemale.Enabled = false;
                    dateDOB.Enabled = false;
                    chkChangePass.Checked = false;
                    txtMail.Enabled = false;
                    txtPhoneNo.Enabled = false;
                    // ------

                    dataGridViewManager.Enabled = true;

                    // btn save cancel
                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;
                case "CANCEL":
                    // btn add edit delete
                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;
                    btnDelete.Enabled = true;

                    // Stu info
                    txtMaId.Enabled = false;
                    txtMaId.ReadOnly = false;
                    txtUsername.Enabled = false;
                    txtUsername.ReadOnly = false;
                    txtPassword.Enabled = false;
                    chkChangePass.Enabled = false;
                    txtFullName.Enabled = false;
                    rbtnMale.Enabled = false;
                    rbtnFemale.Enabled = false;
                    dateDOB.Enabled = false;
                    chkChangePass.Checked = false;
                    txtMail.Enabled = false;
                    txtPhoneNo.Enabled = false;
                    // ------

                    dataGridViewManager.Enabled = true;

                    // btn save cancel
                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;
            }
        }

        private void dataGridViewManager_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            LoadForm();
        }

        private void AdminManagerGUI_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void chkChangePass_CheckedChanged(object sender, EventArgs e)
        {
            if (chkChangePass.Checked == true)
            {
                txtPassword.Enabled = true;
            } else
            {
                txtPassword.Enabled = false;
            }
        }

        private void LoadData()
        {
            List<Manager> managers = ManagerDAO.getManagers();
            dataGridViewManager.DataSource = managers;
            LoadForm();
        }

        private void LoadForm()
        {
            Manager m = (Manager)dataGridViewManager.CurrentRow.DataBoundItem;
            txtMaId.Text = m.MaID;
            txtUsername.Text = m.Username;
            txtPassword.Text = "";
            txtFullName.Text = m.Name;
            if (m.Gender == 1)
            {
                rbtnMale.Select();
            } else
            {
                rbtnFemale.Select();
            }
            dateDOB.Value = m.Dob;
            txtMail.Text = m.Mail;
            txtPhoneNo.Text = m.PhoneNumber;
            lblError.Text = "";
        }

    }
}

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
    public partial class ManagerStudentGUI : Form
    {
        string choice;

        bool isBedEmpty = false;
        public ManagerStudentGUI()
        {
            InitializeComponent();
        }

        private void ManagerStudentGUI_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void LoadData()
        {
            List<Student> students = StudentDAO.getStudents();
            dataGridViewStudent.DataSource = students;

            DataTable room_dt = RoomDAO.GetDataTableRoomGroupBy();
            cbxRoom.DataSource = room_dt;
            cbxRoom.DisplayMember = "roomName";
            cbxRoom.ValueMember = "roomName";

            LoadBed();
            LoadForm();
        }

        private void LoadBed()
        {
            DataTable bed_dt = RoomDAO.GetDataTableBedNoByRoomName(cbxRoom.SelectedValue.ToString());
            cbxBed.DataSource = bed_dt;
            cbxBed.DisplayMember = "bedNo";
            cbxBed.ValueMember = "bedNo";
        }

        private void LoadForm()
        {
            Student s = (Student)dataGridViewStudent.CurrentRow.DataBoundItem;
            txtStuID.Text = s.StuID;
            txtUsername.Text = s.Username;
            txtPassword.Text = "";
            txtFullName.Text = s.Name;
            if (s.Gender == 1)
            {
                rbtnMale.Select();
            }
            else
            {
                rbtnFemale.Select();
            }
            dateDOB.Value = s.Dob;
            dateBookingDate.Value = s.BookingDate;
            cbxRoom.SelectedValue = s.RoomName;
            if (s.BedNo == 0)
            {
                isBedEmpty = true;
            }
            else
            {
                isBedEmpty = false;
            }
            LoadBed();
            cbxBed.SelectedValue = s.BedNo;
            txtBalance.Text = s.MoneyAccount.ToString();
            txtDebt.Text = s.Debt.ToString();
            lblError.Text = "";
        }

        private void dataGridViewStudent_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            LoadForm();
        }

        private void ReNewData()
        {
            txtStuID.Text = "";
            txtUsername.Text = "";
            txtPassword.Text = "";
            txtFullName.Text = "";
            rbtnMale.Select();
            dateDOB.Value = DateTime.Now;
            dateBookingDate.Value = DateTime.Now;
            cbxRoom.SelectedIndex = 0;
            cbxBed.SelectedIndex = 0;
            txtBalance.Text = "";
            txtDebt.Text = "";
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            choice = "ADD";
            ReNewData();
            AdjustGUI(choice);
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            choice = "EDIT";
            AdjustGUI(choice);
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            DialogResult result = MessageBox.Show("Sure u wanna delete this student?", "Confirm!", MessageBoxButtons.YesNo);
            if (result == DialogResult.Yes) 
            {
                Student s = (Student)dataGridViewStudent.CurrentRow.DataBoundItem;
                Account a = AccountDAO.GetAccountByUsername(s.Username);
                Room r = new Room(s.RoomName, s.Gender, s.BedNo, 0, RoomDAO.getRoomPrice(s.RoomName));
                RoomDAO.Update(r);
                StudentDAO.Delete(s.StuID);
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
                if (string.IsNullOrEmpty(txtStuID.Text)
                    || string.IsNullOrEmpty(txtUsername.Text)
                    || string.IsNullOrEmpty(txtPassword.Text)
                    || string.IsNullOrEmpty(txtFullName.Text)
                    || string.IsNullOrEmpty(txtBalance.Text)
                    || string.IsNullOrEmpty(txtDebt.Text))
                {
                    MessageBox.Show("Must fill all information to add!");
                    return;
                }
                try
                {
                    int.Parse(txtBalance.Text);
                    int.Parse(txtDebt.Text);
                }
                catch (FormatException)
                {
                    MessageBox.Show("Balance or debt must be number!");
                    return;
                }

                if (AccountDAO.GetAccountByUsername(txtUsername.Text) != null)
                {
                    MessageBox.Show("Username already existed");
                    return;
                }
                else if (StudentDAO.getStudentByStuID(txtStuID.Text) != null)
                {
                    MessageBox.Show("Student ID already existed");
                    return;
                }

                // Check gender
                int selectedGender = 1;
                if (rbtnFemale.Checked == true) 
                {
                    selectedGender = 0;
                }
                if (selectedGender != RoomDAO.getRoomBedByRoomNameBedNo(cbxRoom.SelectedValue.ToString(), int.Parse(cbxBed.SelectedValue.ToString())).Gender)
                {
                    lblError.Text = "* * Wrong room gender!";
                    return;
                }
                // -------------

                if (RoomDAO.getRoomBedByRoomNameBedNo(cbxRoom.SelectedValue.ToString(), int.Parse(cbxBed.SelectedValue.ToString())).BedStatus == 1)
                {
                    lblError.Text = "* * Bed occupied by others!";
                    return;
                }

                // Add account
                Account a = new Account(txtUsername.Text, txtPassword.Text, 0);
                AccountDAO.Insert(a);
                // ------------
                // Add student account
                int gender = 1;
                if (rbtnFemale.Checked == true)
                {
                    gender = 0;
                }
                Student s = new Student(txtStuID.Text, txtUsername.Text, txtFullName.Text,
                    dateDOB.Value, gender, cbxRoom.SelectedValue.ToString(),
                    int.Parse(cbxBed.SelectedValue.ToString()), dateBookingDate.Value,
                    int.Parse(txtBalance.Text), int.Parse(txtDebt.Text));
                StudentDAO.Insert(s);

                Room r = new Room(cbxRoom.SelectedValue.ToString(), gender, int.Parse(cbxBed.SelectedValue.ToString()), 1, RoomDAO.getRoomPrice(cbxRoom.SelectedValue.ToString()));
                RoomDAO.Update(r);
            }

            if (choice.Equals("EDIT"))
            {
                // Check condition
                if (string.IsNullOrEmpty(txtBalance.Text) || string.IsNullOrEmpty(txtDebt.Text))
                {
                    MessageBox.Show("Must fill all information to edit!");
                    return;
                }
                if (chkChangePassword.Checked == true)
                {
                    if (string.IsNullOrEmpty(txtPassword.Text))
                    {
                        MessageBox.Show("Must fill all information to edit!");
                        return;
                    }
                }
                if (isBedEmpty == false)
                {
                    // Check gender
                    int selectedGender = 1;
                    if (rbtnFemale.Checked == true)
                    {
                        selectedGender = 0;
                    }
                    Room chk_r = RoomDAO.getRoomBedByRoomNameBedNo(cbxRoom.SelectedValue.ToString(), int.Parse(cbxBed.SelectedValue.ToString()));
                    if (selectedGender != chk_r.Gender)
                    {
                        lblError.Text = "* * Wrong room gender!";
                        return;
                    }
                    // -------------
                    Student s = StudentDAO.getStudentByStuID(txtStuID.Text);
                    if (chk_r.BedStatus == 1 && (!chk_r.RoomName.Equals(s.RoomName) || chk_r.BedNo != s.BedNo))
                    {
                        lblError.Text = "* * Bed occupied by others!";
                        return;
                    }
                }

                    
                // ----------------
                int gender = 1;
                if (rbtnFemale.Checked == true)
                {
                    gender = 0;
                }
                Account a;
                Room r;

                Student currStu = (Student)dataGridViewStudent.CurrentRow.DataBoundItem;

                if (chkChangePassword.Checked == true)
                {
                    a = new Account(txtUsername.Text, txtPassword.Text, 0);
                    AccountDAO.Update(a);
                }

                if (isBedEmpty == false)
                {
                    Room currRoom = new Room(currStu.RoomName, currStu.Gender, currStu.BedNo, 0, RoomDAO.getRoomPrice(currStu.RoomName));
                    RoomDAO.Update(currRoom);
                    r = new Room(cbxRoom.SelectedValue.ToString(), gender, int.Parse(cbxBed.SelectedValue.ToString()), 1, RoomDAO.getRoomPrice(currStu.RoomName));
                    RoomDAO.Update(r);
                    Student s = new Student(txtStuID.Text, txtUsername.Text, txtFullName.Text,
                    dateDOB.Value, gender, cbxRoom.SelectedValue.ToString(),
                    int.Parse(cbxBed.SelectedValue.ToString()), dateBookingDate.Value,
                    int.Parse(txtBalance.Text), int.Parse(txtDebt.Text));
                    StudentDAO.Update(s);
                }
                else
                {
                    Student s = new Student(txtStuID.Text, txtUsername.Text, txtFullName.Text,
                    dateDOB.Value, gender, currStu.RoomName, 0, currStu.BookingDate,
                    int.Parse(txtBalance.Text), int.Parse(txtDebt.Text));
                    StudentDAO.Update(s);
                }

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

        private void AdjustGUI(string choice)
        {
            switch (choice)
            {
                case "ADD":
                    dataGridViewStudent.Enabled = false;

                    // btn add edit delete
                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    // Stu info
                    txtStuID.Enabled = true;
                    txtStuID.ReadOnly = false;
                    txtUsername.Enabled = true;
                    txtUsername.ReadOnly = false;
                    txtPassword.Enabled = true;
                    chkChangePassword.Enabled = false;
                    txtFullName.Enabled = true;
                    rbtnMale.Enabled = true;
                    rbtnFemale.Enabled = true;
                    dateDOB.Enabled = true;
                    dateBookingDate.Enabled = true;
                    cbxRoom.Enabled = true;
                    cbxBed.Enabled = true;
                    txtBalance.Enabled = true;
                    txtDebt.Enabled = true;
                    // ------

                    // btn save cancel
                    btnSave.Enabled = true;
                    btnCancel.Enabled = true;
                    break;
                case "EDIT":
                    dataGridViewStudent.Enabled = false;

                    // btn add edit delete
                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    // Stu info
                    txtStuID.Enabled = true;
                    txtStuID.ReadOnly = true;
                    txtUsername.Enabled = true;
                    txtUsername.ReadOnly = true;
                    txtPassword.Enabled = false;
                    chkChangePassword.Enabled = true;
                    txtFullName.Enabled = true;
                    rbtnMale.Enabled = true;
                    rbtnFemale.Enabled = true;
                    dateDOB.Enabled = true;
                    // If have bed then allow edit
                    if (isBedEmpty == false)
                    {
                        dateBookingDate.Enabled = true;
                        cbxRoom.Enabled = true;
                        cbxBed.Enabled = true;
                    }
                    else
                    {
                        dateBookingDate.Enabled = false;
                        cbxRoom.Enabled = false;
                        cbxBed.Enabled = false;
                    }

                    txtBalance.Enabled = true;
                    txtDebt.Enabled = true;
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
                    txtStuID.Enabled = false;
                    txtStuID.ReadOnly = false;
                    txtUsername.Enabled = false;
                    txtUsername.ReadOnly = false;
                    txtPassword.Enabled = false;
                    chkChangePassword.Enabled = false;
                    txtFullName.Enabled = false;
                    rbtnMale.Enabled = false;
                    rbtnFemale.Enabled = false;
                    dateDOB.Enabled = false;
                    dateBookingDate.Enabled = false;
                    cbxRoom.Enabled = false;
                    cbxBed.Enabled = false;
                    txtBalance.Enabled = false;
                    txtDebt.Enabled = false;
                    chkChangePassword.Checked = false;
                    // ------

                    dataGridViewStudent.Enabled = true;

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
                    txtStuID.Enabled = false;
                    txtStuID.ReadOnly = false;
                    txtUsername.Enabled = false;
                    txtUsername.ReadOnly = false;
                    txtPassword.Enabled = false;
                    chkChangePassword.Enabled = false;
                    txtFullName.Enabled = false;
                    rbtnMale.Enabled = false;
                    rbtnFemale.Enabled = false;
                    dateDOB.Enabled = false;
                    dateBookingDate.Enabled = false;
                    cbxRoom.Enabled = false;
                    cbxBed.Enabled = false;
                    txtBalance.Enabled = false;
                    txtDebt.Enabled = false;
                    chkChangePassword.Checked = false;
                    // ------

                    dataGridViewStudent.Enabled = true;

                    // btn save cancel
                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;
            }
        }

        private void chkChangePassword_CheckedChanged(object sender, EventArgs e)
        {
            if (chkChangePassword.Checked == true)
            {
                txtPassword.Enabled = true;
            }
            else
            {
                txtPassword.Enabled = false;
            }
        }

        private void cbxRoom_SelectedIndexChanged(object sender, EventArgs e)
        {
            LoadBed();
        }
    }
}

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
    public partial class ManagerViewRoomInforGUI : Form
    {
        string choice;
        public ManagerViewRoomInforGUI()
        {
            InitializeComponent();
            rbtnMale.Select();
            rbtnAvail.Select();
        }

        private void ManagerViewRoomInforGUI_Load(object sender, EventArgs e)
        {
            LoadData();
        }

        private void LoadData()
        {
            DataTable room_dt = RoomDAO.GetDataTableRoomGroupBy();
            cbxRoom.DataSource = room_dt;
            cbxRoom.DisplayMember = "roomName";
            cbxRoom.ValueMember = "roomName";

            LoadGridData();
        }

        private void LoadGridData()
        {
            List<Room> rooms = RoomDAO.GetRoomBedPricesByRoomName(cbxRoom.SelectedValue.ToString());
            dataGridViewRoom.DataSource = rooms;
            lblNotify.Visible = true;
        }

        private void LoadForm()
        {
            Room r = (Room)dataGridViewRoom.CurrentRow.DataBoundItem;
            txtRoomName.Text = r.RoomName;
            if (r.Gender == 1)
            {
                rbtnMale.Select();
            }
            else
            {
                rbtnFemale.Select();
            }
            txtBedNo.Text = r.BedNo.ToString();
            if (r.BedStatus == 0)
            {
                rbtnAvail.Select();
            }
            else
            {
                rbtnOccupy.Select();
            }
            txtPrice.Text = r.Price.ToString();
            lblError.Text = "";
        }

        private void cbxRoom_SelectedIndexChanged(object sender, EventArgs e)
        {
            LoadGridData();
        }

        private void dataGridViewRoom_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            LoadForm();
            lblNotify.Visible = false;
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            choice = "ADD";
            AdjustGUI(choice);
            ReNewData();
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            choice = "EDIT";
            AdjustGUI(choice);
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (dataGridViewRoom.CurrentRow == null)
            {
                MessageBox.Show("Must select an item on data grid view");
                return;
            } else
            {
                Room r = (Room)dataGridViewRoom.CurrentRow.DataBoundItem;
                RoomDAO.DeleteBedNo(r.RoomName, r.BedNo);
                // Check if list room is empty then delete room
                if (RoomDAO.GetRoomBedPricesByRoomName(txtRoomName.Text).Count == 0)
                {
                    RoomDAO.DeleteRoom(r.RoomName);
                }
            }
            LoadData();
        }

        private void btnSave_Click(object sender, EventArgs e)
        {
            if (choice.Equals("ADD"))
            {
                // Check conditions
                if (isStringNull() == true)
                {
                    MessageBox.Show("Must fill all information to add!");
                    return;
                }

                try
                {
                    int.Parse(txtPrice.Text);
                    int.Parse(txtBedNo.Text);
                } catch (FormatException)
                {
                    MessageBox.Show("Price or Bed number must be number!");
                    return;
                }
                if (RoomDAO.getRoomBedByRoomNameBedNo(txtRoomName.Text, int.Parse(txtBedNo.Text)) != null)
                {
                    lblError.Text = "Bed number: " + txtBedNo.Text + " already existed in room: " + txtRoomName.Text;
                    return;
                }
                // ---------------------

                // Add
                int gender = 1;
                if (rbtnFemale.Checked == true)
                {
                    gender = 0;
                }
                int status = 0;
                if (rbtnOccupy.Checked == true)
                {
                    status = 1;
                }
                Room r = new Room(txtRoomName.Text, gender, int.Parse(txtBedNo.Text), status, int.Parse(txtPrice.Text));
                // Check if room name existed
                if(RoomDAO.GetRoomBedPricesByRoomName(txtRoomName.Text).Count != 0)
                {
                    RoomDAO.InsertBed(r);
                } else // not
                {
                    RoomDAO.Insert(r);
                }
            }
            if (choice.Equals("EDIT"))
            {
                // Check conditions
                if (isStringNull() == true)
                {
                    MessageBox.Show("Must fill all information to add!");
                    return;
                }

                try
                {
                    int.Parse(txtPrice.Text);
                    int.Parse(txtBedNo.Text);
                }
                catch (FormatException)
                {
                    MessageBox.Show("Price or Bed number must be number!");
                    return;
                }

                // ---------------------

                // Update
                int gender = 1;
                if (rbtnFemale.Checked == true)
                {
                    gender = 0;
                }
                int status = 0;
                if (rbtnOccupy.Checked == true)
                {
                    status = 1;
                }
                Room r = new Room(txtRoomName.Text, gender, int.Parse(txtBedNo.Text), status, int.Parse(txtPrice.Text));
                RoomDAO.Update(r);
            }


            LoadData();
            choice = "SAVE";
            AdjustGUI(choice);
        }

        private bool isStringNull()
        {
            if (string.IsNullOrEmpty(txtRoomName.Text)
                || string.IsNullOrEmpty(txtBedNo.Text)
                || string.IsNullOrEmpty(txtPrice.Text))
            {
                return true;
            }
            return false;
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
                    dataGridViewRoom.Enabled = false;

                    // btn add edit delete
                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    // Room info
                    txtRoomName.Enabled = true;
                    rbtnMale.Enabled = true;
                    rbtnFemale.Enabled = true;
                    txtBedNo.Enabled = true;
                    rbtnAvail.Enabled = true;
                    rbtnOccupy.Enabled = true;
                    txtPrice.Enabled = true;
                    // ------

                    // btn save cancel
                    btnSave.Enabled = true;
                    btnCancel.Enabled = true;
                    break;
                case "EDIT":
                    dataGridViewRoom.Enabled = false;

                    // btn add edit delete
                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    // Room info
                    txtRoomName.Enabled = true;
                    txtRoomName.ReadOnly = true;
                    rbtnMale.Enabled = true;
                    rbtnFemale.Enabled = true;
                    txtBedNo.Enabled = true;
                    rbtnAvail.Enabled = true;
                    rbtnOccupy.Enabled = true;
                    txtPrice.Enabled = true;
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

                    // Room info
                    txtRoomName.Enabled = false;
                    txtRoomName.ReadOnly = false;
                    rbtnMale.Enabled = false;
                    rbtnFemale.Enabled = false;
                    txtBedNo.Enabled = false;
                    rbtnAvail.Enabled = false;
                    rbtnOccupy.Enabled = false;
                    txtPrice.Enabled = false;
                    // ------

                    dataGridViewRoom.Enabled = true;

                    // btn save cancel
                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;
                case "CANCEL":
                    // btn add edit delete
                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;
                    btnDelete.Enabled = true;

                    // Room info
                    txtRoomName.Enabled = false;
                    txtRoomName.ReadOnly = false;
                    rbtnMale.Enabled = false;
                    rbtnFemale.Enabled = false;
                    txtBedNo.Enabled = false;
                    rbtnAvail.Enabled = false;
                    rbtnOccupy.Enabled = false;
                    txtPrice.Enabled = false;
                    // ------

                    dataGridViewRoom.Enabled = true;

                    // btn save cancel
                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;
            }
        }

        private void ReNewData()
        {
            txtRoomName.Text = "";
            txtBedNo.Text = "";
            txtPrice.Text = "";
            rbtnMale.Select();
            rbtnAvail.Select();
        }

    }
}

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
    public partial class ManagerBookRequestGUI : Form
    {

        public ManagerBookRequestGUI(string user)
        {
            InitializeComponent();
            List<String> list = new List<string>();
            list.Add("In progess");
            list.Add("Accepted");
            list.Add("Rejected");
            comboBoxStatus.DataSource = list;

            DataTable dt = RoomDAO.GetDataTableRoomGroupBy();
            comboBoxRoom.DataSource = dt;
            comboBoxRoom.DisplayMember = "roomName";
            comboBoxRoom.ValueMember = "roomName";

            DataTable dt1 = RoomDAO.GetDataTableBedNoStatus(comboBoxRoom.SelectedValue.ToString());
            comboBoxBedNo.DataSource = dt1;
            comboBoxBedNo.ValueMember = "bedNo";
            comboBoxBedNo.DisplayMember = "bedNo";

            view();
            btnAccept.Enabled = true;
            btnDecline.Enabled = true;
        }
        private void view()
        {
            string filter="";
            if (comboBoxStatus.SelectedIndex == 0)
                filter = "status = 1 ";
            else
            {
                if (comboBoxStatus.SelectedIndex == 1)
                    filter = "status = 2 ";
                else
                {
                    if (comboBoxStatus.SelectedIndex == 2)
                        filter = "status = 0 ";
                }
            }
            try
            {
                if (checkBox1.Checked == false)
                    filter = filter + "AND roomName LIKE '" + comboBoxRoom.SelectedValue.ToString() + "' AND bedNo =" + comboBoxBedNo.SelectedValue.ToString();

            } catch (NullReferenceException)
            {
            }
            
            DataTable dt = HistoryBookDAO.GetDataTable();
            DataView dv = new DataView(dt);
            dv.RowFilter = filter;
            dataGridView1.DataSource = dv;
        }

        private void comboBoxStatus_SelectedIndexChanged(object sender, EventArgs e)
        {
            if (comboBoxStatus.SelectedIndex == 0)
            {
                btnAccept.Enabled = true;
                btnDecline.Enabled = true;
            }
            else
            {
                btnAccept.Enabled = false;
                btnDecline.Enabled = false;
            }
            view();
        }

        private void comboBoxRoom_SelectedIndexChanged(object sender, EventArgs e)
        {
            DataTable dt1 = RoomDAO.GetDataTableBedNoStatus(comboBoxRoom.SelectedValue.ToString());
            comboBoxBedNo.DataSource = dt1;
            comboBoxBedNo.ValueMember = "bedNo";
            comboBoxBedNo.DisplayMember = "bedNo";
            view();
        }

        private void btnAccept_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("please select one row");
            }
            else
            {
                int bookID = int.Parse(dataGridView1.SelectedRows[0].Cells["bookID"].Value.ToString());
                HistoryBook his = HistoryBookDAO.GetHistoryBooksByBookID(bookID);
                his.Status = 2;
                HistoryBookDAO.Update(his);


                string roomName = dataGridView1.SelectedRows[0].Cells["roomName"].Value.ToString();
                int bedNo = int.Parse(dataGridView1.SelectedRows[0].Cells["bedNo"].Value.ToString());
                Room r = RoomDAO.getRoomBedByRoomNameBedNoPrice(roomName, bedNo);
                r.BedStatus = 1;
                RoomDAO.Update(r);


                Student stu = StudentDAO.getStudentByStuID(dataGridView1.SelectedRows[0].Cells["stuID"].Value.ToString());
                stu.RoomName = roomName;
                stu.BedNo = bedNo;
                stu.BookingDate = DateTime.Now;
                stu.MoneyAccount = stu.MoneyAccount - r.Price;
                StudentDAO.Update(stu);

                HistoryPayment hp = new HistoryPayment(1,stu.StuID,DateTime.Now,"tiền phòng",r.Price, roomName);
                HistoryPaymentDAO.Insert(hp);

                List<HistoryBook> list = HistoryBookDAO.GetHistoryBooksByRoomNameStatus(dataGridView1.SelectedRows[0].Cells["roomName"].Value.ToString(),int.Parse(dataGridView1.SelectedRows[0].Cells["bedNo"].Value.ToString()));
                for (int i = 0; i < list.Count; i++)
                {
                    HistoryBook h = list[i];
                    h.Status = 0;
                    HistoryBookDAO.Update(h);
                }
                view();
            }
        }

        private void btnDecline_Click(object sender, EventArgs e)
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("please select one row");
            }
            else
            {
                int bookID = int.Parse(dataGridView1.SelectedRows[0].Cells["bookID"].Value.ToString());
                HistoryBook his = HistoryBookDAO.GetHistoryBooksByBookID(bookID);
                his.Status = 0;
                HistoryBookDAO.Update(his);
                view();
            }
        }

        private void comboBoxBedNo_SelectedIndexChanged(object sender, EventArgs e)
        {
            view();
        }

        private void checkBox1_CheckedChanged(object sender, EventArgs e)
        {
            view();
        }
    }
}

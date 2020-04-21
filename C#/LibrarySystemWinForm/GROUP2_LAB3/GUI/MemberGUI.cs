using GROUP2_LAB3.DAL;
using GROUP2_LAB3.DTL;
using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace GROUP2_LAB3.GUI
{
    public partial class MemberGUI : Form
    {
        DataView dv;
        Borrower b;
        public MemberGUI()
        {
            InitializeComponent();
            View();
            displayButtons(1);
        }
        private void View()
        {
            DataTable dt = BorrowerDAO.GetDataTable();
            dv = new DataView(dt);
            dataGridView1.DataSource = dv;
        }
        private void displayButtons(int state)
        {
            switch (state)
            {
                // allow to filter/Add/Edit/Delete borrower
                case 1:
                    txtMemberCode.Enabled = true;
                    txtMemberCode.Focus();

                    txtName.Enabled = false;
                    txtSex.Enabled = false;
                    txtAddress.Enabled = false;
                    txtTelephone.Enabled = false;
                    txtEmail.Enabled = false;


                    btnFilter.Enabled = true;

                    btnAdd.Text = "Add";
                    btnAdd.Enabled = true;

                    btnEdit.Text = "Edit";
                    btnEdit.Enabled = true;

                    btnDelete.Enabled = true;
                    break;

                // Allow to add a borrower
                case 2:
                    txtMemberCode.Enabled = false;

                    txtName.Enabled = true;
                    txtSex.Enabled = true;
                    txtAddress.Enabled = true;
                    txtTelephone.Enabled = true;
                    txtEmail.Enabled = true;
                    txtName.Focus();
                    btnAdd.Text = "Save";
                    btnAdd.Enabled = true;

                    btnFilter.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    break;

                // Allow to edit a borrower
                case 3:

                    txtMemberCode.Enabled = false;

                    txtName.Enabled = true;
                    txtSex.Enabled = true;
                    txtAddress.Enabled = true;
                    txtTelephone.Enabled = true;
                    txtEmail.Enabled = true;
                    txtName.Focus();
                    btnEdit.Text = "Save";
                    btnEdit.Enabled = true;

                    btnFilter.Enabled = false;
                    btnAdd.Enabled = false;
                    btnDelete.Enabled = false;
                    break;

            }
        }
        private void label5_Click(object sender, EventArgs e)
        {

        }

        private void btnFilter_Click(object sender, EventArgs e)
        {
            int memberCode;
            try
            {
                memberCode = int.Parse(txtMemberCode.Text);
            }
            catch
            {
                MessageBox.Show("memberCode number must be integer (empty for all Borrwer)!");
                if (txtMemberCode.Text != "") return;
                else memberCode = -1;
            }

            if (memberCode > -1) dv.RowFilter = "borrowerNumber = " + memberCode.ToString();
        }

        private void txtSex_Validating(object sender, CancelEventArgs e)
        {
            if (txtSex.Text.Length == 0)
            {
                // Cancel the event and select the text to be corrected by the user.
                e.Cancel = true;
                txtSex.Select(0, txtSex.Text.Length);

                // Set the ErrorProvider error with the text to display.  
                this.errorProvider1.SetError(txtSex, "Must be 'M' or 'F'");
                return;
            }
            if (txtSex.Text[0] != 'M' && txtSex.Text[0] != 'F')
            {
                // Cancel the event and select the text to be corrected by the user.
                e.Cancel = true;
                txtSex.Select(0, txtSex.Text.Length);

                // Set the ErrorProvider error with the text to display.  
                this.errorProvider1.SetError(txtSex, "Must be 'M' or 'F'");
                return;
            }
            e.Cancel = false;
        }

        private void txtSex_Validated(object sender, EventArgs e)
        {
            errorProvider1.SetError(txtSex, "");
        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Add")
            {
                b = new Borrower(BorrowerDAO.GetBorrowerNumberMax() + 1, "", 'M', "","","");
                displayBook();

                displayButtons(2);
            }
            else
            {
                b.Name = txtName.Text;
                b.Sex = char.Parse(txtSex.Text);
                b.Address = txtAddress.Text;
                b.Telephone= txtTelephone.Text;
                b.Email = txtEmail.Text;
                BorrowerDAO.Insert(b);

                // Add to DataTable
                DataTable dt = dv.Table;
                DataRow newRow = dt.NewRow();
                newRow["borrowerNumber"] = b.BorrowerNumber;
                newRow["name"] = b.Name;
                newRow["sex"] = b.Sex;
                newRow["address"] = b.Address;
                newRow["telephone"] = b.Telephone;
                newRow["email"] = b.Email;
                dt.Rows.Add(newRow);
                dv.RowFilter = "";

                displayButtons(1);
            }
        }
        private void displayBook()
        {
            txtMemberCode.Text = b.BorrowerNumber.ToString();
            txtName.Text = b.Name;
            txtSex.Text = b.Sex.ToString();
            txtAddress.Text = b.Address;
            txtTelephone.Text = b.Telephone;
            txtEmail.Text = b.Email;
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Edit")
            {
                if (!isSelected()) return;

                txtMemberCode.Text = dataGridView1.SelectedRows[0].Cells["borrowerNumber"].Value.ToString();

                txtName.Text = dataGridView1.SelectedRows[0].Cells["name"].Value.ToString();
                txtSex.Text = dataGridView1.SelectedRows[0].Cells["sex"].Value.ToString();
                txtAddress.Text = dataGridView1.SelectedRows[0].Cells["address"].Value.ToString();
                txtTelephone.Text = dataGridView1.SelectedRows[0].Cells["telephone"].Value.ToString();
                txtEmail.Text = dataGridView1.SelectedRows[0].Cells["email"].Value.ToString();
                displayButtons(3);

            }
            else
            {
                b = new Borrower(int.Parse(txtMemberCode.Text), txtName.Text, char.Parse(txtSex.Text), txtAddress.Text, txtTelephone.Text, txtEmail.Text);
                BorrowerDAO.Update(b);

                // Update in DataTable
                DataTable dt = dv.Table;
                DataRow[] result = dt.Select("borrowerNumber = " + b.BorrowerNumber);
                DataRow row = result[0];
                row["name"] = b.Name;
                row["sex"] = b.Sex;
                row["address"] = b.Address;
                row["telephone"] = b.Telephone;
                row["email"] = b.Email;
                dv.RowFilter = "";

                displayButtons(1);
            }
        }
        private bool isSelected()
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("You must select a book in the list of books!");
                return false;
            }
            if (dataGridView1.SelectedRows[0].Cells["borrowerNumber"].Value == null)
            {
                MessageBox.Show("You must select a book in the list of books!");
                return false;
            }
            return true;
        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (!isSelected()) return;

            int borrowerNumber = (int)dataGridView1.SelectedRows[0].Cells["borrowerNumber"].Value;
            DialogResult dr = MessageBox.Show(String.Format("Do you want to delete this borrower number {0}?", borrowerNumber), "Confirm deteting", MessageBoxButtons.YesNo);
            if (dr == DialogResult.No) return;

            BorrowerDAO.Delete(borrowerNumber);

            View();
        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;
            txtMemberCode.Text = dataGridView1.Rows[e.RowIndex].Cells["borrowerNumber"].Value.ToString();

            txtName.Text = dataGridView1.Rows[e.RowIndex].Cells["name"].Value.ToString();
            txtSex.Text = dataGridView1.Rows[e.RowIndex].Cells["sex"].Value.ToString();
            txtAddress.Text = dataGridView1.Rows[e.RowIndex].Cells["address"].Value.ToString();
            txtTelephone.Text = dataGridView1.Rows[e.RowIndex].Cells["telephone"].Value.ToString();
            txtEmail.Text = dataGridView1.Rows[e.RowIndex].Cells["email"].Value.ToString();

        }

        private void MemberGUI_Load(object sender, EventArgs e)
        {

        }
    }
}

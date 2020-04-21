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
    public partial class ReturnGUI : Form
    {
        DataView dv;
        public ReturnGUI()
        {
            InitializeComponent();
            displayButtons(1);
            txtReturnedDate.Text = DateTime.Now.AddDays(0).ToString("dd/MM/yyyy");

        }

        private void btnMember_Click(object sender, EventArgs e)
        {
            int borrowerNumber;
            try
            {
                borrowerNumber = int.Parse(txtBorrowerNumber.Text);
            }
            catch
            {
                MessageBox.Show("Borrower number must be a integer!");
                txtBorrowerNumber.Focus();
                return;
            }
            Borrower b = BorrowerDAO.GetBorrower(borrowerNumber);
            if (b == null)
            {
                MessageBox.Show(String.Format("Borrower number {0} does't exist!", borrowerNumber));
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;


            View();

            displayButtons(2);


        }

        private void btnFine_Click(object sender, EventArgs e)
        {
            if (!isSelected()) return;
            double fine = 0;
            foreach (DataGridViewRow dr in dataGridView1.SelectedRows)
            {
                fine += (int)(DateTime.Now.AddDays(20) - Convert.ToDateTime(dr.Cells["dueDate"].Value.ToString())).TotalDays;
            }

            txtFineAmount.Text = fine.ToString("C2");

            displayButtons(3);

        }

        private void btnReturn_Click(object sender, EventArgs e)
        {
            double fine, fineTotal = 0;
            try
            {
                DateTime.ParseExact(txtReturnedDate.Text, "dd/MM/yyyy", null);
            }
            catch
            {
                MessageBox.Show("Format of date must be 'dd/MM/yyyy'!");
                return;
            }

            CirculatedCopy cc;

            foreach (DataGridViewRow dr in dataGridView1.SelectedRows)
            {
                fine = 0;
                if (DateTime.ParseExact(txtReturnedDate.Text, "dd/MM/yyyy", null) > Convert.ToDateTime(dr.Cells["dueDate"].Value.ToString()))
                    fine = (int)(DateTime.Now.AddDays(20) - Convert.ToDateTime(dr.Cells["dueDate"].Value.ToString())).TotalDays;

                fineTotal += fine;

                cc = new CirculatedCopy(int.Parse(dr.Cells["copyNumber"].Value.ToString()), int.Parse(dr.Cells["borrowerNumber"].Value.ToString()),
                    Convert.ToDateTime(dr.Cells["borrowedDate"].Value.ToString()), Convert.ToDateTime(dr.Cells["dueDate"].Value.ToString()));
                cc.Id = int.Parse(dr.Cells["ID"].Value.ToString());
                cc.ReturnedDate = DateTime.ParseExact(txtReturnedDate.Text, "dd/MM/yyyy", null);
                cc.FineAmount = fine;

                Return(cc);

            }


            View();

            displayButtons(1);

        }
        private void Return(CirculatedCopy cc)
        {
            CirculatedCopyDAO.Update(cc);

            Copy c = CopyDAO.GetCopy(cc.CopyNumber);

            // update type = 'A' in copy
            c.Type = 'A';
            CopyDAO.Update(c);

        }

        private bool isSelected()
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("Don't have any book to return!");
                return false;
            }
            if (dataGridView1.SelectedRows[0].Cells["copyNumber"].Value == null)
            {
                MessageBox.Show("You must select a book in the list to return!");
                return false;

            }

            return true;


        }

        private void txtReturnedDate_Validated(object sender, EventArgs e)
        {

        }

        private void txtReturnedDate_Validating(object sender, CancelEventArgs e)
        {
            try
            {
                DateTime.ParseExact(txtReturnedDate.Text, "dd/MM/yyyy", null);
                e.Cancel = false;
            }
            catch
            {
                MessageBox.Show("Format date must be 'dd/MM/yyyy'!");
                txtReturnedDate.Focus();
                e.Cancel = true;
            }

        }
        private void View()
        {

            DataTable dt = CirculatedCopyDAO.GetBorrowedCopies(int.Parse(txtBorrowerNumber.Text));
            dataGridView1.DataSource = dt;
            this.dataGridView1.Columns["borrowedDate"].DefaultCellStyle.Format = "dd/MM/yyyy";
            this.dataGridView1.Columns["dueDate"].DefaultCellStyle.Format = "dd/MM/yyyy";
            this.dataGridView1.Columns["returnedDate"].DefaultCellStyle.Format = "dd/MM/yyyy";

            lblNumberBorrowedBooks.Text = dt.Rows.Count.ToString();
        }


        private void displayButtons(int state)
        {
            switch (state)
            {
                // to enter member and check Member
                case 1:
                    txtBorrowerNumber.Enabled = true;
                    btnMember.Enabled = true;

                    dataGridView1.Enabled = false;
                    btnFine.Enabled = false;

                    txtReturnedDate.Enabled = true;
                    btnReturn.Enabled = false;
                    break;
                // to Confirm fine
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    dataGridView1.Enabled = true;
                    btnFine.Enabled = true;

                    txtReturnedDate.Enabled = true;
                    btnReturn.Enabled = false;

                    break;
                // to Return
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    btnFine.Enabled = false;
                    dataGridView1.Enabled = false;

                    txtReturnedDate.Enabled = true;
                    btnReturn.Enabled = true;
                    break;

            }

        }

        private void txtName_TextChanged(object sender, EventArgs e)
        {

        }

        private void ReturnGUI_Load(object sender, EventArgs e)
        {

        }

        private void txtFineAmount_TextChanged(object sender, EventArgs e)
        {

        }
    }
}

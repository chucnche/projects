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

namespace GROUP2_LAB3.DAL
{

    public partial class ReserveGUI : Form
    {
        DataView dv;
        public ReserveGUI()
        {
            InitializeComponent();
            displayButtons(1);
            txtDate.Text = DateTime.Now.AddDays(0).ToString("dd/MM/yyyy");
        }

        private void label4_Click(object sender, EventArgs e)
        {

        }

        private void txtFineAmount_TextChanged(object sender, EventArgs e)
        {

        }

        private void ReserveGUI_Load(object sender, EventArgs e)
        {

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
            if(lblNumberReservedBooks.Text=="0")
            displayButtons(2);
            else
            {
                displayButtons(1);
            }
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

        private void txtDate_Validating(object sender, CancelEventArgs e)
        {
            try
            {
                DateTime.ParseExact(txtDate.Text, "dd/MM/yyyy", null);
                e.Cancel = false;
            }
            catch
            {
                MessageBox.Show("Format date must be 'dd/MM/yyyy'!");
                txtDate.Focus();
                e.Cancel = true;
            }
        }
        private void View()
        {
            DataTable dt = ReserveDAO.GetReservation(int.Parse(txtBorrowerNumber.Text));
            dataGridView1.DataSource = dt;
            this.dataGridView1.Columns["date"].DefaultCellStyle.Format = "dd/MM/yyyy";

            lblNumberReservedBooks.Text = dt.Rows.Count.ToString();
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
                    btnCondition.Enabled = false;

                    txtBookNumber.Enabled = false;
                    txtDate.Enabled = false;
                    btnReserve.Enabled = false;
                    break;
                // to Confirm fine
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    dataGridView1.Enabled = true;
                    btnCondition.Enabled = true;

                    txtBookNumber.Enabled = true;
                    txtDate.Enabled = false;
                    btnReserve.Enabled = false;

                    break;
                // to Return
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    btnCondition.Enabled = false;
                    txtBookNumber.Enabled = false;
                    txtDate.Enabled = false;
                    btnReserve.Enabled = true;
                    break;

            }

        }

        private void btnCondition_Click(object sender, EventArgs e)
        {
            int bookNumber;
            try
            {
                bookNumber = int.Parse(txtBookNumber.Text);
            }
            catch
            {
                MessageBox.Show("Borrower number must be a integer!");
                txtBorrowerNumber.Focus();
                return;
            }
            Book b = BookDAO.GetBook(bookNumber);
            if (b == null)
            {
                MessageBox.Show(String.Format("Booknumber {0} does't exist!", bookNumber));
                txtBorrowerNumber.Focus();
                return;
            }

            if (CopyDAO.GetCopyByBookNumber(bookNumber)==null)
                displayButtons(3);
            else
            {
                displayButtons(2);
            }
        }

        private void btnReserve_Click(object sender, EventArgs e)
        {
            Reservation re = new Reservation();
            re.BorrowerNumber = int.Parse(txtBorrowerNumber.Text);
            re.BookNumber = int.Parse(txtBookNumber.Text);
            re.Date = DateTime.ParseExact(txtDate.Text, "dd/MM/yyyy", null);
            re.Status = 'R';
            ReserveDAO.Insert(re);
            View();
            txtBookNumber.Text = "";
            displayButtons(1);
        }
    }
}

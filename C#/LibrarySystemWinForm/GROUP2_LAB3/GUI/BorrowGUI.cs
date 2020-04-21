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
    public partial class BorrowGUI : Form
    {

        DataView dv;
        Copy c;
        Reservation r;

        enum errorBorrow
        {
            OK,
            Connect,
            CopyNotExist,
            CopyReferenced,
            CopyBorrowed,
            CopyReserved
        };

        public BorrowGUI()
        {
            InitializeComponent();
            txtBorrowedDate.Text = DateTime.Now.ToString("dd/MM/yyyy");
            txtDueDate.Text = DateTime.Now.AddDays(14).ToString("dd/MM/yyyy");
            displayButtons(1);

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
            //create in DAO
            Borrower b = BorrowerDAO.GetBorrower(borrowerNumber);
            if (b == null)
            {
                MessageBox.Show(String.Format("Borrower number {0} does't exist!", borrowerNumber));
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;

            View();

            int n = dataGridView1.Rows.Count;
            MessageBox.Show("Number = " + n);

            if (dataGridView1.Rows.Count >= 5)
            {
                MessageBox.Show("You borrowed 5 books, so you can't borrow any more!");
                txtBorrowerNumber.Focus();
                return;
            }

            displayButtons(2);

            r = null;
            c = null;


        }

        private void btnCondition_Click(object sender, EventArgs e)
        {
            int copyNumber;
            try
            {
                copyNumber = int.Parse(txtCopyNumber.Text);
            }
            catch
            {
                MessageBox.Show("Copy number must be a integer!");
                txtCopyNumber.Focus();
                return;
            }

            errorBorrow error = checkCondition(int.Parse(txtBorrowerNumber.Text), int.Parse(txtCopyNumber.Text), out c, out r);
            string str = "";
            switch (error)
            {
                case errorBorrow.CopyNotExist:
                    str = "No this copy number, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.CopyReferenced:
                    str = "It is referenced, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.CopyBorrowed:
                    str = "It is borrwed, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.CopyReserved:
                    str = "It is reserved by other, so you can't borrow!";
                    txtCopyNumber.Focus();
                    break;
                case errorBorrow.Connect:
                    str = "Can't connect to Database, so you can't borrow!";
                    break;

            }


            if (str != "")
            {
                MessageBox.Show(str);
                return;
            }

            displayButtons(3);
        }
        private errorBorrow checkCondition(int borrowerNumber, int copyNumber, out Copy c, out Reservation r)
        {
            c = null;
            r = null;

                c = CopyDAO.GetCopy(copyNumber);

            if (c == null) return errorBorrow.CopyNotExist;
            if (c.Type == 'R') return errorBorrow.CopyReferenced;
            if (c.Type == 'B') return errorBorrow.CopyBorrowed;

            // Check if this book is reserved by others and you are not at the first of the reservation list
            int bookNumber = c.BookNumber;
            r = ReserveDAO.GetFirstReservation(bookNumber);
            if (r != null && r.BorrowerNumber != borrowerNumber) return errorBorrow.CopyReserved;

            return errorBorrow.OK;

        }

        private void btnBorrow_Click(object sender, EventArgs e)
        {
            try
            {
                DateTime.ParseExact(txtBorrowedDate.Text, "dd/MM/yyyy", null);
            }
            catch
            {
                MessageBox.Show("Format of date is not valid!");
                return;
            }

            CirculatedCopy cc = new CirculatedCopy(int.Parse(txtCopyNumber.Text), int.Parse(txtBorrowerNumber.Text),
                DateTime.ParseExact(txtBorrowedDate.Text, "dd/MM/yyyy", null), DateTime.ParseExact(txtDueDate.Text, "dd/MM/yyyy", null));

            borrow(cc, c, r);

            View();
            displayButtons(1);

        }
        private void borrow(CirculatedCopy cc, Copy c, Reservation r)
        {
            // Insert borrow record
            if (cc == null) return;
            CirculatedCopyDAO.Insert(cc);

            // update type = 'B' at Copy
            if (c == null) return;
            c.Type = 'B';
            CopyDAO.Update(c);


            // update status = 'A' at Reservation
            if (r == null) return;
            r.Status = 'A';
            ReserveDAO.Update(r);


        }
        private void View()
        {
            DataTable dt = CirculatedCopyDAO.GetBorrowedCopies(int.Parse(txtBorrowerNumber.Text));
            dataGridView1.DataSource = dt;
            lblNumberBorrowedBooks.Text = dt.Rows.Count.ToString();
            this.dataGridView1.Columns["borrowedDate"].DefaultCellStyle.Format = "dd/MM/yyyy";
            this.dataGridView1.Columns["dueDate"].DefaultCellStyle.Format = "dd/MM/yyyy";
            this.dataGridView1.Columns["returnedDate"].DefaultCellStyle.Format = "dd/MM/yyyy";

        }
        private void displayButtons(int state)
        {
            switch (state)
            {
                // to enter member and check member
                case 1:
                    txtBorrowerNumber.Enabled = true;
                    btnMember.Enabled = true;

                    txtCopyNumber.Enabled = false;
                    btnCondition.Enabled = false;

                    txtBorrowedDate.Enabled = false;
                    btnBorrow.Enabled = false;
                    break;
                // to check condition
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    txtCopyNumber.Enabled = true;
                    btnCondition.Enabled = true;

                    txtBorrowedDate.Enabled = false;
                    btnBorrow.Enabled = false;
                    break;
                // to borrow
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    txtCopyNumber.Enabled = false;
                    btnCondition.Enabled = false;

                    txtBorrowedDate.Enabled = true;
                    btnBorrow.Enabled = true;
                    break;

            }

        }

        private void txtBorrowedDate_Validated(object sender, EventArgs e)
        {
            DateTime dueDate = DateTime.ParseExact(txtBorrowedDate.Text, "dd/MM/yyyy", null).AddDays(14);
            txtDueDate.Text = dueDate.ToString("dd/MM/yyyy");

        }

        private void txtBorrowedDate_Validating(object sender, CancelEventArgs e)
        {
            try
            {
                DateTime.ParseExact(txtBorrowedDate.Text, "dd/MM/yyyy", null);
                e.Cancel = false;
            }
            catch
            {
                MessageBox.Show("Format of date is not valid!");
                txtBorrowedDate.Focus();
                e.Cancel = true;
            }

        }
    }
}

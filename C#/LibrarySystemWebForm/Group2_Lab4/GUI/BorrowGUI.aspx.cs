using Group2_Lab4.DAL;
using Group2_Lab4.DTL;
using System;
using System.Collections.Generic;
using System.Data;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Group2_Lab4.GUI
{
    public partial class BorrowGUI : System.Web.UI.Page
    {
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
        protected void Page_Load(object sender, EventArgs e)
        {
            lblError.Text = "";
            if (!IsPostBack)
            {
                Calendar1.SelectedDate = DateTime.Now.Date;
                txtDueDate.Text = DateTime.Now.AddDays(14).ToString("dd/MM/yyyy");
                displayButtons(1);
            }

        }
        private void View()
        {
            DataTable dt = CirculatedCopyDAO.GetBorrowedCopies(int.Parse(txtBorrowerNumber.Text));
            GridView1.DataSource = dt;
            GridView1.DataBind();
            lblNumberBorrowedCopied.Text = dt.Rows.Count.ToString();

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

                    Calendar1.Enabled = false;
                    btnBorrow.Enabled = false;
                    break;
                // to check condition
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    txtCopyNumber.Enabled = true;
                    btnCondition.Enabled = true;

                    Calendar1.Enabled = false;
                    btnBorrow.Enabled = false;
                    break;
                // to borrow
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    txtCopyNumber.Enabled = false;
                    btnCondition.Enabled = false;

                    Calendar1.Enabled = true;
                    btnBorrow.Enabled = true;
                    break;

            }

        }

        protected void btnMember_Click(object sender, EventArgs e)
        {
            int borrowerNumber;
            try
            {
                borrowerNumber = int.Parse(txtBorrowerNumber.Text);
            }
            catch
            {
                lblError.Text = "Borrower number must be a integer!";
                txtBorrowerNumber.Focus();
                return;
            }
            //create in DAO
            Borrower b = BorrowerDAO.GetBorrower(borrowerNumber);
            if (b == null)
            {
                lblError.Text = String.Format("Borrower number {0} does't exist!", borrowerNumber);
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;

            View();

            int n = GridView1.Rows.Count;

            if (GridView1.Rows.Count >= 5)
            {
                lblError.Text = "You borrowed 5 books, so you can't borrow any more!";
                txtBorrowerNumber.Focus();
                return;
            }

            displayButtons(2);

            r = null;
            c = null;

        }

        protected void btnCondition_Click(object sender, EventArgs e)
        {
            int copyNumber;
            try
            {
                copyNumber = int.Parse(txtCopyNumber.Text);
            }
            catch
            {
                lblError.Text = "Copy number must be a integer!";
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
                lblError.Text = str;
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

        private void borrow(CirculatedCopy cc, Copy c, Reservation r)
        {
            // Insert borrow record
            if (cc == null) return;
            CirculatedCopyDAO.Insert(cc);

            // update type = 'B' at Copy
            c = CopyDAO.GetCopy(Int32.Parse(txtCopyNumber.Text));
            c.Type = 'B';
            CopyDAO.Update(c);


            // update status = 'A' at Reservation
            if (r == null) return;
            r.Status = 'A';
            ReserveDAO.Update(r);


        }

        protected void btnBorrow_Click(object sender, EventArgs e)
        {
            CirculatedCopy cc = new CirculatedCopy(int.Parse(txtCopyNumber.Text), int.Parse(txtBorrowerNumber.Text),
                Convert.ToDateTime(Calendar1.SelectedDate.ToString()), DateTime.ParseExact(txtDueDate.Text, "dd/MM/yyyy", null));

            borrow(cc, c, r);

            View();
            displayButtons(1);
        }

        protected void Calendar1_SelectionChanged(object sender, EventArgs e)
        {
            txtDueDate.Text = Calendar1.SelectedDate.AddDays(14).ToString("dd/MM/yyyy");
        }
    }
}
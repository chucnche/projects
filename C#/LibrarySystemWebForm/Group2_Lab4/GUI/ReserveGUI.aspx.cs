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
    public partial class ReserveGUI : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblError.Text = "";
            if (!IsPostBack)
            {
                Calendar1.SelectedDate = DateTime.Now.Date;
                displayButtons(1);
            }
        }
        private void View()
        {
            DataTable dt = ReserveDAO.GetReservation(int.Parse(txtBorrowerNumber.Text));
            GridView1.DataSource = dt;
            GridView1.DataBind();
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

                    btnCondition.Enabled = false;

                    txtBookNumber.Enabled = false;
                    Calendar1.Enabled = false;
                    btnReserve.Enabled = false;
                    break;
                // to Confirm fine
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    btnCondition.Enabled = true;

                    txtBookNumber.Enabled = true;
                    Calendar1.Enabled = false;
                    btnReserve.Enabled = false;

                    break;
                // to Return
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    btnCondition.Enabled = false;
                    txtBookNumber.Enabled = false;
                    Calendar1.Enabled = false;
                    btnReserve.Enabled = true;
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
                lblError.Text="Borrower number must be a integer!";
                txtBorrowerNumber.Focus();
                return;
            }
            Borrower b = BorrowerDAO.GetBorrower(borrowerNumber);
            if (b == null)
            {
                lblError.Text = String.Format("Borrower number {0} does't exist!", borrowerNumber);
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;


            View();
            if (lblNumberReservedBooks.Text == "0")
                displayButtons(2);
            else
            {
                displayButtons(1);
            }
        }

        protected void btnCondition_Click(object sender, EventArgs e)
        {
            int bookNumber;
            try
            {
                bookNumber = int.Parse(txtBookNumber.Text);
            }
            catch
            {
                lblError.Text = "Borrower number must be a integer!";
                txtBorrowerNumber.Focus();
                return;
            }
            Book b = BookDAO.GetBook(bookNumber);
            if (b == null)
            {
                lblError.Text = String.Format("Booknumber {0} does't exist!", bookNumber);
                txtBorrowerNumber.Focus();
                return;
            }

            if (CopyDAO.GetCopyByBookNumber(bookNumber) == null)
            {
                displayButtons(3);
                txtTitle.Text = b.Title;

            }

            else
            {
                displayButtons(2);
            }
        }

        protected void btnReserve_Click(object sender, EventArgs e)
        {
            Reservation re = new Reservation();
            re.BorrowerNumber = int.Parse(txtBorrowerNumber.Text);
            re.BookNumber = int.Parse(txtBookNumber.Text);
            re.Date = Convert.ToDateTime(Calendar1.SelectedDate.ToString());
            re.Status = 'R';
            ReserveDAO.Insert(re);
            View();
            txtBookNumber.Text = "";
            displayButtons(1);
        }
    }
}
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
    public partial class ReturnGUI : System.Web.UI.Page
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
                
                txtBorrowerNumber.Focus();
                return;
            }
            txtName.Text = b.Name;
            View();
            displayButtons(2);
        }
        private void View()
        {

            DataTable dt = CirculatedCopyDAO.GetBorrowedCopies(int.Parse(txtBorrowerNumber.Text));
            GridView1.DataSource = dt;
            GridView1.DataBind();
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

                    btnFine.Enabled = false;
                    Calendar1.Enabled = false;
                    btnReturn.Enabled = false;
                    break;
                // to Confirm fine
                case 2:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    btnFine.Enabled = true;

                    Calendar1.Enabled = true;
                    btnReturn.Enabled = false;

                    break;
                // to Return
                case 3:
                    txtBorrowerNumber.Enabled = false;
                    btnMember.Enabled = false;

                    btnFine.Enabled = false;

                    Calendar1.Enabled = true;
                    btnReturn.Enabled = true;
                    break;

            }

        }

        protected void btnFine_Click(object sender, EventArgs e)
        {
            try
            {
                double fine = 0;
                if (Convert.ToDateTime(Calendar1.SelectedDate.ToString()) > Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text))
                    fine += (int)(Convert.ToDateTime(Calendar1.SelectedDate.ToString()) - Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text)).TotalDays;
                txtFineAmount.Text = fine.ToString("C2");
                displayButtons(3);
            }
            catch (Exception ex)
            {
                lblError.Text = "Error";
                return;
            }

        }

        protected void btnFine_Click1(object sender, EventArgs e)
        {

        }

        protected void btnReturn_Click(object sender, EventArgs e)
        {
            CirculatedCopy cc;

                double  fine = 0;
                if (Convert.ToDateTime(Calendar1.SelectedDate.ToString()) > Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text))
                    fine = (int)(Convert.ToDateTime(Calendar1.SelectedDate.ToString()) - Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text)).TotalDays;

            cc = new CirculatedCopy(int.Parse(GridView1.SelectedRow.Cells[2].Text), int.Parse(GridView1.SelectedRow.Cells[3].Text),
                    Convert.ToDateTime(GridView1.SelectedRow.Cells[4].Text), Convert.ToDateTime(GridView1.SelectedRow.Cells[5].Text));
                cc.Id = int.Parse(GridView1.SelectedRow.Cells[1].Text);
            cc.ReturnedDate = Convert.ToDateTime(Calendar1.SelectedDate.ToString());
                cc.FineAmount = fine;

                Return(cc);

            View();
            txtFineAmount.Text = "";
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
    }
}
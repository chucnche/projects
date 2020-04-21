using Group2_Lab4.DAL;
using Group2_Lab4.DTL;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;

namespace Group2_Lab4.GUI
{
    public partial class BorrowerGUI : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {
            lblError.Text = "";
            if (!IsPostBack)
            {

                displayButtons(1);
            }
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            HttpContext.Current.Session["add"] = 1;
            displayButtons(2);
        }
        private void displayButtons(int state)
        {
            switch (state)
            {
                // allow to filter/Add/Edit/Delete borrower
                case 1:
                    txtName.Enabled = false;
                    txtSex.Enabled = false;
                    txtAddress.Enabled = false;
                    txtTelephone.Enabled = false;
                    txtEmail.Enabled = false;



                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;
                    btnCancel.Enabled = false;
                    btnSave.Enabled = false;
                    break;

                // Allow to add a borrower
                case 2:
                    txtName.Enabled = true;
                    txtSex.Enabled = true;
                    txtAddress.Enabled = true;
                    txtTelephone.Enabled = true;
                    txtEmail.Enabled = true;

                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnCancel.Enabled = true;
                    btnSave.Enabled = true;
                    break;

                // Allow to edit a borrower
                case 3:
                    txtName.Enabled = true;
                    txtSex.Enabled = true;
                    txtAddress.Enabled = true;
                    txtTelephone.Enabled = true;
                    txtEmail.Enabled = true;

                    btnAdd.Enabled = false;
                    btnEdit.Enabled = false;
                    btnCancel.Enabled = true;
                    btnSave.Enabled = true;
                    break;

            }
        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            if (GridView1.SelectedRow == null)
            {
                lblError.Text = "Error: No member is selected!";
                return;
            }
            HttpContext.Current.Session["add"] = 2;
            displayButtons(2);
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            int add = (int)Session["add"];
            Borrower b = new Borrower();
            b.Name = txtName.Text;
            b.Sex = char.Parse(txtSex.Text);
            b.Address = txtAddress.Text;
            b.Telephone = txtTelephone.Text;
            b.Email = txtEmail.Text;
            if (add == 1)
            {
                b.BorrowerNumber = BorrowerDAO.GetBorrowerNumberMax() + 1;
                BorrowerDAO.Insert(b);
            }
            else if (add == 2)
            {
                b.BorrowerNumber = Int32.Parse(GridView1.SelectedRow.Cells[1].Text);
                BorrowerDAO.Update(b);
            }
            displayButtons(1);
            ObjectDataSource1.Select();
            GridView1.DataBind();
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            displayButtons(1);
        }

        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            txtName.Text = GridView1.SelectedRow.Cells[2].Text;
            txtSex.Text = GridView1.SelectedRow.Cells[3].Text;
            txtAddress.Text = GridView1.SelectedRow.Cells[4].Text;
            txtTelephone.Text = GridView1.SelectedRow.Cells[5].Text;
            txtEmail.Text = GridView1.SelectedRow.Cells[6].Text;
        }

        protected void GridView1_DataBound(object sender, EventArgs e)
        {
            lblNumberMembers.Text = GridView1.Rows.Count.ToString();
        }
    }
}
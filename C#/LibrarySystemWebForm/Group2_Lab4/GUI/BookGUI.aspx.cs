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
    public partial class BookGUI : System.Web.UI.Page
    {
        protected void Page_Load(object sender, EventArgs e)
        {

            lblError.Text = "";
            if (!IsPostBack)
            {

                displayButtons(1);
            }
        }
        private void displayButtons(int state)
        {
            switch (state)
            {
                // allow to filter/Add/Edit/Delete book
                case 1:
                    txtTitle.Enabled = true;
                    txtTitle1.Enabled = false;
                    txtAuthors.Enabled = false;
                    txtPublisher.Enabled = false;


                    btnAdd.Enabled = true;
                    btnEdit.Enabled = true;
                    btnSave.Enabled = false;
                    btnCancel.Enabled = false;
                    break;

                // Allow to add a book
                case 2:
                    txtTitle.Enabled = false;
                    txtTitle1.Enabled = true;
                    txtAuthors.Enabled = true;
                    txtPublisher.Enabled = true;
                    btnSave.Enabled = true;
                    btnCancel.Enabled = true;
                    break;

                // Allow to edit a book
                case 3:

                    txtTitle.Enabled = false;
                    txtTitle1.Enabled = true;
                    txtAuthors.Enabled = true;
                    txtPublisher.Enabled = true;
                    btnSave.Enabled = true;
                    btnCancel.Enabled = true;
                    break;

            }
        }
        protected void GridView1_SelectedIndexChanged(object sender, EventArgs e)
        {
            txtTitle.Text = GridView1.SelectedRow.Cells[2].Text;
            txtTitle1.Text = GridView1.SelectedRow.Cells[2].Text;
            txtAuthors.Text = GridView1.SelectedRow.Cells[3].Text;
            txtPublisher.Text = GridView1.SelectedRow.Cells[4].Text;
        }

        protected void GridView1_DataBound(object sender, EventArgs e)
        {
            lblNoRows.Text = GridView1.Rows.Count.ToString();
        }

        protected void btnAdd_Click(object sender, EventArgs e)
        {
            HttpContext.Current.Session["add"] = 1;
            RequiredFieldValidator1.Enabled = true;
            displayButtons(2);
        }

        protected void btnEdit_Click(object sender, EventArgs e)
        {
            if (GridView1.SelectedRow == null)
            {
                lblError.Text = "Error: No book is selected!";
                return;
            }
            HttpContext.Current.Session["add"] = 2;
            displayButtons(2);

        }

        protected void btnCopies_Click(object sender, EventArgs e)
        {
            if (GridView1.SelectedRow != null)
            {
                Book b = new Book();
                b.BookNumber = Int32.Parse(GridView1.SelectedRow.Cells[1].Text);
                b.Title = GridView1.SelectedRow.Cells[2].Text;
                b.Authors = GridView1.SelectedRow.Cells[3].Text;
                b.Publisher = GridView1.SelectedRow.Cells[4].Text;
                HttpContext.Current.Session["book"] = GridView1.SelectedRow;
                Response.Redirect("CopyGUI.aspx");
            }
            else
            {
                lblError.Text = "Error: No book is selected!";
            }
        }

        protected void btnSave_Click(object sender, EventArgs e)
        {
            int add = (int)Session["add"];
            Book b = new Book();
           
            b.Title = txtTitle1.Text;
            b.Authors = txtAuthors.Text;
            b.Publisher = txtPublisher.Text;
            if (add == 1)
            {
                b.BookNumber = BookDAO.GetBookNumberMax() + 1;
                BookDAO.Insert(b);
            }
            else if (add == 2)
            {
                b.BookNumber = Int32.Parse(GridView1.SelectedRow.Cells[1].Text);
                BookDAO.Update(b);
            }
            displayButtons(1);
            RequiredFieldValidator1.Enabled = false;
            ObjectDataSource1.Select();
            GridView1.DataBind();
        }

        protected void btnCancel_Click(object sender, EventArgs e)
        {
            displayButtons(1);
        }

        protected void btnFilter_Click(object sender, EventArgs e)
        {
            ObjectDataSource1.FilterExpression = "title like '%{0}%'";
            ObjectDataSource1.FilterParameters.Clear();
            ObjectDataSource1.FilterParameters.Add("p1", txtTitle.Text);

        }



        protected void GridView1_RowDeleted(object sender, GridViewDeletedEventArgs e)
        {
            if (e.ExceptionHandled == false)
            {
                lblError.Text = "Delete Book Failed";
            }
        }

        protected void GridView1_RowUpdated(object sender, GridViewUpdatedEventArgs e)
        {
            if (e.ExceptionHandled == false)
            {
                lblError.Text = "Edit Book Failed";
            }
        }
    }
}
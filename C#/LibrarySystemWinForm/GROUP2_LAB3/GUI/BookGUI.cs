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
    public partial class BookGUI : Form
    {
        DataView dv, dvc;
        Book b;
        Copy c;

        public BookGUI()
        {
            InitializeComponent();
            View();
            displayButtons(1);

            displayCopyButtons(1);


        }
        private void View()
        {
            DataTable dt = BookDAO.GetDataTable();
            dv = new DataView(dt);
            dataGridView1.DataSource = dv;
        }
        private void label2_Click(object sender, EventArgs e)
        {

        }

        private void btnFilter_Click(object sender, EventArgs e)
        {
            int bookNumber;
            try
            {
                bookNumber = int.Parse(txtBookNumber.Text);
            }
            catch
            {
                MessageBox.Show("Book number must be integer (empty for all books)!");
                if (txtBookNumber.Text != "") return;
                else bookNumber = -1;
            }

            if (bookNumber > -1) dv.RowFilter = "bookNumber = " + bookNumber.ToString();


        }

        private void btnAdd_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Add")
            {
                b = new Book(BookDAO.GetBookNumberMax() + 1, "", "", "");
                displayBook();

                displayButtons(2);
            }
            else
            {
                b.Title = txtTitle.Text;
                b.Authors = txtAuthors.Text;
                b.Publisher = txtPublisher.Text;

                BookDAO.Insert(b);

                View();

                displayButtons(1);
            }

        }
        private void displayButtons(int state)
        {
            switch (state)
            {
                // allow to filter/Add/Edit/Delete book
                case 1:
                    txtBookNumber.Enabled = true;
                    txtBookNumber.Focus();

                    txtTitle.Enabled = false;
                    txtAuthors.Enabled = false;
                    txtPublisher.Enabled = false;


                    btnFilter.Enabled = true;

                    btnAdd.Text = "Add";
                    btnAdd.Enabled = true;

                    btnEdit.Text = "Edit";
                    btnEdit.Enabled = true;

                    btnDelete.Enabled = true;
                    break;

                // Allow to add a book
                case 2:
                    txtBookNumber.Enabled = false;
                    txtTitle.Enabled = true;
                    txtAuthors.Enabled = true;
                    txtPublisher.Enabled = true;
                    txtTitle.Focus();

                    btnAdd.Text = "Save";
                    btnAdd.Enabled = true;

                    btnFilter.Enabled = false;
                    btnEdit.Enabled = false;
                    btnDelete.Enabled = false;

                    break;

                // Allow to edit a book
                case 3:

                    txtBookNumber.Enabled = false;
                    txtTitle.Enabled = true;
                    txtAuthors.Enabled = true;
                    txtPublisher.Enabled = true;
                    txtTitle.Focus();

                    btnEdit.Text = "Save";
                    btnEdit.Enabled = true;

                    btnFilter.Enabled = false;
                    btnAdd.Enabled = false;
                    btnDelete.Enabled = false;
                    break;

            }
        }

        private void btnEdit_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Edit")
            {
                if (!isSelected()) return;

                txtBookNumber.Text = dataGridView1.SelectedRows[0].Cells["bookNumber"].Value.ToString();

                txtTitle.Text = dataGridView1.SelectedRows[0].Cells["title"].Value.ToString();
                txtAuthors.Text = dataGridView1.SelectedRows[0].Cells["authors"].Value.ToString();
                txtPublisher.Text = dataGridView1.SelectedRows[0].Cells["publisher"].Value.ToString();

                displayButtons(3);

            }
            else
            {
                b = new Book(int.Parse(txtBookNumber.Text), txtTitle.Text, txtAuthors.Text, txtPublisher.Text);
                BookDAO.Update(b);

                // Update in DataTable
                DataTable dt = dv.Table;
                DataRow[] result = dt.Select("bookNumber = " + b.BookNumber);
                DataRow row = result[0];
                row["title"] = b.Title;
                row["authors"] = b.Authors;
                row["publisher"] = b.Publisher;
                dv.RowFilter = "";

                displayButtons(1);
            }

        }

        private void btnDelete_Click(object sender, EventArgs e)
        {
            if (!isSelected()) return;

            int bookNumber = (int)dataGridView1.SelectedRows[0].Cells["bookNumber"].Value;
            DialogResult dr = MessageBox.Show(String.Format("Do you want to delete this book number {0}?", bookNumber), "Confirm deteting", MessageBoxButtons.YesNo);
            if (dr == DialogResult.No) return;
            BookDAO.Delete(bookNumber);
            View();

        }

        private void displayBook()
        {
            txtBookNumber.Text = b.BookNumber.ToString();
            txtTitle.Text = b.Title;
            txtPublisher.Text = b.Publisher;
            txtAuthors.Text = b.Authors;
        }
        private bool isSelected()
        {
            if (dataGridView1.SelectedRows.Count == 0)
            {
                MessageBox.Show("You must select a book in the list of books!");
                return false;
            }
            if (dataGridView1.SelectedRows[0].Cells["bookNumber"].Value == null)
            {
                MessageBox.Show("You must select a book in the list of books!");
                return false;
            }
            return true;
        }
        private void ViewCopies()
        {
            if (dataGridView1.SelectedRows.Count == 0) return;
            int bookNumber = (int)dataGridView1.SelectedRows[0].Cells["bookNumber"].Value;
            txtCopyBookNumber.Text = bookNumber.ToString();
            dvc = new DataView(CopyDAO.GetDataTable());
            dvc.RowFilter = "bookNumber = " + bookNumber;
            dataGridView2.DataSource = dvc;
        }

        private bool isCopySelected()
        {
            if (dataGridView2.SelectedRows.Count == 0)
            {
                MessageBox.Show("You must select a copy in the list of copies!");
                return false;
            }
            if (dataGridView2.SelectedRows[0].Cells["copyNumber"].Value == null)
            {
                MessageBox.Show("You must select a copy in the list of copies!");
                return false;
            }
            return true;
        }
        private void displayCopyButtons(int stateCopy)
        {
            switch (stateCopy)
            {
                // Allow to Add/Edit/delete copy
                case 1:
                    txtCopyBookNumber.Enabled = false;
                    txtCopyNumber.Enabled = false;
                    txtSequenceNumber.Enabled = false;
                    txtType.Enabled = false;
                    txtPrice.Enabled = false;

                    btnCopyDelete.Enabled = true;

                    btnCopyAdd.Text = "Add";
                    btnCopyAdd.Enabled = true;

                    btnCopyEdit.Text = "Edit";
                    btnCopyEdit.Enabled = true;
                    break;

                // Allow to add a copy
                case 2:
                    txtCopyBookNumber.Enabled = false;
                    txtCopyNumber.Enabled = false;
                    txtSequenceNumber.Enabled = false;
                    txtType.Enabled = true;
                    txtPrice.Enabled = true;
                    txtPrice.Focus();

                    btnCopyAdd.Text = "Save";
                    btnCopyAdd.Enabled = true;

                    btnCopyEdit.Text = "Edit";
                    btnCopyEdit.Enabled = false;

                    btnCopyDelete.Enabled = false;

                    break;
                // Allow to edit a copy
                case 3:
                    txtCopyBookNumber.Enabled = false;
                    txtCopyNumber.Enabled = false;
                    txtSequenceNumber.Enabled = false;
                    txtType.Enabled = true;
                    txtPrice.Enabled = true;
                    txtPrice.Focus();

                    btnCopyAdd.Text = "Add";
                    btnCopyAdd.Enabled = false;

                    btnCopyEdit.Text = "Save";
                    btnCopyEdit.Enabled = true;

                    btnCopyDelete.Enabled = false;

                    break;

            }
        }

        private void btnCopyAdd_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Add")
            {
                if (!isSelected()) return;
                txtCopyBookNumber.Text = dataGridView1.SelectedRows[0].Cells["bookNumber"].Value.ToString();
                c = new Copy(int.Parse(txtCopyBookNumber.Text), CopyDAO.GetCopyNumberMax() + 1, CopyDAO.GetSequenceNumberMax(int.Parse(txtCopyBookNumber.Text)) + 1, 'A', 0);
                displayCopy();

                displayCopyButtons(2);

            }
            else
            {
                c.Price = double.Parse(txtPrice.Text);
                CopyDAO.Insert(c);

                ViewCopies();

                displayCopyButtons(1);


            }

        }

        private void btnCopyEdit_Click(object sender, EventArgs e)
        {
            Button btn = (Button)sender;
            if (btn.Text == "Edit")
            {
                if (!isCopySelected()) return;

                if (txtType.Text[0] == 'B')
                {
                    MessageBox.Show("Can't edit borrowed copy!");
                    return;
                }

                displayCopyButtons(3);
            }
            else
            {
                c = new Copy(int.Parse(txtCopyBookNumber.Text), int.Parse(txtCopyNumber.Text), int.Parse(txtSequenceNumber.Text), txtType.Text[0], double.Parse(txtPrice.Text));

                CopyDAO.Update(c);

                ViewCopies();

                displayCopyButtons(1);
            }

        }

        private void btnCopyDelete_Click(object sender, EventArgs e)
        {

            if (!isCopySelected()) return;

            int copyNumber = (int)dataGridView2.SelectedRows[0].Cells["copyNumber"].Value;
            DialogResult dr = MessageBox.Show(String.Format("Do you want to delete this copy number {0}?", copyNumber), "Confirm deteting", MessageBoxButtons.YesNo);
            if (dr == DialogResult.No) return;
            CopyDAO.Delete(copyNumber);

            ViewCopies();

        }

        private void dataGridView1_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;

            txtBookNumber.Text = dataGridView1.Rows[e.RowIndex].Cells["bookNumber"].Value.ToString();
            txtCopyBookNumber.Text = txtBookNumber.Text;
            txtTitle.Text = dataGridView1.Rows[e.RowIndex].Cells["title"].Value.ToString();
            txtAuthors.Text = dataGridView1.Rows[e.RowIndex].Cells["authors"].Value.ToString();
            txtPublisher.Text = dataGridView1.Rows[e.RowIndex].Cells["publisher"].Value.ToString();

            ViewCopies();

        }

        private void dataGridView2_CellClick(object sender, DataGridViewCellEventArgs e)
        {
            if (e.RowIndex < 0) return;

            txtCopyBookNumber.Text = dataGridView2.Rows[e.RowIndex].Cells["bookNumber"].Value.ToString();
            txtCopyNumber.Text = dataGridView2.Rows[e.RowIndex].Cells["copyNumber"].Value.ToString();
            txtSequenceNumber.Text = dataGridView2.Rows[e.RowIndex].Cells["sequenceNumber"].Value.ToString();
            txtType.Text = dataGridView2.Rows[e.RowIndex].Cells["type"].Value.ToString();
            txtPrice.Text = dataGridView2.Rows[e.RowIndex].Cells["price"].Value.ToString();

        }

        private void txtType_Validating(object sender, CancelEventArgs e)
        {
            if (txtType.Text.Length == 0)
            {
                // Cancel the event and select the text to be corrected by the user.
                e.Cancel = true;
                txtType.Select(0, txtType.Text.Length);

                // Set the ErrorProvider error with the text to display.  
                this.errorProvider1.SetError(txtType, "Must be 'A' or 'R'");
                return;
            }
            if (txtType.Text[0] != 'A' && txtType.Text[0] != 'R')
            {
                // Cancel the event and select the text to be corrected by the user.
                e.Cancel = true;
                txtType.Select(0, txtType.Text.Length);

                // Set the ErrorProvider error with the text to display.  
                this.errorProvider1.SetError(txtType, "Must be 'A' or 'R'");
                return;
            }
            e.Cancel = false;

        }

        private void txtType_Validated(object sender, EventArgs e)
        {
            errorProvider1.SetError(txtType, "");
        }

        private void displayCopy()
        {
            txtCopyBookNumber.Text = c.BookNumber.ToString();
            txtCopyNumber.Text = c.CopyNumber.ToString();
            txtSequenceNumber.Text = c.SequenceNumber.ToString();
            txtType.Text = c.Type.ToString();
            txtPrice.Text = c.Price.ToString();
        }




    }
}

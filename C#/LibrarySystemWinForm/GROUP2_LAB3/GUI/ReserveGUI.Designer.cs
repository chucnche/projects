namespace GROUP2_LAB3.DAL
{
    partial class ReserveGUI
    {
        /// <summary>
        /// Required designer variable.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Clean up any resources being used.
        /// </summary>
        /// <param name="disposing">true if managed resources should be disposed; otherwise, false.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        /// <summary>
        /// Required method for Designer support - do not modify
        /// the contents of this method with the code editor.
        /// </summary>
        private void InitializeComponent()
        {
            this.lblNumberBorrowedBooks = new System.Windows.Forms.Label();
            this.label5 = new System.Windows.Forms.Label();
            this.btnReserve = new System.Windows.Forms.Button();
            this.txtDate = new System.Windows.Forms.TextBox();
            this.dataGridView1 = new System.Windows.Forms.DataGridView();
            this.btnMember = new System.Windows.Forms.Button();
            this.txtName = new System.Windows.Forms.TextBox();
            this.txtBorrowerNumber = new System.Windows.Forms.TextBox();
            this.label2 = new System.Windows.Forms.Label();
            this.label3 = new System.Windows.Forms.Label();
            this.label4 = new System.Windows.Forms.Label();
            this.txtBookNumber = new System.Windows.Forms.TextBox();
            this.lbl = new System.Windows.Forms.Label();
            this.btnCondition = new System.Windows.Forms.Button();
            this.lblNumberReservedBooks = new System.Windows.Forms.Label();
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).BeginInit();
            this.SuspendLayout();
            // 
            // lblNumberBorrowedBooks
            // 
            this.lblNumberBorrowedBooks.AutoSize = true;
            this.lblNumberBorrowedBooks.Location = new System.Drawing.Point(261, 119);
            this.lblNumberBorrowedBooks.Name = "lblNumberBorrowedBooks";
            this.lblNumberBorrowedBooks.Size = new System.Drawing.Size(0, 17);
            this.lblNumberBorrowedBooks.TabIndex = 55;
            // 
            // label5
            // 
            this.label5.AutoSize = true;
            this.label5.Location = new System.Drawing.Point(54, 119);
            this.label5.Name = "label5";
            this.label5.Size = new System.Drawing.Size(207, 17);
            this.label5.TabIndex = 54;
            this.label5.Text = "The number of reverved books:";
            // 
            // btnReserve
            // 
            this.btnReserve.Location = new System.Drawing.Point(755, 459);
            this.btnReserve.Name = "btnReserve";
            this.btnReserve.Size = new System.Drawing.Size(199, 23);
            this.btnReserve.TabIndex = 52;
            this.btnReserve.Text = "Reserve";
            this.btnReserve.UseVisualStyleBackColor = true;
            this.btnReserve.Click += new System.EventHandler(this.btnReserve_Click);
            // 
            // txtDate
            // 
            this.txtDate.Location = new System.Drawing.Point(545, 459);
            this.txtDate.Name = "txtDate";
            this.txtDate.Size = new System.Drawing.Size(148, 22);
            this.txtDate.TabIndex = 51;
            this.txtDate.TextChanged += new System.EventHandler(this.txtFineAmount_TextChanged);
            this.txtDate.Validating += new System.ComponentModel.CancelEventHandler(this.txtDate_Validating);
            // 
            // dataGridView1
            // 
            this.dataGridView1.AllowUserToAddRows = false;
            this.dataGridView1.AllowUserToDeleteRows = false;
            this.dataGridView1.ColumnHeadersHeightSizeMode = System.Windows.Forms.DataGridViewColumnHeadersHeightSizeMode.AutoSize;
            this.dataGridView1.Location = new System.Drawing.Point(57, 149);
            this.dataGridView1.Name = "dataGridView1";
            this.dataGridView1.ReadOnly = true;
            this.dataGridView1.RowHeadersWidth = 51;
            this.dataGridView1.RowTemplate.Height = 24;
            this.dataGridView1.Size = new System.Drawing.Size(897, 276);
            this.dataGridView1.TabIndex = 47;
            // 
            // btnMember
            // 
            this.btnMember.Location = new System.Drawing.Point(545, 42);
            this.btnMember.Name = "btnMember";
            this.btnMember.Size = new System.Drawing.Size(198, 23);
            this.btnMember.TabIndex = 46;
            this.btnMember.Text = "Check Member";
            this.btnMember.UseVisualStyleBackColor = true;
            this.btnMember.Click += new System.EventHandler(this.btnMember_Click);
            // 
            // txtName
            // 
            this.txtName.Location = new System.Drawing.Point(395, 43);
            this.txtName.Name = "txtName";
            this.txtName.Size = new System.Drawing.Size(130, 22);
            this.txtName.TabIndex = 45;
            // 
            // txtBorrowerNumber
            // 
            this.txtBorrowerNumber.Location = new System.Drawing.Point(195, 41);
            this.txtBorrowerNumber.Name = "txtBorrowerNumber";
            this.txtBorrowerNumber.Size = new System.Drawing.Size(130, 22);
            this.txtBorrowerNumber.TabIndex = 44;
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Location = new System.Drawing.Point(340, 43);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(49, 17);
            this.label2.TabIndex = 43;
            this.label2.Text = "Name:";
            // 
            // label3
            // 
            this.label3.AutoSize = true;
            this.label3.Location = new System.Drawing.Point(93, 41);
            this.label3.Name = "label3";
            this.label3.Size = new System.Drawing.Size(98, 17);
            this.label3.TabIndex = 42;
            this.label3.Text = "Member code:";
            // 
            // label4
            // 
            this.label4.AutoSize = true;
            this.label4.Location = new System.Drawing.Point(483, 462);
            this.label4.Name = "label4";
            this.label4.Size = new System.Drawing.Size(42, 17);
            this.label4.TabIndex = 50;
            this.label4.Text = "Date:";
            this.label4.Click += new System.EventHandler(this.label4_Click);
            // 
            // txtBookNumber
            // 
            this.txtBookNumber.Location = new System.Drawing.Point(195, 81);
            this.txtBookNumber.Name = "txtBookNumber";
            this.txtBookNumber.Size = new System.Drawing.Size(130, 22);
            this.txtBookNumber.TabIndex = 57;
            // 
            // lbl
            // 
            this.lbl.AutoSize = true;
            this.lbl.Location = new System.Drawing.Point(91, 81);
            this.lbl.Name = "lbl";
            this.lbl.Size = new System.Drawing.Size(98, 17);
            this.lbl.TabIndex = 58;
            this.lbl.Text = "Book Number:";
            // 
            // btnCondition
            // 
            this.btnCondition.Location = new System.Drawing.Point(510, 85);
            this.btnCondition.Name = "btnCondition";
            this.btnCondition.Size = new System.Drawing.Size(233, 23);
            this.btnCondition.TabIndex = 59;
            this.btnCondition.Text = "Check Reservation condition";
            this.btnCondition.UseVisualStyleBackColor = true;
            this.btnCondition.Click += new System.EventHandler(this.btnCondition_Click);
            // 
            // lblNumberReservedBooks
            // 
            this.lblNumberReservedBooks.AutoSize = true;
            this.lblNumberReservedBooks.Location = new System.Drawing.Point(264, 119);
            this.lblNumberReservedBooks.Name = "lblNumberReservedBooks";
            this.lblNumberReservedBooks.Size = new System.Drawing.Size(16, 17);
            this.lblNumberReservedBooks.TabIndex = 60;
            this.lblNumberReservedBooks.Text = "0";
            // 
            // ReserveGUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(8F, 16F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(1167, 579);
            this.Controls.Add(this.lblNumberReservedBooks);
            this.Controls.Add(this.btnCondition);
            this.Controls.Add(this.lbl);
            this.Controls.Add(this.txtBookNumber);
            this.Controls.Add(this.lblNumberBorrowedBooks);
            this.Controls.Add(this.label5);
            this.Controls.Add(this.btnReserve);
            this.Controls.Add(this.txtDate);
            this.Controls.Add(this.label4);
            this.Controls.Add(this.dataGridView1);
            this.Controls.Add(this.btnMember);
            this.Controls.Add(this.txtName);
            this.Controls.Add(this.txtBorrowerNumber);
            this.Controls.Add(this.label2);
            this.Controls.Add(this.label3);
            this.Name = "ReserveGUI";
            this.Text = "ReserveGUI";
            this.Load += new System.EventHandler(this.ReserveGUI_Load);
            ((System.ComponentModel.ISupportInitialize)(this.dataGridView1)).EndInit();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Label lblNumberBorrowedBooks;
        private System.Windows.Forms.Label label5;
        private System.Windows.Forms.Button btnReserve;
        private System.Windows.Forms.TextBox txtDate;
        private System.Windows.Forms.DataGridView dataGridView1;
        private System.Windows.Forms.Button btnMember;
        private System.Windows.Forms.TextBox txtName;
        private System.Windows.Forms.TextBox txtBorrowerNumber;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label3;
        private System.Windows.Forms.Label label4;
        private System.Windows.Forms.TextBox txtBookNumber;
        private System.Windows.Forms.Label lbl;
        private System.Windows.Forms.Button btnCondition;
        private System.Windows.Forms.Label lblNumberReservedBooks;
    }
}
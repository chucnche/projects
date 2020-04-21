namespace Group2_Project.GUI
{
    partial class StudentMainGUI
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
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.toolStripContainer1 = new System.Windows.Forms.ToolStripContainer();
            this.homeToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bookBedToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ElectricityWaterBillToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.PaymentHistoryToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.requestToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ViewRoomInforToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.logoutToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.menuStrip1.SuspendLayout();
            this.toolStripContainer1.ContentPanel.SuspendLayout();
            this.toolStripContainer1.SuspendLayout();
            this.SuspendLayout();
            // 
            // menuStrip1
            // 
            this.menuStrip1.Dock = System.Windows.Forms.DockStyle.None;
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(50, 50);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.homeToolStripMenuItem,
            this.bookBedToolStripMenuItem,
            this.ElectricityWaterBillToolStripMenuItem,
            this.PaymentHistoryToolStripMenuItem,
            this.requestToolStripMenuItem,
            this.ViewRoomInforToolStripMenuItem,
            this.logoutToolStripMenuItem});
            this.menuStrip1.Location = new System.Drawing.Point(7, 7);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(4, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(914, 58);
            this.menuStrip1.TabIndex = 1;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // toolStripContainer1
            // 
            // 
            // toolStripContainer1.ContentPanel
            // 
            this.toolStripContainer1.ContentPanel.Controls.Add(this.label2);
            this.toolStripContainer1.ContentPanel.Controls.Add(this.label1);
            this.toolStripContainer1.ContentPanel.Margin = new System.Windows.Forms.Padding(2);
            this.toolStripContainer1.ContentPanel.Size = new System.Drawing.Size(914, 353);
            this.toolStripContainer1.Location = new System.Drawing.Point(7, 67);
            this.toolStripContainer1.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.toolStripContainer1.Name = "toolStripContainer1";
            this.toolStripContainer1.Size = new System.Drawing.Size(914, 353);
            this.toolStripContainer1.TabIndex = 2;
            this.toolStripContainer1.Text = "toolStripContainer1";
            // 
            // homeToolStripMenuItem
            // 
            this.homeToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.Home;
            this.homeToolStripMenuItem.Name = "homeToolStripMenuItem";
            this.homeToolStripMenuItem.Size = new System.Drawing.Size(102, 54);
            this.homeToolStripMenuItem.Text = "Home";
            this.homeToolStripMenuItem.Click += new System.EventHandler(this.homeToolStripMenuItem_Click);
            // 
            // bookBedToolStripMenuItem
            // 
            this.bookBedToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.BookBed1;
            this.bookBedToolStripMenuItem.Name = "bookBedToolStripMenuItem";
            this.bookBedToolStripMenuItem.Size = new System.Drawing.Size(116, 54);
            this.bookBedToolStripMenuItem.Text = "BookBed";
            this.bookBedToolStripMenuItem.Click += new System.EventHandler(this.bookBedToolStripMenuItem_Click);
            // 
            // ElectricityWaterBillToolStripMenuItem
            // 
            this.ElectricityWaterBillToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.ElectricWater1;
            this.ElectricityWaterBillToolStripMenuItem.Name = "ElectricityWaterBillToolStripMenuItem";
            this.ElectricityWaterBillToolStripMenuItem.Size = new System.Drawing.Size(167, 54);
            this.ElectricityWaterBillToolStripMenuItem.Text = "ElectricityWaterBill";
            this.ElectricityWaterBillToolStripMenuItem.Click += new System.EventHandler(this.ElectricityWaterBillToolStripMenuItem_Click);
            // 
            // PaymentHistoryToolStripMenuItem
            // 
            this.PaymentHistoryToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.HistoryPayment;
            this.PaymentHistoryToolStripMenuItem.Name = "PaymentHistoryToolStripMenuItem";
            this.PaymentHistoryToolStripMenuItem.Size = new System.Drawing.Size(154, 54);
            this.PaymentHistoryToolStripMenuItem.Text = "PaymentHistory";
            this.PaymentHistoryToolStripMenuItem.Click += new System.EventHandler(this.PaymentHistoryToolStripMenuItem_Click);
            // 
            // requestToolStripMenuItem
            // 
            this.requestToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.Request;
            this.requestToolStripMenuItem.Name = "requestToolStripMenuItem";
            this.requestToolStripMenuItem.Size = new System.Drawing.Size(111, 54);
            this.requestToolStripMenuItem.Text = "Request";
            this.requestToolStripMenuItem.Click += new System.EventHandler(this.requestToolStripMenuItem_Click);
            // 
            // ViewRoomInforToolStripMenuItem
            // 
            this.ViewRoomInforToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.RoomInfo1;
            this.ViewRoomInforToolStripMenuItem.Name = "ViewRoomInforToolStripMenuItem";
            this.ViewRoomInforToolStripMenuItem.Size = new System.Drawing.Size(151, 54);
            this.ViewRoomInforToolStripMenuItem.Text = "ViewRoomInfor";
            this.ViewRoomInforToolStripMenuItem.Click += new System.EventHandler(this.ViewRoomInforToolStripMenuItem_Click);
            // 
            // logoutToolStripMenuItem
            // 
            this.logoutToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.Logout1;
            this.logoutToolStripMenuItem.Name = "logoutToolStripMenuItem";
            this.logoutToolStripMenuItem.Size = new System.Drawing.Size(107, 54);
            this.logoutToolStripMenuItem.Text = "Logout";
            this.logoutToolStripMenuItem.Click += new System.EventHandler(this.logoutToolStripMenuItem_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 26.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.Blue;
            this.label2.Location = new System.Drawing.Point(359, 203);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(226, 39);
            this.label2.TabIndex = 3;
            this.label2.Text = "Role: Student";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Tai Le", 27.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Blue;
            this.label1.Location = new System.Drawing.Point(197, 110);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(520, 47);
            this.label1.TabIndex = 2;
            this.label1.Text = "Welcome to Dormitory system";
            // 
            // StudentMainGUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(931, 429);
            this.Controls.Add(this.toolStripContainer1);
            this.Controls.Add(this.menuStrip1);
            this.Margin = new System.Windows.Forms.Padding(2, 2, 2, 2);
            this.Name = "StudentMainGUI";
            this.Text = "StudentMainGUI";
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.toolStripContainer1.ContentPanel.ResumeLayout(false);
            this.toolStripContainer1.ContentPanel.PerformLayout();
            this.toolStripContainer1.ResumeLayout(false);
            this.toolStripContainer1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem homeToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem bookBedToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ElectricityWaterBillToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem PaymentHistoryToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem requestToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ViewRoomInforToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem logoutToolStripMenuItem;
        private System.Windows.Forms.ToolStripContainer toolStripContainer1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
    }
}
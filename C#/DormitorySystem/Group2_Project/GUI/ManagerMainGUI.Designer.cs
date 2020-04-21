namespace Group2_Project.GUI
{
    partial class ManagerMainGUI
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
            this.toolStripContainer1 = new System.Windows.Forms.ToolStripContainer();
            this.menuStrip1 = new System.Windows.Forms.MenuStrip();
            this.viewRoomInfoToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.logoutToolStripMenuItem1 = new System.Windows.Forms.ToolStripMenuItem();
            this.studentToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.bookRequestToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.ElectricityWaterToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.studentRequestToolStripMenuItem = new System.Windows.Forms.ToolStripMenuItem();
            this.label2 = new System.Windows.Forms.Label();
            this.label1 = new System.Windows.Forms.Label();
            this.toolStripContainer1.ContentPanel.SuspendLayout();
            this.toolStripContainer1.SuspendLayout();
            this.menuStrip1.SuspendLayout();
            this.SuspendLayout();
            // 
            // toolStripContainer1
            // 
            // 
            // toolStripContainer1.ContentPanel
            // 
            this.toolStripContainer1.ContentPanel.Controls.Add(this.label2);
            this.toolStripContainer1.ContentPanel.Controls.Add(this.label1);
            this.toolStripContainer1.ContentPanel.Margin = new System.Windows.Forms.Padding(2);
            this.toolStripContainer1.ContentPanel.Size = new System.Drawing.Size(817, 423);
            this.toolStripContainer1.Location = new System.Drawing.Point(5, 67);
            this.toolStripContainer1.Margin = new System.Windows.Forms.Padding(2);
            this.toolStripContainer1.Name = "toolStripContainer1";
            this.toolStripContainer1.Size = new System.Drawing.Size(817, 423);
            this.toolStripContainer1.TabIndex = 4;
            this.toolStripContainer1.Text = "toolStripContainer1";
            // 
            // menuStrip1
            // 
            this.menuStrip1.Dock = System.Windows.Forms.DockStyle.None;
            this.menuStrip1.ImageScalingSize = new System.Drawing.Size(50, 50);
            this.menuStrip1.Items.AddRange(new System.Windows.Forms.ToolStripItem[] {
            this.studentToolStripMenuItem,
            this.bookRequestToolStripMenuItem,
            this.ElectricityWaterToolStripMenuItem,
            this.studentRequestToolStripMenuItem,
            this.viewRoomInfoToolStripMenuItem,
            this.logoutToolStripMenuItem1});
            this.menuStrip1.Location = new System.Drawing.Point(7, 7);
            this.menuStrip1.Name = "menuStrip1";
            this.menuStrip1.Padding = new System.Windows.Forms.Padding(4, 2, 0, 2);
            this.menuStrip1.Size = new System.Drawing.Size(815, 58);
            this.menuStrip1.TabIndex = 3;
            this.menuStrip1.Text = "menuStrip1";
            // 
            // viewRoomInfoToolStripMenuItem
            // 
            this.viewRoomInfoToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.RoomInfo;
            this.viewRoomInfoToolStripMenuItem.Name = "viewRoomInfoToolStripMenuItem";
            this.viewRoomInfoToolStripMenuItem.Size = new System.Drawing.Size(151, 54);
            this.viewRoomInfoToolStripMenuItem.Text = "ViewRoomInfor";
            this.viewRoomInfoToolStripMenuItem.Click += new System.EventHandler(this.viewRoomInfoToolStripMenuItem_Click);
            // 
            // logoutToolStripMenuItem1
            // 
            this.logoutToolStripMenuItem1.Image = global::Group2_Project.Properties.Resources.Logout;
            this.logoutToolStripMenuItem1.Name = "logoutToolStripMenuItem1";
            this.logoutToolStripMenuItem1.Size = new System.Drawing.Size(107, 54);
            this.logoutToolStripMenuItem1.Text = "Logout";
            this.logoutToolStripMenuItem1.Click += new System.EventHandler(this.logoutToolStripMenuItem1_Click);
            // 
            // studentToolStripMenuItem
            // 
            this.studentToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.ManagerStudent1;
            this.studentToolStripMenuItem.Name = "studentToolStripMenuItem";
            this.studentToolStripMenuItem.Size = new System.Drawing.Size(110, 54);
            this.studentToolStripMenuItem.Text = "Student";
            this.studentToolStripMenuItem.Click += new System.EventHandler(this.studentToolStripMenuItem_Click);
            // 
            // bookRequestToolStripMenuItem
            // 
            this.bookRequestToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.RequestBooking;
            this.bookRequestToolStripMenuItem.Name = "bookRequestToolStripMenuItem";
            this.bookRequestToolStripMenuItem.Size = new System.Drawing.Size(138, 54);
            this.bookRequestToolStripMenuItem.Text = "BookRequest";
            this.bookRequestToolStripMenuItem.Click += new System.EventHandler(this.bookRequestToolStripMenuItem_Click);
            // 
            // ElectricityWaterToolStripMenuItem
            // 
            this.ElectricityWaterToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.ElectricWater2;
            this.ElectricityWaterToolStripMenuItem.Name = "ElectricityWaterToolStripMenuItem";
            this.ElectricityWaterToolStripMenuItem.Size = new System.Drawing.Size(151, 54);
            this.ElectricityWaterToolStripMenuItem.Text = "ElectricityWater";
            this.ElectricityWaterToolStripMenuItem.Click += new System.EventHandler(this.ElectricityWaterToolStripMenuItem_Click);
            // 
            // studentRequestToolStripMenuItem
            // 
            this.studentRequestToolStripMenuItem.Image = global::Group2_Project.Properties.Resources.Request1;
            this.studentRequestToolStripMenuItem.Name = "studentRequestToolStripMenuItem";
            this.studentRequestToolStripMenuItem.Size = new System.Drawing.Size(152, 54);
            this.studentRequestToolStripMenuItem.Text = "StudentRequest";
            this.studentRequestToolStripMenuItem.Click += new System.EventHandler(this.studentRequestToolStripMenuItem_Click);
            // 
            // label2
            // 
            this.label2.AutoSize = true;
            this.label2.Font = new System.Drawing.Font("Microsoft Sans Serif", 26.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label2.ForeColor = System.Drawing.Color.Blue;
            this.label2.Location = new System.Drawing.Point(297, 238);
            this.label2.Name = "label2";
            this.label2.Size = new System.Drawing.Size(243, 39);
            this.label2.TabIndex = 3;
            this.label2.Text = "Role: Manager";
            // 
            // label1
            // 
            this.label1.AutoSize = true;
            this.label1.Font = new System.Drawing.Font("Microsoft Tai Le", 27.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.label1.ForeColor = System.Drawing.Color.Blue;
            this.label1.Location = new System.Drawing.Point(148, 145);
            this.label1.Name = "label1";
            this.label1.Size = new System.Drawing.Size(520, 47);
            this.label1.TabIndex = 2;
            this.label1.Text = "Welcome to Dormitory system";
            // 
            // ManagerMainGUI
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(837, 501);
            this.Controls.Add(this.toolStripContainer1);
            this.Controls.Add(this.menuStrip1);
            this.Margin = new System.Windows.Forms.Padding(2);
            this.Name = "ManagerMainGUI";
            this.Text = "ManagerMainGUI";
            this.toolStripContainer1.ContentPanel.ResumeLayout(false);
            this.toolStripContainer1.ContentPanel.PerformLayout();
            this.toolStripContainer1.ResumeLayout(false);
            this.toolStripContainer1.PerformLayout();
            this.menuStrip1.ResumeLayout(false);
            this.menuStrip1.PerformLayout();
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.ToolStripContainer toolStripContainer1;
        private System.Windows.Forms.MenuStrip menuStrip1;
        private System.Windows.Forms.ToolStripMenuItem studentToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem bookRequestToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem ElectricityWaterToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem studentRequestToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem viewRoomInfoToolStripMenuItem;
        private System.Windows.Forms.ToolStripMenuItem logoutToolStripMenuItem1;
        private System.Windows.Forms.Label label2;
        private System.Windows.Forms.Label label1;
    }
}
namespace WinFormsTabsDemo
{
    partial class Form1
    {
        private System.ComponentModel.IContainer components = null;
        private System.Windows.Forms.TabControl mainTabControl;
        private System.Windows.Forms.TabPage hesaplarTabPage;
        private System.Windows.Forms.TabControl hesaplarSubTabControl;
        private System.Windows.Forms.TabPage vadesizHesaplarimTabPage;
        private System.Windows.Forms.TabPage vadeliHesaplarimTabPage;
        private System.Windows.Forms.TabPage hesapAcilisiTabPage;

        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Windows Form Designer generated code

        private void InitializeComponent()
        {
            this.mainTabControl = new System.Windows.Forms.TabControl();
            this.hesaplarTabPage = new System.Windows.Forms.TabPage();
            this.hesaplarSubTabControl = new System.Windows.Forms.TabControl();
            this.vadesizHesaplarimTabPage = new System.Windows.Forms.TabPage();
            this.vadeliHesaplarimTabPage = new System.Windows.Forms.TabPage();
            this.hesapAcilisiTabPage = new System.Windows.Forms.TabPage();

            this.mainTabControl.SuspendLayout();
            this.hesaplarTabPage.SuspendLayout();
            this.hesaplarSubTabControl.SuspendLayout();
            this.SuspendLayout();

            // 
            // mainTabControl
            // 
            this.mainTabControl.Controls.Add(this.hesaplarTabPage);
            this.mainTabControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.mainTabControl.Location = new System.Drawing.Point(0, 0);
            this.mainTabControl.Name = "mainTabControl";
            this.mainTabControl.SelectedIndex = 0;
            this.mainTabControl.Size = new System.Drawing.Size(800, 450);
            this.mainTabControl.TabIndex = 0;

            // 
            // hesaplarTabPage
            // 
            this.hesaplarTabPage.Controls.Add(this.hesaplarSubTabControl);
            this.hesaplarTabPage.Location = new System.Drawing.Point(4, 24);
            this.hesaplarTabPage.Name = "hesaplarTabPage";
            this.hesaplarTabPage.Padding = new System.Windows.Forms.Padding(3);
            this.hesaplarTabPage.Size = new System.Drawing.Size(792, 422);
            this.hesaplarTabPage.TabIndex = 0;
            this.hesaplarTabPage.Text = "Hesaplar";
            this.hesaplarTabPage.UseVisualStyleBackColor = true;

            // 
            // hesaplarSubTabControl
            // 
            this.hesaplarSubTabControl.Controls.Add(this.vadesizHesaplarimTabPage);
            this.hesaplarSubTabControl.Controls.Add(this.vadeliHesaplarimTabPage);
            this.hesaplarSubTabControl.Controls.Add(this.hesapAcilisiTabPage);
            this.hesaplarSubTabControl.Dock = System.Windows.Forms.DockStyle.Fill;
            this.hesaplarSubTabControl.Location = new System.Drawing.Point(3, 3);
            this.hesaplarSubTabControl.Multiline = true;
            this.hesaplarSubTabControl.Name = "hesaplarSubTabControl";
            this.hesaplarSubTabControl.SelectedIndex = 0;
            this.hesaplarSubTabControl.Size = new System.Drawing.Size(786, 416);
            this.hesaplarSubTabControl.TabIndex = 0;

            // 
            // vadesizHesaplarimTabPage
            // 
            this.vadesizHesaplarimTabPage.Location = new System.Drawing.Point(4, 24);
            this.vadesizHesaplarimTabPage.Name = "vadesizHesaplarimTabPage";
            this.vadesizHesaplarimTabPage.Padding = new System.Windows.Forms.Padding(3);
            this.vadesizHesaplarimTabPage.Size = new System.Drawing.Size(778, 388);
            this.vadesizHesaplarimTabPage.TabIndex = 0;
            this.vadesizHesaplarimTabPage.Text = "Vadesiz Hesaplarım";
            this.vadesizHesaplarimTabPage.UseVisualStyleBackColor = true;

            // 
            // vadeliHesaplarimTabPage
            // 
            this.vadeliHesaplarimTabPage.Location = new System.Drawing.Point(4, 24);
            this.vadeliHesaplarimTabPage.Name = "vadeliHesaplarimTabPage";
            this.vadeliHesaplarimTabPage.Padding = new System.Windows.Forms.Padding(3);
            this.vadeliHesaplarimTabPage.Size = new System.Drawing.Size(778, 388);
            this.vadeliHesaplarimTabPage.TabIndex = 1;
            this.vadeliHesaplarimTabPage.Text = "Vadeli Hesaplarım";
            this.vadeliHesaplarimTabPage.UseVisualStyleBackColor = true;

            // 
            // hesapAcilisiTabPage
            // 
            this.hesapAcilisiTabPage.Location = new System.Drawing.Point(4, 24);
            this.hesapAcilisiTabPage.Name = "hesapAcilisiTabPage";
            this.hesapAcilisiTabPage.Padding = new System.Windows.Forms.Padding(3);
            this.hesapAcilisiTabPage.Size = new System.Drawing.Size(778, 388);
            this.hesapAcilisiTabPage.TabIndex = 2;
            this.hesapAcilisiTabPage.Text = "Hesap Açılışı";
            this.hesapAcilisiTabPage.UseVisualStyleBackColor = true;

            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(7F, 15F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(800, 450);
            this.Controls.Add(this.mainTabControl);
            this.Name = "Form1";
            this.Text = "Bankacılık Demo";

            this.mainTabControl.ResumeLayout(false);
            this.hesaplarTabPage.ResumeLayout(false);
            this.hesaplarSubTabControl.ResumeLayout(false);
            this.ResumeLayout(false);
        }

        #endregion
    }
}

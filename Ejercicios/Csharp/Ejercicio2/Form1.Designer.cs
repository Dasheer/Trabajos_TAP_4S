
namespace Ejercicio2
{
    partial class Form1
    {
        /// <summary>
        /// Variable del diseñador necesaria.
        /// </summary>
        private System.ComponentModel.IContainer components = null;

        /// <summary>
        /// Limpiar los recursos que se estén usando.
        /// </summary>
        /// <param name="disposing">true si los recursos administrados se deben desechar; false en caso contrario.</param>
        protected override void Dispose(bool disposing)
        {
            if (disposing && (components != null))
            {
                components.Dispose();
            }
            base.Dispose(disposing);
        }

        #region Código generado por el Diseñador de Windows Forms

        /// <summary>
        /// Método necesario para admitir el Diseñador. No se puede modificar
        /// el contenido de este método con el editor de código.
        /// </summary>
        private void InitializeComponent()
        {
            this.btn_toAcept = new System.Windows.Forms.Button();
            this.txtBox_writter = new System.Windows.Forms.TextBox();
            this.lbl_text = new System.Windows.Forms.Label();
            this.txt_output = new System.Windows.Forms.TextBox();
            this.btn_clear = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btn_toAcept
            // 
            this.btn_toAcept.BackColor = System.Drawing.SystemColors.Info;
            this.btn_toAcept.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btn_toAcept.Font = new System.Drawing.Font("Montserrat", 9.749999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_toAcept.Location = new System.Drawing.Point(394, 12);
            this.btn_toAcept.Name = "btn_toAcept";
            this.btn_toAcept.Size = new System.Drawing.Size(78, 27);
            this.btn_toAcept.TabIndex = 0;
            this.btn_toAcept.Text = "Aceptar";
            this.btn_toAcept.UseVisualStyleBackColor = false;
            this.btn_toAcept.Click += new System.EventHandler(this.button1_Click);
            // 
            // txtBox_writter
            // 
            this.txtBox_writter.Location = new System.Drawing.Point(149, 16);
            this.txtBox_writter.Name = "txtBox_writter";
            this.txtBox_writter.Size = new System.Drawing.Size(239, 20);
            this.txtBox_writter.TabIndex = 1;
            // 
            // lbl_text
            // 
            this.lbl_text.AutoSize = true;
            this.lbl_text.BackColor = System.Drawing.Color.Transparent;
            this.lbl_text.Cursor = System.Windows.Forms.Cursors.Default;
            this.lbl_text.Font = new System.Drawing.Font("Montserrat", 9.749999F, System.Drawing.FontStyle.Bold, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.lbl_text.Location = new System.Drawing.Point(12, 16);
            this.lbl_text.Name = "lbl_text";
            this.lbl_text.Size = new System.Drawing.Size(131, 18);
            this.lbl_text.TabIndex = 2;
            this.lbl_text.Text = "Introduzca texto";
            this.lbl_text.Click += new System.EventHandler(this.lbl_text_Click);
            // 
            // txt_output
            // 
            this.txt_output.Location = new System.Drawing.Point(12, 45);
            this.txt_output.Multiline = true;
            this.txt_output.Name = "txt_output";
            this.txt_output.Size = new System.Drawing.Size(460, 221);
            this.txt_output.TabIndex = 3;
            // 
            // btn_clear
            // 
            this.btn_clear.BackColor = System.Drawing.SystemColors.Info;
            this.btn_clear.Cursor = System.Windows.Forms.Cursors.Hand;
            this.btn_clear.Font = new System.Drawing.Font("Montserrat", 9.749999F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btn_clear.Location = new System.Drawing.Point(207, 272);
            this.btn_clear.Name = "btn_clear";
            this.btn_clear.Size = new System.Drawing.Size(78, 27);
            this.btn_clear.TabIndex = 4;
            this.btn_clear.Text = "Limpiar";
            this.btn_clear.UseVisualStyleBackColor = false;
            this.btn_clear.Click += new System.EventHandler(this.btn_clear_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(484, 311);
            this.Controls.Add(this.btn_clear);
            this.Controls.Add(this.txt_output);
            this.Controls.Add(this.lbl_text);
            this.Controls.Add(this.txtBox_writter);
            this.Controls.Add(this.btn_toAcept);
            this.Name = "Form1";
            this.Text = "Mi Ventana";
            this.Click += new System.EventHandler(this.button1_Click);
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.Button btn_toAcept;
        private System.Windows.Forms.TextBox txtBox_writter;
        private System.Windows.Forms.Label lbl_text;
        private System.Windows.Forms.TextBox txt_output;
        private System.Windows.Forms.Button btn_clear;
    }
}


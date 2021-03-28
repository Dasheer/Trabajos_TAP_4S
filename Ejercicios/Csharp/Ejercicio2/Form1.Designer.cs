
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
            this.btn_press = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // btn_press
            // 
            this.btn_press.BackColor = System.Drawing.SystemColors.Info;
            this.btn_press.Location = new System.Drawing.Point(160, 112);
            this.btn_press.Name = "btn_press";
            this.btn_press.Size = new System.Drawing.Size(156, 60);
            this.btn_press.TabIndex = 0;
            this.btn_press.Text = "Presioname";
            this.btn_press.UseVisualStyleBackColor = false;
            this.btn_press.Click += new System.EventHandler(this.button1_Click);
            // 
            // Form1
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.BackColor = System.Drawing.SystemColors.ActiveCaption;
            this.ClientSize = new System.Drawing.Size(484, 311);
            this.Controls.Add(this.btn_press);
            this.Name = "Form1";
            this.Text = "Form1";
            this.Click += new System.EventHandler(this.button1_Click);
            this.ResumeLayout(false);

        }

        #endregion

        private System.Windows.Forms.Button btn_press;
    }
}



namespace Calculadora
{
    partial class Calculadora
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
            this.txt = new System.Windows.Forms.TextBox();
            this.bntSeven = new System.Windows.Forms.Button();
            this.btnSix = new System.Windows.Forms.Button();
            this.btnThree = new System.Windows.Forms.Button();
            this.btnMulti = new System.Windows.Forms.Button();
            this.btnSum = new System.Windows.Forms.Button();
            this.btnSub = new System.Windows.Forms.Button();
            this.btnDivi = new System.Windows.Forms.Button();
            this.btnAc = new System.Windows.Forms.Button();
            this.btnSame = new System.Windows.Forms.Button();
            this.btnOne = new System.Windows.Forms.Button();
            this.btnFor = new System.Windows.Forms.Button();
            this.btnNine = new System.Windows.Forms.Button();
            this.btnZero = new System.Windows.Forms.Button();
            this.btnTwo = new System.Windows.Forms.Button();
            this.btnFive = new System.Windows.Forms.Button();
            this.btnEight = new System.Windows.Forms.Button();
            this.SuspendLayout();
            // 
            // txt
            // 
            this.txt.BackColor = System.Drawing.SystemColors.Window;
            this.txt.Font = new System.Drawing.Font("Tahoma", 15.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.txt.ForeColor = System.Drawing.SystemColors.WindowFrame;
            this.txt.Location = new System.Drawing.Point(13, 13);
            this.txt.Name = "txt";
            this.txt.ReadOnly = true;
            this.txt.Size = new System.Drawing.Size(459, 33);
            this.txt.TabIndex = 0;
            this.txt.Text = "1234567890....";
            // 
            // bntSeven
            // 
            this.bntSeven.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.bntSeven.Location = new System.Drawing.Point(13, 71);
            this.bntSeven.Name = "bntSeven";
            this.bntSeven.Size = new System.Drawing.Size(96, 49);
            this.bntSeven.TabIndex = 1;
            this.bntSeven.Text = "7";
            this.bntSeven.UseVisualStyleBackColor = true;
            this.bntSeven.Click += new System.EventHandler(this.bntSeven_Click);
            // 
            // btnSix
            // 
            this.btnSix.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSix.Location = new System.Drawing.Point(13, 142);
            this.btnSix.Name = "btnSix";
            this.btnSix.Size = new System.Drawing.Size(96, 48);
            this.btnSix.TabIndex = 2;
            this.btnSix.Text = "6";
            this.btnSix.UseVisualStyleBackColor = true;
            this.btnSix.Click += new System.EventHandler(this.btnSix_Click);
            // 
            // btnThree
            // 
            this.btnThree.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnThree.Location = new System.Drawing.Point(13, 213);
            this.btnThree.Name = "btnThree";
            this.btnThree.Size = new System.Drawing.Size(96, 48);
            this.btnThree.TabIndex = 3;
            this.btnThree.Text = "3";
            this.btnThree.UseVisualStyleBackColor = true;
            this.btnThree.Click += new System.EventHandler(this.btnThree_Click);
            // 
            // btnMulti
            // 
            this.btnMulti.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.btnMulti.Font = new System.Drawing.Font("Tahoma", 14.25F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnMulti.Location = new System.Drawing.Point(13, 288);
            this.btnMulti.Name = "btnMulti";
            this.btnMulti.Size = new System.Drawing.Size(96, 49);
            this.btnMulti.TabIndex = 4;
            this.btnMulti.Text = "*";
            this.btnMulti.UseVisualStyleBackColor = false;
            this.btnMulti.Click += new System.EventHandler(this.btnMulti_Click);
            // 
            // btnSum
            // 
            this.btnSum.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.btnSum.Font = new System.Drawing.Font("Tahoma", 9.75F);
            this.btnSum.Location = new System.Drawing.Point(376, 288);
            this.btnSum.Name = "btnSum";
            this.btnSum.Size = new System.Drawing.Size(96, 49);
            this.btnSum.TabIndex = 8;
            this.btnSum.Text = "+";
            this.btnSum.UseVisualStyleBackColor = false;
            this.btnSum.Click += new System.EventHandler(this.btnSum_Click);
            // 
            // btnSub
            // 
            this.btnSub.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.btnSub.Font = new System.Drawing.Font("Tahoma", 18F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSub.Location = new System.Drawing.Point(376, 213);
            this.btnSub.Name = "btnSub";
            this.btnSub.Size = new System.Drawing.Size(96, 48);
            this.btnSub.TabIndex = 7;
            this.btnSub.Text = "-";
            this.btnSub.UseVisualStyleBackColor = false;
            this.btnSub.Click += new System.EventHandler(this.btnSub_Click);
            // 
            // btnDivi
            // 
            this.btnDivi.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.btnDivi.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnDivi.Location = new System.Drawing.Point(376, 142);
            this.btnDivi.Name = "btnDivi";
            this.btnDivi.Size = new System.Drawing.Size(96, 48);
            this.btnDivi.TabIndex = 6;
            this.btnDivi.Text = "/";
            this.btnDivi.UseVisualStyleBackColor = false;
            this.btnDivi.Click += new System.EventHandler(this.btnDivi_Click);
            // 
            // btnAc
            // 
            this.btnAc.BackColor = System.Drawing.SystemColors.ScrollBar;
            this.btnAc.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnAc.Location = new System.Drawing.Point(376, 71);
            this.btnAc.Name = "btnAc";
            this.btnAc.Size = new System.Drawing.Size(96, 49);
            this.btnAc.TabIndex = 5;
            this.btnAc.Text = "AC";
            this.btnAc.UseVisualStyleBackColor = false;
            this.btnAc.Click += new System.EventHandler(this.btnAc_Click);
            // 
            // btnSame
            // 
            this.btnSame.BackColor = System.Drawing.SystemColors.Highlight;
            this.btnSame.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnSame.ForeColor = System.Drawing.SystemColors.ButtonFace;
            this.btnSame.Location = new System.Drawing.Point(254, 288);
            this.btnSame.Name = "btnSame";
            this.btnSame.Size = new System.Drawing.Size(96, 49);
            this.btnSame.TabIndex = 12;
            this.btnSame.Text = "=";
            this.btnSame.UseVisualStyleBackColor = false;
            this.btnSame.Click += new System.EventHandler(this.btnSame_Click);
            // 
            // btnOne
            // 
            this.btnOne.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnOne.Location = new System.Drawing.Point(254, 213);
            this.btnOne.Name = "btnOne";
            this.btnOne.Size = new System.Drawing.Size(96, 48);
            this.btnOne.TabIndex = 11;
            this.btnOne.Text = "1";
            this.btnOne.UseVisualStyleBackColor = true;
            this.btnOne.Click += new System.EventHandler(this.btnOne_Click);
            // 
            // btnFor
            // 
            this.btnFor.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnFor.Location = new System.Drawing.Point(254, 142);
            this.btnFor.Name = "btnFor";
            this.btnFor.Size = new System.Drawing.Size(96, 48);
            this.btnFor.TabIndex = 10;
            this.btnFor.Text = "4";
            this.btnFor.UseVisualStyleBackColor = true;
            this.btnFor.Click += new System.EventHandler(this.btnFor_Click);
            // 
            // btnNine
            // 
            this.btnNine.Location = new System.Drawing.Point(254, 71);
            this.btnNine.Name = "btnNine";
            this.btnNine.Size = new System.Drawing.Size(96, 49);
            this.btnNine.TabIndex = 9;
            this.btnNine.Text = "9";
            this.btnNine.UseVisualStyleBackColor = true;
            this.btnNine.Click += new System.EventHandler(this.btnNine_Click);
            // 
            // btnZero
            // 
            this.btnZero.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnZero.Location = new System.Drawing.Point(126, 288);
            this.btnZero.Name = "btnZero";
            this.btnZero.Size = new System.Drawing.Size(96, 49);
            this.btnZero.TabIndex = 16;
            this.btnZero.Text = "0";
            this.btnZero.UseVisualStyleBackColor = true;
            this.btnZero.Click += new System.EventHandler(this.btnZero_Click);
            // 
            // btnTwo
            // 
            this.btnTwo.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnTwo.Location = new System.Drawing.Point(126, 213);
            this.btnTwo.Name = "btnTwo";
            this.btnTwo.Size = new System.Drawing.Size(96, 48);
            this.btnTwo.TabIndex = 15;
            this.btnTwo.Text = "2";
            this.btnTwo.UseVisualStyleBackColor = true;
            this.btnTwo.Click += new System.EventHandler(this.btnTwo_Click);
            // 
            // btnFive
            // 
            this.btnFive.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnFive.Location = new System.Drawing.Point(126, 142);
            this.btnFive.Name = "btnFive";
            this.btnFive.Size = new System.Drawing.Size(96, 48);
            this.btnFive.TabIndex = 14;
            this.btnFive.Text = "5";
            this.btnFive.UseVisualStyleBackColor = true;
            this.btnFive.Click += new System.EventHandler(this.btnFive_Click);
            // 
            // btnEight
            // 
            this.btnEight.Font = new System.Drawing.Font("Tahoma", 9.75F, System.Drawing.FontStyle.Regular, System.Drawing.GraphicsUnit.Point, ((byte)(0)));
            this.btnEight.Location = new System.Drawing.Point(126, 71);
            this.btnEight.Name = "btnEight";
            this.btnEight.Size = new System.Drawing.Size(96, 49);
            this.btnEight.TabIndex = 13;
            this.btnEight.Text = "8";
            this.btnEight.UseVisualStyleBackColor = true;
            this.btnEight.Click += new System.EventHandler(this.btnEight_Click);
            // 
            // Calculadora
            // 
            this.AutoScaleDimensions = new System.Drawing.SizeF(6F, 13F);
            this.AutoScaleMode = System.Windows.Forms.AutoScaleMode.Font;
            this.ClientSize = new System.Drawing.Size(484, 361);
            this.Controls.Add(this.btnZero);
            this.Controls.Add(this.btnTwo);
            this.Controls.Add(this.btnFive);
            this.Controls.Add(this.btnEight);
            this.Controls.Add(this.btnSame);
            this.Controls.Add(this.btnOne);
            this.Controls.Add(this.btnFor);
            this.Controls.Add(this.btnNine);
            this.Controls.Add(this.btnSum);
            this.Controls.Add(this.btnSub);
            this.Controls.Add(this.btnDivi);
            this.Controls.Add(this.btnAc);
            this.Controls.Add(this.btnMulti);
            this.Controls.Add(this.btnThree);
            this.Controls.Add(this.btnSix);
            this.Controls.Add(this.bntSeven);
            this.Controls.Add(this.txt);
            this.Name = "Calculadora";
            this.Text = "Calculadora";
            this.ResumeLayout(false);
            this.PerformLayout();

        }

        #endregion

        private System.Windows.Forms.TextBox txt;
        private System.Windows.Forms.Button bntSeven;
        private System.Windows.Forms.Button btnSix;
        private System.Windows.Forms.Button btnThree;
        private System.Windows.Forms.Button btnMulti;
        private System.Windows.Forms.Button btnSum;
        private System.Windows.Forms.Button btnSub;
        private System.Windows.Forms.Button btnDivi;
        private System.Windows.Forms.Button btnAc;
        private System.Windows.Forms.Button btnSame;
        private System.Windows.Forms.Button btnOne;
        private System.Windows.Forms.Button btnFor;
        private System.Windows.Forms.Button btnNine;
        private System.Windows.Forms.Button btnZero;
        private System.Windows.Forms.Button btnTwo;
        private System.Windows.Forms.Button btnFive;
        private System.Windows.Forms.Button btnEight;
    }
}


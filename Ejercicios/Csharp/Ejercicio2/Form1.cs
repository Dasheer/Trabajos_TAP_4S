using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Ejercicio2
{
    public partial class Form1 : Form
    {
        public Form1()
        {
            InitializeComponent();
        }

        private void button1_Click(object sender, EventArgs e)
        {
            String texto = txtBox_writter.Text;
            txt_output.AppendText(texto + "\r\n");
            txt_output.Enabled =false;
            txtBox_writter.Text = "";
            txt_output.ForeColor = Color.Black;
            isCliclekd = !isCliclekd;
        }

        bool isCliclekd = false;

        private void lbl_text_Click(object sender, EventArgs e)
        {

        }

        private void btn_clear_Click(object sender, EventArgs e)
        {
            txt_output.Text = "";
            txtBox_writter.Text = "";
        }
    }
}

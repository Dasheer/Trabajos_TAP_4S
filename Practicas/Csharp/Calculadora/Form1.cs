using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Calculadora
{
    public partial class Calculadora : Form
    {
        String texto;
        String ope;
        double num1;
        double num2;
        double result;

        public Calculadora()
        {
            InitializeComponent();
        }

        private void btnOne_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "1";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "1";
            }
        }

        private void btnTwo_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "2";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "2";
            }
        }

        private void btnThree_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "3";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "3";
            }
        }

        private void btnFor_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "4";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "4";
            }
        }

        private void btnFive_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "5";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "5";
            }
        }

        private void btnSix_Click(object sender, EventArgs e)
        {

        }

        private void bntSeven_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "7";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "7";
            }
        }

        private void btnEight_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "8";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "8";
            }
        }

        private void btnNine_Click(object sender, EventArgs e)
        {
            if (txt.Text.Equals("1234567890....") || txt.Text.Equals("0"))
            {
                txt.Text = "";
            }
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "9";
                txt.Text = texto;
            }
            else
            {
                txt.Text = "9";
            }
        }

        private void btnZero_Click(object sender, EventArgs e)
        {
            txt.ForeColor = Color.Black;
            if (txt.Text != null)
            {
                texto = txt.Text + "0";
                txt.Text = texto;
            }

        }

        private void btnAc_Click(object sender, EventArgs e)
        {
            txt.Text = "0";
        }

        private void btnSum_Click(object sender, EventArgs e)
        {
            num1 = Convert.ToDouble(txt.Text);
            ope = "+";
            txt.Text = "";

        }

        private void btnSub_Click(object sender, EventArgs e)
        {
            num1 = Convert.ToDouble(txt.Text);
            ope = "-";
            txt.Text = "";
        }

        private void btnDivi_Click(object sender, EventArgs e)
        {
            num1 = Convert.ToDouble(txt.Text);
            ope = "/";
            txt.Text = "";
        }

        private void btnMulti_Click(object sender, EventArgs e)
        {
            num1 = Convert.ToDouble(txt.Text);
            ope = "*";
            txt.Text = "";
        }

        private void btnSame_Click(object sender, EventArgs e)
        {
            num2 = Convert.ToDouble(txt.Text);

            if (ope == "+")
            {
                result = num1 + num2;
                txt.Text = result.ToString();
            }
            else if (ope == "-")
            {
                result = num1 - num2;
                txt.Text = result.ToString();
            }
            else if (ope == "/")
            {
                if (num2 == 0)
                {
                    txt.Text = "Math error";
                }
                else
                {
                    result = num1 / num2;
                    txt.Text = result.ToString();
                }
            }
            else if (ope == "*")
            {
                result = num1 * num2;
                txt.Text = result.ToString();
            }
        }
    }
}

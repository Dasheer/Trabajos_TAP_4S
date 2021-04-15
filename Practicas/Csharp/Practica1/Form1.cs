using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using System.Windows.Forms;

namespace Practica1
{
    public partial class Calculadora : Form
    {
        public Calculadora()
        {
            InitializeComponent();
        }

        private void addDigit(string number)
        {
            if(textOperation.Text.Equals("0"))
            {
                textOperation.Text = "";
            }

            if(!textOperation.Text.Equals(null))
            {
                string addNumber = textOperation.Text + number;
                textOperation.Text = addNumber;
            }else
            {
                textOperation.Text = number;
            }
        }

        private void numberZero_Click(object sender, EventArgs e)
        {
            addDigit("0");
        }

        private void numberOne_Click(object sender, EventArgs e)
        {
            addDigit("1");
        }

        private void numberTwo_Click(object sender, EventArgs e)
        {
            addDigit("2");
        }

        private void numberThree_Click(object sender, EventArgs e)
        {
            addDigit("3");
        }

        private void numberFour_Click(object sender, EventArgs e)
        {
            addDigit("4");
        }

        private void numberFive_Click(object sender, EventArgs e)
        {
            addDigit("5");
        }

        private void numberSix_Click(object sender, EventArgs e)
        {
            addDigit("6");
        }

        private void numberSeven_Click(object sender, EventArgs e)
        {
            addDigit("7");
        }

        private void numberEight_Click(object sender, EventArgs e)
        {
            addDigit("8");
        }

        private void numberNine_Click(object sender, EventArgs e)
        {
            addDigit("9");
        }

        private void buttonPoint_Click(object sender, EventArgs e)
        {
            if (!(textOperation.Text.Contains("."))){
                addDigit(".");
            }
        }

        private void Calculadora_Load(object sender, EventArgs e)
        {

        }

        private void buttonAdd_Click(object sender, EventArgs e)
        {
            this.numberOneCalc = float.Parse(this.textOperation.Text);
            this.operation = "+";
            this.textOperation.Text = "";
        }

        private void buttonSubtract_Click(object sender, EventArgs e)
        {
            this.numberOneCalc = float.Parse(this.textOperation.Text);
            this.operation = "-";
            this.textOperation.Text = "";
        }

        private void buttonMultiplication_Click(object sender, EventArgs e)
        {
            this.numberOneCalc = float.Parse(this.textOperation.Text);
            this.operation = "*";
            this.textOperation.Text = "";
        }

        private void buttonDivision_Click(object sender, EventArgs e)
        {
            this.numberOneCalc = float.Parse(this.textOperation.Text);
            this.operation = "÷";
            this.textOperation.Text = "";
        }

        private void buttonPercentage_Click(object sender, EventArgs e)
        {
            this.numberOneCalc = float.Parse(this.textOperation.Text);
            this.operation = "%";
            this.textOperation.Text = "";
        }

        private void buttonScuareRoot_Click(object sender, EventArgs e)
        {
            this.numberOneCalc = float.Parse(this.textOperation.Text);
            this.operation = "√";
            this.textOperation.Text = "";
        }

        private void buttonDelete_Click(object sender, EventArgs e)
        {
            string tam = textOperation.Text;
            if(tam.Length > 0)
            {
                if(tam.Length == 1)
                {
                    textOperation.Text = "0";
                }
                else
                {
                    tam = tam.Substring(0, tam.Length - 1);
                    textOperation.Text = tam;
                }
            }
        }

        private void buttonAllClear_Click(object sender, EventArgs e)
        {
            textOperation.Text = "0";
        }

        private float numberOneCalc;
        private float numberTwoCalc;
        private string operation;

        private void buttonEqual_Click(object sender, EventArgs e)
        {
            this.numberTwoCalc = float.Parse(this.textOperation.Text);

            switch (this.operation)
            {
                case "+":

                    textOperation.Text = Convert.ToString(this.numberOneCalc + this.numberTwoCalc);
                    
                    break;
                case "-":
                    textOperation.Text = Convert.ToString(this.numberOneCalc - this.numberTwoCalc);
                    break;
                case "*":
                    textOperation.Text = Convert.ToString(this.numberOneCalc * this.numberTwoCalc);
                    break;
                case "÷":
                    textOperation.Text = Convert.ToString(this.numberOneCalc / this.numberTwoCalc);
                    break;
                case "%":
                    textOperation.Text = Convert.ToString((this.numberOneCalc * 100) / this.numberTwoCalc);
                    break;
                case "√":
                    textOperation.Text = Convert.ToString(Math.Sqrt(this.numberTwoCalc));
                    break;
                default:
                    textOperation.Text = "Syntax Error";
                    break;
            }
        }
    }
}

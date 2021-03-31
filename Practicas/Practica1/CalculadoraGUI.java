package Practicas.Practica1;

import java.awt.*;
import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.border.Border;

public class CalculadoraGUI extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public CalculadoraGUI() {
        topPanel();
        bottomPanel();
        initComponents();
    }

    // Iniciación de componentes
    public void initComponents() {

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel, BorderLayout.SOUTH);

        // Contruccion de la ventana
        this.setSize(400, 500);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setTitle("Calculadora");
    }

    // Creación del panel superior
    public void topPanel() {
        //
        topPanel = new Panel();
        topPanel.setLayout(new BorderLayout());

        textOperation = new Label("0");
        textResult = new Label("0");

        topPanel.add(textOperation, BorderLayout.NORTH);
        topPanel.add(textResult, BorderLayout.SOUTH);
    }

    // Creación del panel inferior
    public void bottomPanel() {
        //
        bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(5, 4, 8, 8));

        numberOne = new Button("1");
        numberTwo = new Button("2");
        numberThree = new Button("3");
        numbreFour = new Button("4");
        numberFive = new Button("5");
        numberSix = new Button("6");
        numberSeven = new Button("7");
        numberEight = new Button("8");
        numberNine = new Button("9");
        numberZero = new Button("0");

        buttonPoint = new Button(".");
        buttonEqual = new Button("=");
        buttonPercentage = new Button("%");
        buttonAllClear = new Button("CA");
        buttonLeftParenthesis = new Button("(");
        buttonRightParenthesis = new Button(")");
        buttonDivision = new Button("/");
        buttonMultiplication = new Button("x");
        buttonAdd = new Button("+");
        buttonSubtract = new Button("-");

        bottomPanel.add(buttonLeftParenthesis);
        bottomPanel.add(buttonRightParenthesis);
        bottomPanel.add(buttonPercentage);
        bottomPanel.add(buttonAllClear);
        bottomPanel.add(numberSeven);
        bottomPanel.add(numberEight);
        bottomPanel.add(numberNine);
        bottomPanel.add(buttonDivision);
        bottomPanel.add(numbreFour);
        bottomPanel.add(numberFive);
        bottomPanel.add(numberSix);
        bottomPanel.add(buttonMultiplication);
        bottomPanel.add(numberOne);
        bottomPanel.add(numberTwo);
        bottomPanel.add(numberThree);
        bottomPanel.add(buttonSubtract);
        bottomPanel.add(numberZero);
        bottomPanel.add(buttonPoint);
        bottomPanel.add(buttonEqual);
        bottomPanel.add(buttonAdd);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        CalculadoraGUI calculadoraGUI = new CalculadoraGUI();
    }

    // Creación de los widgets
    private Panel topPanel;
    private Panel bottomPanel;

    private Label textOperation;
    private Label textResult;

    private Button numberOne;
    private Button numberTwo;
    private Button numberThree;
    private Button numbreFour;
    private Button numberFive;
    private Button numberSix;
    private Button numberSeven;
    private Button numberEight;
    private Button numberNine;
    private Button numberZero;

    private Button buttonPoint;
    private Button buttonEqual;
    private Button buttonPercentage;
    private Button buttonAllClear;
    private Button buttonLeftParenthesis;
    private Button buttonRightParenthesis;
    private Button buttonDivision;
    private Button buttonMultiplication;
    private Button buttonAdd;
    private Button buttonSubtract;

}

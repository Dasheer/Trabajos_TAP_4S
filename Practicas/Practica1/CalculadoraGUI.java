package Practicas.Practica1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

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
        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        fontM = new Fonts();
        this.setFont(fontM.FontM(0, 18f));
        this.setLayout(new BorderLayout());
        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel);

        // Contruccion de la ventana
        this.setSize(500, 400);
        this.setVisible(true);
        this.setResizable(false);
        this.setTitle("Calculadora");
        this.setLocationRelativeTo(null);
    }

    // Creación del panel superior
    public void topPanel() {
        //

        fontM = new Fonts();

        topPanel = new Panel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.decode("#F4FDFB"));

        textOperation = new Label("0");
        textResult = new Label("0");

        topPanel.add(textOperation, BorderLayout.NORTH);
        textOperation.setAlignment(Label.RIGHT);
        textOperation.setFont(fontM.FontM(0, 12f));

        topPanel.add(textResult, BorderLayout.SOUTH);
        textResult.setAlignment(Label.RIGHT);
        textResult.setFont(fontM.FontM(0, 18f));

    }

    // Creación del panel inferior
    public void bottomPanel() {
        //
        bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(5, 4, 5, 5));

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
        buttonAllClear = new Button("AC");
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

        button(numberOne);
        button(numberTwo);

    }

    public Button button(Button buttonType) {
        buttonType.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                buttonType.setBackground(Color.CYAN);
            }

            public void mouseExited(MouseEvent e) {
                buttonType.setBackground(UIManager.getColor("control"));
            }
        });

        return buttonType;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new CalculadoraGUI();
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

    private Fonts fontM;

}

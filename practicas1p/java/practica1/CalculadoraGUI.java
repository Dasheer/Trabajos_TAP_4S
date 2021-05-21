package practicas1p.java.practica1;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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

        numberOne.addActionListener(this);
        numberTwo.addActionListener(this);
        numberThree.addActionListener(this);
        numberFour.addActionListener(this);
        numberFive.addActionListener(this);
        numberSix.addActionListener(this);
        numberSeven.addActionListener(this);
        numberEight.addActionListener(this);
        numberNine.addActionListener(this);
        numberZero.addActionListener(this);

        buttonPoint.addActionListener(this);
        buttonEqual.addActionListener(this);
        buttonPercentage.addActionListener(this);
        buttonAllClear.addActionListener(this);
        buttonDelete.addActionListener(this);
        buttonScuareRoot.addActionListener(this);
        buttonDivision.addActionListener(this);
        buttonMultiplication.addActionListener(this);
        buttonAdd.addActionListener(this);
        buttonSubtract.addActionListener(this);

    }

    // Creación del panel superior
    public void topPanel() {
        //

        fontM = new Fonts();

        topPanel = new Panel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBackground(Color.decode("#F4FDFB"));

        textOperation = new Label("0");

        topPanel.add(textOperation, BorderLayout.NORTH);
        textOperation.setAlignment(Label.RIGHT);
        textOperation.setFont(fontM.FontM(1, 20f));

    }

    // Creación del panel inferior
    public void bottomPanel() {
        //
        bottomPanel = new Panel();
        bottomPanel.setLayout(new GridLayout(5, 4, 5, 5));

        numberOne = new Button("\u0031");
        numberTwo = new Button("\u0032");
        numberThree = new Button("\u0033");
        numberFour = new Button("\u0034");
        numberFive = new Button("\u0035");
        numberSix = new Button("\u0036");
        numberSeven = new Button("\u0037");
        numberEight = new Button("\u0038");
        numberNine = new Button("\u0039");
        numberZero = new Button("\u0030");

        numberOne.setBackground(new Color(174, 214, 241));
        numberTwo.setBackground(new Color(174, 214, 241));
        numberThree.setBackground(new Color(174, 214, 241));
        numberFour.setBackground(new Color(174, 214, 241));
        numberFive.setBackground(new Color(174, 214, 241));
        numberSix.setBackground(new Color(174, 214, 241));
        numberSeven.setBackground(new Color(174, 214, 241));
        numberEight.setBackground(new Color(174, 214, 241));
        numberNine.setBackground(new Color(174, 214, 241));
        numberZero.setBackground(new Color(174, 214, 241));

        buttonPoint = new Button(".");
        buttonEqual = new Button("\u003D");
        buttonPercentage = new Button("\u0025");
        buttonAllClear = new Button("AC");
        buttonDelete = new Button("DEL");
        buttonScuareRoot = new Button("\u221A");
        buttonDivision = new Button("\u00f7");
        buttonMultiplication = new Button("\u00d7");
        buttonAdd = new Button("\u002B");
        buttonSubtract = new Button("\u2212");

        buttonAllClear.setBackground(new Color(241, 174, 174));
        buttonDelete.setBackground(new Color(241, 174, 174));

        bottomPanel.add(buttonAllClear);
        bottomPanel.add(buttonDelete);
        bottomPanel.add(buttonScuareRoot);
        bottomPanel.add(buttonPercentage);
        bottomPanel.add(numberSeven);
        bottomPanel.add(numberEight);
        bottomPanel.add(numberNine);
        bottomPanel.add(buttonDivision);
        bottomPanel.add(numberFour);
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
        button(numberThree);
        button(numberFour);
        button(numberFive);
        button(numberSix);
        button(numberSeven);
        button(numberEight);
        button(numberNine);
        button(numberZero);

    }

    public Button button(Button buttonType) {
        buttonType.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) {
                buttonType.setBackground(Color.decode("#96a8a0"));
                buttonType.setForeground(Color.WHITE);
            }

            public void mouseExited(MouseEvent e) {
                buttonType.setBackground(new Color(174, 214, 241));
                buttonType.setForeground(Color.BLACK);
            }
        });

        return buttonType;
    }

    public void addDigit(String number) {
        if (textOperation.getText().equals("0")) {
            textOperation.setText("");
        }
        if (!textOperation.getText().equals(null)) {
            String addNumber = textOperation.getText() + number;
            textOperation.setText(addNumber);
        } else {
            textOperation.setText(number);
        }
    }

    public String quitZero(float result) {
        String returns = "";

        returns = Float.toString(result);
        if (result % 1 == 0) {
            returns = returns.substring(0, returns.length() - 2);
        }

        return returns;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object buttonPress = e.getSource();

        if (buttonPress == numberOne) {
            addDigit("1");
        }

        if (buttonPress == numberTwo) {
            addDigit("2");
        }

        if (buttonPress == numberThree) {
            addDigit("3");
        }

        if (buttonPress == numberFour) {
            addDigit("4");
        }

        if (buttonPress == numberFive) {
            addDigit("5");
        }

        if (buttonPress == numberSix) {
            addDigit("6");
        }

        if (buttonPress == numberSeven) {
            addDigit("7");
        }

        if (buttonPress == numberEight) {
            addDigit("8");
        }

        if (buttonPress == numberNine) {
            addDigit("9");
        }

        if (buttonPress == numberZero) {
            addDigit("0");
        }

        // Implementación de botones de operaciones

        // Implementación para añadir un solo punto
        // Método que distingue si existe un punto, solo sea aquel que este en la
        // operación
        if (buttonPress == buttonPoint) {
            if (!(textOperation.getText().contains("."))) {
                addDigit(".");
            }
        }

        if (buttonPress == buttonEqual) {
            this.numberTwoCalc = Float.parseFloat(this.textOperation.getText());

            switch (this.operation) {
                case "+":
                    textOperation.setText(quitZero(this.numberOneCalc + this.numberTwoCalc));
                    break;
                case "-":
                    textOperation.setText(quitZero(this.numberOneCalc - this.numberTwoCalc));
                    break;
                case "*":
                    textOperation.setText(quitZero(this.numberOneCalc * this.numberTwoCalc));
                    break;
                case "/":
                    if (numberTwoCalc == 0) {
                        this.textOperation.setText("Math ERROR");
                    } else {
                        textOperation.setText(quitZero(this.numberOneCalc / this.numberTwoCalc));
                    }
                    break;
                case "%":
                    textOperation.setText(quitZero((this.numberOneCalc * 100) / numberTwoCalc));
                    break;

                case "\u221A":
                    textOperation.setText(Double.toString((Math.sqrt(this.numberTwoCalc))));
                    break;

                default:
                    textOperation.setText("Syntax Error");
            }
        }
        if (buttonPress == buttonPercentage) {
            this.numberOneCalc = Float.parseFloat(this.textOperation.getText());
            this.operation = "%";
            this.textOperation.setText("");
        }

        if (buttonPress == buttonAllClear) {
            textOperation.setText("0");
        }

        if (buttonPress == buttonDelete) {
            String tam = textOperation.getText();
            if (tam.length() > 0) {
                if (tam.length() == 1) {
                    textOperation.setText("0");

                } else {
                    tam = tam.substring(0, tam.length() - 1);
                    textOperation.setText(tam);
                }

            }
        }

        if (buttonPress == buttonScuareRoot) {
            this.numberOneCalc = Float.parseFloat(this.textOperation.getText());
            this.operation = "\u221A";
            this.textOperation.setText("");
        }

        if (buttonPress == buttonDivision) {
            this.numberOneCalc = Float.parseFloat(this.textOperation.getText());
            this.operation = "/";
            this.textOperation.setText("");
        }

        if (buttonPress == buttonMultiplication) {
            this.numberOneCalc = Float.parseFloat(this.textOperation.getText());
            this.operation = "*";
            this.textOperation.setText("");
        }

        if (buttonPress == buttonAdd) {
            this.numberOneCalc = Float.parseFloat(this.textOperation.getText());
            this.operation = "+";
            this.textOperation.setText("");
        }

        if (buttonPress == buttonSubtract) {
            this.numberOneCalc = Float.parseFloat(this.textOperation.getText());
            this.operation = "-";
            this.textOperation.setText("");
        }

    }

    public static void main(String[] args) {
        new CalculadoraGUI();
    }

    // Creación de los widgets
    private Panel topPanel;
    private Panel bottomPanel;

    private Label textOperation;

    private Button numberOne;
    private Button numberTwo;
    private Button numberThree;
    private Button numberFour;
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
    private Button buttonScuareRoot;
    private Button buttonDelete;
    private Button buttonDivision;
    private Button buttonMultiplication;
    private Button buttonAdd;
    private Button buttonSubtract;

    private Fonts fontM;

    private float numberOneCalc;
    private float numberTwoCalc;
    private String operation;

}

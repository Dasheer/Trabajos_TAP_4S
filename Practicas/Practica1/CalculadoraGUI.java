package Practicas.Practica1.Calculadora.java;

import java.awt.*;
import java.awt.event.*;

public class CalculadoraGUI extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Calculadora(){
        initComponents();
    }

    // Iniciación de componentes
    public void initComponents() {
        //
    }

    // Creación del panel superior
    public void topPanel() {
        //
    }

    // Creación del panel inferior
    public void bottomPanel() {
        //
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        //
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

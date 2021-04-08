package Practicas.Practica1;

import java.awt.*;
import java.awt.event.*;

public class Calculadora {

    public Calculadora(double numberOne, double numberTwo, String operation) {
        this.numberOne = numberOne;
        this.numberTwo = numberTwo;
        this.operation = operation;
    }

    public Label add(Label textOperation) {
        this.numberOne = Double.parseDouble(textOperation.getText());
        this.operation = "+";
        textOperation.setText("");
        return textOperation;
    }

    public Label operation(Label textResult) {
        this.numberTwo = Double.parseDouble(textResult.getText());

        switch (this.operation) {
        case "+":
            textResult.setText(Double.toString(this.numberOne + this.numberTwo));
            break;
        }

        return textResult;
    }

    private double numberOne;
    private double numberTwo;
    private String operation;
}

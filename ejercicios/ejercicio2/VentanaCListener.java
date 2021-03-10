package ejercicios.ejercicio2;

import java.awt.TextField;
import java.awt.Frame;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Label;
import java.awt.TextArea;

import java.awt.event.*;

public class VentanaCListener extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public VentanaCListener() {
        this.init();
        this.setSize(400, 300);
        this.setVisible(true);
    }

    /**
     * Inicializamos los widgets y los metodos al contenedor
     */

    public void init() {
        isClicked = false;
        btn_click = new Button("Aceptar");
        btn_clear = new Button("Limpiar");
        lbl_msg = new Label("Introduzca el texto en el campo inferior: ");
        txt_in = new TextField("");
        txt_result = new TextArea();
        this.setLayout(new BorderLayout());
        this.add(lbl_msg, BorderLayout.NORTH);
        this.add(txt_in, BorderLayout.SOUTH);
        this.add(btn_click, BorderLayout.EAST);
        this.add(txt_result, BorderLayout.CENTER);
        this.add(btn_clear, BorderLayout.WEST);
        btn_click.addActionListener(this);
        btn_clear.addActionListener(this);
    }

    public static void main(String[] args) {
        VentanaCListener w = new VentanaCListener();
        w.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        // if (isClicked) {
        // btn_click.setLabel("Presioname");
        // } else {
        // btn_click.setLabel("Presionado");
        // }
        if (arg0.getSource() == btn_click) {
            String txt = txt_in.getText();
            txt_result.append(txt + "\n");

        }

        if (arg0.getSource() == btn_clear) {
            txt_result.setText("");
            txt_in.setText("");
        }
        isClicked = !isClicked;

    }

    /**
     * Creación de los widgets
     */
    Button btn_click;
    Button btn_clear;
    TextField txt_in;
    Label lbl_msg;
    TextArea txt_result;
    boolean isClicked;

}

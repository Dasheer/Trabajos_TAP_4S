package Ejercicios.Java.bloc_notas;

import java.awt.event.*;

import javax.swing.BoxLayout;
import javax.swing.border.Border;

import java.awt.*;

public class Colores extends Frame implements ActionListener {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Colores(TextArea tArea) {
        initComponents();
        textAreaC = tArea;
    }

    public void initComponents() {

        // Creación de los paneles superior, central e inferior
        panel_superior = new Panel();
        panel_inferior = new Panel();

        // Asignación del Layout en los paneles
        panel_superior.setLayout(new GridLayout(7, 2));
        panel_inferior.setLayout(new GridLayout(7, 2));

        // Creación de los botones
        blackColor = new Button("Negro");
        redColor = new Button("Rojo");
        greenColor = new Button("Verde");
        yellowColor = new Button("Amarillo");
        blueColor = new Button("Azul");
        magentaColor = new Button("Magenta");
        whiteColor = new Button("Blanco");
        cyanColor = new Button("Cyan");
        darkGrayColor = new Button("Gris Oscuro");
        lightGrayColor = new Button("Gris Claro");
        grayColor = new Button("Gris");
        orangeColor = new Button("Naranja");
        pinkColor = new Button("Rosado");
        toAccept = new Button("Aceptar");

        textAreaC = new TextArea();
        textAreaC.setText("Ejemplo");
        textAreaC.getForeground();
        textAreaC.setEditable(false);

        // fontM = new Fonts();

        // this.setFont(fontM.FontM(0, 12f));

        this.setLayout(new GridLayout(7, 2));

        this.add(blackColor);
        this.add(redColor);
        this.add(greenColor);
        this.add(yellowColor);
        this.add(darkGrayColor);
        this.add(lightGrayColor);
        this.add(grayColor);
        this.add(blueColor);
        this.add(magentaColor);
        this.add(whiteColor);
        this.add(cyanColor);
        this.add(orangeColor);
        this.add(pinkColor);
        this.add(toAccept);

        // Creación de la ventana
        this.setLocationRelativeTo(null);
        this.setSize(400, 200);
        this.setTitle("Colores");
        this.setResizable(false);
        this.setVisible(true);

        blackColor.addActionListener(this);
        redColor.addActionListener(this);
        greenColor.addActionListener(this);
        yellowColor.addActionListener(this);
        darkGrayColor.addActionListener(this);
        lightGrayColor.addActionListener(this);
        grayColor.addActionListener(this);
        blueColor.addActionListener(this);
        magentaColor.addActionListener(this);
        whiteColor.addActionListener(this);
        cyanColor.addActionListener(this);
        orangeColor.addActionListener(this);
        pinkColor.addActionListener(this);
        toAccept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // Se crea un objeto que es el encargado de obtener el resultado del ActionEvent
        Object btnOnpress = e.getSource();

        // Asignación del color negro
        if (btnOnpress == blackColor) {
            textAreaC.setForeground(Color.BLACK);
            textAreaC.setBackground(Color.WHITE);
        }

        // Asignación del color rojo
        if (btnOnpress == redColor) {
            textAreaC.setForeground(Color.RED);
        }

        if (btnOnpress == greenColor) {
            textAreaC.setForeground(Color.GREEN);
        }

        // Asignación del color amarillo
        if (btnOnpress == yellowColor) {
            textAreaC.setForeground(Color.YELLOW);
        }

        // Asignación del color gris oscuro
        if (btnOnpress == darkGrayColor) {
            textAreaC.setForeground(Color.DARK_GRAY);
        }

        // Asignación del color gris claro
        if (btnOnpress == lightGrayColor) {
            textAreaC.setForeground(Color.LIGHT_GRAY);
        }

        // Asignación del color gris
        if (btnOnpress == grayColor) {
            textAreaC.setForeground(Color.GRAY);
        }

        // Asignación del color azul
        if (btnOnpress == blueColor) {
            textAreaC.setForeground(Color.BLUE);
        }

        // Asignación del color magenta
        if (btnOnpress == magentaColor) {
            textAreaC.setForeground(Color.MAGENTA);
        }

        // Asignación del color blanco
        if (btnOnpress == whiteColor) {
            textAreaC.setForeground(Color.WHITE);
            textAreaC.setBackground(Color.BLACK);
        }

        // Asignación del color cyan
        if (btnOnpress == cyanColor) {
            textAreaC.setForeground(Color.CYAN);
        }

        // Asignación del color naranaja
        if (btnOnpress == orangeColor) {
            textAreaC.setForeground(Color.ORANGE);
        }

        // Asignación del color rosado
        if (btnOnpress == pinkColor) {
            textAreaC.setForeground(Color.PINK);
        }

        // Asignación del boton aceptar, la cual hace que la ventana se cierre
        if (btnOnpress == toAccept) {
            dispose();
        }

    }

    public static void main(String[] args) {
        // todo
    }

    // Creacion de los widgets
    private Panel panel_superior;
    private Panel panel_inferior;

    private Button blackColor;
    private Button redColor;
    private Button greenColor;
    private Button yellowColor;
    private Button blueColor;
    private Button magentaColor;
    private Button whiteColor;
    private Button cyanColor;
    private Button darkGrayColor;
    private Button lightGrayColor;
    private Button grayColor;
    private Button orangeColor;
    private Button pinkColor;
    private Button toAccept;

    private TextArea textAreaC;

    private Fonts fontM;

    public void setTextAreaC(TextArea textAreaC) {
        this.textAreaC = textAreaC;
    }

}
package practicas1p.java.practica3;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JDialog;
import javax.swing.JTextArea;

public class Ayuda extends JDialog {

    public Ayuda(JDialog d, boolean b) {
        initComponents();
    }

    private void initComponents() {
        this.setSize(450, 300);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        this.setResizable(false);
        this.setTitle("Ayuda");

        textHelp = new JTextArea();
        textHelp.setFont(new Font("Arial", Font.PLAIN, 25));
        textHelp.setText(
                "Al escribir la direccion web, se escribe por ejemplo: \nwww.itescam.edu.mx\nNo debe de introducir: https, http.\nNo debe de tener espacios.");
        this.add(textHelp, BorderLayout.CENTER);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    }

    private JTextArea textHelp;

}

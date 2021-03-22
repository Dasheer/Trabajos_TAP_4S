package ejercicios.bloc_notas;

import java.awt.*;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.*;
import java.io.InputStream;

import javax.swing.JComboBox;
import javax.swing.border.Border;

public class Fonts extends Frame implements ActionListener {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    public Fonts(TextArea txtArea) {
        initComponents();
        textAreaF = txtArea;
    }

    public void initComponents() {

        panel_superior = new Panel();
        panel_inferior = new Panel();
        panel_superior.setLayout(new FlowLayout());
        panel_inferior.setLayout(new FlowLayout());

        //
        String tamFont[] = { "Tamanio", "7", "9", "10", "12", "14", "16" };

        selectFont = new JComboBox(tamFont);

        btn_toAcept = new Button("Aceptar");

        textAreaF = new TextArea();
        textAreaF.getFont();

        this.setLayout(new BorderLayout());

        panel_superior.add(selectFont, FlowLayout.LEFT);
        this.add(panel_superior, BorderLayout.NORTH);

        panel_inferior.add(btn_toAcept, FlowLayout.LEFT);
        this.add(panel_inferior, BorderLayout.SOUTH);

        this.setSize(200, 250);
        this.setTitle("Fuentes");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        selectFont.addActionListener(this);
        btn_toAcept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object btnPress = e.getSource();

        if (btnPress == btn_toAcept) {
            dispose();
        }

        if (btnPress == selectFont) {
            if (selectFont.getSelectedIndex() == 1) {
                textAreaF.setFont(new Font("Arial", 0, 7));
            } else if (selectFont.getSelectedIndex() == 2) {
                textAreaF.setFont(new Font("Arial", 0, 9));
            }
        }
    }

    private Button btn_toAcept;;
    // private Button subtractFont;
    private TextArea textAreaF;
    private JComboBox selectFont;
    private Panel panel_superior;
    private Panel panel_inferior;

    public void setTextAreaF(TextArea textAreaF) {
        this.textAreaF = textAreaF;
    }
}

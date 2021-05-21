package ejercicios1p.java.bloc_notas;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

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
        String tamFont[] = { "Tamanio", "8", "9", "10", "11", "12", "14", "16", "18", "20", "22", "24", "26", "28",
                "36" };

        selectFont = new JComboBox(tamFont);

        btn_toAcept = new Button("Aceptar");

        textAreaF = new TextArea();
        textAreaF.getFont();

        this.setLayout(new BorderLayout());

        panel_superior.add(selectFont, FlowLayout.LEFT);
        this.add(panel_superior, BorderLayout.NORTH);

        panel_inferior.add(btn_toAcept, FlowLayout.LEFT);
        this.add(panel_inferior, BorderLayout.SOUTH);

        this.setSize(200, 200);
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
                textAreaF.setFont(new Font("Arial", 0, 8));
            } else if (selectFont.getSelectedIndex() == 2) {
                textAreaF.setFont(new Font("Arial", 0, 9));
            } else if (selectFont.getSelectedIndex() == 3) {
                textAreaF.setFont(new Font("Arial", 0, 10));
            } else if (selectFont.getSelectedIndex() == 4) {
                textAreaF.setFont(new Font("Arial", 0, 11));
            } else if (selectFont.getSelectedIndex() == 5) {
                textAreaF.setFont(new Font("Arial", 0, 12));
            } else if (selectFont.getSelectedIndex() == 6) {
                textAreaF.setFont(new Font("Arial", 0, 14));
            } else if (selectFont.getSelectedIndex() == 7) {
                textAreaF.setFont(new Font("Arial", 0, 16));
            } else if (selectFont.getSelectedIndex() == 8) {
                textAreaF.setFont(new Font("Arial", 0, 18));
            } else if (selectFont.getSelectedIndex() == 9) {
                textAreaF.setFont(new Font("Arial", 0, 20));
            } else if (selectFont.getSelectedIndex() == 10) {
                textAreaF.setFont(new Font("Arial", 0, 22));
            } else if (selectFont.getSelectedIndex() == 11) {
                textAreaF.setFont(new Font("Arial", 0, 24));
            } else if (selectFont.getSelectedIndex() == 12) {
                textAreaF.setFont(new Font("Arial", 0, 26));
            } else if (selectFont.getSelectedIndex() == 13) {
                textAreaF.setFont(new Font("Arial", 0, 28));
            } else if (selectFont.getSelectedIndex() == 14) {
                textAreaF.setFont(new Font("Arial", 0, 36));
            } else {
                // TODO:
            }
        }
    }

    private Button btn_toAcept;;
    private TextArea textAreaF;
    private JComboBox selectFont;
    private Panel panel_superior;
    private Panel panel_inferior;

    public void setTextAreaF(TextArea textAreaF) {
        this.textAreaF = textAreaF;
    }
}

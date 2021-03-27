package Ejercicios.Java.bloc_notas;

import java.awt.*;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.*;

public class About extends Frame implements ActionListener{
    
    public About(){
        initComponents();
    }

    public void initComponents(){

        // Creación y asignación de los paneles
        panel_superior = new Panel();
        panel_inferior = new Panel();
        panel_superior.setLayout(new BorderLayout());
        panel_inferior.setLayout(new FlowLayout());

        // Creación del Label 
        creator = new TextArea();

        creator.setText("Este bloc de notas fue hecho por:" + "\nDaniel Eduardo Pech Canul" + "\nMatricula: 7014");
        creator.setEditable(false);
        creator.setBounds(150,150,100,100);

        // Creación del botón
        btn_toAcept = new Button("Aceptar");

        this.setLayout(new BorderLayout());

        panel_superior.add(creator, BorderLayout.CENTER);
        this.add(panel_superior, BorderLayout.CENTER);

        panel_inferior.add(btn_toAcept, FlowLayout.LEFT);
        this.add(panel_inferior, BorderLayout.SOUTH);
        
        this.setSize(230, 200);
        this.setTitle("Acerca de...");
        this.setVisible(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        btn_toAcept.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object btnPress = e.getSource();

        // Cerrar ventana
        if(btnPress == btn_toAcept){
            dispose();
        }
    }

    private Button btn_toAcept;;
    private TextArea creator;
    private Panel panel_superior;
    private Panel panel_inferior;
}

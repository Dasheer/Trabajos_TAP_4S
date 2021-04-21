package Practicas.Java.Practica2;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class Contenedor extends JFrame implements ActionListener, MouseMotionListener, MouseListener, KeyListener {

    public Contenedor() {
        initComponents();
    }

    public void initComponents() {

        // Creación del frame
        this.setSize(600, 600);
        this.setVisible(true);
        this.setTitle("Juego");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Creamos una variable contentWindow, la cual contiene los graficos ya
        // definidos
        contentWindow = new ContenedorVentana();
        // Le asignamos un tamaño al grafico, y le extraemos su altura y su ancho
        contentWindow.setBounds(0, 0, this.getWidth(), this.getHeight());

        // Le aplicamos las acciones que realiza mientras este dentro de la ventana
        contentWindow.addMouseListener(this);
        contentWindow.addMouseMotionListener(this);
        contentWindow.addKeyListener(this);

        // Agregamos la ventana al Frame
        this.add(contentWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        // Cunado isClicked sea falso, se obtiene las coordenadas donde esta el mouse, y
        // le asignamos una alerta, por ultimo este se repinta en el frame
        if (!contentWindow.isClicked()) {
            contentWindow.setX(e.getX());
            contentWindow.setY(e.getY());
            contentWindow.setAlert("Start..!");
            contentWindow.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        // Cuando estemos moviendo el mause, muestra las coordenadas donde esté,
        // mientras sea dentro del Frame
        contentWindow.setMove("Moviendo a: [" + e.getX() + "," + e.getY() + "]");
        contentWindow.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // cuando contentWindo sea clickeado, se le asigna las coordenadas donde se
        // movió por ultima vez, y se le extrae las coordenadas de este mismo
        if (contentWindow.isClicked()) {
            contentWindow.setX(e.getX());
            contentWindow.setY(e.getY());
            contentWindow.setMove("Position: [" + e.getX() + ", " + e.getY() + "]");
            contentWindow.repaint();
        } else {
            contentWindow.setX(e.getX());
            contentWindow.setY(e.getY());
        }
        contentWindow.isClicked();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // Cuando el mouse entre en el Frame, se le asigna una alerta de Iniciando
        contentWindow.setAlert("Iniciando");
        contentWindow.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // Cuando el mouse salga del Frame, se le asigna una alerta de Saliendo
        contentWindow.setAlert("Saliendo");
        contentWindow.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Cuando el mouse este presionado en el Frame, se le asigna una alerta de
        // Presionado
        contentWindow.setAlert("Presionado");
        contentWindow.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // Se actualiza el cubo, y se le renombra como "Sr. Cubo"
        contentWindow.setAlert("Soy el Sr. Cubo");
        contentWindow.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

        // Mientres el cubo este dentro del contenedor sera posible mover con las letras
        // del teclado A, W, S, D
        if (!contentWindow.isClicked()) {
            switch (e.getKeyChar()) {
            case 'd':
            case 'D':
                contentWindow.setAlert("Pressed d");
                contentWindow.setX(contentWindow.getX() + 10);

                break;
            case 'a':
            case 'A':
                contentWindow.setAlert("Pressed a");
                contentWindow.setX(contentWindow.getX() - 10);
                break;
            case 'w':
            case 'W':
                contentWindow.setAlert("Pressed w");
                contentWindow.setY(contentWindow.getY() - 10);

                break;
            case 's':
            case 'S':
                contentWindow.setAlert("Pressed s");
                contentWindow.setY(contentWindow.getY() + 10);
                break;

            }
            contentWindow.repaint();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //

    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    private ContenedorVentana contentWindow;
}

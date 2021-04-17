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
        this.setSize(600, 600);
        this.setVisible(true);
        this.setTitle("Juego");
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentWindow = new ContenedorVentana();
        contentWindow.setBounds(0, 0, this.getWidth(), this.getHeight());

        contentWindow.addMouseListener(this);
        contentWindow.addMouseMotionListener(this);
        contentWindow.addKeyListener(this);
        this.add(contentWindow);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (!contentWindow.isClicked()) {
            contentWindow.setX(e.getX());
            contentWindow.setY(e.getY());
            contentWindow.setAlert("Start..!");
            contentWindow.repaint();
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        contentWindow.setMove("Moviendo a: [" + e.getX() + "," + e.getY() + "]");
        contentWindow.repaint();

    }

    @Override
    public void mouseClicked(MouseEvent e) {
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
        contentWindow.setAlert("Iniciando");
        contentWindow.repaint();
    }

    @Override
    public void mouseExited(MouseEvent e) {
        contentWindow.setAlert("Saliendo");
        contentWindow.repaint();

    }

    @Override
    public void mousePressed(MouseEvent e) {
        contentWindow.setAlert("Presionado");
        contentWindow.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        contentWindow.setAlert("Soy el Sr. Cubo");
        contentWindow.repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {

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

package Practicas.Java.Practica2;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class ContenedorVentana extends Canvas {

    public ContenedorVentana() {
        this.setVisible(true);
        this.setSize(400, 400);
        this.setBackground(new Color(174, 201, 241));

        isClicked = false;
        x = 10;
        y = 10;
        w = h = 50;

    }

    @Override
    public void paint(Graphics g) {

        g.setColor(new Color(203, 67, 53));
        g.fillRect(10, 10, 450, 450);

        g.setColor(new Color(98, 53, 203));
        g.fillOval(10, 500, 60, 60);
        g.drawString(alert, 10, 485);
        g.drawString(move, 10, 495);
        if (x >= 10 && x <= 420 && y >= 10 && y <= 420) {
            g.setColor(new Color(53, 180, 203));
            g.fillRect(x, y, w, h);
            g.drawString(text, x, y);
        } else {
            setAlert("No es posible salir del contenedor");
            repaint();
            int posX = 10;
            int posY = 25;
            g.setColor(new Color(53, 180, 203));
            g.fillRect(posX, posY, w, h);
            g.drawString(text, posX, posY);
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public String getAlert() {
        return alert;
    }

    public void setAlert(String alert) {
        this.alert = alert;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMove() {
        return move;
    }

    public void setMove(String move) {
        this.move = move;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean isClicked) {
        this.isClicked = !isClicked;
    }

    private int x, y;
    private int w, h;
    private String alert = "Juego iniciado";
    private String text = "Soy el Sr. Cubo";
    private String move = "Movimiento";
    private boolean isClicked;

}

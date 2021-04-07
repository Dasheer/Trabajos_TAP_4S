package Proyecto.Juego;

import java.awt.*;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    public TicTacToe() {
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Tic Tac Toe");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new TicTacToe();
    }

}

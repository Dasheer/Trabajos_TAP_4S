package Proyecto.Juego;

import java.awt.*;
import java.awt.event.WindowListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.event.*;

public class TicTacToe extends JFrame implements ActionListener {

    public TicTacToe() {
        menu();
        game();
        initComponents();
    }

    public void initComponents() {
        this.setTitle("Tic Tac Toe");
        this.setSize(500, 500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.add(buttons);
    }

    public void menu() {
        menuGame = new JMenuBar();
        main = new JMenu("Juego");
        rebootG = new JMenuItem("Reiniciar");
        exitG = new JMenuItem("Salir");

        this.setJMenuBar(menuGame);
        menuGame.add(main);
        main.add(rebootG);
        main.addSeparator();
        main.add(exitG);

    }

    public void game() {
        buttons = new JPanel();
        buttons.setLayout(new GridLayout(3, 3, 8, 8));
        createButton(buttonUpperLeft, "");
        createButton(buttonTopUp, "");
        createButton(buttonUpperRight, "");
        createButton(buttonLeft, "");
        createButton(buttonCenter, "");
        createButton(buttonRight, "");
        createButton(buttonLowerLeft, "");
        createButton(buttonLowerDown, "");
        createButton(buttonLowerRight, "");
    }

    private void createButton(JButton b, String s) {
        b = new JButton(s);
        buttons.add(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    private JMenuBar menuGame;
    private JMenu main;
    private JMenuItem rebootG;
    private JMenuItem exitG;

    private JPanel buttons;
    private JButton buttonUpperLeft;
    private JButton buttonTopUp;
    private JButton buttonUpperRight;
    private JButton buttonLeft;
    private JButton buttonCenter;
    private JButton buttonRight;
    private JButton buttonLowerLeft;
    private JButton buttonLowerDown;
    private JButton buttonLowerRight;
}

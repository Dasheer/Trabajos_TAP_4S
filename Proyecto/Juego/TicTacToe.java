package Proyecto.Juego;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TicTacToe extends Frame implements ActionListener {

    public TicTacToe() {
        menu();
        game();
        initComponents();
    }

    public void initComponents() {
        this.setSize(500, 500);
        this.setTitle("Tic Tac Toe");
        this.setUndecorated(true);
        this.setVisible(true);
        this.setResizable(false);
        this.setLocationRelativeTo(null);

        this.setLayout(new BorderLayout());
        this.add(buttons);

        exitG.addActionListener(this);

    }

    public void menu() {
        menuGame = new MenuBar();
        main = new Menu("Juego");
        rebootG = new MenuItem("Reiniciar");
        exitG = new MenuItem("Salir");

        setMenuBar(menuGame);
        menuGame.add(main);
        main.add(rebootG);
        main.addSeparator();
        main.add(exitG);

    }

    public void game() {
        buttons = new Panel();
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

    private void createButton(Button b, String s) {
        b = new Button(s);
        buttons.add(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object onPress = e.getSource();

        if (onPress == exitG) {
            dispose();
        }

    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    private MenuBar menuGame;
    private Menu main;
    private MenuItem rebootG;
    private MenuItem exitG;

    private Panel buttons;
    private Button buttonUpperLeft;
    private Button buttonTopUp;
    private Button buttonUpperRight;
    private Button buttonLeft;
    private Button buttonCenter;
    private Button buttonRight;
    private Button buttonLowerLeft;
    private Button buttonLowerDown;
    private Button buttonLowerRight;

}

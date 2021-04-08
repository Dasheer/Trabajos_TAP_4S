package Proyecto.Juego;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.*;

public class TicTacToe extends JFrame implements ActionListener {

    public TicTacToe() {
        menu();
        topPanel();
        bottomPanel();
        initComponents();
    }

    public void initComponents() {
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(50, 50, 50));
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(bottomPanel);

        game = new GameTicTacToe(true, false);
    }

    public void menu() {
        menuGame = new JMenuBar();
        main = new JMenu("Juego");
        resetGame = new JMenuItem("Reiniciar");
        exitG = new JMenuItem("Salir");

        this.setJMenuBar(menuGame);
        menuGame.add(main);
        main.add(resetGame);
        main.addSeparator();
        main.add(exitG);

        resetGame.addActionListener(this);
    }

    public void topPanel() {
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        topPanel.setBounds(0, 0, 600, 75);

        label = new JLabel();
        label.setBackground(new Color(133, 193, 233));
        label.setForeground(new Color(236, 240, 241));
        label.setFont(new Font("Ink Free", Font.PLAIN, 40));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic Tac Toe");
        label.setOpaque(true);

        topPanel.add(label, BorderLayout.NORTH);

    }

    public void bottomPanel() {
        bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(3, 3, 5, 5));
        bottomPanel.setBackground(new Color(52, 152, 219));

        buttons = new JButton[9];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            bottomPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli", Font.BOLD, 72));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        // bottomPanel.add()

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object onPress = e.getSource();
        for (int i = 0; i < buttons.length; i++) {
            if (onPress == buttons[i]) {
                if (game.isPlayerOne()) {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(203, 67, 53));
                        buttons[i].setText("X");
                        game.setPlayerOne(false);
                        game.setPlayerTwo(true);
                        label.setText("Turno de O");
                    }
                } else {
                    if (buttons[i].getText().equals("")) {
                        buttons[i].setForeground(new Color(46, 134, 193));
                        buttons[i].setText("O");
                        game.setPlayerOne(true);
                        game.setPlayerTwo(false);
                        label.setText("Turno de X");
                    }
                }
                gameCount++;
            }
        }

        boolean winner = game.operation(buttons);
        if (winner) {
            label.setText("Felicidades " + game.Winner + " eres el ganador");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
            }
        } else if (gameCount == 9) {
            label.setText("¡Es un empate!... Vuelve a intentarlo");
            for (int i = 0; i < buttons.length; i++) {
                buttons[i].setEnabled(false);
            }
        }

        if (onPress == resetGame) {
            resetGame();
        }

    }

    public void resetGame() {
        for (int i = 0; i < buttons.length; i++) {
            buttons[i].setText("");
            buttons[i].setEnabled(true);
        }
        label.setText("Tic Tac Toe");
        gameCount = 0;
    }

    public static void main(String[] args) {
        new TicTacToe();
    }

    // Implementación de los Windgets
    private JMenuBar menuGame;
    private JMenu main;
    private JMenuItem resetGame;
    private JMenuItem exitG;
    private Random random;
    private JPanel topPanel;
    private JPanel bottomPanel;
    private JLabel label;
    private JButton[] buttons;
    private GameTicTacToe game;
    private int gameCount = 0;

    class GameTicTacToe {

        public GameTicTacToe(boolean playerOne, boolean playerTwo) {
            this.playerOne = playerOne;
            this.playerTwo = playerTwo;
        }

        public boolean isPlayerOne() {
            return playerOne;
        }

        public void setPlayerOne(boolean playerOne) {
            this.playerOne = playerOne;
        }

        public boolean isPlayerTwo() {
            return playerTwo;
        }

        public void setPlayerTwo(boolean playerTwo) {
            this.playerTwo = playerTwo;
        }

        public boolean operation(JButton[] buttons) {
            if (buttons[0].getText().equalsIgnoreCase("O") && buttons[1].getText().equalsIgnoreCase("O")
                    && buttons[2].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[0].getText().equalsIgnoreCase("O") && buttons[3].getText().equalsIgnoreCase("O")
                    && buttons[6].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[0].getText().equalsIgnoreCase("O") && buttons[4].getText().equalsIgnoreCase("O")
                    && buttons[8].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[1].getText().equalsIgnoreCase("O") && buttons[4].getText().equalsIgnoreCase("O")
                    && buttons[7].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[2].getText().equalsIgnoreCase("O") && buttons[5].getText().equalsIgnoreCase("O")
                    && buttons[8].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[2].getText().equalsIgnoreCase("O") && buttons[4].getText().equalsIgnoreCase("O")
                    && buttons[6].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[3].getText().equalsIgnoreCase("O") && buttons[4].getText().equalsIgnoreCase("O")
                    && buttons[5].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[6].getText().equalsIgnoreCase("O") && buttons[7].getText().equalsIgnoreCase("O")
                    && buttons[8].getText().equalsIgnoreCase("O")) {
                Winner = "(O)";
                return true;
            }
            if (buttons[0].getText().equalsIgnoreCase("X") && buttons[1].getText().equalsIgnoreCase("X")
                    && buttons[2].getText().equalsIgnoreCase("X")) {
                Winner = "(X)";
                return true;
            }
            if (buttons[0].getText().equalsIgnoreCase("X") && buttons[3].getText().equalsIgnoreCase("X")
                    && buttons[6].getText().equalsIgnoreCase("X")) {
                Winner = "(X)";
                return true;
            }
            if (buttons[0].getText().equalsIgnoreCase("X") && buttons[4].getText().equalsIgnoreCase("X")
                    && buttons[8].getText().equalsIgnoreCase("X")) {
                Winner = "(X)";
                return true;
            }
            if (buttons[1].getText().equalsIgnoreCase("X") && buttons[4].getText().equalsIgnoreCase("X")
                    && buttons[7].getText().equalsIgnoreCase("X")) {
                Winner = "(X)";
                return true;
            }
            if (buttons[2].getText().equalsIgnoreCase("X") && buttons[5].getText().equalsIgnoreCase("X")
                    && buttons[8].getText().equalsIgnoreCase("X")) {
                Winner = "(X)";
                return true;
            }
            if (buttons[2].getText().equalsIgnoreCase("X") && buttons[4].getText().equalsIgnoreCase("X")
                    && buttons[6].getText().equalsIgnoreCase("X")) {

                Winner = "(X)";
                return true;
            }
            if (buttons[3].getText().equalsIgnoreCase("X") && buttons[4].getText().equalsIgnoreCase("X")
                    && buttons[5].getText().equalsIgnoreCase("X")) {
                Winner = "(X)";
                return true;
            }
            if (buttons[6].getText().equalsIgnoreCase("X") && buttons[7].getText().equalsIgnoreCase("X")
                    && buttons[8].getText().equalsIgnoreCase("X")) {
                Winner = "(X)";
                return true;
            }
            return false;
        }

        String Winner;
        boolean playerOne, playerTwo;

    }

}
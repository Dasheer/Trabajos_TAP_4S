package Proyecto.Juego;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class Snake extends JFrame {

    public Snake() {
        initComponents();
    }

    public void initComponents() {
        gp = new GamePanel();
        this.add(gp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setVisible(true);
        this.setJMenuBar(gp.menuGame);

    }

    public static void main(String[] args) {
        new Snake();
    }

    GamePanel gp;

    class GamePanel extends JPanel implements ActionListener {

        public GamePanel() {
            random = new Random();
            this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
            this.setBackground(new Color(150, 203, 178));
            this.setFocusable(true);
            this.addKeyListener(new MyKeyAdapter());
            menu();
            startGame();

        }

        public void startGame() {
            newApple();
            running = true;
            time = new Timer(DELAY, this);
            time.start();
        }

        public void pause() {
            gamePaused = true;
            time.stop();
        }

        public void resume() {
            gamePaused = false;
            time.start();
        }

        public void menu() {
            menuGame = new JMenuBar();
            main = new JMenu("Juego");
            resetGame = new JMenuItem("Reiniciar");
            exitG = new JMenuItem("Salir");
            menuGame.add(main);
            main.add(resetGame);
            main.addSeparator();
            main.add(exitG);
            resetGame.addActionListener(this);
            exitG.addActionListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        public void draw(Graphics g) {

            if (running) {
                // for (int i = 0; i < SCREEN_HEIGHT / UNIT_SIZE; i++) {
                // g.drawLine(i * UNIT_SIZE, 0, i * UNIT_SIZE, SCREEN_HEIGHT);
                // g.drawLine(0, i * UNIT_SIZE, SCREEN_WIDTH, i * UNIT_SIZE);
                // g.setColor(new Color(202, 202, 202));
                // }
                g.setColor(new Color(236, 83, 83));
                g.fillOval(appleX, appleY, UNIT_SIZE, UNIT_SIZE);

                for (int i = 0; i < bodyParts; i++) {
                    if (i == 0) {
                        g.setColor(new Color(83, 236, 160));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    } else {
                        g.setColor(new Color(3, 177, 133));
                        g.fillRect(x[i], y[i], UNIT_SIZE, UNIT_SIZE);
                    }
                }

                g.setFont(new Font("Ink Free", Font.BOLD, 50));
                FontMetrics metrics = getFontMetrics(g.getFont());
                g.drawString("Puntos: " + apple, (SCREEN_WIDTH - metrics.stringWidth("Puntos: " + apple)) / 2,
                        g.getFont().getSize());
            } else {
                gameOver(g);
            }

        }

        public void newApple() {
            appleX = random.nextInt((int) (SCREEN_WIDTH / UNIT_SIZE)) * UNIT_SIZE;
            appleY = random.nextInt((int) (SCREEN_HEIGHT / UNIT_SIZE)) * UNIT_SIZE;
        }

        public void move() {
            for (int i = bodyParts; i > 0; i--) {
                x[i] = x[i - 1];
                y[i] = y[i - 1];
            }

            switch (direction) {
            case 'U':
                y[0] = y[0] - UNIT_SIZE;
                break;
            case 'D':
                y[0] = y[0] + UNIT_SIZE;
                break;
            case 'L':
                x[0] = x[0] - UNIT_SIZE;
                break;
            case 'R':
                x[0] = x[0] + UNIT_SIZE;
                break;
            }
        }

        public void checkApple() {
            if ((x[0] == appleX) && (y[0] == appleY)) {
                bodyParts++;
                apple++;
                newApple();
            }
        }

        public void checkCollisions() {
            for (int i = bodyParts; i > 0; i--) {
                if ((x[0] == x[i]) && (y[0] == y[i])) {
                    running = false;
                }
            }

            if (x[0] < 0) {
                running = false;
            }

            if (x[0] > SCREEN_WIDTH) {
                running = false;
            }

            if (y[0] < 0) {
                running = false;
            }

            if (y[0] > SCREEN_HEIGHT) {
                running = false;
            }

            if (!running) {
                time.stop();
            }

        }

        public void gameOver(Graphics g) {
            g.setColor(new Color(177, 35, 3));
            g.setFont(new Font("Ink Free", Font.BOLD, 50));
            FontMetrics metrics = getFontMetrics(g.getFont());
            g.drawString("Juego Terminado", (SCREEN_WIDTH - metrics.stringWidth("Juego Terminado")) / 2,
                    SCREEN_HEIGHT / 2);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            Object onPress = e.getSource();
            if (running) {
                move();
                checkApple();
                checkCollisions();
            }

            if (onPress == exitG) {
                dispose();
            }

            if (onPress == resetGame) {
                this.remove(gp);
                gp = new GamePanel();
                this.add(gp);
                gp.requestFocusInWindow();
                SwingUtilities.updateComponentTreeUI(this);
            }

            repaint();

        }

        private static final int SCREEN_WIDTH = 1300;
        private static final int SCREEN_HEIGHT = 750;
        private static final int UNIT_SIZE = 50;
        private static final int GAME_UNITS = (SCREEN_WIDTH * SCREEN_HEIGHT) / (UNIT_SIZE * UNIT_SIZE);
        private static final int DELAY = 150;
        private final int x[] = new int[GAME_UNITS];
        private final int y[] = new int[GAME_UNITS];
        private int bodyParts = 6;
        private int apple;
        private int appleX;
        private int appleY;
        private char direction = 'R';
        private boolean running = true;
        private Timer time;
        private Random random;
        private boolean gamePaused = false;
        private JMenuBar menuGame;
        private JMenu main;
        private JMenuItem resetGame;
        private JMenuItem exitG;

        public class MyKeyAdapter extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()) {
                case KeyEvent.VK_LEFT:
                    if (direction != 'R') {
                        direction = 'L';
                    }
                    break;
                case KeyEvent.VK_RIGHT:
                    if (direction != 'L') {
                        direction = 'R';
                    }
                    break;
                case KeyEvent.VK_UP:
                    if (direction != 'D') {
                        direction = 'U';
                    }
                    break;
                case KeyEvent.VK_DOWN:
                    if (direction != 'U') {
                        direction = 'D';
                    }
                    break;
                case KeyEvent.VK_SPACE:
                    if (gamePaused) {
                        resume();
                    } else {
                        pause();
                    }
                    break;
                }
            }
        }

    }

}

package Proyecto.Juego;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;

public class Pacman extends JFrame {

    public Pacman() {
        initComponents();
    }

    public void initComponents() {
        pm = new PacmanModel();
        this.add(pm);
        this.setSize(600, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

    }

    public static void main(String[] args) {
        new Pacman();
    }

    PacmanModel pm;

    class PacmanModel extends JPanel implements ActionListener {

        public PacmanModel() {
            loadImages();
            initVariable();
            this.addKeyListener(new MyKeyAdapter());
            this.setFocusable(true);
            startGame();
        }

        private void loadImages() {
            down = new ImageIcon("/Images/down.gif").getImage();
            up = new ImageIcon("/Images/up.gif").getImage();
            left = new ImageIcon("/Images/left.gif").getImage();
            ghost = new ImageIcon("/Images/ghost.gif").getImage();
            heart = new ImageIcon("/Images/heart.gif").getImage();
        }

        public void showIntroScreen(Graphics2D g2d) {
            String start = "Precione ESPACIO para inicar";
            g2d.setColor(Color.YELLOW);
            g2d.drawString(start, SCREEN_SIZE / 4, 150);
        }

        public void drawScore(Graphics2D g2d) {
            g2d.setFont(smallFont);
            g2d.setColor(new Color(5, 151, 79));
            String s = "Puntos: " + score;
            g2d.drawString(s, SCREEN_SIZE / 2 + 96, SCREEN_SIZE + 16);

            for (int i = 0; i < lives; i++) {
                g2d.drawImage(heart, i * 28 + 8, SCREEN_SIZE + 1, this);
            }
        }

        private void initVariable() {
            dimension = new Dimension(400, 400);
            ghostX = new int[MAX_GHOSTS];
            ghostDx = new int[MAX_GHOSTS];
            ghostY = new int[MAX_GHOSTS];
            ghostDy = new int[MAX_GHOSTS];
            ghostSpeed = new int[MAX_GHOSTS];

            dx = new int[4];
            dy = new int[4];

            time = new Timer(40, this);
            time.start();
        }

        private void playGame(Graphics2D g2d) {
            if (dying) {
                death();
            } else {
                movePacman();
                drawPacman(g2d);
                moveGhosts(g2d);
                checkMaze();
            }
        }

        public void movePacman() {
            int pos;
            short ch;

            if (pacmanX % BLOCK_SIZE == 0 && pacmanY % BLOCK_SIZE == 0) {
                pos = pacmanX / BLOCK_SIZE + BLOCKS * (int) (pacmanY / BLOCK_SIZE);
                ch = screenData[pos];

                if ((ch & 16) != 0) {
                    screenData[pos] = (short) (ch & 15);
                    score++;
                }

                if (reqDx != 0 || reqDy != 0) {
                    if (!((reqDx == -1 && reqDy == 0 && (ch & 1) != 0) || (reqDy == 1 && reqDy == 0 && (ch & 4) != 0)
                            || (reqDx == 0 && reqDy == -1 && (ch & 2) != 0)
                            || (reqDx == 0 && reqDy == 1 && (ch & 8) != 0))) {
                        pacmanDx = reqDx;
                        pacmanDy = reqDy;
                    }
                }

                if ((pacmanDx == -1 && pacmanDy == 0 && (ch & 1) != 0)
                        || (pacmanDx == 1 && pacmanDy == 0 && (ch & 4) != 0)
                        || (pacmanDx == 0 && pacmanDy == -1 && (ch & 2) != 0)
                        || (pacmanDx == 0 && pacmanDy == 1 && (ch & 8) != 0)) {
                    pacmanDx = 0;
                    pacmanDy = 0;
                }
            }

            pacmanX = pacmanX + PACMAN_SPEED * pacmanDx;
            pacmanY = pacmanY + PACMAN_SPEED * pacmanDy;
        }

        public void drawPacman(Graphics2D g2d) {
            if (reqDx == -1) {
                g2d.drawImage(left, pacmanX + 1, pacmanY + 1, this);
            } else if (reqDx == 1) {
                g2d.drawImage(right, pacmanX + 1, pacmanY + 1, this);
            } else if (reqDy == -1) {
                g2d.drawImage(up, pacmanX + 1, pacmanY + 1, this);
            } else {
                g2d.drawImage(down, pacmanX + 1, pacmanY + 1, this);
            }
        }

        private void moveGhosts(Graphics2D g2d) {

            int pos;
            int count;

            for (int i = 0; i < GHOSTS; i++) {
                if (ghostX[i] % BLOCK_SIZE == 0 && ghostY[i] % BLOCK_SIZE == 0) {
                    pos = ghostX[i] / BLOCK_SIZE + BLOCKS * (int) (ghostY[i] / BLOCK_SIZE);

                    count = 0;

                    if ((screenData[pos] & 1) == 0 && ghostDx[i] != 1) {
                        dx[count] = -1;
                        dy[count] = 0;
                        count++;
                    }

                    if ((screenData[pos] & 2) == 0 && ghostDy[i] != 1) {
                        dx[count] = 0;
                        dy[count] = -1;
                        count++;
                    }

                    if ((screenData[pos] & 4) == 0 && ghostDx[i] != -1) {
                        dx[count] = 1;
                        dy[count] = 0;
                        count++;
                    }

                    if ((screenData[pos] & 8) == 0 && ghostDy[i] != -1) {
                        dx[count] = 0;
                        dy[count] = 1;
                        count++;
                    }

                    if (count == 0) {

                        if ((screenData[pos] & 15) == 15) {
                            ghostDx[i] = 0;
                            ghostDy[i] = 0;
                        } else {
                            ghostDx[i] = -ghostDx[i];
                            ghostDy[i] = -ghostDy[i];
                        }

                    } else {

                        count = (int) (Math.random() * count);

                        if (count > 3) {
                            count = 3;
                        }

                        ghostDx[i] = dx[count];
                        ghostDy[i] = dy[count];
                    }

                }

                ghostX[i] = ghostX[i] + (ghostDx[i] * ghostSpeed[i]);
                ghostY[i] = ghostY[i] + (ghostDy[i] * ghostSpeed[i]);
                drawGhost(g2d, ghostX[i] + 1, ghostY[i] + 1);

                if (pacmanX > (ghostX[i] - 12) && pacmanX < (ghostX[i] + 12) && pacmanY > (ghostY[i] - 12)
                        && pacmanY < (ghostY[i] + 12) && inGame) {

                    dying = true;
                }
            }
        }

        public void drawGhost(Graphics2D g2d, int x, int y) {
            g2d.drawImage(ghost, x, y, this);
        }

        private void checkMaze() {
            int i = 0;
            boolean finished = true;
            while (i < BLOCKS * BLOCKS && finished) {
                if ((screenData[i] & 48) != 0) {
                    finished = false;
                }
                i++;
            }
            if (finished) {
                score += 50;
                if (GHOSTS < MAX_GHOSTS) {
                    GHOSTS++;
                }
                if (currentSpeed < maxSpeed) {
                    currentSpeed++;
                }
            }
            startLevel();
        }

        private void death() {
            lives--;
            if (lives == 0) {
                inGame = false;
            }

            continueLevel();
        }

        public void drawMaze(Graphics2D g2d) {
            short i = 0;
            int x, y;
            for (y = 0; y < SCREEN_SIZE; y += BLOCK_SIZE) {
                for (x = 0; x < SCREEN_SIZE; x += BLOCK_SIZE) {

                    g2d.setColor(new Color(0, 72, 251));
                    g2d.setStroke(new BasicStroke(5));

                    if ((levelData[i] == 0)) {
                        g2d.fillRect(x, y, BLOCK_SIZE, BLOCK_SIZE);
                    }

                    if ((screenData[i] & 1) != 0) {
                        g2d.drawLine(x, y, x, y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 2) != 0) {
                        g2d.drawLine(x, y, x + BLOCK_SIZE - 1, y);
                    }

                    if ((screenData[i] & 4) != 0) {
                        g2d.drawLine(x + BLOCK_SIZE - 1, y, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 8) != 0) {
                        g2d.drawLine(x, y + BLOCK_SIZE - 1, x + BLOCK_SIZE - 1, y + BLOCK_SIZE - 1);
                    }

                    if ((screenData[i] & 16) != 0) {
                        g2d.setColor(new Color(255, 255, 255));
                        g2d.fillOval(x + 10, y + 10, 6, 6);
                    }

                    i++;
                }
            }
        }

        private void startGame() {
            lives = 3;
            score = 0;
            startLevel();
            GHOSTS = 6;
            currentSpeed = 3;
        }

        private void startLevel() {
            int i;

            for (i = 0; i < BLOCKS * BLOCKS; i++) {
                screenData[i] = levelData[i];
            }
            continueLevel();
        }

        private void continueLevel() {
            int dx = 1;
            int random;

            for (int i = 0; i < GHOSTS; i++) {
                ghostY[i] = 4 * BLOCK_SIZE;
                ghostX[i] = 4 * BLOCK_SIZE;
                ghostDy[i] = 0;
                ghostDx[i] = dx;
                dx = -dx;
                random = (int) (Math.random() * (currentSpeed + 1));

                if (random > currentSpeed) {
                    random = currentSpeed;
                }

                ghostSpeed[i] = validSpeeds[random];
            }

            pacmanX = 7 * BLOCK_SIZE;
            pacmanY = 11 * BLOCK_SIZE;
            pacmanDx = 0;
            pacmanDy = 0;
            reqDx = 0;
            reqDy = 0;
            dying = false;

        }

        @Override
        public void paintComponents(Graphics g) {
            super.paintComponents(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.BLACK);
            g2d.fillRect(0, 0, dimension.width, dimension.height);

            drawMaze(g2d);
            drawScore(g2d);

            if (inGame) {
                playGame(g2d);
            } else {
                showIntroScreen(g2d);
            }

            Toolkit.getDefaultToolkit().sync();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            repaint();
        }

        private Dimension dimension;
        private final Font smallFont = new Font("Ink Free", Font.BOLD, 14);
        private boolean inGame = false;
        private boolean dying = false;

        private final int BLOCK_SIZE = 24;
        private final int BLOCKS = 15;
        private final int SCREEN_SIZE = BLOCKS * BLOCK_SIZE;
        private final int MAX_GHOSTS = 12;
        private final int PACMAN_SPEED = 6;

        private int GHOSTS = 6;
        private int lives, score;
        private int[] dx, dy;
        private int[] ghostX, ghostY, ghostDx, ghostDy, ghostSpeed;

        private Image heart, ghost;
        private Image up, down, left, right;

        private int pacmanX, pacmanY, pacmanDx, pacmanDy, pacmanSpeed;
        private int reqDx, reqDy;

        private final int validSpeeds[] = { 1, 2, 3, 4, 6, 8 };
        private final int maxSpeed = 6;
        private int currentSpeed = 3;
        private short[] screenData;
        private Timer time;

        private final short levelData[] = { 19, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 18, 22, 17, 16, 16, 16,
                16, 24, 16, 16, 16, 16, 16, 16, 16, 16, 20, 25, 24, 24, 24, 28, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20,
                0, 0, 0, 0, 0, 0, 17, 16, 16, 16, 16, 16, 16, 16, 20, 19, 18, 18, 18, 18, 18, 16, 16, 16, 16, 24, 24,
                24, 24, 20, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21, 17, 16, 16, 16, 16, 16, 16, 16, 16,
                20, 0, 0, 0, 0, 21, 17, 16, 16, 16, 24, 16, 16, 16, 16, 20, 0, 0, 0, 0, 21, 17, 16, 16, 20, 0, 17, 16,
                16, 16, 16, 18, 18, 18, 18, 20, 17, 24, 24, 28, 0, 25, 24, 24, 16, 16, 16, 16, 16, 16, 20, 21, 0, 0, 0,
                0, 0, 0, 0, 17, 16, 16, 16, 16, 16, 20, 17, 18, 18, 22, 0, 19, 18, 18, 16, 16, 16, 16, 16, 16, 20, 17,
                16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16, 16, 16, 20, 17, 16, 16, 20, 0, 17, 16, 16, 16, 16, 16, 16,
                16, 16, 20, 25, 24, 24, 24, 26, 24, 24, 24, 24, 24, 24, 24, 24, 24, 28 };

        public class MyKeyAdapter extends KeyAdapter {
            @Override
            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();
                if (inGame) {
                    if (key == KeyEvent.VK_LEFT) {
                        reqDx = -1;
                        reqDy = 0;
                    } else if (key == KeyEvent.VK_RIGHT) {
                        reqDx = 1;
                        reqDy = 0;
                    } else if (key == KeyEvent.VK_UP) {
                        reqDx = 0;
                        reqDy = -1;
                    } else if (key == KeyEvent.VK_DOWN) {
                        reqDx = 0;
                        reqDy = 1;
                    } else if (key == KeyEvent.VK_SPACE && time.isRunning()) {
                        inGame = false;
                    }
                } else {
                    if (key == KeyEvent.VK_SPACE) {
                        inGame = true;
                        startGame();
                    }
                }
            }
        }
    }

}

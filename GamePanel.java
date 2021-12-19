import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;
import java.awt.event.*;

import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int panelWidth = 600;
    static final int panelHeight = 600;
    static final int snakeSize = 20;
    static final int appleSize = 20;
    static final int increment = 5;
    static final int DELAY = 50;
    static final int numOfGrid = (panelWidth * panelHeight) / (snakeSize * snakeSize);
    boolean gameRunning = false;
    int highScore = 0;
    Timer timer;
    Random random;
    Apple apple;
    Snake snake;

    GamePanel() {
        random = new Random();
        this.setPreferredSize(new Dimension(panelWidth, panelHeight));
        super.setBackground(Color.blue);
        this.setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());
        setVisible(true);
        startGame();
    }

    public void startGame() {
        gameRunning = true;
        timer = new Timer(DELAY, this);
        timer.start();
        newSnake();
        newApple();
    }

    public class Apple {
        int appleXCoordinate;
        int appleYCoordinate;

        Apple() {
            appleXCoordinate = random.nextInt((int) (panelWidth / appleSize) - 1) * appleSize;
            appleYCoordinate = random.nextInt((int) (panelWidth / appleSize) - 1) * appleSize;

        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.red);
            g2d.fillRect(apple.appleXCoordinate, apple.appleYCoordinate, appleSize, appleSize);
        }
    }

    public void newApple() {
        apple = new Apple();
        for (int i = 0; i < snake.segments; i++) {
            if (apple.appleXCoordinate == snake.snakeXCoordinates[i]
                    && apple.appleYCoordinate == snake.snakeYCoordinates[i]) {
                newApple();
            }
        }
    }

    public class Snake {
        int applesEaten;
        int segments;
        String direction;
        final int[] snakeXCoordinates = new int[numOfGrid];
        final int[] snakeYCoordinates = new int[numOfGrid];

        Snake() {
            applesEaten = 0;
            segments = 3;
            direction = "Right";
            snakeXCoordinates[0] = 300;
            snakeXCoordinates[1] = 280;
            snakeXCoordinates[2] = 260;
            snakeYCoordinates[0] = 300;
            snakeYCoordinates[1] = 300;
            snakeYCoordinates[2] = 300;
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            for (int i = 0; i < segments; i++) {
                g2d.setColor(Color.green);
                g2d.fillRect(snakeXCoordinates[i], snakeYCoordinates[i], snakeSize, snakeSize);
            }
        }

        public void updateSnake() {
            for (int i = segments; i > 0; i--) {
                snakeXCoordinates[i] = snakeXCoordinates[i - 1];
                snakeYCoordinates[i] = snakeYCoordinates[i - 1];
            }
            if (direction == "Right") {
                snakeXCoordinates[0] = snakeXCoordinates[0] + snakeSize;
            } else if (direction == "Left") {
                snakeXCoordinates[0] = snakeXCoordinates[0] - snakeSize;
            } else if (direction == "Up") {
                snakeYCoordinates[0] = snakeYCoordinates[0] - snakeSize;
            } else if (direction == "Down") {
                snakeYCoordinates[0] = snakeYCoordinates[0] + snakeSize;
            }

            detectCollision();
            detectAppleCollision();
        }

        // Checks if snake collides with boundary or with itself
        public void detectCollision() {
            if (snakeXCoordinates[0] < 0 || snakeXCoordinates[0] >= panelWidth) {
                gameRunning = false;
            } else if (snakeYCoordinates[0] < 0 || snakeYCoordinates[0] >= panelHeight) {
                gameRunning = false;
            } else if (segments >= 4) { // checks if snake collides with itself
                for (int i = 1; i < segments; i++) {
                    if (snakeXCoordinates[0] == snakeXCoordinates[i] && snakeYCoordinates[0] == snakeYCoordinates[i]) {
                        gameRunning = false;
                        break;
                    }
                }
            }
        }
    }

    public void increaseSnake() {
        for (int i = 0; i < 3; i++) {
            snake.snakeXCoordinates[snake.segments + i] = snake.snakeXCoordinates[snake.segments - 1];
            snake.snakeYCoordinates[snake.segments + i] = snake.snakeYCoordinates[snake.segments - 1];
        }
        snake.segments += 3;
    }

    public void detectAppleCollision() {
        if (snake.snakeXCoordinates[0] == apple.appleXCoordinate
                && snake.snakeYCoordinates[0] == apple.appleYCoordinate) {
            snake.applesEaten++;
            newApple();
            increaseSnake();
        }
    }

    public void newSnake() {
        snake = new Snake();
    }

    public void checkGameOver() {
        if (!gameRunning) {
            timer.stop();
            this.removeAll();

        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        apple.paintComponent(g);
        snake.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {
        snake.updateSnake();
        checkGameOver();
        if (gameRunning) {
            repaint();
        }
    }

    public class GameKeyAdapter extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_W:
                    if (!(snake.direction.equals("Down"))) {
                        snake.direction = "Up";
                    }
                    break;
                case KeyEvent.VK_S:
                    if (!(snake.direction.equals("Up"))) {
                        snake.direction = "Down";
                    }
                    break;
                case KeyEvent.VK_D:
                    if (!(snake.direction.equals("Left"))) {
                        snake.direction = "Right";
                    }
                    break;
                case KeyEvent.VK_A:
                    if (!(snake.direction.equals("Right"))) {
                        snake.direction = "Left";
                    }
                    break;
            }
        }
    }
}
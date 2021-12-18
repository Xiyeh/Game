import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;

import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int panelWidth = 600;
    static final int panelHeight = 600;
    static final int snakeSize = 20;
    static final int appleSize = 20;
    static final int increment = 5;
    static final int DELAY = 100;
    static final int numOfGrid = (panelWidth * panelHeight) / (snakeSize * snakeSize);
    static boolean gameRunning = false;
    Timer timer;
    Random random;
    Apple apple;
    Snake snake;

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHeight);
        super.setBackground(Color.BLACK);
        this.setFocusable(true);
        setVisible(true);
        startGame();
    }

    public void startGame() {
        gameRunning = true;
        timer = new Timer(DELAY, this);
        timer.start();
        newApple();
        newSnake();
    }

    public class Apple {
        int appleXCoordinate;
        int appleYCoordinate;

        Apple() {
            appleXCoordinate = random.nextInt((int) (panelWidth / appleSize)) * appleSize;
            appleYCoordinate = random.nextInt((int) (panelWidth / appleSize)) * appleSize;
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.red);
            g2d.fillRect(apple.appleXCoordinate, apple.appleYCoordinate, appleSize, appleSize);
        }
    }

    public void newApple() {
        apple = new Apple();
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
            snakeXCoordinates[0] = 40;
            snakeXCoordinates[1] = 20;
            snakeXCoordinates[2] = 0;
            snakeYCoordinates[0] = 0;
            snakeYCoordinates[1] = 0;
            snakeYCoordinates[2] = 0;
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
            }
        }
    }

    public void newSnake() {
        snake = new Snake();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        apple.paintComponent(g);
        snake.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {
        snake.updateSnake();
        repaint();
    }

}
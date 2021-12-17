import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;

import java.awt.*;
import java.util.LinkedList;

public class GamePanel extends JPanel implements ActionListener {
    static final int panelWidth = 600;
    static final int panelHeight = 600;
    static final int snakeWidth = 20;
    static final int appleSize = 20;
    static final int numOfGrid = (panelWidth * panelHeight) / (snakeWidth * snakeWidth);
    static boolean gameOver = false;

    Random random;
    Apple apple;
    Snake snake;
    String direction;

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHeight);
        super.setBackground(Color.BLACK);
        this.setFocusable(true);

        apple = new Apple();

        snake = new Snake();
        setVisible(true);
    }

    public class Apple {
        int XCoordinate;
        int YCoordinate;

        Apple() {
            XCoordinate = random.nextInt((int) (panelWidth / appleSize)) * appleSize;
            YCoordinate = random.nextInt((int) (panelWidth / appleSize)) * appleSize;
        }

        public void paintComponent(Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.red);
            g2d.fillRect(apple.XCoordinate, apple.YCoordinate, appleSize, appleSize);
        }
    }

    public void newApple() {
        apple = new Apple();
    }

    public class Snake {
        // represents each segment of the snake
        class SnakeSegment extends JPanel {
            public int xCoordSS;
            public int yCoordSS;
            Graphics2D g2d;

            SnakeSegment(int xCoord, int yCoord) {
                xCoordSS = xCoord;
                yCoordSS = yCoord;
            }

        }

        LinkedList<SnakeSegment> segments;

        Snake() {
            segments = new LinkedList<SnakeSegment>();
            SnakeSegment head = new SnakeSegment(300, 300);
            ///
            SnakeSegment b1 = new SnakeSegment(280, 300);
            SnakeSegment b2 = new SnakeSegment(260, 300);
            segments.add(b1);
            segments.add(b2);
            ///
            segments.addFirst(head);
            direction = "Right";

            // while (!gameOver) {
            //     updateSnake();
            //     try {
            //         wait(500);
            //     }
                
            // }
            // repaint();
        }

        // Loops through snakeSegmentList[] and draws each segment
        public void paintComponent(Graphics g) {
            SnakeSegment tempSegment;
            for (int i = 0; i < segments.size(); i++) {
                tempSegment = segments.get(i);
                tempSegment.g2d = (Graphics2D) g;
                tempSegment.g2d.setColor(Color.green);
                segments.get(i).g2d.fillRect(tempSegment.xCoordSS, tempSegment.yCoordSS, snakeWidth, snakeWidth);

            }
        }
    }

    // public void updateSnake() {
    //     snake.segments.addFirst(snake.segments.getFirst() + snakeWidth);
    //     int changeX;
    //     int changeY;
    //     if (direction.equals("Right")) {
    //         changeX = snakeWidth;
    //         changeY = 0;
    //     } else if (direction.equals("Left")) {
    //         changeX = -snakeWidth;
    //         changeY = 0;
    //     } else if (direction.equals("Down")) {
    //         changeX = 0;
    //         changeY = snakeWidth;
    //     } else {
    //         changeX = 0;
    //         changeY = -snakeWidth;
    //     }

    //     for (int i = snake.segments.size(); i > 0; i--) {
    //         snake.segments.get(i).xCoordSS = snake.segments.get(i - 1).xCoordSS;
    //     }

    //     snake.SnakeSegment newHead = new
    //     snake.SnakeSegment(snake.segments.getFirst().xCoordSS + changeX,
    //     snake.segments.getFirst().yCoordSS + changeY)
    //     snake.segments.addFirst(newHead);
    //     repaint();
    // }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        apple.paintComponent(g);
        snake.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;

import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int panelWidth = 600;
    static final int panelHeight = 600;
    static final int snakeWidth = 20;
    static final int appleSize = 20;
    static final int numOfGrid = (panelWidth * panelHeight) / (snakeWidth * snakeWidth);

    Random random;
    Apple apple = new Apple();
    Snake snake;

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHeight);
        super.setBackground(Color.blue);
        this.setFocusable(true);
        apple.newApple();
        snake = new Snake();
        // super.add(apple);
        setVisible(true);
    }

    public class Apple {
        int XCoordinate;
        int YCoordinate;

        public void newApple() {
            XCoordinate = random.nextInt((int) ((panelWidth / appleSize) - 1)) * appleSize;
            YCoordinate = random.nextInt((int) ((panelWidth / appleSize) - 1)) * appleSize;
        }
    }

    public class Snake {
        // represents each segment of the snake
        class SnakeSegment extends JPanel {
            int xCoordSS;
            int yCoordSS;
            Graphics2D g2d;

            SnakeSegment(int xCoord, int yCoord) {
                xCoordSS = xCoord;
                yCoordSS = yCoord;
            }

        }

        // String that represents the direction of the snake ("Up", "Right", "Down", or
        // "Left")
        String direction;

        // Array of all snake segments. Represents the full snake. First element
        // represents the 'head' of the snake and the last represents the 'tail'
        SnakeSegment snakeSegmentList[];

        Snake() {
            snakeSegmentList = new SnakeSegment[numOfGrid];
            SnakeSegment head = new SnakeSegment(300, 300);
            snakeSegmentList[0] = head;
            direction = "Right";
            repaint();
        }

        // Loops through snakeSegmentList[] and draws each segment
        public void paintComponent(Graphics g) {
            SnakeSegment tempSegment;
            for (int i = 0; i < numOfGrid; i++) {
                if (snakeSegmentList[i] == null) {
                    break;
                }
                tempSegment = snakeSegmentList[i];
                tempSegment.g2d = (Graphics2D) g;
                tempSegment.g2d.setColor(Color.green);
                snakeSegmentList[i].g2d.fillRect(tempSegment.xCoordSS, tempSegment.yCoordSS, snakeWidth, snakeWidth);

            }
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(apple.XCoordinate, apple.YCoordinate, appleSize, appleSize);
        snake.paintComponent(g);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}

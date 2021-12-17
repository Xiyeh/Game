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

    Random random;
    Apple apple = new Apple();

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHeight);
        super.setBackground(Color.blue);
        this.setFocusable(true);
        apple.newApple();
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

            SnakeSegment(int xCoord, int yCoord) {
                xCoordSS = xCoord;
                yCoordSS = yCoord;
            }

            SnakeSegment() {

            }

        }

        // String that represents the direction of the snake ("Up", "Right", "Down", or
        // "Left")
        String direction;

        // Array of all snake segments. Represents the full snake. First element
        // represents the 'head' of the snake and the last represents the 'tail'
        SnakeSegment snakeSegmentList[];

        Snake() {
            snakeSegmentList = new SnakeSegment[(panelWidth * panelHeight) / (snakeWidth * snakeWidth)];
            SnakeSegment head = new SnakeSegment(300, 300);
            snakeSegmentList[0] = head;
        }
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(apple.XCoordinate, apple.YCoordinate, appleSize, appleSize);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}

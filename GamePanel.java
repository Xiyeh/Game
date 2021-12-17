import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;

import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int panelWidth = 600;
    static final int panelHieght = 600;
    static final int snakeWidth = 20;
    static final int appleSize = 20;

    Random random;
    Apple apple = new Apple();

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHieght);
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

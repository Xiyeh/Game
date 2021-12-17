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
    int appleXCoordinate;
    int appleYCoordinate;
    Random random;

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHieght);
        super.setBackground(Color.blue);
        this.setFocusable(true);
        newApple();
        // super.add(apple);
    }

    public void newApple() {
        appleXCoordinate = random.nextInt((int)(panelWidth / appleSize)) * appleSize;
        appleYCoordinate = random.nextInt((int)(panelWidth / appleSize)) * appleSize;
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.red);
        g2d.fillRect(appleXCoordinate, appleYCoordinate, appleSize, appleSize);
    }

    public void actionPerformed(ActionEvent e) {
        repaint();
    }

}

import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.util.Random;

import java.awt.*;

public class GamePanel extends JPanel implements ActionListener {
    static final int panelWidth = 600;
    static final int panelHieght = 600;
    static final int snakeWidth = 5;
    static final int appleSize = 5;
    int appleXCoordinate;
    int appleYCoordinate;
    Random random;

    GamePanel() {
        random = new Random();
        super.setBounds(0, 0, panelWidth, panelHieght);
        super.setBackground(Color.blue);
        this.setFocusable(true);
        //newApple();
        // super.add(apple);
    }

    // public void newApple() {
    //     appleXCoordinate = random.nextInt((int)(panelWidth / appleSize)) * appleSize;
    //     appleYCoordinate = random.nextInt((int)(panelWidth / appleSize)) * appleSize;
    // }

    // @Override
    // public void paintComponent(Graphics g) {
    //     this.paintComponent(g);
    //     draw(g);
    // }

    // public void draw(Graphics g) {
    //     g.setColor(Color.RED);
    //     g.fillRect(appleXCoordinate, appleYCoordinate, appleSize, appleSize);
    // }

    public void actionPerformed(ActionEvent e) {

    }

}

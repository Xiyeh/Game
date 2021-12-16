import java.awt.Color;

import javax.swing.JFrame;
import java.awt.Container;


public class Frame extends JFrame {
    Container container;
    GamePanel titleScreen;

    Frame() {
        super.setTitle("Snake Game");
        super.setSize(600, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setVisible(true);
        super.setLayout(null);
        super.getContentPane().setBackground(Color.BLACK);
        super.setLocationRelativeTo(null);
        container = super.getContentPane();
        
        GamePanel titleScreen = new GamePanel();

        container.add(titleScreen.titlePanel);
        container.add(titleScreen.highScorePanel);
        container.add(titleScreen.startButtonPanel);
        container.add(titleScreen.exitButtonPanel);
        // super.pack();
    }
}

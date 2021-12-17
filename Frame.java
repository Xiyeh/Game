import java.awt.Color;

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Frame extends JFrame {
    // Container container;
    TitleScreenPanel titleScreenPanel;
    GamePanel gamePanel;
    TitleScreenListener titleScreenListener = new TitleScreenListener();

    Frame() {
        super.setTitle("Snake Game");
        super.setSize(600, 600);
        super.setDefaultCloseOperation(EXIT_ON_CLOSE);
        super.setResizable(false);
        super.setVisible(true);
        super.setLayout(null);
        super.getContentPane().setBackground(Color.BLACK);
        super.setLocationRelativeTo(null);

        titleScreenPanel = new TitleScreenPanel();
        this.add(titleScreenPanel.titlePanel);
        this.add(titleScreenPanel.highScorePanel);
        this.add(titleScreenPanel.startButtonPanel);
        this.add(titleScreenPanel.exitButtonPanel);
        titleScreenPanel.startButton.addActionListener(titleScreenListener);
        titleScreenPanel.exitButton.addActionListener((event) -> System.exit(0));
    }

    public void createGamePanel() {
        this.titleScreenPanel.titlePanel.setVisible(false);
        this.titleScreenPanel.highScorePanel.setVisible(false);
        this.titleScreenPanel.startButtonPanel.setVisible(false);
        this.titleScreenPanel.exitButtonPanel.setVisible(false);
        gamePanel = new GamePanel();
        this.add(gamePanel);
        super.setVisible(true);

    }

    public class TitleScreenListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGamePanel();
            loop();
        }
    }

    public void loop() {
        for (int i = 0; i < 15; i++) {
            gamePanel.updateSnake();
            gamePanel.repaint();
            super.repaint();

        }
    }

    // refreshes Panel
    public void updatePanel() {
        gamePanel.repaint();
    }
}

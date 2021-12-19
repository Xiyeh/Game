import java.awt.Color;
import java.awt.BorderLayout;
import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

public class Frame extends JFrame {
    // Container container;
    static final int DELAY = 1000;
    TitleScreenPanel titleScreenPanel;
    GamePanel gamePanel;
    TitleScreenListener titleScreenListener = new TitleScreenListener();
    Timer timer;

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
        super.setLayout(new BorderLayout());
        gamePanel = new GamePanel();
        this.add(gamePanel);
        this.pack();
        this.setVisible(true);
    }

    public void createGameOverPanel() {
        this.gamePanel.setVisible(false);
    }

    public class TitleScreenListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGamePanel();
        }
    }
}

import javax.swing.JFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    // Container container;
    static final int DELAY = 100;
    int highScore = 0;
    TitleScreenPanel titleScreenPanel;
    GamePanel gamePanel;
    TitleScreenListener titleScreenListener = new TitleScreenListener();
    EndGameListener endGameListener = new EndGameListener();
    BackToTitleScreen backToTitleScreen = new BackToTitleScreen();
    Timer timer;
    GameOverPanel gameOverPanel;

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

        timer = new Timer(DELAY, endGameListener);
        timer.start();
    }

    public void createGameOverPanel() {
        highScore = gamePanel.highScore;
        this.getContentPane().remove(gamePanel);
        gameOverPanel = new GameOverPanel(highScore);
        this.add(gameOverPanel);
        gameOverPanel.titleScreenButton.addActionListener(backToTitleScreen);

        this.setVisible(true);
    }

    void backToTitleScreen() {
        this.getContentPane().remove(gameOverPanel);
        this.titleScreenPanel.titlePanel.setVisible(true);
        this.titleScreenPanel.highScorePanel.setVisible(true);
        this.titleScreenPanel.startButtonPanel.setVisible(true);
        this.titleScreenPanel.exitButtonPanel.setVisible(true);
    }

    public class TitleScreenListener implements ActionListener {
        public void actionPerformed(ActionEvent event) {
            createGamePanel();
        }
    }

    public class EndGameListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkGameOver();
        }
    }

    public class BackToTitleScreen implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            backToTitleScreen();
        }

    }

    public void checkGameOver() {
        if (gamePanel.gameRunning == false) {
            System.out.println("GAME OVER DETECTED");
            timer.stop();
            createGameOverPanel();
            titleScreenPanel.changeHighScore(gamePanel.highScore);
        }
    }
}

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.*;

public class GameOverPanel extends JPanel {
    JButton titleScreenButton;
    int score;

    GameOverPanel(int score) {
        this.score = score;
        this.setPreferredSize(new Dimension(600, 600));
        super.setBackground(Color.black);
        repaint();
        titleScreenButton = new JButton("Back to Titlescreen");
        titleScreenButton.setFont(new Font("Papyrus", Font.BOLD, 40));
        this.setLayout(new GridBagLayout());
        this.add(titleScreenButton, new GridBagConstraints());
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Papyrus", Font.BOLD, 60));
        g.drawString("Game Over", 130, 100);
        g.setFont(new Font("Papyrus", Font.BOLD, 50));
        g.setColor(Color.green);
        g.drawString("Score: " + score, 200, 200);
    }
}

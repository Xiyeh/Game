import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPanel extends JPanel {
    JButton titleScreenButton;

    GameOverPanel() {
        this.setPreferredSize(new Dimension(600, 600));
        super.setBackground(Color.black);
        repaint();
        titleScreenButton = new JButton("Start");
        titleScreenButton.setFont(new Font("Papyrus", Font.BOLD, 40));
        this.add(titleScreenButton);
        this.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.setFont(new Font("Papyrus", Font.BOLD, 50));
        FontMetrics metrics = g.getFontMetrics(new Font("Papyrus", Font.BOLD, 50));

        g.drawString("Game Over", 170, 300);
    }
}

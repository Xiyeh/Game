import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.util.Random;


public class GamePanel extends JPanel implements ActionListener{
    Random random;

    GamePanel() {
        random = new Random();
        super.setPreferredSize(new Dimension(600, 600));
        super.setBackground(Color.black);
    }

    public void actionPerformed(ActionEvent e) {

    }
}

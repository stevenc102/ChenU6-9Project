import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class GameFrame extends JFrame implements ActionListener {
    private Game minesweeper;
    private GamePanel gamePanel;
    private Timer time;
    private JPanel blankPanel;
    private int seconds;
    public GameFrame() {
        super();
        minesweeper = new Game();
        gamePanel = new GamePanel(minesweeper);
        setUpFrame();
        blankPanel = new JPanel();
        seconds = 0;
    }


    public void setUpFrame() {
        time = new Timer(1000, null);
        time.addActionListener(this);
        time.start();
        setSize(600, 400);
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (Tile tile : gamePanel.getTiles()) {
            add(tile.getButton());
        }
        setLayout(new GridLayout(16, 16));
        setVisible(true);
    }

    public void initGame() {
        while(!gamePanel.checkLost()) {
            if (seconds % 3 == 0) {
                setTitle("Minesweeper: " + GamePanel.bombsLeft + " bombs left");
            }
        }
        dispose();
        JFrame frame = new JFrame();
        frame.setSize(600, 400);
        frame.setTitle("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new JLabel("YOU LOSE", SwingConstants.CENTER));
        frame.setVisible(true);
    }

    private void timerFires() {
        seconds++;
    }

    public void actionPerformed(ActionEvent e) {}
}
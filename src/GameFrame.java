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
    private static int highScore = 0;
    private int seconds;
    private JButton restartButton;
    public GameFrame() {
        super();
        restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        minesweeper = new Game();
        gamePanel = new GamePanel(minesweeper);
        setUpFrame();
        blankPanel = new JPanel();
        seconds = 0;
        initGame();
    }


    public void setUpFrame() {
        time = new Timer(1000, null);
        time.addActionListener(this);
        time.start();
        setSize(600, 400);
        setTitle("Minesweeper");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for (Tile[] tileArray : gamePanel.getTiles()) {
            for (Tile tile : tileArray) {
                add(tile.getButton());
            }
        }
        setLayout(new GridLayout(16, 16));
        setVisible(true);
    }

    public void initGame() {
        while(!gamePanel.checkLost() && !gamePanel.checkWon()) {
            if (seconds % 2 == 0) {
                setTitle("Minesweeper: " + GamePanel.bombsLeft + " bombs left");
                gamePanel.revealBlank();
            }
        }

        if (gamePanel.checkLost()) {
            gamePanel.endGame();
            JFrame frame = new JFrame();
            frame.setSize(600, 400);
            frame.setTitle("Minesweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(2, 2));
            frame.add(new JLabel("YOU LOSE", SwingConstants.CENTER));
            frame.add(new JLabel("Time taken: " + seconds), SwingConstants.CENTER);
            if (highScore != 0) {
                frame.add(new JLabel("Current highscore: " + highScore + " seconds"), SwingConstants.CENTER);
            } else {
                frame.add(new JLabel("There is currently no highscore :("), SwingConstants.CENTER);
            }
            frame.add(restartButton);
            frame.setVisible(true);
        } else {
            gamePanel.endGame();
            highScore = seconds;
            JFrame frame = new JFrame();
            frame.setSize(600, 400);
            frame.setTitle("Minesweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(2, 2));
            frame.add(new JLabel("YOU WIN", SwingConstants.CENTER));
            frame.add(new JLabel("Time taken: " + seconds), SwingConstants.CENTER);
            if (highScore != 0) {
                frame.add(new JLabel("Current highscore: " + highScore + " seconds"), SwingConstants.CENTER);
            } else {
                frame.add(new JLabel("There is currently no highscore :("), SwingConstants.CENTER);
            }
            frame.add(restartButton);
            frame.setVisible(true);
        }
    }

    private void timerFires() {
        seconds++;
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            if (((JButton)source).getText().equals("Restart")) {
                dispose();
                minesweeper = new Game();
                GamePanel gamePanel2 = new GamePanel(minesweeper);
                JFrame temp = new JFrame();
                temp.add(gamePanel2);
                temp.setSize(600, 400);
                temp.setTitle("Minesweeper");
                temp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                for (Tile[] tileArray : gamePanel.getTiles()) {
                    for (Tile tile : tileArray) {
                        temp.add(tile.getButton());
                    }
                }
                temp.setLayout(new GridLayout(16, 16));
                seconds = 0;
                temp.setVisible(true);
                System.out.println(gamePanel2.checkLost());
                System.out.println(gamePanel2.checkWon());

//
//                }
            }
        }
    }
}
import javax.swing.JFrame;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class GameFrame extends JFrame implements ActionListener {
    private Game minesweeper;
    private GamePanel gamePanel;
    private Timer time;
    private boolean temp;
    private JFrame frame;
    private static ArrayList<Integer> highScore = new ArrayList<Integer>();
    private int seconds;
    private boolean restart;
    private JButton restartButton;
    public GameFrame() {
        super();
        restart = false;
        frame = new JFrame();
        restartButton = new JButton("Restart");
        restartButton.addActionListener(this);
        minesweeper = new Game();
        gamePanel = new GamePanel(minesweeper);
        setUpFrame();
        temp = true;
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
        setLayout(new GridLayout(gamePanel.getGame().getBoard().getHeight(), gamePanel.getGame().getBoard().getWidth()));
        setVisible(true);
    }

    public void initGame() {
        gamePanel.revealRandom();
        while(!gamePanel.checkLost() && !gamePanel.checkWon()) {
            setTitle("Minesweeper: " + GamePanel.bombsLeft + " bombs left");
            gamePanel.revealBlank();
        }

        if (gamePanel.checkLost() && temp) {
            gamePanel.endGame();
            frame.setSize(600, 400);
            frame.setTitle("Minesweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(2, 2));
            frame.add(new JLabel("YOU LOSE", SwingConstants.CENTER));
            frame.add(new JLabel("Time taken: " + seconds, SwingConstants.CENTER));
            if (highScore.size() != 0) {
                frame.add(new JLabel("Current highscores: " + highScore + " seconds", SwingConstants.CENTER));
            } else {
                frame.add(new JLabel("There is currently no highscore. ", SwingConstants.CENTER));
            }
            frame.add(restartButton);
            frame.setVisible(true);
            temp = false;
        } else if (gamePanel.checkWon() && temp){
            gamePanel.endGame();
            highScore.add(seconds);
            frame.setSize(600, 400);
            frame.setTitle("Minesweeper");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLayout(new GridLayout(2, 2));
            frame.add(new JLabel("YOU WIN", SwingConstants.CENTER));
            frame.add(new JLabel("Time taken: " + seconds, SwingConstants.CENTER));
            if (highScore.size() != 0) {
                frame.add(new JLabel("Current highscores: " + highScore + " seconds", SwingConstants.CENTER));
            } else {
                frame.add(new JLabel("There is currently no highscore. ", SwingConstants.CENTER));
            }
            frame.add(restartButton);
            frame.setVisible(true);
            temp = false;
        }
    }

    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        if (source instanceof JButton) {
            if (((JButton)source).getText().equals("Restart")) {
                    restart = true;
            }
            } else if (source instanceof Timer) {
            seconds++;
        }
    }

    public boolean getRestart() {
        return restart;
    }

    public void removeFrame() {
        dispose();
        frame.dispose();
    }
}
import javax.swing.*;

public class Game extends JPanel {
    private int HEIGHT = 100;
    private int WIDTH = 200;
    public Game() {
        Board gameBoard = new Board(16, 16);
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(WIDTH, HEIGHT);
        JButton button = new JButton("Press");
        frame.getContentPane().add(button); // Adds Button to content pane of frame
        frame.setVisible(true);
    }

    public int[][] getBoard() {

    }

}

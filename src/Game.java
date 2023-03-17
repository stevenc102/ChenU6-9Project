import javax.swing.*;
import java.awt.*;

public class Game extends JPanel {
    private int HEIGHT = 200;
    private int WIDTH = 200;

    private Board board;
    public Game() {
        Board gameBoard = new Board(16, 16);
        JFrame frame = new JFrame("Minesweeper");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(HEIGHT, WIDTH);
        frame.setVisible(true);
        GridLayout grid = new GridLayout(2, 2);
        int count = 1;
        for (int i = 0 ; i < 4; i++) {

            Button button = new Button(count + "");
            button.setBounds(new Rectangle(5, 5));
            count++;
            frame.add(button);

        }

        frame.setLayout(grid);
    }

    public Board getBoard() {
        return board;
    }

}

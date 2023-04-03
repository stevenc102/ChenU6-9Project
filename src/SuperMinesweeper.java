import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SuperMinesweeper implements ActionListener {
    GameFrame game = new GameFrame();
    private Timer time;
    private int seconds;
    public SuperMinesweeper() {
        game.initGame();
        time = new Timer(1000, null);
        time.start();
        time.addActionListener(this);
    }

    public void initGame() {
        for (int i = 0; i < 10000; i++) {
            if (game.getRestart() && seconds % 2 == 0) {
                game.removeFrame();
                game = new GameFrame();
                game.initGame();
            }
        }
    }

    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (source instanceof Timer) {
            seconds++;
        }
    }
}

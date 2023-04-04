import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.MouseEvent;

public class Bomb extends Tile implements ActionListener{
    private boolean lost;
    public Bomb(int row, int col) {
        super(9, row, col);
        lost = false;
    }

    public boolean isLost() {
        return lost;
    }


    public void actionPerformed(ActionEvent ae){
        if (!getFlagged()) {
            getButton().setEnabled(false);
            getButton().setBackground(Color.WHITE);
            getButton().setText("💣");
            lost = true;
        }
    }



    public void setDisabled() {
       getButton().setEnabled(false);
       getButton().setBackground(Color.red);
       getButton().setText("💣");

    }
}

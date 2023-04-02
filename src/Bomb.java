import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.MouseEvent;
import javax.swing.*;
public class Bomb extends Tile implements ActionListener{
    private boolean lost;
    public Bomb() {
        super(9);
        lost = false;
    }

    public boolean isLost() {
        return lost;
    }


    public void actionPerformed(ActionEvent ae){
        getButton().setEnabled(false);
        getButton().setBackground(Color.red);
        getButton().setText("💣");
        lost = true;
    }


}

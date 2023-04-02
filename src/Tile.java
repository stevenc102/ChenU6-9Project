import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Tile implements ActionListener, MouseListener {
    private int num;
    private JButton button;
    private boolean isFlagged;

    public Tile(int num) {
        this.num = num;
        isFlagged = false;
        initTile();
    }

    private void initTile() {
        button = new JButton("");
        button.addActionListener(this);
        button.addMouseListener(this);
        button.setForeground(Color.BLACK);
        button.setBackground(Color.LIGHT_GRAY);
    }

    public JButton getButton() {
        return button;
    }

    public boolean getFlagged() {
        return isFlagged;
    }

    public void actionPerformed(ActionEvent ae){
        if (!isFlagged) {
            button.setEnabled(false);
            button.setBackground(Color.WHITE);
            if (num > 0) {
                button.setText("" + num);
            } else {
                button.setText("");
            }
        }
    }

    public void mouseClicked(MouseEvent me) {
        if (SwingUtilities.isRightMouseButton(me)) {
            if (button.getText().equals("\uD83D\uDEA9")){
                isFlagged = false;
                button.setText("");
                GamePanel.bombsLeft ++;
            } else {
                isFlagged = true;
                button.setText("\uD83D\uDEA9");
                GamePanel.bombsLeft --;
            }
        }
    }

    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}

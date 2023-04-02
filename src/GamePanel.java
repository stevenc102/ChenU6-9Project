import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{

    public static int bombsLeft;
    private Game minesweeper;
    private ArrayList<Tile> tiles;
    public GamePanel(Game minesweeper) {
        super();
        tiles = new ArrayList<Tile>();
        this.minesweeper = minesweeper;
        bombsLeft = minesweeper.getBoard().getBombs();
        setUpPanel();
    }

    private void setUpPanel() {
        for (int i = 0; i < minesweeper.getBoard().getBoard().length; i++) {
            for (int j = 0; j < minesweeper.getBoard().getBoard()[i].length; j++){
                int num = minesweeper.getBoard().getBoard()[i][j];
                if (num == 9){
                    Bomb bomb = new Bomb();
                    tiles.add(bomb);
                } else {
                    Tile tile = new Tile(num);
                    tiles.add(tile);
                }
            }

        }

    }

    public boolean checkLost() {

        for (int i = 0; i < tiles.size(); i++) {
            if (tiles.get(i).getFlagged()) {

            }
            if (tiles.get(i) instanceof Bomb) {
                if (((Bomb)tiles.get(i)).isLost()) {
                    return true;
                }
            }
        }

        return false;
    }

    public ArrayList<Tile> getTiles(){
        return tiles;
    }




}
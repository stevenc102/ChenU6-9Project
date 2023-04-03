import javax.swing.*;
import java.util.ArrayList;

public class GamePanel extends JPanel{

    public static int bombsLeft;
    private Game minesweeper;
    private Tile[][] tiles;
    public GamePanel(Game minesweeper) {
        super();
        tiles = new Tile[minesweeper.getBoard().getBoard().length][minesweeper.getBoard().getBoard()[0].length];
        this.minesweeper = minesweeper;
        bombsLeft = minesweeper.getBoard().getBombs();
        setUpPanel();
    }

    private void setUpPanel() {
        for (int i = 0; i < minesweeper.getBoard().getBoard().length; i++) {
            for (int j = 0; j < minesweeper.getBoard().getBoard()[i].length; j++){
                int num = minesweeper.getBoard().getBoard()[i][j];
                if (num == 9){
                    Bomb bomb = new Bomb(i, j);
                    tiles[i][j] = bomb;
                } else {
                    Tile tile = new Tile(num, i, j);
                    tiles[i][j] = tile;
                }
            }

        }

    }

    public boolean checkLost() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j] instanceof Bomb) {
                    if (((Bomb) tiles[i][j]).isLost()) {
                        return true;
                    }
                }
            }
        }



        return false;
    }

    public boolean checkWon() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                if (tiles[i][j].getNum() != 0 && tiles[i][j].getNum() != 9) {
                    if (!tiles[i][j].isRevealed()) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public void endGame() {
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                tiles[i][j].setDisabled();
            }
        }
    }

    public void revealBlank() {
        boolean temp = false;
        for (Tile[] tileArray : tiles) {
            for (Tile tile : tileArray) {
                if (tile.isRevealed()) {
                    temp = true;
                }
                if (temp) {
                    int r = tile.getRow();
                    int c = tile.getCol();
                    int startR = r - 1;
                    int endR = r + 1;
                    int startC = c - 1;
                    int endC = c + 1;
                    if (startR < 0) {
                        startR = 0;
                    }
                    if (endR > minesweeper.getBoard().getBoard().length - 1) {
                        endR = minesweeper.getBoard().getBoard().length - 1;
                    }
                    if (startC < 0) {
                        startC = 0;
                    }
                    if (endC > minesweeper.getBoard().getBoard()[0].length - 1) {
                        endC = minesweeper.getBoard().getBoard()[0].length - 1;
                    }
                    if (tiles[r][c].isRevealed() && tiles[r][c].getNum() == 0) {
                        for (int i = startR; i <= endR; i++) {
                            for (int j = startC; j <= endC; j++) {
                                tiles[i][j].reveal();
                            }
                        }
                    }

                }

            }

        }
    }

    public Tile[][] getTiles(){
        return tiles;
    }




}
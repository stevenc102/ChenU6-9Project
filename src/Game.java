
public class Game{
    private Board board;
    private Board revealedBoard;
    public Game() {

        board = new Board(16, 16);
        revealedBoard = new Board(16, 16);
        board.initBoard();


    }


    public Board getBoard() {
        return board;
    }

    public Board getRevealedBoard() {
        return revealedBoard;
    }


}

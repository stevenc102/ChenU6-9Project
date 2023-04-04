
public class Game{
    private final Board board;
    public Game() {
        board = new Board(8, 8);
        board.initBoard();
    }

    public Board getBoard() {
        return board;
    }


}

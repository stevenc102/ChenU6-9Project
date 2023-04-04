
public class Game{
    private final Board board;
    public Game() {
        board = new Board(4, 4);
        board.initBoard();
    }

    public Board getBoard() {
        return board;
    }


}

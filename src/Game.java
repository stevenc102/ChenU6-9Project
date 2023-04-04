
public class Game{
    private final Board board;
    public Game() {
        board = new Board(5, 5);
        board.initBoard();
    }

    public Board getBoard() {
        return board;
    }


}

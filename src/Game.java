
public class Game{
    private final Board board;
    public Game() {
        board = new Board(8, 10);
        board.initBoard();
    }

    public Board getBoard() {
        return board;
    }


}


public class Game{
    private final Board board;
    public Game() {
        board = new Board(16, 16);
        board.initBoard();
    }

    public Board getBoard() {
        return board;
    }


}

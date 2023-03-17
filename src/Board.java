public class Board {
    private int rows;
    private int columns;

    private int[][] board;
    public Board(int height, int width) {
        this.rows = height;
        this.columns = width;
        board = new int[height][width];
    }




}

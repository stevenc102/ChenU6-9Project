public class Board {
    private final int rows;
    private final int columns;

    private final int bombs;
    private final int[][] board;
    public Board(int height, int width) {
        this.rows = height;
        this.columns = width;
        bombs = (int)(rows * columns * 0.21);
        board = new int[height][width];
    }

    public void initBoard() {
        int bombs = this.bombs;
        while(bombs > 0) {
            for (int i = 0 ; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if ((int)(Math.random() * 8) == 0 && bombs > 0) {
                        board[i][j] = 9;
                        bombs--;
                    }
                }
            }
        }
        for (int i = 0 ; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 9) {
                    incrementAdjacent(i, j);
                }
            }
        }
    }

    public int getHeight() {
        return rows;
    }

    public int getWidth() {
        return columns;
    }

    public int[][] getBoard() {
        return board;
    }

    private void incrementAdjacent(int row, int col) {
        int startR = row - 1;
        int endR = row + 1;
        int startC = col - 1;
        int endC = col + 1;
        if (startR < 0) {
            startR = 0;
        }
        if (endR > board.length - 1) {
            endR = board.length - 1;
        }
        if (startC < 0) {
            startC = 0;
        }
        if (endC > board[0].length - 1) {
            endC = board[0].length - 1;
        }
        for (int i = startR; i <= endR; i++) {
            for (int j = startC; j <= endC; j++) {
                if (board[i][j] != 9) {
                    board[i][j] ++;
                }
            }
        }
    }

    public int getBombs() {
        return bombs;
    }

}

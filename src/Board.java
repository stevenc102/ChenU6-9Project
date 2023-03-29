public class Board {
    private int rows;
    private int columns;

    private int[][] board;
    public Board(int height, int width) {
        this.rows = height;
        this.columns = width;
        board = new int[height][width];
    }

    public void initBoard() {
        int bombs = (int)(rows * columns * 0.21);
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
        int r = row;
        int c = col;
        int startR = r - 1;
        int endR = r + 1;
        int startC = c - 1;
        int endC = c + 1;
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


}

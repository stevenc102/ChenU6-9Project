
public class Game{
    private Board board;
    private Board revealedBoard;
    public Game() {

        board = new Board(16, 16);
        revealedBoard = new Board(16, 16);
        board.initBoard();


    }

    public void initGame(){
        System.out.print("  ");
        for (int width = 0; width < revealedBoard.getBoard()[0].length; width++){
            System.out.print("|---");
        }
        System.out.println(" |");
        for (int i = 0; i < revealedBoard.getBoard().length; i++){
            if (i <= 10){
                System.out.print((i+1) + " |");
            } else {
                System.out.print((i + 1) +"|");
            }
            for (int j = 0; j < revealedBoard.getBoard()[i].length; j++){
                if (revealedBoard.getBoard()[i][j] == 9) {
                    System.out.print("💣 |");
                } else if (revealedBoard.getBoard()[i][j] == 0){
                    if (i < 10){
                        System.out.print("   " + "|");
                    } else {
                        System.out.print("   " + " |");
                    }
                } else {
                    System.out.print(" " + revealedBoard.getBoard()[i][j] + " |");
                }
            }
            System.out.println("");
            System.out.print("  ");
            for (int width = 0; width < revealedBoard.getBoard()[0].length; width++){
                System.out.print("|---");
            }
            System.out.println(" |");
        }

    }
}

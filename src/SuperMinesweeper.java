public class SuperMinesweeper {
    GameFrame game = new GameFrame();

    public SuperMinesweeper() {
        game.initGame();
    }

    public void initGame() {
        while(true) {
            if (game.getRestart()) {
                game.removeFrame();
                game = new GameFrame();
                game.initGame();
            }
        }
    }
}

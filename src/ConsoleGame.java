public class ConsoleGame extends GameTable {

    /* Displays current gameplay in console after player does a turn */
    public void DoTurnInConsole(int x, int y) {
        DoTurn(x, y);
        for (int xpos = 0; xpos < _visabletable[0].length; xpos++) {
            for (int ypos = 0; ypos < _visabletable.length; ypos++) {
                System.out.print(_visabletable[ypos][xpos] + "  ");
            }
            System.out.println();
        }
    }

    /* Displays current gameplay in console */
    public void DoTurnInConsole() {
        for (int xpos = 0; xpos < _visabletable[0].length; xpos++) {
            for (int ypos = 0; ypos < _visabletable.length; ypos++) {
                System.out.print(_visabletable[ypos][xpos] + "  ");
            }
            System.out.println();
        }
    }

    /* Displays whole current game table in console window */
    public void DrawTableInConsole() {
        for (int x = 0; x < _table[0].length; x++) {
            for (int y = 0; y < _table.length; y++) {
                System.out.print(_table[y][x] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    public void CreateTable(int xsize, int ysize, int bombs) {
        super.CreateTable(xsize, ysize, bombs);
        DoTurnInConsole();
    }

    @Override
    protected void GameOver() {
        super.GameOver();
        System.out.println("Game Over!");
    }

    @Override
    protected void GameWin() {
        super.GameOver();
        System.out.println("You Won!");
    }

}

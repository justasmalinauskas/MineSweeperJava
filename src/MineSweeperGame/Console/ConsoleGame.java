package MineSweeperGame.Console;

import MineSweeperGame.Base.GameTable;

public class ConsoleGame extends GameTable {

    /* Displays current gameplay in Console after player does a turn */
    public void DoTurnInConsole(int x, int y) {
        DoTurn(x, y);
        for (int ypos = 0; ypos < _ysize; ypos++) {
            for (int xpos = 0; xpos < _xsize; xpos++) {
                System.out.print(_visabletable[ypos][xpos] + "  ");
            }
            System.out.println();
        }
    }

    /* Displays current gameplay in Console */
    public void DoTurnInConsole() {
        for (int ypos = 0; ypos < _ysize; ypos++) {
            for (int xpos = 0; xpos < _xsize; xpos++) {
                System.out.print(_visabletable[ypos][xpos] + "  ");
            }
            System.out.println();
        }
    }

    /* Displays whole current game table in Console*/
    public void DrawTableInConsole() {
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                System.out.print(_table[y][x] + "\t");
            }
            System.out.println();
        }
    }

    @Override
    protected void OutOfTable() {
        System.out.println("Koordinatės nėra tinkamos");
    }

    /* Creates game table for Console version */
    @Override
    public void CreateTable(int xsize, int ysize, int bombs) {
        super.CreateTable(xsize, ysize, bombs);
        DoTurnInConsole();
    }

    /* Game Over for Console version */
    @Override
    protected void GameOver() {
        super.GameOver();
        System.out.println("Game Over!");
    }

    /* Game Won for Console version */
    @Override
    protected void GameWin() {
        super.GameOver();
        System.out.println("You Won!");
    }

}

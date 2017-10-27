package MineSweeperGame.Console;

import MineSweeperGame.Base.GameRules;

public class ConsoleGame extends GameRules {

    private void Display() {
        for (int ypos = 0; ypos < _table.GetYSize(); ypos++) {
            for (int xpos = 0; xpos < _table.GetXSize(); xpos++) {
                System.out.print(_visabletable.GetElement(xpos, ypos) + "  ");
            }
            System.out.println();
        }
    }


    /* Displays current gameplay in Console after player does a turn */
    public void DoTurnInConsole(int x, int y) {
        DoTurn(x, y);
        Display();
    }

    /* Displays current gameplay in Console */
    private void DoTurnInConsole() {
        Display();
    }

    /* Displays whole current game table in Console*/
    public void DrawTableInConsole() {
        for (int y = 0; y < _table.GetYSize(); y++) {
            for (int x = 0; x < _table.GetXSize(); x++) {
                System.out.print(_table.GetElement(x, y) + "\t");
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

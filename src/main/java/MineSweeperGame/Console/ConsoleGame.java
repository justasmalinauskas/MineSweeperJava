package MineSweeperGame.Console;

import MineSweeperGame.Base.Exceptions.TooManyBombs;
import MineSweeperGame.Base.Exceptions.TurnIsOutOfBounds;
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
    public void DoTurnInConsole(int x, int y) throws TurnIsOutOfBounds {
        DoTurn(x, y);
        Display();
    }

    /* Displays current gameplay in Console */
    private void DoTurnInConsole() {
        Display();
    }

    @Override
    protected void OutOfTable() {
        System.out.println("Koordinatės nėra tinkamos");
    }

    /* Creates game table for Console version */
    @Override
    public void CreateTable(int xsize, int ysize, int bombs) throws TooManyBombs {
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

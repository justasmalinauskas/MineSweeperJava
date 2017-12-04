import com.minesweeper.base.ConsoleGame;
import com.minesweeper.base.TablesSizeError;
import com.minesweeper.base.TooManyBombs;
import com.minesweeper.base.TurnIsOutOfBounds;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ConsoleGameTest extends ConsoleGame {

    @Test
    public void startGame() throws TooManyBombs, TablesSizeError {
        ConsoleGame testTable = ConsoleGame.getInstance();
        testTable.CreateTable(10, 10, 10);
        assertEquals(true, testTable.GetGameStatus());
    }

    @Test(expected = TooManyBombs.class)
    public void startbadGame() throws TooManyBombs, TablesSizeError {
        ConsoleGame testTable = ConsoleGame.getInstance();
        testTable.CreateTable(5, 5, 25);
    }

    @Test(expected = TurnIsOutOfBounds.class)
    public void outOfBoundsTestBigger() throws TooManyBombs, TablesSizeError, TurnIsOutOfBounds {
        int testFieldConst = 9;
        ConsoleGame testTable = ConsoleGame.getInstance();
        testTable.CreateTable(testFieldConst, testFieldConst, testFieldConst);
        final Integer badCoord = testFieldConst + 1;
        testTable.DoTurn(badCoord, badCoord);
    }

    @Test(expected = TurnIsOutOfBounds.class)
    public void outOfBoundsTestSmaller() throws TooManyBombs, TablesSizeError, TurnIsOutOfBounds {
        int testFieldConst = 9;
        ConsoleGame testTable = ConsoleGame.getInstance();
        testTable.CreateTable(testFieldConst, testFieldConst, testFieldConst);
        final Integer badCoord = -1;
        testTable.DoTurn(badCoord, badCoord);
    }

    @Test
    public void checkIfGameHasEnd() throws TooManyBombs, TablesSizeError, TurnIsOutOfBounds {
        ConsoleGame testTable = ConsoleGame.getInstance();
        int t = 4;
        testTable.CreateTable(t, t, t);
        while (testTable.GetGameStatus()) {
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    testTable.DoTurn(i, j);
                }
            }
        }
        assertEquals(false, testTable.GetGameStatus());
    }
}
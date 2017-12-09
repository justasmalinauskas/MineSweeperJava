package MineSweeperTests;

import MineSweeperBase.Console.ConsoleGame;
import MineSweeperBase.Exceptions.TablesSizeError;
import MineSweeperBase.Exceptions.TooManyBombs;
import MineSweeperBase.Exceptions.TurnIsOutOfBounds;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConsoleGameTest extends ConsoleGame {

    @Test
    public void startGame() throws TooManyBombs, TablesSizeError {
        ConsoleGame testTable = ConsoleGame.getInstance();
        testTable.CreateTable(10,10,10);
        assertEquals(true, testTable.GetGameStatus());
    }

    @Test
    public void startbadGame() throws TooManyBombs, TablesSizeError {
        ConsoleGame testTable = ConsoleGame.getInstance();
        try
        {
            testTable.CreateTable(5,5,25);
            fail("Should have thrown TooManyBombs but did not!");
        }
        catch (final TooManyBombs e) {
            final String msg = "Too many bombs in field for a nice game!";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void OutOfBoundsTestBigger() throws TooManyBombs, TablesSizeError {
        int testFieldConst = 9;
        ConsoleGame testTable = ConsoleGame.getInstance();
        testTable.CreateTable(testFieldConst,testFieldConst,testFieldConst);
        try
        {
            final Integer badcoord = testFieldConst+1;
            testTable.DoTurn(badcoord,badcoord);
            fail("Should have thrown TurnIsOutOfBounds but did not!");
        }
        catch (final TurnIsOutOfBounds e) {
            final String msg = "Coordinate you entered is out of field!";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void OutOfBoundsTestSmaller() throws TooManyBombs, TablesSizeError {
        int testFieldConst = 9;
        ConsoleGame testTable = ConsoleGame.getInstance();
        testTable.CreateTable(testFieldConst,testFieldConst,testFieldConst);
        try
        {
            final Integer badcoord = -1;
            testTable.DoTurn(badcoord,badcoord);
            fail("Should have thrown TurnIsOutOfBounds but did not!");
        }
        catch (final TurnIsOutOfBounds e) {
            final String msg = "Coordinate you entered is out of field!";
            assertEquals(msg, e.getMessage());
        }
    }

    @Test
    public void CheckIfGameHasEnd() throws TooManyBombs, TablesSizeError, TurnIsOutOfBounds {
        ConsoleGame testTable = ConsoleGame.getInstance();
        int t = 4;
        testTable.CreateTable(t,t,t);
        while (testTable.GetGameStatus())
        {
            for (int i = 0; i < t; i++) {
                for (int j = 0; j < t; j++) {
                    testTable.DoTurn(i, j);
                }
            }
        }
        assertEquals(false, testTable.GetGameStatus());
    }

    @Test
    public void ImagesGet() {


    }
}
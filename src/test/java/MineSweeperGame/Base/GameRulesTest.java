package MineSweeperGame.Base;

import MineSweeperGame.Base.Exceptions.TooManyBombs;
import MineSweeperGame.Base.Exceptions.TurnIsOutOfBounds;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class GameRulesTest extends GameRules {

    @Test
    public void startGame() throws TooManyBombs {
        GameRules testTable = new GameRules();
        testTable.CreateTable(10,10,10);
        assertEquals(true, testTable.GetGameStatus());
    }

    @Test
    public void startbadGame() throws TooManyBombs {
        GameRules testTable = new GameRules();
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
    public void OutOfBoundsTestBigger() throws TooManyBombs {
        int testFieldConst = 9;
        GameRules testTable = new GameRules();
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
    public void OutOfBoundsTestSmaller() throws TooManyBombs {
        int testFieldConst = 9;
        GameRules testTable = new GameRules();
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

}
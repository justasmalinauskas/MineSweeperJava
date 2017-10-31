package MineSweeperGame.Base;

import MineSweeperGame.Base.Exceptions.*;

public class GameRules {

    /* Variables used in MineSweeperGame.Base.GameRules class, used protected
    because I wanted my subclasses to see all information
    needed for stable work */
    protected Table _table;
    protected VisibleTable _visabletable;
    private boolean _ingame = false;

    /* Constructor */
    protected GameRules() {

    }

    protected void CleanTable() {
        _table = null;
        _visabletable = null;
    }

    /* Creates game table for new game */
    public void CreateTable(int xsize, int ysize, int bombs) throws TooManyBombs {
        if (bombs < (xsize * ysize / 2) + 1) {
            _table = new Table(xsize, ysize, bombs);
            _visabletable = new VisibleTable(_table);
            _ingame = true;
        }
        else
            throw new TooManyBombs();
    }

    /* Makes game turn at specified coordinates */
    protected void DoTurn(int x, int y) throws TurnIsOutOfBounds{
        if (!_table.IsOutOfBounds(x, y)) {

            if (_table.IsNumber(x, y)) _visabletable.DisplayElement(_table, x, y);
            if (_table.IsNumberZero(x, y)) _visabletable.DisplayElements(_table, x, y);
            if (_table.IsBomb(x, y)) {
                _visabletable.DisplayAllElements(_table);
                GameOver();
            }
            CheckIfWon();
        }
        else
            throw new TurnIsOutOfBounds();

    }

    protected void OutOfTable() {

    }

    /* Prints that game over and stops current game */
    protected void GameOver() {
        _visabletable.SetTable(_table.GetTable());
        _ingame = false;
    }

    /* Checks if field cleared enough to win the game */
    private void CheckIfWon() {
        if (_table != null && _visabletable != null)
            if (_visabletable.PossibleWin(_table.GetBombsCount()) && _ingame) GameWin();
    }

    /* method returned when game is won */
    protected void GameWin() {
        GameOver();
    }

    /* Returns game status to player */
    public boolean GetGameStatus() {
        return _ingame;
    }

}

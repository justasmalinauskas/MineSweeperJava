package MineSweeperBase;

import MineSweeperBase.Exceptions.*;

public class GameRules {

    /* Variables used in MineSweeperBase.GameRules class, used protected
    because I wanted my subclasses to see all information
    needed for stable work */
    private Table _table;
    private VisibleTable _visabletable;
    private boolean _ingame = false;

    /* Constructor */
    protected GameRules() {

    }

    protected int GetXSize() throws TablesSizeError {
        if (_table.GetXSize() == _visabletable.GetXSize()) {
            return _table.GetXSize();
        }
        else
            throw new TablesSizeError();
    }

    protected int GetYSize() throws TablesSizeError {
        if (_table.GetYSize() == _visabletable.GetYSize()) {
            return _table.GetYSize();
        }
        else
            throw new TablesSizeError();
    }

    protected BlockType GetVisableElement(int x, int y) {
        return _visabletable.GetElement(x, y);
    }

    protected void CleanTable() {
        _table = null;
        _visabletable = null;
    }

    /* Creates game table for new game */
    protected void CreateTable(int xsize, int ysize, int bombs) throws TooManyBombs, TablesSizeError {
        if (bombs < (xsize * ysize / 2) + 1) {
            _table = new Table(xsize, ysize, bombs);
            _visabletable = new VisibleTable(_table);
            _ingame = true;
        }
        else
            throw new TooManyBombs();
    }

    /* Makes game turn at specified coordinates */
    public void DoTurn(int x, int y) throws TurnIsOutOfBounds{
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

    /* Prints that game over and stops current game */
    protected void GameOver() {
        _visabletable.SetTable(_table.GetTable());
        _ingame = false;
    }

    /* Checks if field cleared enough to win the game */
    protected void CheckIfWon() {
        if (_table != null && _visabletable != null)
            if (_visabletable.PossibleWin(_table.GetBombsCount()) && _ingame) GameWin();
    }

    /* method returned when game is won */
    protected void GameWin() {
        GameOver();
    }

    /* Returns game status to player */
    protected boolean GetGameStatus() {
        return _ingame;
    }

    protected BlockType GetElement(int x, int y) {
        return _visabletable.GetElement(x,y);
    }
}

package MineSweeperGame.Base;

public class GameRules {

    /* Variables used in MineSweeperGame.Base.GameRules class, used protected
    because I wanted my subclasses to see all information
    needed for stable work */
    protected Table _table;
    protected VisableTable _visabletable;
    protected boolean _ingame = false;

    /* Constructor */
    public GameRules() {

    }

    /* Creates game table for new game */
    public void CreateTable(int xsize, int ysize, int bombs) {
        _table = new Table(xsize, ysize, bombs);
        _visabletable = new VisableTable(_table);
        _ingame = true;
    }

    /* Makes game turn at specified coordinates */
    public void DoTurn(int x, int y) {
        if (_table.IsOutOfBounds(x, y)) {
            OutOfTable();
            return;
        }
        if (_table.IsNumber(x, y)) _visabletable.DisplayElement(_table, x, y);
        if (_table.IsNumberZero(x, y)) _visabletable.DisplayElements(_table, x, y);
        if (_table.IsBomb(x, y)) {
            _visabletable.DisplayAllElements(_table);
            GameOver();
        }
        CheckIfWon();
    }

    protected void OutOfTable() {

    }

    /* Prints that game over and stops current game */
    protected void GameOver() {
        _ingame = false;
    }

    /* Checks if field cleared enough to win the game */
    private void CheckIfWon() {
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

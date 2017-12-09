package com.minesweeper.base;


public class GameRules {

    /* Variables used in GameRules class, used protected
    because I wanted my subclasses to see all information
    needed for stable work */
    private Table table;
    private VisibleTable visibleTable;
    private boolean ingame = false;

    /* Constructor */
    protected GameRules() {

    }

    protected int GetXSize()  {
        return table.GetXSize();
    }

    protected int GetYSize(){
        return table.GetYSize();
    }

    protected BlockType GetVisableElement(int x, int y) {
        return visibleTable.GetElement(x, y);
    }

    protected void CleanTable() {
        table = null;
        visibleTable = null;
    }

    /* Creates game table for new game */
    protected void CreateTable(int xsize, int ysize, int bombs) throws TooManyBombs, TablesSizeError {
        if (bombs < (xsize * ysize / 2) + 1) {
            table = new Table(xsize, ysize, bombs);
            visibleTable = new VisibleTable(table);
            ingame = true;
        }
        else
            throw new TooManyBombs();
    }

    /* Makes game turn at specified coordinates */
    public void DoTurn(int x, int y) throws TurnIsOutOfBounds {
        if (!table.IsOutOfBounds(x, y)) {

            if (table.IsNumber(x, y)) visibleTable.DisplayElement(table, x, y);
            if (table.IsNumberZero(x, y)) visibleTable.DisplayElements(table, x, y);
            if (table.IsBomb(x, y)) {
                visibleTable.DisplayAllElements(table);
                GameOver();
            }
            CheckIfWon();
        }
        else
            throw new TurnIsOutOfBounds();

    }

    /* Prints that game over and stops current game */
    protected void GameOver() {
        visibleTable.SetTable(table.GetTable());
        ingame = false;
    }

    /* Checks if field cleared enough to win the game */
    protected void CheckIfWon() {
        if (table != null && visibleTable != null)
            if (visibleTable.PossibleWin(table.GetBombsCount()) && ingame) GameWin();
    }

    /* method returned when game is won */
    protected void GameWin() {
        GameOver();
    }

    /* Returns game status to player */
    protected boolean GetGameStatus() {
        return ingame;
    }

    protected BlockType GetElement(int x, int y) {
        return visibleTable.GetElement(x,y);
    }
}

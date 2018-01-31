package com.minesweeper.base;


public class GameRules {

    private Table table;
    private VisibleTable visibleTable;
    private boolean ingame = false;

    protected GameRules() {

    }

    protected int getXSize()  {
        return table.getXSize();
    }

    protected int getYSize(){
        return table.getYSize();
    }

    protected BlockType getVisableElement(int x, int y) {
        return visibleTable.getElement(x, y);
    }

    protected void cleanTable() {
        table = null;
        visibleTable = null;
    }

    protected void createTable(int xsize, int ysize, int bombs) throws TooManyBombs, TablesSizeError {
        if (bombs < (xsize * ysize / 2) + 1) {
            table = new Table(xsize, ysize, bombs);
            visibleTable = new VisibleTable(table);
            ingame = true;
        }
        else
            throw new TooManyBombs();
    }

    public void doTurn(int x, int y) throws TurnIsOutOfBounds {
        if (!table.isOutOfBounds(x, y)) {

            if (table.isNumber(x, y)) visibleTable.displayElement(table, x, y);
            if (table.isNumberZero(x, y)) visibleTable.displayElements(table, x, y);
            if (table.isBomb(x, y)) {
                visibleTable.displayAllElements(table);
                gameOver();
            }
            checkIfWon();
        }
        else
            throw new TurnIsOutOfBounds();
    }

    protected void gameOver() {
        visibleTable.setTable(table.getTable());
        ingame = false;
    }

    protected void checkIfWon() {
        if (table != null && visibleTable != null)
            if (visibleTable.possibleWin(table.getBombsCount()) && ingame) gameWin();
    }

    protected void gameWin() {
        gameOver();
    }

    protected boolean getGameStatus() {
        return ingame;
    }

    protected BlockType getElement(int x, int y) {
        return visibleTable.getElement(x,y);
    }
}

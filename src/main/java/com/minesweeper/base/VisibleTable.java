package com.minesweeper.base;

public class VisibleTable {

    private BlockType[][] _visabletable;

    VisibleTable(Table t) {
        createVisibleTable(t);
    }

    /* Creates a new gameplay table for render to player */
    private void createVisibleTable(Table t) {
        int xsize = t.getXSize();
        int ysize = t.getYSize();
        _visabletable = new BlockType[ysize][xsize];
        for (int y = 0; y < ysize; y++) {
            for (int x = 0; x < xsize; x++) {
                _visabletable[y][x] = BlockType.BLOCK;
            }
        }
    }

    public int getXSize() {
        return _visabletable[0].length;
    }

    public int getYSize() {
        return _visabletable.length;
    }

    /* Checks if table field unrevealed */
    private boolean ifUnrevealed(int x, int y) {
        return _visabletable[y][x] == BlockType.BLOCK;
    }

    /* Reveals part of empty cells if needed when empty cell selected */
    void displayElements(Table t, int x, int y) {
        int xsize = _visabletable[0].length;
        int ysize = _visabletable.length;
        for (int ypos = Math.max(0, y - 1); ypos < Math.min(y + 2, ysize); ypos++) {
            for (int xpos = Math.max(0, x - 1); xpos < Math.min(x + 2, xsize); xpos++) {
                if (t.isNumber(xpos, ypos) && ifUnrevealed(xpos, ypos)) displayElement(t, xpos, ypos);
                if (t.isNumberZero(xpos, ypos) && ifUnrevealed(xpos, ypos)) {
                    _visabletable[ypos][xpos] = t.getElement(xpos, ypos);
                    displayElements(t, xpos, ypos);
                }
            }
        }
    }

    /* Reveals whole game table to player */
    void displayAllElements(Table t) {
        _visabletable = t.getTable();
    }

    /* Reveals one field element */
    void displayElement(Table t, int x, int y) {
        _visabletable[y][x] = t.getElement(x, y);
    }

    /* Counts how many unrevealed fields left in game table */
    private int blanksLeft() {
        int blank = 0;
        for (BlockType[] a_visabletable : _visabletable) {
            for (int x = 0; x < _visabletable[0].length; x++) {
                if (a_visabletable[x] == BlockType.BLOCK) blank++;
            }
        }
        return blank;
    }

    boolean possibleWin(int bombs) {
        return bombs >= blanksLeft();
    }

    /* Returns one element from visable game table */
    public BlockType getElement(int x, int y) {
        return _visabletable[y][x];
    }

    void setTable(BlockType[][] table) {
        _visabletable = table;
    }
}

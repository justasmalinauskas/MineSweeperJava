package MineSweeperGame.Base;

public class VisibleTable {

    private char[][] _visabletable;

    VisibleTable(Table t) {
        CreateVisableTable(t);
    }

    /* Creates a new gameplay table for render to player */
    private void CreateVisableTable(Table t) {
        int xsize = t.GetXSize();
        int ysize = t.GetYSize();
        _visabletable = new char[ysize][xsize];
        for (int y = 0; y < ysize; y++) {
            for (int x = 0; x < xsize; x++) {
                _visabletable[y][x] = '+';
            }
        }
    }

    /* Checks if table field unrevealed */
    private boolean IfUnrevealed(int x, int y) {
        return _visabletable[y][x] == '+';
    }

    /* Reveals part of empty cells if needed when empty cell selected */
    void DisplayElements(Table t, int x, int y) {
        int xsize = _visabletable[0].length;
        int ysize = _visabletable.length;
        for (int ypos = Math.max(0, y - 1); ypos < Math.min(y + 2, ysize); ypos++) {
            for (int xpos = Math.max(0, x - 1); xpos < Math.min(x + 2, xsize); xpos++) {
                if (t.IsNumber(xpos, ypos) && IfUnrevealed(xpos, ypos)) DisplayElement(t, xpos, ypos);
                if (t.IsNumberZero(xpos, ypos) && IfUnrevealed(xpos, ypos)) {
                        _visabletable[ypos][xpos] = t.GetElement(xpos, ypos);
                        DisplayElements(t, xpos, ypos);
                }
            }
        }
    }

    /* Reveals whole game table to player */
    void DisplayAllElements(Table t) {
        _visabletable = t.GetTable();
    }

    /* Reveals one field element */
    void DisplayElement(Table t, int x, int y) { _visabletable[y][x] = t.GetElement(x, y); }

    /* Counts how many unrevealed fields left in game table */
    private int BlanksLeft() {
        int blank = 0;
        for (char[] a_visabletable : _visabletable) {
            for (int x = 0; x < _visabletable[0].length; x++) {
                if (a_visabletable[x] == '+') blank++;
            }
        }
        return blank;
    }

    boolean PossibleWin(int bombs) {
        return bombs >= BlanksLeft();
    }


    /* Returns all game table as 2D char array */
    public char[][] GetTable() {
        return _visabletable;
    }

    /* Returns one element from visable game table */
    public char GetElement(int x, int y) {
        return _visabletable[y][x];
    }

    void SetTable (char[][] table) {
        _visabletable = table;
    }
}

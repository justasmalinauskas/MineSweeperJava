package MineSweeperGame.Base;

public class Table {

    private char[][] _table;
    private int _xsize;
    private int _ysize;
    private int _bombs;

    public Table(int xsize, int ysize, int bombs) {
        this._xsize = xsize;
        this._ysize = ysize;
        this._bombs = bombs;
        GetEmptyTable();
        SetBombs();
    }

    /* Creates 'empty' table filled with 'zeroes' */
    private void GetEmptyTable() {
        _table = new char[_ysize][_xsize];
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) _table[y][x] = '0';
        }
    }

    /* Makes bombs for game also calculates nearby bombs in 3x3 array from bomb */
    private void SetBombs() {
        int usedbombs = 0;
        while (usedbombs < _bombs) {
            int[] xy = GetRandomInt();
            if (_table[xy[0]][xy[1]] != '*') {
                _table[xy[0]][xy[1]] = '*';
                usedbombs++;
            }
        }
        /* Calculating how much bombs are in 3x3 area
        (avoiding out of bound exception)
        around each cell excluding bombs cell itself */
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                if (_table[y][x] != '*') {
                    for (int yt = Math.max(0, y - 1); yt < Math.min(y + 2, _ysize); yt++) {
                        for (int xt = Math.max(0, x - 1); xt < Math.min(x + 2, _xsize); xt++) {
                            if (xt != x || yt != y)
                                if (_table[yt][xt] == '*') _table[y][x] = IntToChar(CharToInt(_table[y][x]) + 1);
                        }
                    }
                }
            }
        }
    }

    /* Converts character to integer */
    private int CharToInt(char i) {
        return Character.getNumericValue(i);
    }

    /* Converts integer to character */
    private char IntToChar(int i) {
        return Character.forDigit(i, 10);
    }

    /* Makes a random coordinate */
    private int[] GetRandomInt() {
        int[] answer = new int[2];
        answer[0] = (int) (Math.random() * _ysize);
        answer[1] = (int) (Math.random() * _xsize);
        return answer;
    }

    /* Checks if number pressed */
    private boolean IfNumber(char i) {
        return i != '*' && i != '0';
    }


    /* Returns Table to other classes */
    public char[][] GetTable() {
        return _table;
    }

    public int GetXSize() {
        return _xsize;
    }

    public int GetYSize() {
        return _ysize;
    }

    public int GetBombsCount() {
        return _bombs;
    }

    public char GetElement(int x, int y) {
        return _table[y][x];
    }

    public boolean IsOutOfBounds(int x, int y) {
        if (x < 0 || y < 0 || x > _xsize || y > _ysize) return true;
        return false;
    }

    public boolean IsNumber(int x, int y) {
        if (_table[y][x] != '*' && _table[y][x] != '0') return true;
        return false;
    }

    public boolean IsNumberZero(int x, int y) {
        if (_table[y][x] == '0') return true;
        return false;
    }

    public boolean IsBomb(int x, int y) {
        if (_table[y][x] == '*') return true;
        return false;
    }

}

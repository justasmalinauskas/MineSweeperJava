public class GameTable {

    /* Variables used in GameTable class, used protected
    because I wanted my subclasses to see all information
    needed for stable work */
    protected char _table[][];
    protected char _visabletable[][];
    protected int _xsize;
    protected int _ysize;
    protected int _bombscount;
    protected boolean _ingame = false;

    /* Constructor */
    public GameTable() {

    }

    /* Sets all used local variables */
    private void SetVariables(int xsize, int ysize, int bombs) {
        _xsize = xsize;
        _ysize = ysize;
        _bombscount = bombs;
        _ingame = true;
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
        while (usedbombs < _bombscount) {
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
                            if (xt != x || yt != y) {
                                if (_table[yt][xt] == '*') {
                                    _table[y][x] = IntToChar(CharToInt(_table[y][x]) + 1);
                                }
                            }
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

    /* Creates a new gameplay table for render to player */
    private void CreateUserTable() {
        _visabletable = new char[_ysize][_xsize];
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                _visabletable[y][x] = '█';
            }
        }
    }

    /* Creates game table for new game */
    public void CreateTable(int xsize, int ysize, int bombs) {
        SetVariables(xsize, ysize, bombs);
        GetEmptyTable();
        SetBombs();
        CreateUserTable();
    }

    /* Makes game turn at specified coordinates */
    public void DoTurn(int x, int y) {
        if (IfNumber(_table[y][x])) DisplayElement(x, y);
        if (_table[y][x] == '0') DisplaySomeElements(x, y);
        if (_table[y][x] == '*') {
            DisplayAllElements();
            GameOver();
        }
        CheckIfWon();
    }

    /* Reveals part of empty cells if needed when empty cell selected */
    private void DisplaySomeElements(int x, int y) {
        for (int ypos = Math.max(0, y - 1); ypos < Math.min(y + 2, _ysize); ypos++) {
            for (int xpos = Math.max(x - 1, 0); xpos < Math.min(x + 2, _xsize); xpos++) {
                if (IfNumber(_table[ypos][xpos]) && IfUnrevealed(xpos, ypos)) DisplayElement(xpos, ypos);
                if (_table[ypos][xpos] == '0' && IfUnrevealed(xpos, ypos)) {
                    _visabletable[ypos][xpos] = _table[ypos][xpos];
                    DisplaySomeElements(xpos, ypos);
                }
            }
        }
    }

    /* Checks if number pressed */
    private boolean IfNumber(char i) {
        return i != '*' && i != '0';
    }

    /* Checks if table field unrevealed */
    private boolean IfUnrevealed(int x, int y) {
        return _visabletable[y][x] == '█';
    }

    /* Reveals one field element */
    private void DisplayElement(int x, int y) {
        _visabletable[y][x] = _table[y][x];
    }

    /* Reveals whole game table to player */
    private void DisplayAllElements() {
        _visabletable = _table;
    }

    /* Prints that game over and stops current game */
    protected void GameOver() {
        _ingame = false;
    }

    /* Counts how many unrevealed fields left in game table */
    private int BlanksLeft() {
        int blank = 0;
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                if (_visabletable[y][x] == '█') blank++;
            }
        }
        return blank;
    }

    /* Checks if field cleared enough to win the game */
    private void CheckIfWon() {
        if (_bombscount >= BlanksLeft() && _ingame) GameWin();
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

public class GameTable {

    protected char _table[][];
    protected char _visabletable[][];
    protected int _xsize;
    protected int _ysize;
    protected int _bombscount;
    protected boolean _ingame = false;


    public GameTable() {

    }

    private void SetVariables(int xsize, int ysize, int bombs) {
        _xsize = xsize;
        _ysize = ysize;
        _bombscount = bombs;
        _ingame = true;
    }

    private int[][] GetEmptyIntTable() {
        int _tableInterger[][] = new int[_ysize][_xsize];
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) _tableInterger[y][x] = 0;
        }
        return _tableInterger;
    }

    private int[][] SetBombs(int[][] intTable) {
        int usedbombs = 0;
        while (usedbombs < _bombscount) {
            int[] xy = GetRandomInt();
            if (intTable[xy[0]][xy[1]] != 9) {
                intTable[xy[0]][xy[1]] = 9;
                usedbombs++;
            }
        }
        /* Calculating how much bombs are in 3x3 area(avoiding out of bound exception)
        around each cell excluding bombs cell itself */
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                if (intTable[y][x] != 9) {
                    for (int yt = Math.max(0, y - 1); yt < Math.min(y + 2, _ysize); yt++) {
                        for (int xt = Math.max(0, x - 1); xt < Math.min(x + 2, _xsize); xt++) {
                            if (xt != x || yt != y) {
                                if (intTable[yt][xt] == 9) {
                                    intTable[y][x]++;
                                }
                            }
                        }
                    }
                }
            }
        }
        return intTable;
    }

    private int[] GetRandomInt() {
        int[] answer = new int[2];
        answer[0] = (int) (Math.random() * _ysize);
        answer[1] = (int) (Math.random() * _xsize);
        return answer;
    }

    private void CreateRealTable(int[][] _tableInteger) {
        _table = new char[_ysize][_xsize];
        /* Setting interger table as real game table and setting bomb as * charatcher */
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                if (_tableInteger[y][x] == 9)
                    _table[y][x] = '*';
                else
                    _table[y][x] = Character.forDigit(_tableInteger[y][x], 10);
            }
        }
    }

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
        /* Sets all needed local variables */
        SetVariables(xsize, ysize, bombs);
        /* Initial game table in intergers */
        int _tableInteger[][] = GetEmptyIntTable();
        /* Bombs generating as interger expressing bomb as number 9
        because interger array is needed for calculating nearby bombs
        and in 3x3 array 9 bombs nearby are impossible option */
        _tableInteger = SetBombs(_tableInteger);
        /* Creating real game table */
        CreateRealTable(_tableInteger);
        /* Creates a new gameplay table for render to player */
        CreateUserTable();
    }


    /* Makes game turn at specified coordinates */
    public void DoTurn(int x, int y) throws ArrayIndexOutOfBoundsException {
        if (IfNumber(_table[y][x])) {
            DisplayElement(y, x);
        }
        if (_table[y][x] == '*') {
            DisplayAllElements();
            GameOver();
        }
        if (_table[y][x] == '0')
            DisplaySomeElements(y, x);
        CheckIfWon();
        if (x < 0 || y < 0 || x > _xsize || y > _ysize)
            throw new ArrayIndexOutOfBoundsException();
    }

    /* Reveals part of empty cells if needed when empty cell selected */
    private void DisplaySomeElements(int x, int y) {
        for (int ypos = Math.max(0, y - 1); ypos < Math.min(y + 2, _ysize); ypos++) {
            for (int xpos = Math.max(x - 1, 0); xpos < Math.min(x + 2, _xsize); xpos++) {
                if (IfNumber(_table[ypos][xpos])) {
                    DisplayElement(ypos, xpos);
                }
                if (_table[ypos][xpos] == '0' && _visabletable[ypos][xpos] == '█') {
                    _visabletable[ypos][xpos] = _table[ypos][xpos];
                    DisplaySomeElements(ypos, xpos);
                }

            }
        }
    }

    /* checks if number pressed */
    private boolean IfNumber(char i) {
        if (i == '1' || i == '2' || i == '3' || i == '4' || i == '5' || i == '6' || i == '7' || i == '8') {
            return true;
        }
        return false;
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

    /* Counts how many unreveald fields left in game table */
    private int BlanksLeft() {
        int blank = 0;
        for (int x = 0; x < _visabletable[0].length; x++) {
            for (int y = 0; y < _visabletable.length; y++) {
                if (_visabletable[y][x] == '█')
                    blank++;
            }
        }
        return blank;
    }

    /* Checks if field cleared enough to win the game */
    private void CheckIfWon() {
        if (_bombscount >= BlanksLeft() && _ingame) {
            GameWin();
        }
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

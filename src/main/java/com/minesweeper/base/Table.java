package com.minesweeper.base;

public class Table {

    private final int _xsize;
    private final int _ysize;
    private final int _bombs;
    private BlockType[][] _table;
    private char[][] _chartable;

    Table(int xsize, int ysize, int bombs) {
        this._xsize = xsize;
        this._ysize = ysize;
        this._bombs = bombs;
        getEmptyCharTable();
        setBombs();
        calcBombsDistance();
        makeItEnumOne();
    }

    private void makeItEnumOne() {
        _table = new BlockType[_ysize][_xsize];
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                switch (_chartable[y][x]) {
                    case '0':
                        _table[y][x] = BlockType.ZERO;
                        break;
                    case '1':
                        _table[y][x] = BlockType.ONE;
                        break;
                    case '2':
                        _table[y][x] = BlockType.TWO;
                        break;
                    case '3':
                        _table[y][x] = BlockType.THREE;
                        break;
                    case '4':
                        _table[y][x] = BlockType.FOUR;
                        break;
                    case '5':
                        _table[y][x] = BlockType.FIVE;
                        break;
                    case '6':
                        _table[y][x] = BlockType.SIX;
                        break;
                    case '8':
                        _table[y][x] = BlockType.EIGHT;
                        break;
                    default:
                        _table[y][x] = BlockType.BOMB;
                        break;


                }
            }
        }
    }

    private void getEmptyCharTable() {
        _chartable = new char[_ysize][_xsize];
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) _chartable[y][x] = '0';
        }
    }

    private void setBombs() {
        int usedbombs = 0;
        while (usedbombs < _bombs) {
            int[] xy = getRandomInt();
            if (_chartable[xy[0]][xy[1]] != '*') {
                _chartable[xy[0]][xy[1]] = '*';
                usedbombs++;
            }
        }

    }

    private void calcBombsDistance() {
        for (int y = 0; y < _ysize; y++) {
            for (int x = 0; x < _xsize; x++) {
                if (_chartable[y][x] != '*') {
                    for (int yt = Math.max(0, y - 1); yt < Math.min(y + 2, _ysize); yt++) {
                        for (int xt = Math.max(0, x - 1); xt < Math.min(x + 2, _xsize); xt++) {
                            if (xt != x || yt != y)
                                if (_chartable[yt][xt] == '*') _chartable[y][x] = intToChar(charToInt(_chartable[y][x]) + 1);
                        }
                    }
                }
            }
        }
    }

    private int charToInt(char i) {
        return Character.getNumericValue(i);
    }

    private char intToChar(int i) {
        return Character.forDigit(i, 10);
    }

    private int[] getRandomInt() {
        int[] answer = new int[2];
        answer[0] = (int) (Math.random() * _ysize);
        answer[1] = (int) (Math.random() * _xsize);
        return answer;
    }

    protected BlockType[][] getTable() {
        return _table;
    }

    public int getXSize() {
        return _xsize;
    }

    public int getYSize() {
        return _ysize;
    }

    protected int getBombsCount() {
        return _bombs;
    }

    public BlockType getElement(int x, int y) {
        return _table[y][x];
    }

    protected boolean isOutOfBounds(int x, int y) {
        return x < 0 || y < 0 || x > _xsize || y > _ysize;
    }

    protected boolean isNumber(int x, int y) {
        return _table[y][x] != BlockType.BOMB && _table[y][x] != BlockType.ZERO;
    }

    protected boolean isNumberZero(int x, int y) {
        return _table[y][x] == BlockType.ZERO;
    }

    protected boolean isBomb(int x, int y) {
        return _table[y][x] == BlockType.BOMB;
    }

}

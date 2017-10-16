package MineSweeperGame.Base;

public class Table {

    private char[][] _table;
    private int _xsize;
    private int _ysize;
    private int _bombs;

    public Table() {

    }

    public Table(int xsize, int ysize, int bombs) {
        MakeTable();
    }

    private char[][] MakeTable() {
        return new char[1][1];
    }

}

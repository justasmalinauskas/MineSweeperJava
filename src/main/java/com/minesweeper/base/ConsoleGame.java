package com.minesweeper.base;

public class ConsoleGame extends GameRules {

    private static ConsoleGame instance;

    public static ConsoleGame getInstance() {
        if (instance == null) {
            instance = new ConsoleGame();
        }
        return instance;
    }

    private void display() throws TablesSizeError {
        for (int ypos = 0; ypos < instance.getYSize(); ypos++) {
            for (int xpos = 0; xpos < instance.getXSize(); xpos++) {
                if (instance.getVisableElement(xpos, ypos) == BlockType.ZERO)
                    System.out.print("0 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.ONE)
                    System.out.print("1 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.TWO)
                    System.out.print("2 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.THREE)
                    System.out.print("3 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.FOUR)
                    System.out.print("4 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.FIVE)
                    System.out.print("5 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.SIX)
                    System.out.print("6 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.SEVEN)
                    System.out.print("7 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.EIGHT)
                    System.out.print("8 ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.BLOCK)
                    System.out.print("+ ");
                if (instance.getVisableElement(xpos, ypos) == BlockType.BOMB)
                    System.out.print("* ");
            }
            System.out.println();
        }
    }

    public void doTurnInConsole(int x, int y) throws TurnIsOutOfBounds, TablesSizeError {
        doTurn(x, y);
        display();
    }

    private void doTurnInConsole() throws TablesSizeError {
        display();
    }

    public boolean getGameStatus() {
        return super.getGameStatus();
    }

    @Override
    public void createTable(int xsize, int ysize, int bombs) throws TooManyBombs, TablesSizeError {
        super.createTable(xsize, ysize, bombs);
        doTurnInConsole();
    }

    public void gameOver() {
        super.gameOver();
        System.out.println("Game Over!");
    }

    @Override
    protected void gameWin() {
        super.gameOver();
        System.out.println("You Won!");
    }
}

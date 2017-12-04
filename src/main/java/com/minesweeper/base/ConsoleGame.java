package com.minesweeper.base;

public class ConsoleGame extends GameRules {

    private static ConsoleGame instance;

    public static ConsoleGame getInstance() {
        if (instance == null) {
            instance = new ConsoleGame();
        }
        return instance;
    }




    private void Display() throws TablesSizeError {
        for (int ypos = 0; ypos < instance.GetYSize(); ypos++) {
            for (int xpos = 0; xpos < instance.GetXSize(); xpos++) {
                if (instance.GetVisableElement(xpos, ypos) == BlockType.ZERO)
                    System.out.print("0 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.ONE)
                    System.out.print("1 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.TWO)
                    System.out.print("2 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.THREE)
                    System.out.print("3 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.FOUR)
                    System.out.print("4 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.FIVE)
                    System.out.print("5 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.SIX)
                    System.out.print("6 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.SEVEN)
                    System.out.print("7 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.EIGHT)
                    System.out.print("8 ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.BLOCK)
                    System.out.print("+ ");
                if (instance.GetVisableElement(xpos, ypos) == BlockType.BOMB)
                    System.out.print("* ");
            }
            System.out.println();
        }
    }


    /* Displays current gameplay in Console after player does a turn */
    public void DoTurnInConsole(int x, int y) throws TurnIsOutOfBounds, TablesSizeError {
        DoTurn(x, y);
        Display();
    }

    /* Displays current gameplay in Console */
    private void DoTurnInConsole() throws TablesSizeError {
        Display();
    }

    public boolean GetGameStatus() {
        return super.GetGameStatus();
    }


    /* Creates game table for Console version */
    @Override
    public void CreateTable(int xsize, int ysize, int bombs) throws TooManyBombs, TablesSizeError {
        super.CreateTable(xsize, ysize, bombs);
        DoTurnInConsole();
    }

    /* Game Over for Console version */
    public void GameOver() {
        super.GameOver();
        System.out.println("Game Over!");
    }

    /* Game Won for Console version */
    @Override
    protected void GameWin() {
        super.GameOver();
        System.out.println("You Won!");
    }

}

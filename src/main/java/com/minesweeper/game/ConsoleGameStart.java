package com.minesweeper.game;

import com.minesweeper.base.ConsoleGame;
import com.minesweeper.base.TablesSizeError;
import com.minesweeper.base.TooManyBombs;
import com.minesweeper.base.TurnIsOutOfBounds;

import java.util.Scanner;

class ConsoleGameStart {

    private static ConsoleGame Table = ConsoleGame.getInstance();

    public static void main(String[] args) throws TooManyBombs, TurnIsOutOfBounds, TablesSizeError {
        Table.createTable(9, 9, 10);
        while (Table.getGameStatus()) {
            System.out.println("Įveskite koordinates X ir Y");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            Scanner sc1 = new Scanner(System.in);
            int j = sc1.nextInt();
            Table.doTurnInConsole(i, j);
        }
    }
}

package MineSweeperGame;

import MineSweeperGame.Console.ConsoleGame;

import java.util.Scanner;

class ConsoleGameStart {

    private static final ConsoleGame Table = new ConsoleGame();

    public static void main(String[] args) {
        Table.CreateTable(9, 9, 10);
        while (Table.GetGameStatus()) {
            //Table.DrawTableInConsole();
            System.out.println("Įveskite koordinates X ir Y");
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            Scanner sc1 = new Scanner(System.in);
            int j = sc1.nextInt();
            Table.DoTurnInConsole(i, j);
        }

    }
}

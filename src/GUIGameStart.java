import MineSweeperGame.GUI.GUIGame;

import javax.swing.*;

public class GUIGameStart {

    private static GUIGame Table = new GUIGame();

    public static void main(String[] args) {
        /*Table.CreateTable(4, 4, 2);
        while (Table.GetGameStatus()) {
            Scanner sc = new Scanner(System.in);
            int i = sc.nextInt();
            Scanner sc1 = new Scanner(System.in);
            int j = sc1.nextInt();
            Table.DoTurnInConsole(i, j);*/
        JFrame frame = new JFrame("Test Frame");
        //buildContent(frame);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.pack();
        frame.setVisible(true);

    }
}

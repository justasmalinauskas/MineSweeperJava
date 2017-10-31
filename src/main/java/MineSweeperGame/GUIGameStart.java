package MineSweeperGame;

import MineSweeperGame.GUI.GUIGame;
import MineSweeperGame.GUI.GamePanels;

import javax.swing.*;
import java.awt.*;


class GUIGameStart extends JFrame {

    private static final GUIGame Table = new GUIGame();
    private static JFrame frame;
    private static JPanel panel1;
    private static JPanel panel2;

    public static void main(String[] args) {
        try {
            // Sets UI as native, used in OS.
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException e) {

        }
        catch (ClassNotFoundException e) {
            // handle exception
        }
        catch (InstantiationException e) {
            // handle exception
        }
        catch (IllegalAccessException e) {
            // handle exception
        }
        javax.swing.SwingUtilities.invokeLater(() -> {
            frame = new JFrame("MineSweeperJava");
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            panel1 = GamePanels.toppanel();
            frame.add(panel1, BorderLayout.NORTH);
            JButton startbutton = new JButton("Start Game");
            panel1.add(startbutton);
            startbutton.addActionListener(e -> {
                GamePanels.GetValues();
                frame.add(Table.StartGame(GamePanels.X, GamePanels.Y, GamePanels.B), BorderLayout.CENTER);
                frame.getContentPane().revalidate();
                frame.setVisible(true);
            });
        });
    }
}

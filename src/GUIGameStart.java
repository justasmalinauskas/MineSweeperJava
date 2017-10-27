import MineSweeperGame.GUI.GUIGame;
import MineSweeperGame.GUI.GamePanels;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class GUIGameStart extends JFrame {

    private static JFrame frame;
    private static JPanel panel1;
    private static JSplitPane splitPaneH;

    private static GUIGame Table = new GUIGame();

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            frame = new JFrame("MineSweeperJava");
            run();
        });
    }

    public static void run()
    {
        SwingUtilities.invokeLater(() -> {
            frame.setSize(800, 600);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            panel1 = new GamePanels().toppanel( frame, Table);
            frame.add(panel1, BorderLayout.NORTH);
            JButton startbutton = new JButton("Start Game");
            panel1.add(startbutton);
            startbutton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Component[] all_comp=panel1.getComponents();
                    int[] tabledetails = new int[3];
                    int count = 0;
                    for(int i=0;i<=all_comp.length;i++) {
                        if (all_comp[i] instanceof JSpinner) {
                            tabledetails[count] = (int) ((JSpinner)all_comp[i]).getValue();
                            count++;
                            // this is the text. Do what you want with it....
                        }
                    }
                    Table.StartGame(frame, (Integer) x.getValue(), (Integer) y.getValue(), (Integer) b.getValue());//need to extreact values
                }
            });
        });
    }


}

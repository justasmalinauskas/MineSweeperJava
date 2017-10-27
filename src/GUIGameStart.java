import MineSweeperGame.GUI.GUIGame;

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
            panel1 = new JPanel();
            splitPaneH = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
            JButton startbutton = new JButton("Start Game");
            SpinnerModel modelx =
                    new SpinnerNumberModel(9, //initial value
                            5, //min
                            50, //max
                            1);
            SpinnerModel modely =
                    new SpinnerNumberModel(9, //initial value
                            5, //min
                            50, //max
                            1);
            SpinnerModel modelb =
                    new SpinnerNumberModel(9, //initial value
                            5, //min
                            50, //max
                            1);
            JSpinner x = new JSpinner(modelx);
            JSpinner y = new JSpinner(modely);
            JSpinner b = new JSpinner(modelb);
            panel1.add(new JLabel("Horizontal size:"));
            panel1.add(x);
            panel1.add(new JLabel("Vertical size:"));
            panel1.add(y);
            panel1.add(new JLabel("Bombs:"));
            panel1.add(b);
            panel1.add(startbutton);
            frame.add(panel1, BorderLayout.NORTH);
            startbutton.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    Table.StartGame(frame, (Integer) x.getValue(), (Integer) y.getValue(), (Integer) b.getValue());
                }
            });

        });
    }


}

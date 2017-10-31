package MineSweeperGame;

import MineSweeperGame.GUI.GUIGame;

import javax.swing.*;
import java.awt.*;


class GUIGameStart extends JFrame {

    private static final GUIGame Table = new GUIGame();
    private static JFrame frame;
    private static Component component;


    private static int X;
    private static int Y;
    private static int B;
    private static JSpinner x;
    private static JSpinner y;
    private static JSpinner b;

    private static void GetValues() {
        X = (Integer) x.getValue();
        Y = (Integer) y.getValue();
        B = (Integer) b.getValue();
    }


    public static void main(String[] args) {
        try {
            // Sets UI as native, used in OS.
            if (System.getProperty("os.name").toLowerCase().contains("windows"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            else if (System.getProperty("os.name").toLowerCase().contains("linux"))
                UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
            else
                UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
        }
        catch (UnsupportedLookAndFeelException | ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            System.out.println(e.getMessage());
        }
        SwingUtilities.invokeLater(GUIGameStart::GUI);
    }

    private static JPanel addTopPanel() {
        JPanel panel = new JPanel();
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
        x = new JSpinner(modelx);
        y = new JSpinner(modely);
        b = new JSpinner(modelb);
        panel.add(new JLabel("Horizontal size:"));
        panel.add(x);
        panel.add(new JLabel("Vertical size:"));
        panel.add(y);
        panel.add(new JLabel("Bombs:"));
        panel.add(b);
        JButton startbutton = new JButton("Start Game");
        panel.add(startbutton);
        startbutton.addActionListener(e -> actionPerformed());
        return panel;
    }

    private static void actionPerformed() {
        for (Component con : frame.getComponents()) {
            if (con == component) {
                frame.remove(con);
                System.out.println("removed");
            }
        }
        GetValues();
        component = Table.StartGame(X, Y, B);
        frame.add(component, BorderLayout.CENTER);
        frame.repaint();
        frame.revalidate();
        System.out.println(frame.getComponents().length);
    }




    private static void GUI() {
        frame = new JFrame("MineSweeperJava");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.add(addTopPanel(), BorderLayout.NORTH);
        frame.setVisible(true);
    }
}

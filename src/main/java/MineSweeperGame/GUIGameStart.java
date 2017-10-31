package MineSweeperGame;

import MineSweeperGame.GUI.GUIGame;
import MineSweeperGame.GUI.GamePanels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;


class GUIGameStart extends JFrame {

    private static final GUIGame Table = new GUIGame();
    private static JFrame frame;
    private static JPanel panel1;
    private static JPanel panel2;
    private static JPanel contain;
    private static Component component;
    static int containc = 0;


    public static int X, Y, B;
    private static JSpinner x;
    private static JSpinner y;
    private static JSpinner b;


    public static void GetValues() {
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUI();
                System.out.println(System.getProperty("os.name"));
            }
        });
    }

    private static JPanel addTopPanel() {
        JPanel panel = new JPanel();
        //panel.add(GamePanels.toppanel());
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
        startbutton.addActionListener(e -> {
            actionPerformed(e);
        });
        return panel;
    }

    private static void actionPerformed(ActionEvent e) {
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




    public static void GUI() {
        frame = new JFrame("MineSweeperJava");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLayout(new BorderLayout());
        frame.add(addTopPanel(), BorderLayout.NORTH);
        frame.setVisible(true);
    }
}

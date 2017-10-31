package MineSweeperGame.GUI;


import javax.swing.*;
import java.awt.*;

public class GamePanels {


    public static int X, Y, B;
    private static JSpinner x;
    private static JSpinner y;
    private static JSpinner b;

    public static void GetValues() {
        X = (Integer) x.getValue();
        Y = (Integer) y.getValue();
        B = (Integer) b.getValue();
    }

    public static JPanel toppanel() {
        JPanel panel = new JPanel(new FlowLayout());
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
        return panel;
    }
}

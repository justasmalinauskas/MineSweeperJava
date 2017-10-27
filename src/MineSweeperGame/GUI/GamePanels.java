package MineSweeperGame.GUI;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanels {

    public JPanel toppanel(JFrame frame, GUIGame table) {
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
        JSpinner x = new JSpinner(modelx);
        JSpinner y = new JSpinner(modely);
        JSpinner b = new JSpinner(modelb);
        panel.add(new JLabel("Horizontal size:"));
        panel.add(x);
        panel.add(new JLabel("Vertical size:"));
        panel.add(y);
        panel.add(new JLabel("Bombs:"));
        panel.add(b);
        return panel;
    }

    public JPanel bottompanel(JFrame frame, GUIGame table) {

        return null;
    }
}

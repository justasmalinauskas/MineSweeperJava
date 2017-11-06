package MineSweeperBase.GUI;

import MineSweeperBase.Exceptions.*;
import MineSweeperBase.*;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIGame extends GameRules {

    private JPanel panel;
    private JButton[][] buttons = null;
    private GetImages images;


    private static GUIGame instance;

    public static GUIGame getInstance() {
        if (instance == null) {
            instance = new GUIGame();
        }
        return instance;
    }

    private JPanel Display() throws TablesSizeError {
        if (instance != null) {
            JPanel gametable = new JPanel();
            gametable.setLayout(new GridLayout(instance.GetYSize(), instance.GetXSize()));
            gametable.setBorder(BorderFactory.createLineBorder(Color.red));
            buttons = new JButton[instance.GetYSize()][instance.GetXSize()];
            for (int ypos = 0; ypos < instance.GetYSize(); ypos++) {
                for (int xpos = 0; xpos < instance.GetXSize(); xpos++) {
                    final int y = ypos;
                    final int x = xpos;
                    //buttons[y][x] = new JButton(String.valueOf(_visabletable.GetElement(x, y)));
                    buttons[y][x] = new JButton();
                    //buttons[y][x].revalidate();
                    //buttons[y][x].repaint();
                    //buttons[y][x].setVisible(true);
                    buttons[y][x].addActionListener(e -> {
                        try {
                            instance.DoTurn(x, y);
                        } catch (TurnIsOutOfBounds ex) {
                            ex.Message();
                        }
                        SetButtonsValues();
                    });
                    gametable.add(buttons[y][x]);
                }
                System.out.println();
            }
            return gametable;
        }
        return new JPanel();
    }

    private void SetButtonsValues() {
        EventQueue.invokeLater(() -> {
            try {
                for (int y = 0; y < instance.GetYSize(); y++) {
                    for (int x = 0; x < instance.GetXSize(); x++) {
                        ImageIcon icon = GetButtonIconPath(x, y);
                        buttons[y][x].setIcon(icon);
                    }
                }
            } catch (TablesSizeError ex) {
                ex.printStackTrace();
            }
        });
    }

    /* Creates game table for GUI version */

    /**
     * @param x Number of rows in game
     * @param y Number of columns in game
     * @param b Count of bombs in game, it should be less than half of all game table
     */
    public JPanel StartGame(int x, int y, int b) {
        if (panel != null) {
            if (panel.getComponents().length > 0) {
                System.out.println("Gametable has " + panel.getComponents().length + " buttons");
                EndGame();
            }
        }
        try {
            images = new GetImages();
            instance.CreateTable(x, y, b);
            panel = this.Display();
            panel.revalidate();
            panel.repaint();
            SetButtonsValues();
            panel.setVisible(true);
            return panel;
        }
        catch (TooManyBombs ex) {
         ex.Message();
        } catch (TablesSizeError e) {
            e.printStackTrace();
        }
        return null;
    }

    private void EndGame() {
        //panel.getComponents().length;
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setVisible(true);
        instance.CleanTable();
    }



    /* Game Over for GUI version */
    @Override
    protected void GameOver() {
        super.GameOver();

        JOptionPane.showMessageDialog(null, "Game Over!");
        SetButtonsValues();
    }

    /* Game Won for GUI version */
    @Override
    protected void GameWin() {
        super.GameOver();
        SetButtonsValues();
        JOptionPane.showMessageDialog(null, "You Won!");
    }

    private ImageIcon GetButtonIconPath(int x, int y) {
        return images.GetImage(instance.GetElement(x, y));
    }


}

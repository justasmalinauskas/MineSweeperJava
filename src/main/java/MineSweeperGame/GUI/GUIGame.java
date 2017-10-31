package MineSweeperGame.GUI;

import MineSweeperGame.Base.GameRules;

import javax.swing.*;
import java.awt.*;

public class GUIGame extends GameRules {

    private JPanel panel;
    private JButton[][] buttons = null;

    private JPanel Display() {
        if (_table != null && _visabletable != null) {
            JPanel gametable = new JPanel();
            gametable.setLayout(new GridLayout(_table.GetYSize(), _table.GetXSize()));
            gametable.setBorder(BorderFactory.createLineBorder(Color.red));
            buttons = new JButton[_table.GetYSize()][_table.GetXSize()];
            for (int ypos = 0; ypos < _table.GetYSize(); ypos++) {
                for (int xpos = 0; xpos < _table.GetXSize(); xpos++) {
                    final int y = ypos;
                    final int x = xpos;
                    buttons[y][x] = new JButton(String.valueOf(_visabletable.GetElement(x, y)));
                    //buttons[y][x].revalidate();
                    //buttons[y][x].repaint();
                    //buttons[y][x].setVisible(true);
                    buttons[y][x].addActionListener(e -> {
                        DoTurn(x, y);
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
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    for (int y = 0; y < _table.GetYSize(); y++) {
                        for (int x = 0; x < _table.GetXSize(); x++) {
                            buttons[y][x].setText(String.valueOf(_visabletable.GetElement(x, y)));
                            buttons[y][x].revalidate();
                            buttons[y][x].repaint();
                            buttons[y][x].setVisible(true);
                        }
                    }
                } catch (NullPointerException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
    }


    /**
     * @param x Number of rows in game
     * @param y Number of columns in game
     * @param b Count of bombs in game, it should be less than half of all game table
     */
    public JPanel StartGame(int x, int y, int b) {
        if(panel != null) {
            if(panel.getComponents().length > 0) {
                System.out.println("Gametable has " + panel.getComponents().length + " buttons");
                EndGame();
            }
        }
        if (b < x * y / 2 + 1) {
            CreateTable(x, y, b);
            panel = this.Display();
            panel.revalidate();
            panel.repaint();
            SetButtonsValues();
            panel.setVisible(true);

            return panel;
        } else {
            TooMuchBombs();
        }
        return null;
    }

    public void EndGame() {
        //panel.getComponents().length;
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setVisible(true);
        CleanTable();
    }

    private void TooMuchBombs() {
        JOptionPane.showMessageDialog(null, "You can not play a game when more than half field has bombs!");

    }

    /* Creates game table for GUI version */
    @Override
    public void CreateTable(int xsize, int ysize, int bombs) {
        super.CreateTable(xsize, ysize, bombs);
    }

    /* Game Over for GUI version */
    @Override
    protected void GameOver() {
        super.GameOver();
        SetButtonsValues();
        JOptionPane.showMessageDialog(null, "Game Over!");
        //EndGame();
    }

    /* Game Won for GUI version */
    @Override
    protected void GameWin() {
        super.GameOver();
        SetButtonsValues();
        JOptionPane.showMessageDialog(null, "You Won!");
        //EndGame();
    }


}

package MineSweeperGame.GUI;

import MineSweeperGame.Base.GameRules;

import javax.swing.*;
import java.awt.*;

public class GUIGame extends GameRules {

    private JPanel panel;
    private JButton[][] buttons;

    private JPanel Display() {
        if (_table != null && _visabletable != null) {
            JPanel gametable = new JPanel();
            gametable.setLayout(new GridLayout(_table.GetYSize(), _table.GetXSize()));
            buttons = new JButton[_table.GetYSize()][_table.GetXSize()];
            for (int ypos = 0; ypos < _table.GetYSize(); ypos++) {
                for (int xpos = 0; xpos < _table.GetXSize(); xpos++) {
                    final int y = ypos;
                    final int x = xpos;
                    buttons[y][x] = new JButton(String.valueOf(_visabletable.GetElement(x, y)));
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
        return null;
    }

    private void SetButtonsValues() {
        try {
            for (int ypos1 = 0; ypos1 < _table.GetYSize(); ypos1++) {
                for (int xpos1 = 0; xpos1 < _table.GetXSize(); xpos1++) {
                    buttons[ypos1][xpos1].setText(String.valueOf(_visabletable.GetElement(xpos1, ypos1)));
                }
            }
        }
        catch (NullPointerException ex) {
            System.out.println(ex.getMessage());
        }
    }


    /**
     * @param x Number of rows in game
     * @param y Number of columns in game
     * @param b Count of bombs in game, it should be less than half of all game table
     */
    public JPanel StartGame(int x, int y, int b) {
        if (b < x*y/2+1) {
            CreateTable(x,y,b);
            panel = this.Display();
            panel.revalidate();
            panel.repaint();
            return panel;
        }
        else {
            TooMuchBombs();
        }
        return null;
    }

    public void EndGame() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
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

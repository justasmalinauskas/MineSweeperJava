package MineSweeperGame.GUI;

import MineSweeperGame.Base.GameRules;

import javax.swing.*;
import java.awt.*;

public class GUIGame extends GameRules {

    private JPanel panel;
    private JFrame _frame;

    private JPanel Display() {
        if (_table != null && _visabletable != null) {
            JPanel gametable = new JPanel();
            gametable.setLayout(new GridLayout(_table.GetYSize(), _table.GetXSize()));
            final JButton[][] buttons = new JButton[_table.GetYSize()][_table.GetXSize()];
            for (int ypos = 0; ypos < _table.GetYSize(); ypos++) {
                for (int xpos = 0; xpos < _table.GetXSize(); xpos++) {
                    final int y = ypos;
                    final int x = xpos;
                    buttons[y][x] = new JButton(String.valueOf(_visabletable.GetElement(x, y)));
                    buttons[y][x].addActionListener(e -> {
                        DoTurn(x, y);
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
                    });
                    gametable.add(buttons[y][x]);
                }
                System.out.println();
            }
            return gametable;
        }
        return null;
    }




    public void StartGame(JFrame frame, int x, int y, int b) {
        if (panel != null) {
            _frame.getContentPane().remove(panel);
            _frame.getContentPane().repaint();
            CleanTable();
        }
        this._frame = frame;
        CreateTable(x,y,b);
        panel = this.Display();
        _frame.getContentPane().add(panel);
        _frame.setVisible(true);
    }

    private void EndGame() {
        _frame.getContentPane().remove(panel);
        _frame.getContentPane().repaint();
        CleanTable();
    }

    /* Creates game table for GUI version */
    @Override
    public void CreateTable(int xsize, int ysize, int bombs) {
        super.CreateTable(xsize, ysize, bombs);
        Display();
    }

    /* Game Over for GUI version */
    @Override
    protected void GameOver() {
        super.GameOver();
        JOptionPane.showMessageDialog(null, "Game Over!");
        EndGame();
    }

    /* Game Won for GUI version */
    @Override
    protected void GameWin() {
        super.GameOver();
        JOptionPane.showMessageDialog(null, "You Won!");
        EndGame();
    }


}

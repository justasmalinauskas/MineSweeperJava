package MineSweeperGame.GUI;

import MineSweeperGame.Base.Exceptions.TooManyBombs;
import MineSweeperGame.Base.Exceptions.TurnIsOutOfBounds;
import MineSweeperGame.Base.GameRules;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class GUIGame extends GameRules {

    private JPanel panel;
    private JButton[][] buttons = null;
    private GetImages images;

    public GUIGame() {
    }

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
                    //buttons[y][x] = new JButton(String.valueOf(_visabletable.GetElement(x, y)));
                    buttons[y][x] = new JButton();
                    //buttons[y][x].revalidate();
                    //buttons[y][x].repaint();
                    //buttons[y][x].setVisible(true);
                    buttons[y][x].addActionListener(e -> {
                        try {
                            DoTurn(x, y);
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
            for (int y = 0; y < _table.GetYSize(); y++) {
                for (int x = 0; x < _table.GetXSize(); x++) {
                    //buttons[y][x].setText(String.valueOf(_visabletable.GetElement(x, y)));
                    //ImageIcon icon = new ImageIcon(GetButtonIconPath(x, y));
                    //ImageIcon icon = getClass().getClassLoader().getResource(GetButtonIconPath(x, y)).getFile();
                    //Image image = GetButtonIconPath(x, y);
                    ImageIcon icon = GetButtonIconPath(x, y);//new ImageIcon(image.getScaledInstance(21,-1,Image.SCALE_FAST));
                    //Image image = ImageIO.read(new File(getClass().getClassLoader().getResource(GetButtonIconPath(x, y)).getFile()));
                    //Icon icon = new ImageIcon(image);
                    buttons[y][x].setIcon(icon);

                }
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
            try {
                images = new GetImages();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
            CreateTable(x, y, b);
            panel = this.Display();
            panel.revalidate();
            panel.repaint();
            SetButtonsValues();
            panel.setVisible(true);
            return panel;
        }
        catch (TooManyBombs ex) {
         ex.Message();
        }
        return null;
    }

    private void EndGame() {
        //panel.getComponents().length;
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setVisible(true);
        CleanTable();
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

    private ImageIcon GetButtonIconPath(int x, int y) {
        if (_visabletable.GetElement(x, y) == '0')
            return images.GetImage(0);
        if (_visabletable.GetElement(x, y) == '1')
            return images.GetImage(1);
        if (_visabletable.GetElement(x, y) == '2')
            return images.GetImage(2);
        if (_visabletable.GetElement(x, y) == '3')
            return images.GetImage(3);
        if (_visabletable.GetElement(x, y) == '4')
            return images.GetImage(4);
        if (_visabletable.GetElement(x, y) == '5')
            return images.GetImage(5);
        if (_visabletable.GetElement(x, y) == '6')
            return images.GetImage(6);
        if (_visabletable.GetElement(x, y) == '7')
            return images.GetImage(7);
        if (_visabletable.GetElement(x, y) == '8')
            return images.GetImage(8);
        if (_visabletable.GetElement(x, y) == '+')
            return images.GetImage(9);
        if (_visabletable.GetElement(x, y) == '*')
            return images.GetImage(10);
        return null;
    }


}

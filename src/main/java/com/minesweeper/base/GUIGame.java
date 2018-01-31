package com.minesweeper.base;

import javax.swing.*;
import java.awt.*;

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

    private JPanel display() throws TablesSizeError {
        if (instance != null) {
            JPanel gametable = new JPanel();
            gametable.setLayout(new GridLayout(instance.getYSize(), instance.getXSize()));
            gametable.setBorder(BorderFactory.createLineBorder(Color.red));
            buttons = new JButton[instance.getYSize()][instance.getXSize()];
            for (int ypos = 0; ypos < instance.getYSize(); ypos++) {
                for (int xpos = 0; xpos < instance.getXSize(); xpos++) {
                    final int y = ypos;
                    final int x = xpos;
                    buttons[y][x] = new JButton();
                    buttons[y][x].addActionListener(e -> {
                        try {
                            instance.doTurn(x, y);
                        } catch (TurnIsOutOfBounds turnIsOutOfBounds) {
                            turnIsOutOfBounds.printStackTrace();
                        }
                        setButtonsValues();
                    });
                    gametable.add(buttons[y][x]);
                }
                System.out.println();
            }
            return gametable;
        }
        return new JPanel();
    }

    private void setButtonsValues() {
        EventQueue.invokeLater(() -> {
            for (int y = 0; y < instance.getYSize(); y++) {
                for (int x = 0; x < instance.getXSize(); x++) {
                    ImageIcon icon = getButtonIconPath(x, y);
                    buttons[y][x].setIcon(icon);
                }
            }
        });
    }

    public JPanel startGame(int x, int y, int b) {
        if (panel != null) {
            if (panel.getComponents().length > 0) {
                System.out.println("Gametable has " + panel.getComponents().length + " buttons");
                endGame();
            }
        }
        try {
            images = new GetImages();
            instance.createTable(x, y, b);
            panel = this.display();
            panel.revalidate();
            panel.repaint();
            setButtonsValues();
            panel.setVisible(true);
            return panel;
        } catch (TablesSizeError e) {
            e.printStackTrace();
        } catch (TooManyBombs tooManyBombs) {
            tooManyBombs.printStackTrace();
        }
        return null;
    }

    private void endGame() {
        panel.removeAll();
        panel.revalidate();
        panel.repaint();
        panel.setVisible(true);
        instance.cleanTable();
    }

    @Override
    protected void gameOver() {
        setButtonsValues();
        super.gameOver();
        JOptionPane.showMessageDialog(null, "Game Over!");

    }

    @Override
    protected void gameWin() {
        super.gameOver();
        setButtonsValues();
        JOptionPane.showMessageDialog(null, "You Won!");
    }

    private ImageIcon getButtonIconPath(int x, int y) {
        return images.getImage(instance.getElement(x, y));
    }
}

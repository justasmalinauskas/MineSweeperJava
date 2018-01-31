package com.minesweeper.base;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class GetImages {

    private ImageIcon zero;
    private ImageIcon one; // = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("1.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon two;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("2.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon three;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("3.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon four;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("4.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon five;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("5.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon six;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("6.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon seven;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("7.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon eight;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("8.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon block;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("block.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private ImageIcon bomb;// = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("bomb.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));

    public GetImages() {
        initImages();
    }

    private void initImages() {
        try {
            zero = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("0.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            one = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("1.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            two = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("2.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            three = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("3.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            four = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("4.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            five = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("5.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            six = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("6.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            seven = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("7.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            eight = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("8.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            block = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("block.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
            bomb = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("bomb.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
        }
        catch (IOException e) {

        }
    }
    
    public ImageIcon getImage(BlockType id) {
        switch (id) {
            case ZERO:
                return zero;
            case ONE:
                return one;
            case TWO:
                return two;
            case THREE:
                return three;
            case FOUR:
                return four;
            case FIVE:
                return five;
            case SIX:
                return six;
            case SEVEN:
                return seven;
            case EIGHT:
                return eight;
            case BLOCK:
                return block;
            default:
                return bomb;

        }
    }
}

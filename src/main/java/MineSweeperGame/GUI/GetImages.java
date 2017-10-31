package MineSweeperGame.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

class GetImages {

    private final ImageIcon zero = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("0.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon one = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("1.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon two = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("2.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon three = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("3.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon four = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("4.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon five = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("5.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon six = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("6.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon seven = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("7.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon eight = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("8.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon block = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("block.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    private final ImageIcon bomb = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("bomb.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));

    public GetImages() throws IOException {

    }
    
    public ImageIcon GetImage(int id) {
        if (id == 0)
            return zero;
        if (id == 1)
            return one;
        if (id == 2)
            return two;
        if (id == 3)
            return three;
        if (id == 4)
            return four;
        if (id == 5)
            return five;
        if (id == 6)
            return six;
        if (id == 7)
            return seven;
        if (id == 8)
            return eight;
        if (id == 9)
            return block;
        if (id == 10)
            return bomb;
        return null;
    }
}

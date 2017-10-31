package MineSweeperGame.GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class GetImages {

    public ImageIcon zero = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("0.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon one = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("1.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon two = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("2.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon three = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("3.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon four = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("4.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon five = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("5.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon six = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("6.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon seven = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("7.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon eight = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("8.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon block = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("block.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));
    public ImageIcon bomb = new ImageIcon(ImageIO.read(new File(getClass().getClassLoader().getResource("bomb.png").getFile())).getScaledInstance(45,-1, Image.SCALE_SMOOTH));

    public GetImages() throws IOException {

    }
}

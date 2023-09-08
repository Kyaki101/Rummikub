import javax.swing.*;
import java.awt.*;

public class Main{
    public static void main(String args[]){
        ImageIcon image = new ImageIcon("logo.png");
        JLabel label = new JLabel();
        label.setVisible(true);
        label.setText("why is java so shit");
        label.setIcon(image);

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setVisible(true);
        frame.add(label);
        System.out.println(new java.io.File("logo.png").exists());
    }
}
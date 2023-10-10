import javax.swing.*;
import java.awt.*;

public class Background extends JPanel{

    ImageIcon background = new ImageIcon("res/images/background_img.png");

    Background (){
        JLabel bg = new JLabel();
        bg.setIcon(background);
        this.setBackground(Color.black);
        this.setBounds(0, 0, 1400, 1080);
        this.add(bg);
    }
}

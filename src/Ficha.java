import javax.swing.*;
import java.awt.*;

public class Ficha extends JLabel{
    private Color color;
    private int num;

    private boolean comodin;

    public int getNum() {
        return num;
    }


    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor(){
        return this.color;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public boolean isComodin() {
        return comodin;
    }

    public void setComodin(boolean comodin) {
        this.comodin = comodin;
    }

    Ficha(int num, Color color){
        ImageIcon image = new ImageIcon("res/images/ficha.png");
//        Image newImage = image.getImage().getScaledInstance(100, 120, Image.SCALE_DEFAULT);
//        ImageIcon update = new ImageIcon(newImage);
        setNum(num);
        setColor(color);
        this.comodin = false;
        this.setText(String.valueOf(getNum()));
        this.setFont(new Font("SansSerif", Font.BOLD, 75));
        this.setForeground(color);
        this.setHorizontalTextPosition(this.CENTER);
        this.setIcon(image);
        this.setSize(100, 100);
        this.setVerticalAlignment(this.CENTER);
        this.setHorizontalAlignment(this.CENTER);
        this.setBounds(0, 0, 800, 800);
    }

    Ficha(boolean joker){
        ImageIcon image = new ImageIcon("res/images/ficha.png");
        this.color = Color.WHITE;
        this.num = 0;
        setComodin(joker);
        this.setText("J");
        this.setFont(new Font("SansSerif", Font.BOLD, 75));
        this.setHorizontalTextPosition(this.CENTER);
        this.setVerticalAlignment(this.CENTER);
        this.setHorizontalAlignment(this.CENTER);
        this.setBounds(0, 0, 800, 800);

    }
}

import java.util.*;
import javax.swing.*;
public class Ficha extends JLabel{
    private String color;
    private int num;

    private boolean comodin;

    public int getNum() {
        return num;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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

    Ficha(int num, String color){
        ImageIcon image = new ImageIcon("logo.png");
        setNum(num);
        setColor(color);
        this.comodin = false;
        this.setText("testing");
        this.setIcon(image);
    }

    Ficha(boolean joker){
        this.color = "";
        this.num = 0;
        setComodin(joker);
    }
}

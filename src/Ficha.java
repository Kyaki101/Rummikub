import java.util.*;
public class Ficha {
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
        setNum(num);
        setColor(color);
        this.comodin = false;
    }

    Ficha(boolean joker){
        this.color = "";
        this.num = 0;
        setComodin(joker);
    }
}

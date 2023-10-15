import java.awt.*;
import javax.swing.*;

public class Ficha extends JButton{

    private int numero;
    private Color color;

    private boolean isJoker;


    public Ficha(){

        this.isJoker = false;
        this.numero = 0;
        this.color = Color.WHITE;

    }



    public Ficha(int numero, Color color){
        this.isJoker = false;
        this.numero = numero;
        this.color = color;
        this.setForeground(color);
        this.setText(""+this.getNumero());
    }

    public void clear(){
        setColor(Color.WHITE);
        setNumero(0);
        setForeground(getColor());
        setText("" + getNumero());
    }

    public void copy(Ficha ficha){
        this.color = ficha.getColor();
        this.numero = ficha.getNumero();
        setText("" + numero);
        setForeground(color);
    }


    public Ficha(Ficha a){

        this.isJoker = a.getJoker();
        this.numero = a.getNumero();
        this.color = a.getColor();
        this.setForeground(color);
        if(isJoker) this.setText("♨");
        else this.setText("" + numero);


    }

    public void refresh(Game game){
        this.setText("" + numero);
        this.setColor(color);
    }

    public Ficha(boolean a){
        this.isJoker = a;
        this.numero = 100;
        this.color = Color.RED;
        this.setText("+");
        this.setForeground(Color.RED);
    }

    public boolean getJoker(){
        return isJoker;
    }



    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String toString(){

        if(isJoker) return "Joker" + '\n';
        if(color == Color.RED) return "" + numero + " " + "Rojo" + '\n';
        if(color == Color.BLUE) return "" + numero + " " + "Azul" + '\n';
        if(color == Color.BLACK) return "" + numero + " " + "Negro" + '\n';
        if(color == Color.YELLOW) return "" + numero + " " + "Amarillo" + '\n';
        return "Ficha vacia";

    }
}

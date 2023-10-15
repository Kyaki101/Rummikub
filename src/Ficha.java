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
        this.setForeground(color);
        this.setText("");

    }



    public Ficha(int numero, Color color){
        this.isJoker = false;
        this.numero = numero;
        this.color = color;
        this.setForeground(color);
        this.setText(""+this.getNumero());
    }

    public void clear(){

        this.isJoker = false;
        this.numero = 0;
        this.color = Color.WHITE;
        this.setForeground(color);
        this.setText("");

    }

    public void copy(Ficha ficha){
        this.color = ficha.getColor();
        this.numero = ficha.getNumero();
        this.isJoker = ficha.getJoker();
        if(isJoker) this.setText("☻");
        else this.setText("" + numero);
        this.setForeground(color);
    }


    public Ficha(Ficha a){

        this.isJoker = a.getJoker();
        this.numero = a.getNumero();
        this.color = a.getColor();
        if(isJoker) this.setText("☻");
        else this.setText("" + numero);
        this.setForeground(color);



    }

    public void refresh(Game game){

        if (this.getJoker()){
            this.setText("☻");
            this.setForeground(Color.BLACK);
        }
        else{

            this.setText("" + this.getNumero());
            this.setForeground(this.getColor());
        }
    }

    public Ficha(boolean a){
        this.isJoker = a;
        this.numero = 100;
        this.color = Color.BLACK;
        this.setText("☻");
        this.setForeground(Color.RED);
    }

    public boolean getJoker(){
        return isJoker;
    }


    public void setJoker(boolean a){
        this.isJoker = a;
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

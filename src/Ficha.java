import java.awt.*;
import javax.swing.*;
import java.awt.font.*;

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
        this.setFont(font);

    }



    public Ficha(int numero, Color color){
        this.isJoker = false;
        this.numero = numero;
        this.color = color;
        this.setForeground(color);
        this.setText(""+this.getNumero());
        this.setFont(font);
    }

    public void clear(){

        this.isJoker = false;
        this.numero = 0;
        this.color = Color.WHITE;
        this.setForeground(color);
        this.setText("");
        this.setFont(font);

    }

    public void copy(Ficha ficha){
        this.color = ficha.getColor();
        this.numero = ficha.getNumero();
        this.isJoker = ficha.getJoker();
        if(isJoker) this.setText("☻");
        else this.setText("" + numero);
        this.setForeground(color);
        this.setFont(font);
    }


    public Ficha(Ficha a){

        this.isJoker = a.getJoker();
        this.numero = a.getNumero();
        this.color = a.getColor();
        if(isJoker) this.setText("☻");
        else this.setText("" + numero);
        this.setForeground(color);
        this.setFont(font); 

    }

    private Font font = new Font("Arial", Font.PLAIN, 10);

    public void refresh(Game game){

        if (this.getJoker()){
            this.setText("☻");
            this.setForeground(Color.BLACK);
            this.setFont(font);
        }
        else{

            this.setText("" + this.getNumero());
            this.setForeground(this.getColor());
            this.setFont(font);
        }
    }

    public Ficha(boolean a){
        this.isJoker = a;
        this.numero = 100;
        this.color = Color.DARK_GRAY;
        this.setText("☻");
        this.setForeground(Color.DARK_GRAY);
        this.setFont(font);
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



}

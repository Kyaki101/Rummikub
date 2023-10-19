import java.awt.*;
import javax.swing.*;
import java.awt.font.*;

public class Ficha extends JButton{

    private int numero;
    private Color color;

    private boolean isJoker;


    //el siguente constructor se ultiza para instanciar una ficha nula
    //con nula nos referimos a que sus valores son 0 y blanco y no es joker
    public Ficha(){

        this.isJoker = false;
        this.numero = 0;
        this.color = Color.WHITE;
        this.setForeground(color);
        this.setText("");
        this.setFont(font);

    }


    //el constructor se utiliza cuando queremos crear una ficha con color y numero
    public Ficha(int numero, Color color){
        this.isJoker = false;
        this.numero = numero;
        this.color = color;
        this.setForeground(color);
        this.setText(""+this.getNumero());
        this.setFont(font);
    }

    //esta funcion se utiliza cuando queremos anular los valores de una ficha
    public void clear(){

        this.isJoker = false;
        this.numero = 0;
        this.color = Color.WHITE;
        this.setForeground(color);
        this.setText("");
        this.setFont(font);

    }

    //esta funcion se utiliza para copiar los datos de una ficha ya existente sin copiar su direccion de memoria
    public void copy(Ficha ficha){
        this.color = ficha.getColor();
        this.numero = ficha.getNumero();
        this.isJoker = ficha.getJoker();
        if(isJoker) this.setText("☻");
        else this.setText("" + numero);
        this.setForeground(color);
        this.setFont(font);
    }


    //este constructor se utiliza para crear una nueva ficha en base de una ficha ya existente
    public Ficha(Ficha a){

        this.isJoker = a.getJoker();
        this.numero = a.getNumero();
        this.color = a.getColor();
        if(isJoker) this.setText("☻");
        else this.setText("" + numero);
        this.setForeground(color);
        this.setFont(font);

    }

    private Font font = new Font("Roboto", Font.BOLD, 10);


    //este constructor se utiliza cuando queremos crear una ficha tipo joker
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

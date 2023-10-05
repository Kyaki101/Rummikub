import java.awt.*;

public class Ficha {

    private int numero;
    private Color color;

    private boolean isJoker;

    public Ficha(int numero, Color color){
        this.isJoker = false;
        this.numero = numero;
        this.color = color;
    }


    public Ficha(Ficha a){

        this.isJoker = a.getJoker();
        this.numero = a.getNumero();
        this.color = a.getColor();

    }

    public Ficha(boolean a){
        this.isJoker = a;
        this.numero = 0;
        this.color = Color.WHITE;
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
        return "" + numero + " " + "Amarillo" + '\n';

    }
}

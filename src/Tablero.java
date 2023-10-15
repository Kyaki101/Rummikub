import java.awt.*;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Tablero extends JPanel{


    public Casilla[] tablero = new Casilla[7];



    public Tablero(){
        for(int i = 0; i < 7; i++){
            tablero[i] = new Casilla(i * 90);
        }

    }













    public boolean verify(boolean firstTurn, Tablero aux){

        for(int i = 0; i<7; i++){

            if(!tablero[i].verify()) return false;

        }if(this.cantFichas() <= aux.cantFichas()) return false;
        if(firstTurn && this.sumTablero()-aux.sumTablero() < 30) return false;
        return true;
    }







    public boolean insertarFicha(Ficha ficha, int posicion, int i){

        if(tablero[posicion].addFicha(ficha, i)) return true;
        return false;

    }



    public void copy(Tablero t){

        tablero = new Casilla[7];
        for(int i = 0; i < 7; i++){

            tablero[i] = new Casilla(t.getCasilla(i));

        }

    }





    public void cambiarFicha(int posicion1, int posicion2, int i, int j){

        Ficha ficha1 = tablero[posicion1].getFicha(i);
        Ficha ficha2 = tablero[posicion2].getFicha(j);
        tablero[posicion1].setFicha(ficha2, i);
        tablero[posicion2].setFicha(ficha1, j);


    }










    public void imprimirTablero() {

        for(int i = 0; i<7; i++){

            if(tablero[i].cantFichas() != 0){

                System.out.print(i + ". ");
                tablero[i].imprimirCasilla();

            }
        }
    }







    public Casilla getCasilla(int i) {
        return tablero[i];
    }
    


    public Casilla[] getTablero() {
        return tablero;
    }




    public int sumTablero(){

        int sum = 0;
        for(int i = 0; i<7; i++){

            sum += tablero[i].sumCasilla();

        }
        System.out.println(sum);
        return sum;

    }


    public int cantFichas(){

        int sum = 0;
        for(int i = 0; i<7; i++){

            sum += tablero[i].cantFichas();

        }
        return sum;
    }



}
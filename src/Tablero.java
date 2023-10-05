import java.util.List;
import java.util.ArrayList;

public class Tablero{



    public Casilla[] tablero = new Casilla[100];


    public Tablero(){

        for(int i = 0; i < 100; i++){
            tablero[i] = new Casilla();
        }

    }

    public void añadirFicha(Ficha ficha, int posicion){

        tablero[posicion].addFicha(ficha);


    }






    public void insertarFicha(Ficha ficha, int posicion, int i){

        tablero[posicion].addFicha(ficha, i);

    }







    public void cambiarFicha(int posicion1, int posicion2, int i, int j){

        Ficha ficha1 = tablero[posicion1].getFicha(i);
        Ficha ficha2 = tablero[posicion2].getFicha(j);
        tablero[posicion1].setFicha(ficha2, i);
        tablero[posicion2].setFicha(ficha1, j);


    }








    public void imprimirTablero() {
        for (int i = 0; i < 100; i++) {
            System.out.println(tablero[i]);

        }
    }




}
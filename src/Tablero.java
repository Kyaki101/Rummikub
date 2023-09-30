import java.util.List;
import java.util.ArrayList;

public class Tablero{

    //haz un arreglo en el que cada posicion sea un List de fichas
    public List<Ficha>[] tablero = new ArrayList[100];

    // Constructor para inicializar cada elemento del arreglo como una nueva lista vacía
    public Tablero() {
        for (int i = 0; i < 100; i++) {
            tablero[i] = new ArrayList<>();
        }
    }


    public void insertarFicha(Ficha ficha, int posicion){
        tablero[posicion].add(ficha);
    }


    public void imprimirTablero(){
        for(int i = 0; i < 100; i++){
            System.out.println("Posicion " + i + ": " + tablero[i]);
        }
    }






}
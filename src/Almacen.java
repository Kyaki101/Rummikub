import java.awt.Color;
import java.sql.Array;
import java.util.*;

// Definición de la clase Almacen
public class Almacen {

    // Lista para almacenar las fichas en el almacén
    private List<Ficha> cola = new ArrayList<>();

    // Arreglo de colores para las fichas
    private Color colors[] = {Color.BLACK, Color.YELLOW, Color.BLUE, Color.RED};

    // Constructor de la clase Almacen: inicializa el almacén con 2 copias de cada ficha del 1 al 13 y de cada color
    public Almacen(){
        for(int i = 0; i < 52; i++) {
            // Añade dos copias de la misma ficha con diferentes colores
            cola.add(new Ficha(i % 13 + 1, colors[i / 13]));
            cola.add(new Ficha(i % 13 + 1, colors[i / 13]));
        }
    }

    // Método getter para obtener la lista de fichas en el almacén
    public List<Ficha> getCola(){
        return cola;
    }

    // Método para barajar las fichas en el almacén utilizando el método shuffle() de la clase Collections
    public void barajar(){
        Collections.shuffle(cola);
    }
}

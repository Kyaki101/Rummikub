import java.util.ArrayList;
import java.util.List;

// Definición de la clase Baraja
public class Baraja {

    // Lista para almacenar las fichas en la baraja
    private List<Ficha> fichas = new ArrayList<>();

    // Método getter para obtener la lista de fichas en la baraja
    public List<Ficha> getFichas() {
        return fichas;
    }

    // Método setter para establecer la lista de fichas en la baraja
    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    // Constructor que crea una baraja con las primeras 14 fichas de la cola proporcionada
    public Baraja(List<Ficha> cola){
        // Llena la baraja con las primeras 14 fichas de la cola y las remueve de la cola
        for(int i = 0; i < 14; i++){
            fichas.add(cola.get(0));
            cola.remove(0);
        }
    }

    // Método para que la baraja "coma" una ficha del almacén
    public void Comer(Almacen a){
        // Verifica si el almacén está vacío
        if(a.getCola().isEmpty()) {
            // Imprime un mensaje si no quedan cartas en el almacén y retorna
            System.out.println("No quedan cartas en el almacen");
            return;
        }
        // Agrega la primera ficha del almacén a la baraja y la remueve del almacén
        fichas.add(a.getCola().get(0));
        a.getCola().remove(0);
    }
}

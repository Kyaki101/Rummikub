// Definición de la clase Player
public class Player {

    // Variable de instancia para almacenar la baraja del jugador
    Baraja deck;

    public Player(Almacen a) {
        // Inicializa la baraja del jugador con las fichas obtenidas del almacén
        deck = new Baraja(a.getCola());
    }

    public String toString() {
        // Crea una cadena vacía
        String s = "";
        // Itera sobre las primeras 14 fichas en la baraja del jugador
        for (int i = 0; i < 14; i++) {
            // Agrega la representación de cadena de la ficha actual a la cadena s
            s += deck.getFichas().get(i).toString();
        }
        // Devuelve la cadena s que contiene las primeras 14 fichas del jugador
        return s;
    }

    // Método para que el jugador "coma" una ficha del almacén
    public void comer(Almacen a) {
        deck.Comer(a);
    }

    public boolean Gano() {
        return deck.getFichas().isEmpty();
    }






}

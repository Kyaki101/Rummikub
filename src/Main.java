import java.awt.*;

// Clase principal Main
public class Main {

    // Método principal, el punto de entrada del programa
    public static void main(String[] args) {

        // Crear una instancia de Almacen (almacén de fichas) y barajar las fichas
        Almacen a = new Almacen();
        a.barajar();

        // Crear dos jugadores (instancias de la clase Player) y proporcionarles la baraja barajada
        Player luis = new Player(a);
        Player melvin = new Player(a);

        // Imprimir las fichas en la mano de Melvin y Luis
        /*System.out.println("Fichas en la mano de Melvin:");
        System.out.println(melvin);

        System.out.println("Fichas en la mano de Luis:");
        System.out.println(luis);*/



        Tablero tab = new Tablero();

        tab.añadirFicha(new Ficha(1, Color.BLUE), 0);
        tab.añadirFicha(new Ficha(2, Color.BLUE), 0);
        tab.añadirFicha(new Ficha(3, Color.BLUE), 0);
        tab.imprimirTablero();


    }
}

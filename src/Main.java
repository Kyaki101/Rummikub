// Clase principal Main
public class Main {

    // Método principal, el punto de entrada del programa
    public static void main(String[] args) {
        // Comentario: Las siguientes líneas están comentadas y no se utilizan en el programa
        /* Player player1 = new Player();
        Player player2 = new Player();*/

        // Crear una instancia de Almacen (almacén de fichas) y barajar las fichas
        Almacen a = new Almacen();
        a.barajar();

        // Crear dos jugadores (instancias de la clase Player) y proporcionarles la baraja barajada
        Player luis = new Player(a);
        Player melvin = new Player(a);

        // Imprimir las fichas en la mano de Melvin y Luis
        System.out.println("Fichas en la mano de Melvin:");
        System.out.println(melvin);

        System.out.println("Fichas en la mano de Luis:");
        System.out.println(luis);

        for(int i = 0; i<78; i++){

            System.out.println(a.getCola().get(i));
        }

    }
}

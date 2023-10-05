import java.util.Scanner;

public class Player {

    Baraja deck;
    String name;

    public Player(Almacen a) {

        System.out.println("Ingrese el nombre del jugador: ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        deck = new Baraja(a.getCola());


    }




    public void comer(Almacen a) {
        deck.Comer(a);
    }

    public boolean Gano() {
        return deck.getFichas().isEmpty();
    }


    public String getName() {
        return name;
    }


    public String toString(){

        String s = "";
        for(int i = 0; i < deck.getFichas().size(); i++){
            s += deck.getFichas().get(i).toString();
        }return  "\n\n" + s;


    }



}

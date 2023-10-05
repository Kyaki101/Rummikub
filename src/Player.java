import java.util.List;
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

    public Player(){

        name = "";
        deck = new Baraja();

    }

    public List<Ficha> getDeck() {
        return deck.getFichas();
    }


    public Player(Player a){

        deck = new Baraja();
        name = a.getName();
        for(int i = 0; i<a.getDeck().size(); i++){
            deck.getFichas().add(a.getDeck().get(i));
        }

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


    public Ficha eliminarFicha(int i){

        Ficha f = deck.getFichas().get(i);
        deck.getFichas().remove(i);
        return f;

    }








    public void copy(Player a){

        deck = new Baraja();
        name = a.getName();
        for(int i = 0; i<a.getDeck().size(); i++){
            deck.getFichas().add(a.getDeck().get(i));
        }
    }


}

import java.util.List;
import java.util.Scanner;

public class Player {


    private boolean winner;
    private int points;
    private Baraja deck;
    private String name;

    public Player(Almacen a) {

        points = 0;
        System.out.println("Ingrese el nombre del jugador: ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        deck = new Baraja(a.getCola());


    }

    public Player(){

        points = 0;
        name = "";
        deck = new Baraja();

    }

    public Player(Player a){

        points = a.getPoints();
        deck = new Baraja();
        name = a.getName();
        for(int i = 0; i<a.getDeck().size(); i++){
            deck.getFichas().add(a.getDeck().get(i));
        }

    }






    public List<Ficha> getDeck() {
        return deck.getFichas();
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
            s += i + ".  " + deck.getFichas().get(i).toString();
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













    public void setPoints(int i){
        points = i;
    }
    public void addPoints(int i){
        points += i;
    }

    public int getPoints() {
        return points;
    }


    public int sumPoints(){

        if(deck.getFichas().isEmpty()) return 0;
        int sum = 0;
        for(int i = 0; i<deck.getFichas().size(); i++){

            if(deck.getFichas().get(i).getJoker()) sum+= 30;
            else
                sum += deck.getFichas().get(i).getNumero();

        }return sum;

    }



    public boolean getWinner(){
        return winner;
    }

    public void setWinner(){
        winner = true;
    }

}

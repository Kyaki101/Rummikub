import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



public class Player {


    private boolean winner;
    private int points;
    private Baraja deck;
    private String name;

    private Ficha[] stat;




    public Player(Almacen a) {

        points = 0;
        System.out.println("Ingrese el nombre del jugador: ");
        Scanner sc = new Scanner(System.in);
        name = sc.nextLine();
        deck = new Baraja(a.getCola());
        makeDeck();


    }



    public Player(Player a){
        points = a.getPoints();
        deck = new Baraja();
        name = a.getName();
        for(int i = 0; i<a.getDeck().size(); i++){
            deck.getBaraja().add(a.getFicha(i));
        }

    }

    public void refPlayer(Player a){
        points = a.getPoints();
        deck = new Baraja();
        name = a.getName();
        for(int i = 0; i<a.getDeck().size(); i++){
            deck.getBaraja().add(a.getFicha(i));
        }
    }

    public void addFicha(int index, Ficha ficha){
        deck.addFicha(index, ficha);
        makeDeck();
    }







    public void makeDeck(){

        stat =  deck.makeDeck();

    }


    public List<Ficha> getDeck() {
        return deck.getBaraja();
    }










    public Ficha[] getStat(){
        return stat;
    }





    public void comer(Almacen a) {

        deck.Comer(a);
        makeDeck();
    }

    public boolean Gano() {

        return deck.getBaraja().isEmpty();

    }


    public String getName() {
        return name;
    }











    public String toString(){

        String s = "";
        for(int i = 0; i < deck.getBaraja().size(); i++){
            if(deck.getBaraja().get(i) != null) {
                s += i + ".  " + deck.getBaraja().get(i).toString();
            }
        }return  "\n\n" + s;


    }





    public Ficha eliminarFicha(int i){

        Ficha f = deck.getBaraja().get(i);
        deck.getBaraja().remove(i);
        return f;

    }







    // aqui hay un error
    public void copy(Player a){

        deck = new Baraja();
        name = a.getName();
        for(int i = 0; i<a.getDeck().size(); i++){
            deck.getBaraja().add(a.getDeck().get(i));
        }
    }













    public void addPoints(int i){
        points += i;
    }

    public int getPoints() {
        return points;
    }


    public int sumPoints(){

        if(deck.getBaraja().isEmpty()) return 0;
        int sum = 0;
        for(int i = 0; i<deck.getBaraja().size(); i++){

            if(deck.getBaraja().get(i).getJoker()) sum += 30;
            else
                sum += deck.getBaraja().get(i).getNumero();

        }return sum;

    }



    public boolean getWinner(){
        return winner;
    }

    public void setWinner(){
        winner = true;
    }



    public Ficha getFicha(int i){
        return deck.getBaraja().get(i);
    }






}

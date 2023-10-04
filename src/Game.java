import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private List<Player> players = new ArrayList<>();

    private Almacen almacen;

    private int turn;

    private int size;

    String ins;



    public Game(int n){

        size = n;
        almacen = new Almacen();
        for(int i = 0; i<n; i++) players.add(new Player(almacen));
        System.out.println(players.get(0));
        System.out.println(players.get(1));
        turn = 0;
        ins = "";

    }















    public void nextTurn(){
        turn++;
        turn%=size;
    }


    public Player getPlayer(){
        return players.get(turn);
    }


    public int getTurn(){
        return turn;
    }

    public void Turn(){

        System.out.println("Fichas en la mano de " + players.get(turn).getName() + ":");
        System.out.println(players.get(turn));
        System.out.println("Fichas en el almacén: " + almacen.size() + '\n');
        System.out.print("Desea jugar o comer? (j/c): ");
        Scanner sc = new Scanner(System.in);
        ins = sc.nextLine();
        if(ins.equals("c")) players.get(turn).comer(almacen);
        this.nextTurn();
        //aqui falta el codigo del juego


    }






}

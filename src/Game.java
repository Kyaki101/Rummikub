import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    private Tablero tablero;

    private List<Player> players = new ArrayList<>();

    private Almacen almacen;

    private int turn;

    private int size, x, y, z, a, b, c;

    String ins;






    public Game(int n){

        size = n;
        almacen = new Almacen();
        tablero = new Tablero();
        players = new ArrayList<>();
        for(int i = 0; i<n; i++) players.add(new Player(almacen));
        turn = 0;
        ins = "";

    }















    public void nextTurn(){
        turn++;
        turn%=size;
    }















    //esta funcion retorna una lista de los jugadores con sus respectivos puntajes, para que archive los guarde

    public List<Player> Turn(){

        Player jug = new Player(players.get(turn));
        Tablero tab = new Tablero();
        tab.copy(tablero);
        Almacen alm = new Almacen(almacen);




        while(true) {


            System.out.println("Tablero:");
            tablero.imprimirTablero();
            System.out.println("Fichas en la mano de " + players.get(turn).getName() + ":");
            System.out.println(players.get(turn));
            System.out.print("Desea jugar o comer? (j/c): ");
            Scanner sc = new Scanner(System.in);
            ins = sc.nextLine();
            if (ins.equals("c")) players.get(turn).comer(almacen);

            else if (ins.equals("j")) {

                while (true) {


                    play();
                    if (tablero.verify()) {

                        if (players.get(turn).Gano()) {

                            System.out.println("El jugador " + players.get(turn).getName() + " ha ganado");
                            players.get(turn).setWinner();
                            this.addPointsW();
                            return players;
                        }

                        if(almacen.getCola().isEmpty()){

                            System.out.println("El juego ha terminado");
                            this.addPointsE();
                            return players;

                        }
                        this.nextTurn();
                        return this.Turn();



                    } else {

                        //probar caso de tablero duplicado

                        System.out.println("Jugada inválida");
                        tablero.imprimirTablero();
                        players.get(turn).copy(jug);
                        tablero.copy(tab);
                        almacen.copy(alm);

                    }
                }
            }
        }
    }










    public void play(){

        while(true)
        {

            //aqui falta añadir el comer
            System.out.println(players.get(turn).getName() + " desea añadir, insertar o cambiar una ficha, o exit? (a/i/c/e): ");
            Scanner sc = new Scanner(System.in);
            ins = sc.nextLine();
            if (ins.equals("e")) return;



            if (ins.equals("a")) {

                System.out.println("Ingrese el número de ficha de su inventario: ");
                x = sc.nextInt();
                System.out.println("Ingrese la coordenada de la casilla: ");
                y = sc.nextInt();
                tablero.añadirFicha(players.get(turn).eliminarFicha(x), y);


            } else if (ins.equals("i")) {

                System.out.println("Ingrese el número de ficha de su inventario: ");
                x = sc.nextInt();
                System.out.println("Ingrese la coordenada de la casilla: ");
                y = sc.nextInt();
                System.out.println("Ingrese en que indice desea ingresar la ficha: ");
                z = sc.nextInt();
                tablero.insertarFicha(players.get(turn).eliminarFicha(x), y, z);


            } else if (ins.equals("c")) {


                System.out.println("Ingrese la coordenada de la casilla de la ficha 1 que desea cambiar: ");
                x = sc.nextInt();
                System.out.println("Ingrese el indice de la ficha 1 que desea cambiar: ");
                y = sc.nextInt();
                System.out.println("Ingrese la coordenada de la casilla de la ficha 2 que desea cambiar: ");
                z = sc.nextInt();
                System.out.println("Ingrese el indice de la ficha 2 que desea cambiar: ");
                a = sc.nextInt();
                tablero.cambiarFicha(x, z, y, a);


            } else {

                System.out.println("Jugada inválida");
                continue;

            }

        }

    }


    //falta el primer turno, suma de 30


    public void addPointsW(){

        int j;
        int sum = 0;
        for(int i = 0; i<players.size(); i++){

            if(players.get(i).getWinner()) j = i;
            sum += players.get(turn).sumPoints();
            players.get(turn).addPoints(-players.get(turn).sumPoints());

        }players.get(turn).addPoints(sum);
    }


    public void addPointsE(){

        int max = -1, index = 0;
        for(int i = 0; i<players.size(); i++){

            if(players.get(i).sumPoints()>max) {
                max = players.get(i).sumPoints();
                index = i;
            }

        }
        for(int i = 0; i<players.size(); i++){

            if(i!=index) players.get(i).addPoints(-players.get(i).sumPoints());

        }

    }





}

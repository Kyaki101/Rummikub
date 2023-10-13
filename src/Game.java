import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

public class Game extends JFrame implements ActionListener {

    private Tablero tablero;

    private List<Player> players = new ArrayList<>();

    private Almacen almacen;

    private int turn;

    private int size, x, y, z, a, b, c;

    String ins;






    public Game(int n){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1400, 1080);

        size = n;
        almacen = new Almacen();
        tablero = new Tablero(this);
        players = new ArrayList<>();
        for(int i = 0; i<n; i++) players.add(new Player(almacen));
        turn = 0;
        ins = "";

    }


    private Ficha buffer;












    public void nextTurn(){
        turn++;
        turn%=size;
    }

    private JButton comer;


    private void refDeck(Ficha[] pre, Ficha[] stat){
        for(int j = 0; j < 25; j++){
            Rectangle temp = pre[j].getBounds();
            removeFicha(pre[j]);

        }
        for(int i = 0; i < 25; i ++){
            addFicha(stat[i], i * 50, 750, 50, 70);
        }
    }

    public void removeFicha(Ficha ficha){
        ficha.setBounds(1500, 0, 0, 0);
        ficha.removeActionListener(this);
        this.remove(ficha);
    }

    public void addFicha(Ficha ficha, int x, int y, int width, int height){
        ficha.setBounds(x, y, width, height);
        this.add(ficha);
        ficha.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 20; j ++){
                Ficha test = tablero.getTablero()[i].getCasilla()[j];
                if (e.getSource() == test){
                    if(buffer != null && test.getNumero() == 0){
                        tablero.getTablero()[i].getCasilla()[j] = buffer;
                        test.setText("" + buffer.getNumero());
                        test.setForeground(buffer.getColor());
                        buffer = null;
                        System.out.println(tablero.getTablero()[i].getCasilla()[j]);
                    }
                    System.out.println(test);

                }
            }
        }

        for(int i = 0; i < 25; i ++){
            Ficha[] pre = players.get(turn).getStat();
            if(e.getSource() == pre[i]){
                System.out.println(i);
                buffer = new Ficha(pre[i]);
                if(players.get(turn).getDeck().size() > i){

                    players.get(turn).eliminarFicha(i);
                    players.get(turn).makeDeck();
                    Ficha[] stat = players.get(turn).getStat();
                    refDeck(pre, stat);
                }


            }
        }
        if(e.getSource() == comer){
            Ficha[] pre = players.get(turn).getStat();
            players.get(turn).comer(almacen);
            Ficha[] stat = players.get(turn).getStat();
            refDeck(pre, stat);
        }
    }





    //esta funcion retorna una lista de los jugadores con sus respectivos puntajes, para que archive los guarde

    public List<Player> Turn(boolean firstTurn){

        Player jug = new Player(players.get(turn));
        Tablero tab = new Tablero(this);
        tab.copy(tablero);
        Almacen alm = new Almacen(almacen);

        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 20; j ++){
                tablero.getTablero()[i].getCasilla()[j].setBounds(j * 70, i * 100, 60, 80);
                this.add(tablero.getTablero()[i].getCasilla()[j]);
                tablero.getTablero()[i].getCasilla()[j].addActionListener(this);
            }
        }

        comer = new JButton();
        comer.setBounds(1270, 730, 100, 100);
        comer.setText("comer");
        comer.addActionListener(this);
        this.add(comer);

        for(int i = 0; i < 25; i ++){

            if(players.get(turn).getStat()[i] != null) {

                addFicha(players.get(turn).getStat()[i], i * 50, 750, 50, 70);

            }
        }

        this.setVisible(true);


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


                    if(almacen.getCola().isEmpty()){

                        System.out.println("El juego ha terminado");
                        this.addPointsE();
                        return players;

                    }

                    if (tablero.verify() && tablero.cantFichas() > tab.cantFichas() && (!firstTurn || tablero.sumTablero()-tab.sumTablero() >= 30)) {


                        if (players.get(turn).Gano()) {

                            System.out.println("El jugador " + players.get(turn).getName() + " ha ganado");
                            players.get(turn).setWinner();
                            this.addPointsW();
                            return players;
                        }


                        this.nextTurn();
                        if(firstTurn && turn == 0) return this.Turn(false);
                        return this.Turn(firstTurn);



                    } else {


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














//    public void play(){
//
//        while(true)
//        {
//
//            System.out.println("Tablero:");
//            tablero.imprimirTablero();
//            System.out.println("Fichas en la mano de " + players.get(turn).getName() + ":");
//            System.out.println(players.get(turn));
//            System.out.println(players.get(turn).getName() + " desea insertar, swapear, o comer una ficha, o exit? (i/s/c/e): ");
//            Scanner sc = new Scanner(System.in);
//            ins = sc.nextLine();
//            if (ins.equals("e")) return;
//
//
//
//            else if (ins.equals("i")) {
//
//                System.out.println("Ingrese el número de ficha de su inventario: ");
//                x = sc.nextInt();
//                System.out.println("Ingrese la coordenada de la casilla: ");
//                y = sc.nextInt();
//                System.out.println("Ingrese en que indice desea ingresar la ficha: ");
//                z = sc.nextInt();
//                if(tablero.insertarFicha(players.get(turn).getFicha(x), y, z)){
//
//                    players.get(turn).eliminarFicha(x);
//
//                }
//
//
//            } else if (ins.equals("s")) {
//
//
//                System.out.println("Ingrese la coordenada de la casilla de la ficha 1 que desea cambiar: ");
//                x = sc.nextInt();
//                System.out.println("Ingrese el indice de la ficha 1 que desea cambiar: ");
//                y = sc.nextInt();
//                System.out.println("Ingrese la coordenada de la casilla de la ficha 2 que desea cambiar: ");
//                z = sc.nextInt();
//                System.out.println("Ingrese el indice de la ficha 2 que desea cambiar: ");
//                a = sc.nextInt();
//                tablero.cambiarFicha(x, z, y, a);
//
//            }else if(ins.equals("c")) players.get(turn).comer(almacen);
//
//
//            else {
//
//                System.out.println("Jugada inválida");
//                continue;
//
//            }
//
//        }
//
//    }


    //falta el primer turno, suma de 30


    public void addPointsW(){

        int j = 0;
        int sum = 0;
        for(int i = 0; i<players.size(); i++){

            if(players.get(i).getWinner()) j = i;
            sum += players.get(turn).sumPoints();
            players.get(turn).addPoints(-players.get(turn).sumPoints());

        }players.get(j).addPoints(sum);

    }


    public void addPointsE(){

        int min = 1<<30, index = 0;
        for(int i = 0; i<players.size(); i++){

            if(players.get(i).sumPoints()<min) {
                min = players.get(i).sumPoints();
                index = i;
            }

        }

        System.out.println("El jugador " + players.get(index).getName() + " ha ganado");
        for(int i = 0; i<players.size(); i++){

            if(i!=index) players.get(i).addPoints(-players.get(i).sumPoints());

        }

    }



}

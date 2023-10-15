import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends JFrame implements ActionListener {

    private Tablero tablero;

    private List<Player> players = new ArrayList<>();

    private Almacen almacen;

    private int turn;

    private boolean firstTurn;

    private int size;

    private Player jug;

    private Almacen alm;

    private Tablero tab;

    private JButton comer;

    private JButton devolver;

    private JLabel ronda;

    private JButton jugada;

    private Player safe;

    private JButton reiniciarTablero;

    private Ficha buffer;

    private int[] coords = {-1, -1};

    private int pos;

    private Ficha[] stat = new Ficha[25];





    public Game(int n){

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1400, 850);
        size = n;
        almacen = new Almacen();
        tablero = new Tablero();
        players = new ArrayList<>();
        for(int i = 0; i<n; i++) players.add(new Player(almacen));
        turn = 0;
        tab = new Tablero();
        alm = new Almacen(almacen);
        jug = new Player(players.get(turn));
        firstTurn = true;
        for(int i = 0; i < 25; i ++){
            stat[i] = new Ficha();
        }
        copyDeck(players.get(turn).getStat());

    }

    public void copyDeck(Ficha[] deck){
        for(int i = 0; i < 25; i ++){
            stat[i] = deck[i];
            this.addFicha(stat[i], i * 50, 750, 50, 70);
        }
    }















    public void nextTurn(boolean comio){

        turn++;
        turn%=size;
        if(turn == 0 && !comio){
            firstTurn = false;
        }
        jug.copy(players.get(turn));
        tab.copy(tablero);
        alm.copy(almacen);
        refDeck();
        copyDeck(players.get(turn).makeDeck());
        ronda.setText("Es turno de " + players.get(turn).getName());

    }















    public void removeTablero(){
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 20; j++){
                tablero.getTablero()[i].getCasilla()[j].setBounds(1800, 0, 0, 0);
                tablero.getTablero()[i].getCasilla()[j].removeActionListener(this);
                this.remove(tablero.getTablero()[i].getCasilla()[j]);
            }
        }
    }

    public void addTablero(Tablero tablero){
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 20; j++){
                tablero.getTablero()[i].getCasilla()[j].setBounds(j * 70, (i * 90) + 60, 60, 80);
                tablero.getTablero()[i].getCasilla()[j].addActionListener(this);
                this.add(tablero.getTablero()[i].getCasilla()[j]);
            }
        }
    }


    public void refTablero(){

        removeTablero();
        tablero.copy(tab);
        addTablero(tablero);

    }





    private void refDeck(){

        removeBar();

    }

    public void removeBar(){
        for(int i = 0; i < 25; i ++){
            removeFicha(stat[i]);
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
                Ficha current = tablero.getTablero()[i].getCasilla()[j];
                if (e.getSource() == current){
                    if(buffer != null && current.getNumero() == 0){
                        tablero.getTablero()[i].getCasilla()[j].copy(buffer);
                        buffer = null;
                        this.remove(devolver);
                    }
                    else if(buffer == null){
                        buffer = new Ficha(current);
                        coords[0] = i;
                        coords[1] = j;
                        current.clear();
                    }
                    else if(buffer != null && coords[0] != -1){
                        tablero.getTablero()[coords[0]].getCasilla()[coords[1]].copy(current);
                        current.copy(buffer);
                        buffer = null;
                        coords[0] = -1;
                    }
                    System.out.println(current);

                }
            }
        }

        for(int i = 0; i < 25; i ++){
            if(e.getSource() == stat[i] && buffer == null){
                if(stat[i].getJoker()){
                    System.out.println("es Joker");
                }
                System.out.println(i);
                buffer = new Ficha(stat[i]);
                pos = i;
                if(players.get(turn).getDeck().size() >= i){
                    players.get(turn).eliminarFicha(i);
                    copyDeck(players.get(turn).makeDeck());
                    //refDeck();
                }


            }
        }
        if(e.getSource() == comer){

            if(almacen.getCola().isEmpty()){

                addPointsE();
                //setVisible(false);

            }
            players.get(turn).setDeck(jug.getDeck());
            players.get(turn).comer(almacen);
            refTablero();
            nextTurn(true);

        }

        if(e.getSource() == devolver){
            Ficha[] pre = players.get(turn).getStat();
            players.get(turn).addFicha(pos, buffer);
            buffer = null;
            pos = -1;
            Ficha[] stat = players.get(turn).getStat();
            refDeck();
            this.remove(devolver);
            devolver.setVisible(false);
        }


        if(e.getSource() == jugada){
            if(tablero.verify(firstTurn, tab)){

                if(players.get(turn).getDeck().isEmpty()){

                    //aqui falta salirse de la funcion
                    addPointsW();
                    //setVisible(false);
                }

                else if(almacen.getCola().isEmpty()){

                    //aqui falta salirse de la funcion
                    addPointsE();
                    //setVisible(false);

                }else{

                    nextTurn(false);
                }
            }


        }
        if(e.getSource() == reiniciarTablero){
            buffer = null;
            players.get(turn).setDeck(jug.getDeck());
            refDeck();
            copyDeck(players.get(turn).makeDeck());
            refTablero();
        }
    }





    public void Turn(boolean firstTurn) {

        tab.copy(tablero);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 20; j++) {
                tablero.getTablero()[i].getCasilla()[j].setBounds(j * 70, (i * 90) + 60, 60, 80);
                this.add(tablero.getTablero()[i].getCasilla()[j]);
                tablero.getTablero()[i].getCasilla()[j].addActionListener(this);
            }
        }

        comer = new JButton();
        comer.setBounds(1270, 730, 100, 100);
        comer.setText("comer");
        comer.addActionListener(this);
        this.add(comer);

        devolver = new JButton();
        devolver.setBounds(500, 700, 200, 25);
        devolver.setText("Devolver ficha");
        devolver.addActionListener(this);

        jugada = new JButton();
        jugada.setBounds(800, 700, 200, 25);
        jugada.setText("Hacer jugada");
        jugada.addActionListener(this);
        this.add(jugada);

        ronda = new JLabel();
        ronda.setBounds(600, 30, 200, 30);
        ronda.setText("Es turno de " + players.get(turn).getName());
        this.add(ronda);

        reiniciarTablero = new JButton();
        reiniciarTablero.setBounds(100, 700, 200, 25);
        reiniciarTablero.setText("Reinciar Tablero");
        reiniciarTablero.addActionListener(this);
        this.add(reiniciarTablero);

        for (int i = 0; i < 25; i++) {

            if (stat[i] != null) {

                addFicha(stat[i], i * 50, 750, 50, 70);

            }
        }
        this.setVisible(true);

    }


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


    public List<Player> getPlayers(){
        return players;
    }






}
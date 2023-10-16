import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game extends JFrame implements ActionListener {

    private boolean isOpen;
    private Archive datos;
    private Tablero tablero;
    private List<Player> players = new ArrayList<>();
    private Almacen almacen = new Almacen();
    private int turn;
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
    private JLabel cont = new JLabel();
    private Ficha[] stat = new Ficha[50];

    private int alSize = almacen.getCola().size();





    public Game(int n, Archive datos){

        this.datos = datos;
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1400, 900);
        size = n;
        almacen = new Almacen();
        tablero = new Tablero();
        players = new ArrayList<>();
        for(int i = 0; i<n; i++) players.add(new Player(almacen));
        turn = 0;
        tab = new Tablero();
        alm = new Almacen(almacen);
        jug = new Player(players.get(turn));
        isOpen = true;
        for(int i = 0; i < 50; i ++){
            stat[i] = new Ficha();
        }
        copyDeck(players.get(turn).getStat());

    }

    public void copyDeck(Ficha[] deck){
        for(int i = 0; i < 25; i ++){
            stat[i] = deck[i];
            stat[i].setBackground(Color.pink);
            this.addFicha(stat[i], i * 50 + 25, 700, 50, 65);
        }
        for(int i = 25; i < 50; i ++){
            stat[i] = deck[i];
            stat[i].setBackground(Color.pink);
            this.addFicha(stat[i], (i - 25) * 50 + 25, 765, 50, 65);
        }
    }















    public void nextTurn(boolean comio){

        if(!comio) players.get(turn).setFirstTurn();

        turn++;
        turn%=size;
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
        for(int i = 0; i < 50; i ++){
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

        for(int i = 0; i < 50; i ++){
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

            //Esto ahora lo tengo que quitar
            addPointsE();
            datos.update(players);
            isOpen = false;
            dispose();

            if(almacen.getCola().isEmpty()){

                addPointsE();
                datos.update(players);
                isOpen = false;
                dispose();
                //setVisible(false);

            }
            players.get(turn).setDeck(jug.getDeck());
            players.get(turn).comer(almacen);
            alSize -= 1;
            cont.setText("" + alSize);
            refTablero();
            nextTurn(true);

        }




        if(e.getSource() == jugada){
            if(tablero.verify(players.get(turn).getFirstTurn(), tab)){

                if(players.get(turn).Gano()){

                    //aqui falta salirse de la funcion
                    players.get(turn).setWinner();
                    addPointsW();
                    datos.update(players);
                    isOpen = false;
                    dispose();

                }
                else if(almacen.getCola().isEmpty()){

                    //aqui falta salirse de la funcion
                    addPointsE();
                    datos.update(players);
                    isOpen = false;
                    dispose();

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





    public void Turn() {

        tab.copy(tablero);
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 20; j++) {
                tablero.getTablero()[i].getCasilla()[j].setBounds(j * 70, (i * 90) + 60, 60, 80);
                this.add(tablero.getTablero()[i].getCasilla()[j]);
                tablero.getTablero()[i].getCasilla()[j].addActionListener(this);
            }
        }

        alSize = almacen.getCola().size();

        comer = new JButton();
        comer.setBounds(1300, 725, 75, 75);
        comer.setText("comer");
        comer.addActionListener(this);
        this.add(comer);

        /*devolver = new JButton();
        devolver.setBounds(500, 700, 200, 50);
        devolver.setText("Devolver ficha");
        devolver.addActionListener(this);*/

        jugada = new JButton();
        jugada.setBounds(900, 25, 200, 30);
        jugada.setText("Hacer jugada");
        jugada.addActionListener(this);
        this.add(jugada);

        ronda = new JLabel();
        ronda.setBounds(678, 25, 200, 30);
        ronda.setText("Es turno de " + players.get(turn).getName());
        this.add(ronda);

        cont.setBounds(1330, 695, 75, 25);
        cont.setText("" + alSize);
        cont.setVisible(true);
        this.add(cont);

        JLabel Mazo = new JLabel();
        Mazo.setBounds(700, 677, 200, 30);
        Mazo.setText("Mazo: ");
        Mazo.setVisible(true);
        this.add(Mazo);


        reiniciarTablero = new JButton();
        reiniciarTablero.setBounds(370, 25, 200, 30);
        reiniciarTablero.setText("Reinciar Tablero");
        reiniciarTablero.addActionListener(this);
        this.add(reiniciarTablero);

        for (int i = 0; i < 25; i++) {

            if (stat[i] != null) {

                addFicha(stat[i], i * 50 + 25, 700, 50, 65);

            }
        }
        for(int i = 25; i < 50; i ++){
            if (stat[i] != null) {

                addFicha(stat[i], (i - 25) * 50 + 25, 765, 50, 65);

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



    public boolean getOpen(){
        return isOpen;
    }



}
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



    //este constructor se encarga de cargar todos los elementos que necesita el jugador para que el juego
    //sea posible de jugar, tambien se encarga se ajustar el tamaño de la ventana así como agregarle
    //logica al juego
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

    //esta funcion se encarga de copiar la baraja del jugador a quien le corresponda el turno a un
    //arreglo estatico que nos facilita desplegarlo en pantalla
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














    //la funcion nos ayuda a refrescar el tablero y movernos dentro de la lista de jugadores para
    //saber que jugador sigue jugando
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














    //esta funcion lo que logra es anular todas las fichas del tablero
    public void removeTablero(){
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 20; j++){
                tablero.getTablero()[i].getCasilla()[j].setBounds(1800, 0, 0, 0);
                tablero.getTablero()[i].getCasilla()[j].removeActionListener(this);
                this.remove(tablero.getTablero()[i].getCasilla()[j]);
            }
        }
    }
    //esta funcion nos ayuda a copiar el tablero mas actualizado antes de que el jugador
    //a cual el turno le pertenece haya hecho cambios
    public void addTablero(Tablero tablero){
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 20; j++){
                tablero.getTablero()[i].getCasilla()[j].setBounds(j * 70, (i * 90) + 60, 60, 80);
                tablero.getTablero()[i].getCasilla()[j].addActionListener(this);
                this.add(tablero.getTablero()[i].getCasilla()[j]);
            }
        }
    }


    //esto combina la funcion borrar tablero y agregar tablero para poder refrescar el tablero
    //cuando el boton de refrescar es presionado
    public void refTablero(){

        removeTablero();
        tablero.copy(tab);
        addTablero(tablero);

    }




    //refresca el tablero que esta desplegado en la pantalla del usuario
    private void refDeck(){

        removeBar();

    }

    //esta funcion logra que la baraja que se desplega en ese momento se anule
    public void removeBar(){
        for(int i = 0; i < 50; i ++){
            removeFicha(stat[i]);
        }
    }


    //esta funcion se encarga de hacer que la ficha pare de ser visible para el usuario
    public void removeFicha(Ficha ficha){
        ficha.setBounds(1500, 0, 0, 0);
        ficha.removeActionListener(this);
        this.remove(ficha);
    }

    //esta funcion se encarga de que la ficha sea visible para el usuario
    public void addFicha(Ficha ficha, int x, int y, int width, int height){


        ficha.setBounds(x, y, width, height);
        this.add(ficha);
        ficha.addActionListener(this);


    }












    //la siguiente funcion se encarga de confabular todas las funciones logicas de las clases
    //ya creadas y les implementa sus dichos metodos
    @Override
    public void actionPerformed(ActionEvent e) {
        //estos dos for's se utilizan para iterar sobre cada boton del tablero y revisar si son presionados
        for(int i = 0; i < 7; i ++){
            for(int j = 0; j < 20; j ++){
                Ficha current = tablero.getTablero()[i].getCasilla()[j];
                if (e.getSource() == current){//si el boton no tiene datos se le agregan los datos del buffer
                    if(buffer != null && current.getNumero() == 0){//buffer se utiliza para almacenar temporalmente datos
                        tablero.getTablero()[i].getCasilla()[j].copy(buffer);
                        buffer = null;//se vacia el buffer
                    }
                    else if(buffer == null){//si el buffer es nulo, entocnes almacena los datos que hay en la casilla
                        buffer = new Ficha(current);
                        coords[0] = i;
                        coords[1] = j;
                        current.clear();
                    }
                    else if(buffer != null && coords[0] != -1){//se intercambian los valores de las dos fichas que fueron presionadas
                        tablero.getTablero()[coords[0]].getCasilla()[coords[1]].copy(current);
                        current.copy(buffer);
                        buffer = null;
                        coords[0] = -1;
                    }

                }
            }
        }

        for(int i = 0; i < 50; i ++){//el for se utiliza para revisar todos los botones en baraja
            if(e.getSource() == stat[i] && buffer == null){
                //se cargan los datos de la i-esima ficha para luego copiarlos al tablero
                buffer = new Ficha(stat[i]);
                pos = i;
                if(players.get(turn).getDeck().size() >= i){
                    players.get(turn).eliminarFicha(i);
                    copyDeck(players.get(turn).makeDeck());
                }


            }
        }
        if(e.getSource() == comer){

            //si se presiona el boton de comer, el jugador quien le corresponda el turno va a comer
            //tambien luego de que es presionado, se cambia de turno
            if(almacen.getCola().isEmpty()){

                addPointsE();
                datos.update(players);
                isOpen = false;
                dispose();

            }
            players.get(turn).setDeck(jug.getDeck());
            players.get(turn).comer(almacen);
            alSize -= 1;
            cont.setText("" + alSize);
            refTablero();
            nextTurn(true);

        }




        if(e.getSource() == jugada){
            //al ser presionado el boton de jugada, el programa procede a verificar si el tablero es valido
            //si lo es, procede a cambiar de turno, y si no, no hace nada
            if(tablero.verify(players.get(turn).getFirstTurn(), tab)){

                if(players.get(turn).Gano()){

                    players.get(turn).setWinner();
                    addPointsW();
                    datos.update(players);
                    isOpen = false;
                    dispose();

                }
                else if(almacen.getCola().isEmpty()){

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
            //el tablero vuelve al estado en el que estaba antes de que el jugador haya hecho
            //modificaciones
            buffer = null;
            players.get(turn).setDeck(jug.getDeck());
            refDeck();
            copyDeck(players.get(turn).makeDeck());
            refTablero();
        }
    }




    //Esta funcion se encarga de asignarle a cada componente de la interfaz grafica su dicha logica
    //tambien se encarga de darle visibilidad a la pantalla principal
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
        //añade botones a la pantalla y les agrega un action listener para agregarles utilidad
        comer = new JButton();
        comer.setBounds(1300, 725, 75, 75);
        comer.setText("comer");
        comer.addActionListener(this);
        this.add(comer);


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

        //se desplegan todas las fichas de la baraja del jugador
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

    //esta funcion se encarga de darle los puntos ganados a cada jugador de la partida
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
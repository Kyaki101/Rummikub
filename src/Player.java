import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;



public class Player extends JFrame implements ActionListener {

    private boolean winner, firstTurn;
    private int points;
    private Baraja deck;
    private String name = "";
    private String texto = "";
    private Ficha[] stat = new Ficha[50];
    private JButton conf = new JButton();
    JTextField nom = new JTextField();



    public Player(){

        firstTurn = true;
        winner = false;
        points = 0;
        deck = new Baraja();
        name = "";
        for(int i = 0; i < 50; i++){
            stat[i] = new Ficha();
        }

    }

    public boolean getFirstTurn(){
        return firstTurn;
    }

    public void setFirstTurn(){
        firstTurn = false;
    }


    public Player(Almacen a) {

        firstTurn = true;
        JLabel logo = new JLabel();
        ImageIcon img = new ImageIcon("res/images/player.png");
        logo.setBounds(400, 20, 600, 600);
        logo.setIcon(img);
        logo.setVisible(true);
        this.add(logo);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1400, 850);
        nom.setText("Nombre de jugador");
        nom.setBounds(400, 700, 400, 50);
        this.add(nom);
        conf.addActionListener(this);
        conf.setText("Confirmar");
        conf.setBounds(820, 700, 100, 50);
        this.add(conf);
        this.setVisible(true);
        points = 0;
        while(name.equals("")){
            name = texto;
//            System.out.println(texto);
        }
        deck = new Baraja(a.getCola());
        for(int i = 0; i < 50; i++){
            stat[i] = new Ficha();
        }
        makeDeck();


    }



    public Player(Player a){
        firstTurn = a.getFirstTurn();
        points = a.getPoints();
        deck = new Baraja();
        name = a.getName();
        for(int i = 0; i<a.getDeck().size(); i++){
            deck.getBaraja().add(a.getFicha(i));
        }
        for(int i = 0; i < 50; i++){
            stat[i] = new Ficha();
        }
        makeDeck();

    }

    public void refPlayer(Player a){
        firstTurn = a.getFirstTurn();
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



    public void setDeck(List<Ficha> aux){

        deck.setBaraja(aux);

    }




    public Baraja getBaraja(){
        return deck;
    }


    public Ficha[] makeDeck(){

        for(int i = 0; i<50; i++){

            if(i < deck.getBaraja().size()) {

                stat[i].setJoker(deck.getBaraja().get(i).getJoker());
                stat[i].setColor(deck.getBaraja().get(i).getColor());
                stat[i].setNumero(deck.getBaraja().get(i).getNumero());
                stat[i].setForeground(stat[i].getColor());
                if (stat[i].getJoker()) stat[i].setText("☻");
                else stat[i].setText("" + stat[i].getNumero());

            }

            else {
                stat[i].setColor(Color.WHITE);
                stat[i].setNumero(0);
                stat[i].setForeground(stat[i].getColor());
                stat[i].setText("");
            }
        }return stat;

    }


    public List<Ficha> getDeck() {

        return deck.getBaraja();

    }




    public void copy(Player a){

        firstTurn = a.getFirstTurn();
        winner = a.getWinner();
        points = a.getPoints();
        deck.copy(a.getBaraja());
        name = a.getName();

    }





    public Ficha[] getStat(){

        return stat;

    }





    public void comer(Almacen a) {

        deck.Comer(a);
        makeDeck();
    }

    public boolean Gano() {

        //return deck.getSize() > 14;
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


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == conf){
            texto = nom.getText();
            this.dispose();
        }
    }
}

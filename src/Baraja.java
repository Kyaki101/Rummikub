import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Baraja {

    private List<Ficha> fichas = new ArrayList<>();

    private Ficha[] bar = new Ficha[50];











    public List<Ficha> getBaraja() {
        return fichas;
    }


    public Baraja(){

        fichas = new ArrayList<>();

    }

    public void set(int i, Ficha a){

        fichas.set(i, a);
    }


    public Ficha[] makeDeck(){

        for(int i = 0; i<25; i++) bar[i] = new Ficha();
        for(int i = 0; i<25; i++){

            if(i >= fichas.size()){
                bar[i].setColor(Color.WHITE);
                bar[i].setNumero(0);
                bar[i].setForeground(bar[i].getColor());
                bar[i].setText("");
            }
            else{

                bar[i].setColor(fichas.get(i).getColor());
                bar[i].setNumero(fichas.get(i).getNumero());
                bar[i].setForeground(bar[i].getColor());
                bar[i].setText("" + bar[i].getNumero());
            }

        }return bar;

    }






    public void add(Ficha ficha){
        fichas.add(ficha);
    }


    public int getSize(){

        return fichas.size();

    }


    public void setBaraja(List<Ficha> aux){

        fichas = new ArrayList<>(aux);

    }
    public Ficha get(int i){

        return fichas.get(i);

    }








    public void copy(Baraja newB){

        fichas = new ArrayList<>();
        for(int i = 0; i<newB.getSize(); i++) fichas.add(new Ficha(newB.get(i)));

    }




    public Baraja(List<Ficha> cola){
        for(int i = 0; i < 14; i++){
            fichas.add(cola.get(0));
            cola.remove(0);
        }
    }














    public void addFicha(int index, Ficha ficha){
        fichas.add(index, ficha);
        fichas.get(fichas.size() - 1).setText(""+fichas.get(fichas.size() - 1).getNumero());
    }

    public void Comer(Almacen a){

        if(a.getCola().isEmpty()) return;
        fichas.add(a.getCola().get(0));
        fichas.get(fichas.size() - 1).setText(""+fichas.get(fichas.size() - 1).getNumero());
        a.getCola().remove(0);
    }







}
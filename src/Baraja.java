import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Baraja {

    private List<Ficha> fichas = new ArrayList<>();

    private Ficha[] bar = new Ficha[50];











    public List<Ficha> getBaraja() {
        return fichas;
    }


    //se instancia una nueva baraja
    public Baraja(){

        fichas = new ArrayList<>();

    }

    public void set(int i, Ficha a){

        fichas.set(i, a);
    }


    //la siguiente función se encarga de traducir la lista de fichas a una arreglo estático
    //esto con la intención de facilitar el proceso de desplegar la baraja en pantalla
    public Ficha[] makeDeck(){

        for(int i = 0; i<25; i++) bar[i] = new Ficha();
        for(int i = 0; i<25; i++){

            if(i >= fichas.size()){//se ejectura si i entra a una casilla que no exista en la baraja
                bar[i].setColor(Color.WHITE);//se usa un color nulo
                bar[i].setNumero(0);//se usa el cero como numero por defecto
                bar[i].setForeground(bar[i].getColor());//copia color del texto
                bar[i].setText("");//vacia el texto
            }
            else{//se ejecuta si i es valido

                bar[i].setColor(fichas.get(i).getColor());
                bar[i].setNumero(fichas.get(i).getNumero());
                bar[i].setForeground(bar[i].getColor());
                bar[i].setText("" + bar[i].getNumero());
            }

        }return bar;

    }






    //se le arega una ficha a la baraja del jugador
    public void add(Ficha ficha){
        fichas.add(ficha);
    }


    public int getSize(){//devuelve tamaño de la ficha

        return fichas.size();

    }


    //Se copia una baraja ya existente y se le asigna al jugador
    public void setBaraja(List<Ficha> aux){

        fichas = new ArrayList<>(aux);

    }

    //se encuentra ficha en la i-esima ubicación
    public Ficha get(int i){

        return fichas.get(i);

    }







    //Se copia una baraja ya existente
    public void copy(Baraja newB){

        fichas = new ArrayList<>();
        for(int i = 0; i<newB.getSize(); i++) fichas.add(new Ficha(newB.get(i)));

    }



    //se cargan fichas a la baraja
    public Baraja(List<Ficha> cola){
        for(int i = 0; i < 14; i++){
            fichas.add(cola.get(0));
            cola.remove(0);
        }
    }













    //Se le agrega una nueva Ficha a la baraja
    public void addFicha(int index, Ficha ficha){
        fichas.add(index, ficha);
        fichas.get(fichas.size() - 1).setText(""+fichas.get(fichas.size() - 1).getNumero());
    }

    //se implementa la funcion addFicha para agregarle una nueva ficha a la baraja por medio de la funcion comer
    public void Comer(Almacen a){

        if(a.getCola().isEmpty()) return;
        fichas.add(a.getCola().get(0));
        fichas.get(fichas.size() - 1).setText(""+fichas.get(fichas.size() - 1).getNumero());
        a.getCola().remove(0);
    }







}
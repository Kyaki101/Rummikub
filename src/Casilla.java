import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
public class Casilla {

    private Ficha[] fila = new Ficha[20];


    //se instancia un arreglo con 20 Fichas
    public Casilla(int y){

        for(int i = 0; i<20; i++) {
            fila[i] = new Ficha();
            fila[i].setBounds(i * 70, y, 60, 80);
        }
    }


    //se copia una casilla ya creada
    public Casilla(Casilla c){

        for(int i = 0; i < 20; i++) fila[i] = new Ficha(c.getFicha(i));

    }













    public Ficha[] getCasilla(){
        return fila;
    }

    //se copian los datos de una ficha ya creada a un campo de la casilla
    public void setFicha(Ficha ficha, int i){
        fila[i] = ficha;
    }















    //se Hacen todas las verificaciones necesarias para asegurar que si se hace una serie
    //la casilla lo pueda detectar correctamente
    private boolean verifySerie(List<Ficha> serie){

        if(serie.size() < 3) return false;
        int i = 0;
        while(serie.get(i).getJoker()) i++;
        while(i<serie.size()-1){

            if(serie.get(i+1).getJoker()){
                serie.get(i+1).setNumero(serie.get(i).getNumero()+1);
                serie.get(i+1).setColor(serie.get(i).getColor());
            }
            if(serie.get(i).getColor() != serie.get(i+1).getColor() ||
                    serie.get(i).getNumero() != serie.get(i+1).getNumero()-1){
                return false;
            }i++;

        }return true;
    }

    //esta funcion busca si un elemento existe dentro de un grupo, esto para evitar que se hagan
    //jugadas con colores permitidos
    private boolean search(List<Color> vis, Color color){

        for(int i = 0; i<vis.size(); i++){

            if(vis.get(i) == color) return true;

        }return false;

    }


    //se hacen todas las verificaciones necesarias para asegurar que la jugada que contenga
    //un grupo sea valida
    private boolean verifyGroup(List<Ficha> group){

        if(group.size() < 3) return false;
        List<Color> vis = new ArrayList<>();
        int i = 0;
        while(group.get(i).getJoker()) i++;
        while(i<group.size()-1){

            if(group.get(i+1).getJoker()) group.get(i+1).setNumero(group.get(i).getNumero());
            if(group.get(i).getNumero() != group.get(i+1).getNumero() || search(vis, group.get(i).getColor())) return false;
            if(!group.get(i).getJoker()) vis.add(group.get(i).getColor());
            i++;

        }
        if(search(vis, group.get(group.size()-1).getColor())) return false;
        return true;

    }



















    //se utilizan la funciones verifyGroup y verifySerie en pareja para poder hacer revisiones rapidamente
    //dependiendo de la jugada que se esta haciendo
    public boolean verify(){

        List<Ficha> verifier = new ArrayList<>();
        int i = 0;
        while(i<20){

            if(fila[i].getNumero() != 0){//si la ficha no es nula

                while(fila[i].getNumero() != 0 && i<20){//empieza a revisar desde que la primera ficha
                    verifier.add(fila[i]);              //no es nula hasta que paren de se nulas o hasta que se
                    i++;                                //llegue a 20

                }
                if(!this.verifySerie(verifier) && !this.verifyGroup(verifier)){

                    return false;
                }
                verifier = new ArrayList<>();
            }
            i++;

        }return true;

    }









    //se agrega una ficha al tablero si y solo si la ficha no tiene datos
    public boolean addFicha(Ficha ficha, int i){

        if(fila[i].getNumero() != 0)return false;
        fila[i] = ficha;
        return true;

    }


    //se le quitan los datos a la ficha en el i-esimo espacio
    public void removeFicha(int i){

        fila[i] = new Ficha();

    }









    public String toString(){
        return fila.toString();
    }

    public Ficha getFicha(int i){
        return fila[i];
    }







    public void copy(Casilla c){

        fila = new Ficha[20];
        for(int i = 0; i < 20; i++) fila[i] = new Ficha(c.getFicha(i));


    }




    //se calcula la suma de las fichas en dicha casilla mediante una iteracion sobre cada elemento de ella
    public int sumCasilla(){

        int sum = 0;
        for(int i = 0; i<20; i++){

            if(fila[i].getJoker()) return -(1<<30);
            sum += fila[i].getNumero();

        }return sum;

    }










    public int cantFichas(){

        int sum = 0;
        for(int i = 0; i<20; i++){

            //aqui cambie el or
            if(fila[i].getNumero() != 0 || fila[i].getJoker()) sum++;

        }return sum;
    }
}

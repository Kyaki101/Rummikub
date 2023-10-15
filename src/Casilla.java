import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
public class Casilla {

    private Ficha[] fila = new Ficha[20];

    public Casilla(int y){

        for(int i = 0; i<20; i++) {
            fila[i] = new Ficha();
            fila[i].setBounds(i * 70, y, 60, 80);
        }
    }


    public Casilla(Casilla c){

        for(int i = 0; i < 20; i++) fila[i] = new Ficha(c.getFicha(i));

    }













    public Ficha[] getCasilla(){
        return fila;
    }

    public void setFicha(Ficha ficha, int i){
        fila[i] = ficha;
    }















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

    private boolean verifyGroup(List<Ficha> group){

        if(group.size() < 3) return false;
        int i = 0;
        while(group.get(i).getJoker()) i++;
        while(i<group.size()-1){

            if(group.get(i+1).getJoker()) group.get(i+1).setNumero(group.get(i).getNumero());
            if(group.get(i).getNumero() != group.get(i+1).getNumero()) return false;
            i++;

        }return true;

    }




















    //esto hay que arreglarlo
    public boolean verify(){

        List<Ficha> verifier = new ArrayList<>();
        int i = 0;
        while(i<20){

            if(fila[i].getNumero() != 0){

                while(fila[i].getNumero() != 0 && i<20){
                    verifier.add(fila[i]);
                    i++;

                }
                if(!this.verifySerie(verifier) && !this.verifyGroup(verifier)){

                    return false;
                }
                verifier = new ArrayList<>();
            }
            i++;

        }return true;

    }










    public boolean addFicha(Ficha ficha, int i){

        if(fila[i].getNumero() != 0)return false;

        fila[i] = ficha;
        return true;

    }



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





    public int sumCasilla(){

        int sum = 0;
        for(int i = 0; i<20; i++){

            if(fila[i].getJoker()) return -(1<<30);
            sum += fila[i].getNumero();

        }return sum;

    }





    public void imprimirCasilla() {


        for (int i = 0; i < 20; i++) {

            if (fila[i].getNumero() != 0) System.out.print(fila[i].getNumero() + " ");
            else System.out.print(" # ");
        }
        System.out.println();

    }




    public int cantFichas(){

        int sum = 0;
        for(int i = 0; i<20; i++){

            if(fila[i].getNumero() != 0) sum++;

        }return sum;
    }
}

import java.util.ArrayList;
import java.util.List;
public class Casilla {

    private List<Ficha> GroupNSerie = new ArrayList<>();


    public List<Ficha> getCasilla(int i){
        return GroupNSerie;
    }

    public void setFicha(Ficha ficha, int i){
        GroupNSerie.set(i, ficha);
    }


    private boolean verifyGroup(){

        int i = 0;
        while(GroupNSerie.get(i).getJoker()) i++;
        while(i<GroupNSerie.size()-1){

            if(GroupNSerie.get(i+1).getJoker()) GroupNSerie.get(i+1).setNumero(GroupNSerie.get(i).getNumero());
            if(GroupNSerie.get(i).getNumero() != GroupNSerie.get(i+1).getNumero()) return false;
            i++;

        }return true;
    }


    private boolean verifySerie(){

        int i = 0;
        while(GroupNSerie.get(i).getJoker()) i++;
        while(i<GroupNSerie.size()-1){

            if(GroupNSerie.get(i+1).getJoker()){
                GroupNSerie.get(i+1).setNumero(GroupNSerie.get(i).getNumero()+1);
                GroupNSerie.get(i+1).setColor(GroupNSerie.get(i).getColor());
            }
            if(GroupNSerie.get(i).getColor() != GroupNSerie.get(i+1).getColor() ||
                    GroupNSerie.get(i).getNumero() != GroupNSerie.get(i+1).getNumero()-1){
                return false;
            }
            i++;

        }return true;
    }






    public boolean verify() {

        if (GroupNSerie.size() == 0) return true;

        if (GroupNSerie.size() < 3) return false;

        for(int i = 0; i<3; i++) if(GroupNSerie.get(i).getJoker())  return verifySerie() || verifyGroup();

        if (GroupNSerie.get(0).getColor() != GroupNSerie.get(1).getColor()) return verifyGroup();

        return verifySerie();

    }










    public void addFicha(Ficha ficha, int i){
        GroupNSerie.add(i, ficha);
    }

    public void addFicha(Ficha ficha){
        GroupNSerie.add(ficha);
    }

    public void removeFicha(int i){
        GroupNSerie.remove(i);
    }
    public void removeFicha(){
        GroupNSerie.remove(GroupNSerie.size()-1);
    }





    public String toString(){
        return GroupNSerie.toString();
    }

    public Ficha getFicha(int i){
        return GroupNSerie.get(i);
    }



}

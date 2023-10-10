import java.util.ArrayList;
import java.util.List;

public class Baraja {

    private List<Ficha> fichas = new ArrayList<>();

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public Baraja(){

        fichas = new ArrayList<>();

    }



    public void add(Ficha ficha){
        fichas.add(ficha);
    }

    public Baraja(List<Ficha> cola){
        for(int i = 0; i < 14; i++){
            fichas.add(cola.get(0));
            cola.remove(0);
        }
    }

    public void Comer(Almacen a){
        if(a.getCola().isEmpty()) {
            System.out.println("No quedan cartas en el almacen");
            return;
        }
        fichas.add(a.getCola().get(0));
        a.getCola().remove(0);
    }


    public String toString(){
        String s = "";
        for(int i = 0; i < fichas.size(); i++){
            s += fichas.get(i).toString();
        }
        return s;
    }
}

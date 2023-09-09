import java.util.List;
import java.util.ArrayList;
public class Player {


    
    private int cant;
    private List<Ficha> fichas;




    public int getCant() {
        return cant;
    }

    public void setCant(int cant) {
        this.cant = cant;
    }

    public List<Ficha> getFichas() {
        return fichas;
    }

    public void setFichas(List<Ficha> fichas) {
        this.fichas = fichas;
    }

    public void removeFichas(int i){
        this.fichas.remove(i);
        this.cant --;
    }

    public void appendFichas(Ficha token){
        fichas.add(token);
        this.cant ++;
    }



    Player(List<Ficha> f){
        
        this.fichas = new ArrayList<>();
        for(int i = 0; i < 14; i ++){
            fichas.add(f.get(i));
            f.remove(i);
        }

    }
}

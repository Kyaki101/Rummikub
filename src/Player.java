import java.util.List;
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

    Player(){
        this.cant = 0;
    }
}

import java.awt.Color;
import java.util.*;

public class Almacen {

    private List<Ficha> cola = new ArrayList<>();

    private Color colors[] = {Color.BLACK, Color.YELLOW, Color.BLUE, Color.RED};

    public Almacen(){
        for(int i = 0; i < 52; i++) {

            cola.add(new Ficha(i % 13 + 1, colors[i / 13]));
            cola.add(new Ficha(i % 13 + 1, colors[i / 13]));
        }
        cola.add(new Ficha(true));
        cola.add(new Ficha(true));
        barajar();
    }


    public Almacen(Almacen a){

        for(int i = 0; i < a.getCola().size(); i++){
            cola.add(new Ficha(a.getCola().get(i)));
        }

    }









    public void copy(Almacen a){

        for(int i = 0; i < a.getCola().size(); i++){
            cola.add(a.getCola().get(i));
        }

    }


    public List<Ficha> getCola(){
        return cola;
    }

    public void barajar(){
        Collections.shuffle(cola);
    }


    public int size(){
        return cola.size();
    }





}

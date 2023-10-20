import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Archive {


    private HashMap<String, Integer> data;


    //el siguiente constructor se encarga de crear un nuevo hash map para almacenar datos de jugadores
    public Archive(){

        data = new HashMap<>();

    }


    //La siguiente funcioón se encarga de acualizar datos de jugadores ya creados
   private void update(String name, int points){

       Integer aux = data.get(name);
       if(aux == null) data.put(name, points);
       else data.put(name, aux+points);

   }


    //Esta función se encarga se traducir una lista de jugadores a un mapa hash
   public void update(List<Player> players){

         for(int i = 0; i<players.size(); i++){
              update(players.get(i).getName(), players.get(i).getPoints());
         }

   }

   public HashMap<String, Integer> getData(){
        return data;
   }


    //La siguiente función se encarga de calcular quien es el jugador con el puntaje mas alto
    //y nombrarlo el ganador
   public String getWinner(){

       String winner = null;
       int maxPoints = Integer.MIN_VALUE;

       for (HashMap.Entry<String, Integer> entry : data.entrySet()) {
           String key = entry.getKey();//se inserta nombre del jugador
           Integer value = entry.getValue();//se le insertan y conectan los puntos a cada jugador
            //se encuentra el jugador con la mayor cantidad de puntos
           if (value > maxPoints) {
               maxPoints = value;
               winner = key;
           }
       }
       return winner;

   }





}

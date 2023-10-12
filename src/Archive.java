import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class Archive {


    private HashMap<String, Integer> data;



    public Archive(){

        data = new HashMap<>();

    }






   private void update(String name, int points){

       Integer aux = data.get(name);
       if(aux == null) data.put(name, points);
       else data.put(name, aux+points);
   }



   public void update(List<Player> players){

         for(int i = 0; i<players.size(); i++){
              update(players.get(i).getName(), players.get(i).getPoints());
         }

   }


   public HashMap<String, Integer> getData(){
       return data;
   }







}

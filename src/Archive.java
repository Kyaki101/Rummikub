import java.util.ArrayList;
import java.util.List;

public class Archive {


    private List<Player> data = new ArrayList<>();

    public Archive(){
        data = new ArrayList<>();
    }

    public void add(Player p){
        data.add(p);
    }

    public List<Player> getData(){
        return data;
    }


    public void addPoints(int i, int points){
        data.get(i).addPoints(points);
    }


    public void update(List<Player> players){

        for(int i = 0; i < players.size(); i++){
            data.get(i).setPoints(players.get(i).getPoints());
        }

    }







}

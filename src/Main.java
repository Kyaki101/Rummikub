import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class Main{
    public static void main(String args[]){

        List<Ficha> queue = new ArrayList<>();

        for(int i = 0; i < 13; i ++){
            queue.add(new Ficha(i + 1, Color.BLACK));
        }
        for(int i = 0; i < 13; i ++){
            queue.add(new Ficha(i + 1, Color.RED));
        }
        for(int i = 0; i < 13; i ++){
            queue.add(new Ficha(i + 1, Color.ORANGE));
        }
        for(int i = 0; i < 13; i ++){
            queue.add(new Ficha(i + 1, Color.BLUE));
        }

        queue.add(new Ficha(true));
        queue.add(new Ficha(true));
        Collections.shuffle(queue);






        Player luis = new Player(queue);
         //Esto inicializa a luis con sus 14 cartas y ademas modifica queue, por lo que ahora queue tiene 40 elemento -> 54 - 14
        Player Melvin = new Player(queue);

        


      
        



    }
}
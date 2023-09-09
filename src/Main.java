import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.Collections;
import java.util.Arrays;

public class Main{
    public static void main(String args[]){
        Ficha array[54];

        Player luis = new Player();
        Player Melvin = new Player();

        for(int i = 0; i < 13; i ++){
            array[i] = new Ficha(i + 1, Color.BLACK);
        }
        for(int i = 13; i < 26; i ++){
            array[i] = new Ficha(i + 1, Color.RED);
        }
        for(int i = 26; i < 39; i ++){
            array[i] = new Ficha(i + 1, Color.ORANGE);
        }
        for(int i = 39; i < 52; i ++){
            array[i] = new Ficha(i + 1, Color.BLUE);
        }
        array[52] = new Ficha(true);
        array[53] = new Ficha(true);

        List<Ficha> queue = Arrays.asList(array);

        Collections.shuffle(queue);


        for(int i = 0; i < 14; i ++){
            luis.appendFichas(queue.get(0));
            queue.remove(0);
        }

        for(int i = 0; i < 14; i ++){
            Melvin.appendFichas(queue.get(0));
            queue.remove(0);
        }



    }
}
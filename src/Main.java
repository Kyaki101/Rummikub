import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        int pCount = 0;

        //Archive datos = new Archive();
        //ResultsGUI r = new ResultsGUI(datos);
        MainMenu m = new MainMenu();

        while (pCount == 0){
            pCount = m.getFin();
            System.out.println(m.getFin());
        }


        Game g = new Game(pCount);
        g.Turn(true);






    }
}
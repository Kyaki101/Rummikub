import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.lang.Thread;
import java.lang.InterruptedException;


public class Main {

    private static boolean end = false;


    public static void main(String[] args) throws InterruptedException {
        while(!end) {
            int pCount = 0;
            Archive datos = new Archive();
            //ResultsGUI r = new ResultsGUI(datos);
            MainMenu m = new MainMenu();

            while (pCount == 0) {

                pCount = m.getFin();
                System.out.println(m.getFin());
            }


            Game g = new Game(pCount, datos);
            g.Turn();
            while (g.getOpen()) Thread.sleep(1000);

            ResultGUI res = new ResultGUI(datos);
            while(res.getOpen()) Thread.sleep(1000);

            end = res.getEnd();


            //System.out.println(datos.getData());
        }












    }
}
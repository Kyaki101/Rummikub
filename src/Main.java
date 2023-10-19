import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;
import java.lang.Thread;
import java.lang.InterruptedException;


public class Main {

    private static boolean end = false;


    public static void main(String[] args) throws InterruptedException {
        Archive datos = new Archive();
        while(!end) {
            int pCount = 0;
            MainMenu m = new MainMenu();

            while (pCount == 0) { //se encarga de parar el hilo hasta que dicha pantalla se cierre

                pCount = m.getFin();
                System.out.println(m.getFin());
            }

            Game g = new Game(pCount, datos);
            g.Turn();
            while (g.getOpen()) Thread.sleep(1000); // se encarga parar el hilo cada segundo por un segundo
                                                         // mientras se verifica que la pantalla se cierre

            ResultGUI res = new ResultGUI(datos);
            while(res.getOpen()) Thread.sleep(1000);

            end = res.getEnd();

        }

        //desplega la pantalla del ganador
        String winner = datos.getWinner();
        new endScreen(winner);












    }
}
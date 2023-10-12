import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import javax.swing.*;

public class Main {


    public static void main(String[] args) {

        Archive datos = new Archive();
        //Scanner reader = new Scanner(System.in);

        Game g = new Game(1);
        datos.update(g.Turn(true));



    }
}

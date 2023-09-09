import javax.swing.*;
import java.awt.*;

public class Tablero extends JFrame{


    private int filas;

    private int col;



    public int getFilas() {
        return filas;
    }

    public void setFilas(int filas) {
        this.filas = filas;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    Tablero(int filas, int col){
        setFilas(filas);
        setCol(col);
        this.setTitle("Rummikub");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setSize(getCol() * 100, getFilas() * 100);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("res/images/logo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        Ficha token = new Ficha(8, Color.YELLOW);
        Ficha sec = new Ficha(9, Color.YELLOW);
        System.out.println(token.getColor() == sec.getColor());
        this.add(token);
        this.setLayout(null);
    }

    int[][] tab = new int[getFilas()][getCol()];


}

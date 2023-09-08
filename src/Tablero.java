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
        this.setResizable(false);
        this.setSize(getCol() * 100, getFilas() * 100);
        this.setVisible(true);

        ImageIcon image = new ImageIcon("logo.png");
        this.setIconImage(image.getImage());
        this.getContentPane().setBackground(new Color(255, 255, 255));
        Ficha token = new Ficha(8, "yellow");
        this.add(token);
    }

    int[][] tab = new int[getFilas()][getCol()];


}

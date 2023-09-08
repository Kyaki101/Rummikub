public class Tablero {


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
    }

    int[][] tab = new int[getFilas()][getCol()];


}

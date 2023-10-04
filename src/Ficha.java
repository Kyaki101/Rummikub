import java.awt.*;

// Definición de la clase Ficha
public class Ficha {

    // Variables de instancia para almacenar el número y el color de la ficha
    private int numero;
    private Color color;

    private boolean isJoker;

    // Constructor de la clase Ficha que recibe un número y un color como parámetros
    public Ficha(int numero, Color color){
        // Inicializa las variables de instancia con los valores proporcionados
        this.isJoker = false;
        this.numero = numero;
        this.color = color;
    }

    public Ficha(boolean a){
        this.isJoker = a;
        this.numero = 0;
        this.color = Color.WHITE;
    }

    // Método getter para obtener el número de la ficha
    public int getNumero() {
        return numero;
    }

    // Método setter para establecer el número de la ficha
    public void setNumero(int numero) {
        this.numero = numero;
    }

    // Método getter para obtener el color de la ficha
    public Color getColor() {
        return color;
    }

    // Método setter para establecer el color de la ficha
    public void setColor(Color color) {
        this.color = color;
    }

    // Método toString() que devuelve una representación de cadena de la ficha
    public String toString(){
        // Devuelve el número y el color de la ficha como una cadena
        return "" + numero + " " + color + '\n';
    }
}

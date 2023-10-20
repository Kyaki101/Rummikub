import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.InterruptedException;


public class endScreen extends JFrame implements ActionListener {

    JButton terminate = new JButton();

    JLabel winner = new JLabel();

    JLabel fx = new JLabel();


    //al constructor se le agregan todos los botones y se le agregan los atributos necesarios
    //para que la ventana se pueda ver
    //tambien implemetna labels para poder desplegar imagenes al jugador que gana
    endScreen(String player) throws InterruptedException {
        this.setSize(1400, 900);//setea tamaño de pantalla
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//hace que el programa pare de ejecutar cuando se cierra
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 40);//se crea un fuente
        ImageIcon img = new ImageIcon("res/images/congrats.png");//carga imagen
        ImageIcon hmm = new ImageIcon("res/images/ricardo.png");//carga imagen
        fx.setIcon(img);//agrega imagen a label
        fx.setBounds(444, 400, 500, 500);//dicta donde se desplega el elemento en la pantalla
        fx.setVisible(true);//le da visibilidad al elemento
        this.add(fx);//agrega elemento a la pantalla
        winner.setFont(font);//le da una fuente diferente al texto del elemento
        winner.setForeground(Color.pink);
        winner.setText(player + " ha ganado!!!");
        winner.setBounds(0, 100, 1400, 300);
        winner.setVisible(true);
        winner.setHorizontalAlignment(0);//hace que el texto se centralice en el eje x
        this.add(winner);
        this.setVisible(true);
        while (true){//refresca la imagen de ganador
            fx.setIcon(hmm);
            Thread.sleep(100);
            fx.setIcon(img);
            Thread.sleep(1000);

        }
    }
}

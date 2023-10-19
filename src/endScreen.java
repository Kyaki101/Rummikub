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
        this.setSize(1400, 900);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(null);
        Font font = new Font("Arial", Font.BOLD, 40);
        ImageIcon img = new ImageIcon("res/images/congrats.png");
        ImageIcon hmm = new ImageIcon("res/images/ricardo.png");
        fx.setIcon(img);
        fx.setBounds(444, 400, 500, 500);
        fx.setVisible(true);
        this.add(fx);
        winner.setFont(font);
        winner.setForeground(Color.pink);
        winner.setText(player + " ha ganado!!!");
        winner.setBounds(0, 100, 1400, 300);
        winner.setVisible(true);
        winner.setHorizontalAlignment(0);
        this.add(winner);
        this.setVisible(true);
        while (true){
            fx.setIcon(hmm);
            Thread.sleep(100);
            fx.setIcon(img);
            Thread.sleep(1000);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

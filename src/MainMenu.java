import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {

    // el constructor se encarga de desplegar todos los elementos
    // que se instancian para crear una inferfaz de principio de juego
    MainMenu() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1400, 850);
        playerCount.setBounds(400, 700, 400, 50);
        playerCount.setText("Escriba la cantidad de jugadores que desea añadir Maximo (4) ");
        this.add(playerCount);
        validate.setText("Continuar");
        validate.setBounds(820, 700, 100, 50);
        validate.addActionListener(this);
        this.add(validate);
        logo.setIcon(image);
        logo.setBounds(200, 100, 1000, 229);
        this.add(logo);
        this.setVisible(true);


    }

    private JTextField playerCount = new JTextField();
    private JButton validate = new JButton();

    ImageIcon image = new ImageIcon("res/images/copyright.png");

    private JLabel logo =  new JLabel();

    private String pre;

    private int fin;

    public int getFin(){
        return fin;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == validate){
            String texto = playerCount.getText();
            //se hacen verificaciones para asegurar que el texto insertado sea valido
            if (texto == ""){
                JOptionPane.showMessageDialog(null, "No se ha escrito nada");
            }
            if(texto.equals("1") || texto.equals("2") || texto.equals("3") || texto.equals("4")){
                fin = Integer.parseInt(texto);
                this.dispose();
            }
            else{
                JOptionPane.showMessageDialog(null, "El numero no es valido");
            }
        }
    }
}

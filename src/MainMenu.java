import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu extends JFrame implements ActionListener {
    MainMenu() {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1400, 850);
        playerCount.setBounds(600, 700, 200, 50);
        playerCount.setText("Escriba la cantidad de jugadores que desea añadir Maximo (4) ");
        this.add(playerCount);
        validate.setText("Continuar");
        validate.setBounds(820, 700, 50, 50);
        validate.addActionListener(this);
        this.add(validate);


    }

    private JTextField playerCount = new JTextField();
    private JButton validate = new JButton();

    private String pre;

    private int fin;

    public int getFin(){
        return fin;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == validate){
            String texto = playerCount.getText();
            if (texto == ""){
                JOptionPane.showMessageDialog(null, "No se ha escrito nada");
            }
            if(texto != "1" && texto !="2" && texto != "3" && texto != "4"){
                JOptionPane.showMessageDialog(null, "El numero no es valido");
            }
            else{
                fin = Integer.parseInt(texto);
                this.dispose();
            }
        }
    }
}

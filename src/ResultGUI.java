import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class ResultGUI extends JFrame implements ActionListener{
    private JLabel display_player = new JLabel();
    private JLabel display_points = new JLabel();

    private JButton parar = new JButton();

    private JButton continuar = new JButton();

    private boolean end;

    private boolean open = true;

    public boolean getEnd(){
        return end;
    }

    public boolean getOpen(){
        return open;
    }

    ResultGUI(Archive archive) throws InterruptedException {
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);//se agrega funcionalidad de cerrar programa al cerrar pantalla
        this.setResizable(false);//se hace que el tamaño de la pantalla sea inmutable
        this.setSize(1400, 900);//se setea tamaño de la pantalla
        Font font = new Font("Roboto", Font.BOLD, 100);//se crea fuente
        display_points.setBounds(0, 400, 1400, 300);//se ajusta posicionamiento de elemento en pantalla
        display_points.setHorizontalAlignment(0);//se centraliza texto sobre el eje x
        display_player.setBounds(0, 100, 1400, 300);
        display_player.setHorizontalAlignment(0);
        display_points.setFont(font);
        display_player.setFont(font);
        display_player.setVisible(true);//se agrega elemento a la pantalla
        display_points.setVisible(true);
        parar.setText("Parar de jugar");//se le agrega texto al elemento
        parar.setBounds(100, 450, 100, 100);
        parar.addActionListener(this);
        this.add(parar);
        continuar.setText("Jugar nueva ronda");
        continuar.setBounds(1200, 450, 100, 100);
        continuar.addActionListener(this);
        this.add(continuar);
        this.add(display_points);
        this.add(display_player);
        HashMap<String, Integer> data = archive.getData();//se carga mapa hash de resultados para desplegarlos
        this.setVisible(true);

        while(open) {
            //se rotan los puntajes de los jugadores por cada elemento en el mapa hash
            for (HashMap.Entry<String, Integer> entry : data.entrySet()) {
                String key = entry.getKey();
                Integer value = entry.getValue();
                display_player.setText(key);
                display_points.setText("" + value);
                Thread.sleep(1000);//se utiliza para que el hilo descanse por un segundo


            }
        }
    }


    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == continuar){
            //se crea una nueva partida
            end = false;
            open = false;
            dispose();
        }
        else if (e.getSource() == parar) {
            // se termina el juego y se desplega la pantalla del ganador
            end = true;
            open = false;
            dispose();
        }
    }

}

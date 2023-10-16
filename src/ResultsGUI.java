import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ResultsGUI extends JFrame implements ActionListener {

    ResultsGUI(Archive datos){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setLayout(null);
        this.setSize(1400, 850);
        for (Map.Entry<String, Integer> entry : datos.getData().entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

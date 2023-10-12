import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class ResultsGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private Archive archive;

    public ResultsGUI(Archive archive) {
        this.archive = archive;
        frame = new JFrame("Tabla de Resultados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        String[] columnas = {"Nombre", "Puntaje"};
        tableModel = new DefaultTableModel(columnas, 0);
        table = new JTable(tableModel);

        JButton agregarButton = new JButton("Actualizar Resultados");
        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Obtener los datos de Archive y actualizar la tabla
                HashMap<String, Integer> datos = archive.getData();
                actualizarTabla(datos);
            }
        });

        frame.getContentPane().add(new JScrollPane(table), "Center");
        frame.getContentPane().add(agregarButton, "South");
        frame.pack();
        frame.setVisible(true);
    }

    private void actualizarTabla(HashMap<String, Integer> datos) {
        tableModel.setRowCount(0);
        for (String nombre : datos.keySet()) {
            int puntaje = datos.get(nombre);
            tableModel.addRow(new Object[]{nombre, puntaje});
        }
    }

    public static void main(String[] args) {
        Archive archive = new Archive();
        List<Player> players = new ArrayList<>();
        // Agrega jugadores a la lista players si es necesario
        archive.update(players);

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ResultsGUI(archive);
            }
        });
    }
}


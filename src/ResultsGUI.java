import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Map;

public class ResultsGUI {
    private JFrame frame;
    private JTable table;
    private DefaultTableModel tableModel;
    private Archive archive;

    public ResultsGUI(Archive archive) {
        this.archive = archive;
        frame = new JFrame("Tabla de Resultados");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.setPreferredSize(new Dimension(400, 300));

        String[] columnas = {"Nombre", "Puntaje"};
        tableModel = new DefaultTableModel(columnas, 0);
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);

        JButton actualizarButton = new JButton("Actualizar Resultados");
        actualizarButton.setFont(new Font("Arial", Font.PLAIN, 14));
        actualizarButton.setBackground(new Color(51, 153, 255));
        actualizarButton.setForeground(Color.WHITE);
        actualizarButton.setBorderPainted(false);
        actualizarButton.setFocusPainted(false);
        actualizarButton.addActionListener(e -> {
            Map<String, Integer> datos = archive.getData();
            actualizarTabla(datos);
        });
        frame.add(actualizarButton, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void actualizarTabla(Map<String, Integer> datos) {
        tableModel.setRowCount(0);
        datos.forEach((nombre, puntaje) -> tableModel.addRow(new Object[]{nombre, puntaje}));
    }


}

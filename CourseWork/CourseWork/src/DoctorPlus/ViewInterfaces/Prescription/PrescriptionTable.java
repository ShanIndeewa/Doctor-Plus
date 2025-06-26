package DoctorPlus.ViewInterfaces.Prescription;


import javax.swing.*;
        import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class PrescriptionTable extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private JScrollPane scrollPane;

    public JTable getTable() {
        return table;
    }

    public PrescriptionTable() {
        setLayout(new BorderLayout());
        tableModel = new DefaultTableModel();
        Object[] columnNames = {"MedicineName", "Dosage", "Duration"};
        tableModel.setColumnIdentifiers(columnNames);
        table = new JTable(tableModel);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 150));
        add(scrollPane, BorderLayout.CENTER);
    }

    public void addData(String medicineName, String dosage, String duration) {
        tableModel.addRow(new Object[]{medicineName, dosage, duration});
    }

    public void removeSelectedRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            tableModel.removeRow(selectedRow);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a row to remove.");
        }
    }

    public JScrollPane getTableWithScrollPane() {
        return scrollPane;
    }

    public DefaultTableModel getTableModel() {
        return tableModel;
    }

    public void clearTable() {
        tableModel.setRowCount(0);
    }
}

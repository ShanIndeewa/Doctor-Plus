package DoctorPlus.Controllers.PrescriptionController;

import DoctorPlus.DatabaseControllers.MedicineDBC;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.sql.SQLException;

public class TableSearch {
    MedicineDBC medicineDBC;
    JTable medicineTable;

    public JTable getMedicineTable() {
        return medicineTable;
    }

    public TableSearch() throws SQLException {
        medicineDBC = new MedicineDBC();
    }

    public DefaultTableModel getMedicineTableModel() throws SQLException {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        Object[] columnIdentifiers = new Object[]{"medicine_id", "name", "description", "dosage"};
        defaultTableModel.setColumnIdentifiers(columnIdentifiers);


        defaultTableModel = medicineDBC.addDataToTable(defaultTableModel);

        return defaultTableModel;
    }

    public JScrollPane createMedicineTable() throws SQLException {

        medicineTable = new JTable(getMedicineTableModel());

        medicineTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        medicineTable.getColumnModel().getColumn(1).setPreferredWidth(40);
        medicineTable.getColumnModel().getColumn(2).setPreferredWidth(250);
        medicineTable.getColumnModel().getColumn(3).setPreferredWidth(20);


        medicineTable.setRowHeight(30);

        JScrollPane jScrollPane = new JScrollPane(medicineTable);
        jScrollPane.setPreferredSize(new Dimension(900, 200)); // Adjust the size as needed

        return jScrollPane;
    }

    void filterTable(String searchText) {
        DefaultTableModel model = (DefaultTableModel) medicineTable.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        medicineTable.setRowSorter(sorter);

        if (searchText.trim().length() == 0) {
            sorter.setRowFilter(null);
            System.out.println("error");
        } else {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
            System.out.println("Success");
        }
    }
}

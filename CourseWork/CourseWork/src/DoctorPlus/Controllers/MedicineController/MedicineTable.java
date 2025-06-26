package DoctorPlus.Controllers.MedicineController;

import DoctorPlus.DatabaseControllers.MedicineDBC;
import DoctorPlus.ViewInterfaces.Components.InnerTableButtons;
import DoctorPlus.ViewInterfaces.MedicineViews.MedicineHomePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.SQLException;

public class MedicineTable extends JPanel {
    JTable medicineTable;
    MedicineHomePanel medicine;

    public MedicineTable(MedicineHomePanel medicineHomePanel) throws SQLException {
        this.medicine =medicineHomePanel;
        medicineTable = new JTable();
        initializeUI();
    }


    MedicineDBC medicineDBC =new MedicineDBC();
    private void initializeUI() throws SQLException {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        Object[] columnIdentifiers = new Object[]{"medicine_id", "name", "description", "dosage", "Action"};
        defaultTableModel.setColumnIdentifiers(columnIdentifiers);


        defaultTableModel = medicineDBC.addDataToTable(defaultTableModel);
        medicineTable.setModel(defaultTableModel);

        TableColumnModel columnModel = medicineTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(10);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(250);
        columnModel.getColumn(3).setPreferredWidth(20);
        columnModel.getColumn(4).setPreferredWidth(150);

        medicineTable.setRowHeight(30);

        medicineTable.getColumn("Action").setCellRenderer(new InnerTableButtons());
        JCheckBox checkBox = new JCheckBox();
        medicineTable.getColumn("Action").setCellEditor(new MediTableButtonEditor(checkBox, medicineTable, medicine));

        JScrollPane jScrollPane = new JScrollPane(medicineTable);
        jScrollPane.setPreferredSize(new Dimension(900, 400));

        add(jScrollPane);
    }

}

package DoctorPlus.Controllers.PatientControll;

import DoctorPlus.DatabaseControllers.PatientDBC;
import DoctorPlus.ViewInterfaces.PatientViews.PatientHomePanel;
import DoctorPlus.ViewInterfaces.Components.InnerTableButtons;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.*;
import java.sql.SQLException;

public class PatientTable extends JPanel {
    private JTable patientTable;
    private PatientHomePanel patient;
    DefaultTableModel defaultTableModel;

    public DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public JTable getPatientTable() {
        return patientTable;
    }

    PatientDBC patientDBC = new PatientDBC();
    public PatientTable(PatientHomePanel patient) throws SQLException {
        this.patient=patient;
        patientTable = new JTable();
        InitializedUI();
    }

    private void InitializedUI() throws SQLException {
        defaultTableModel = new DefaultTableModel();
        Object[] columnIdentifiers = new Object[]{"patient_id", "first_name", "last_name", "date_of_birth", "gender", "phone_number", "email", "address","Action"};
        defaultTableModel.setColumnIdentifiers(columnIdentifiers);

        defaultTableModel =patientDBC.addDataToTable(defaultTableModel);
        patientTable.setModel(defaultTableModel);

        TableColumnModel columnModel = patientTable.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(5);
        columnModel.getColumn(1).setPreferredWidth(40);
        columnModel.getColumn(2).setPreferredWidth(40);
        columnModel.getColumn(3).setPreferredWidth(30);
        columnModel.getColumn(4).setPreferredWidth(10);
        columnModel.getColumn(5).setPreferredWidth(40);
        columnModel.getColumn(6).setPreferredWidth(100);
        columnModel.getColumn(7).setPreferredWidth(120);
        columnModel.getColumn(8).setPreferredWidth(170);
        patientTable.setRowHeight(30);

        patientTable.getColumn("Action").setCellRenderer(new InnerTableButtons());
        JCheckBox checkBox = new JCheckBox();
        patientTable.getColumn("Action").setCellEditor(new TableButtonEditor(checkBox,patientTable,patient));

        JScrollPane jScrollPane = new JScrollPane(patientTable);
        jScrollPane.setPreferredSize(new Dimension(900,400));

        add(jScrollPane);

    }
}

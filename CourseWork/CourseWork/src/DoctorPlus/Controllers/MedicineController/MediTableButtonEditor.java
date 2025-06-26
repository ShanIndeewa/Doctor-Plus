package DoctorPlus.Controllers.MedicineController;

import DoctorPlus.DatabaseControllers.MedicineDBC;
import DoctorPlus.ViewInterfaces.Components.RoundedButton;
import DoctorPlus.ViewInterfaces.MedicineViews.FormMedicine;
import DoctorPlus.ViewInterfaces.MedicineViews.MedicineHomePanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MediTableButtonEditor extends DefaultCellEditor {
    private JButton updateButton;
    private JButton deleteButton;
    private JPanel panel;
    private JTable table;
    private MedicineHomePanel medicine;

    public MediTableButtonEditor(JCheckBox checkBox, JTable table,MedicineHomePanel medicine) throws SQLException {
        super(checkBox);

        this.medicine=medicine;
        this.table = table;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        updateButton = new RoundedButton("Update",new Color(46, 255, 102));
        updateButton.setBackground(new Color(46, 255, 102));
        deleteButton = new RoundedButton("Delete",new Color(255, 46, 67));
        deleteButton.setBackground(new Color(255, 46, 67));

        MedicineDBC medicineDBC = new MedicineDBC();

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();

                FormMedicine medicineForm = medicine.getUpdateMedicinePanel().getFormMedicine();

                int row = table.getSelectedRow();

                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Update clicked for ID " + table.getValueAt(row, 0).toString() + ". Do you want to proceed?",
                        "Confirm Action",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (response == JOptionPane.YES_OPTION) {

                    medicine.getDisplayMedicines().setVisible(false);
                    medicine.add(medicine.getUpdateMedicinePanel(),BorderLayout.CENTER);
                    medicine.getUpdateMedicinePanel().setVisible(true);

                    medicineForm.getTxtMedicineId().setText(table.getValueAt(row, 0).toString());
                    medicineForm.getTxtName().setText(table.getValueAt(row, 1).toString());
                    medicineForm.getTxtDescription().setText(table.getValueAt(row, 2).toString());
                    medicineForm.getTxtDosage().setText(table.getValueAt(row, 3).toString());
                }
            }


        });

        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();
                // Handle delete action here
                int row = table.getSelectedRow();
                String ID = table.getValueAt(row, 0).toString();

                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Delete clicked for ID " + ID + ". Do you want to proceed?",
                        "Confirm Action",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (response == JOptionPane.YES_OPTION) {

                    try {
                        int status = medicineDBC.deleteById(ID);

                        if(status>0){
                            JOptionPane.showConfirmDialog(
                                    null,
                                    "Record deleted successfully",
                                    "Confirm Action",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.CLOSED_OPTION
                            );
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            model.removeRow(row);
                        }
                        else {
                            JOptionPane.showConfirmDialog(
                                    null,
                                    "Something went wrong",
                                    "Confirm Action",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.CLOSED_OPTION
                            );
                        }
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }


        });

        panel.add(updateButton);
        panel.add(deleteButton);
    }


    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        return panel;
    }

}

package DoctorPlus.Controllers.PatientControll;

import DoctorPlus.DatabaseControllers.PatientDBC;
import DoctorPlus.ViewInterfaces.PatientViews.FormPatient;
import DoctorPlus.ViewInterfaces.PatientViews.PatientHomePanel;
import DoctorPlus.ViewInterfaces.Components.RoundedButton;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

class TableButtonEditor extends DefaultCellEditor {
    private final JButton updateButton;
    private final JButton deleteButton;
    private final JPanel panel;
    private JTable table;
    private PatientHomePanel patient;

    private PatientDBC patientDBC;

    public TableButtonEditor(JCheckBox checkBox, JTable table, PatientHomePanel patient) throws SQLException {

        super(checkBox);

        this.patient=patient;
        this.table = table;
        panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 0));
        updateButton = new RoundedButton("Update",new Color(46, 255, 102));
        updateButton.setBackground(new Color(46, 255, 102));
        deleteButton = new RoundedButton("Delete",new Color(255, 46, 67));
        deleteButton.setBackground(new Color(255, 46, 67));

        patientDBC =new PatientDBC();

        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fireEditingStopped();

                FormPatient patientForm = patient.getUpdatePatientPanel().getFormPatient();

                int row = table.getSelectedRow();

                int response = JOptionPane.showConfirmDialog(
                        null,
                        "Update clicked for ID " + table.getValueAt(row, 0).toString() + ". Do you want to proceed?",
                        "Confirm Action",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );

                if (response == JOptionPane.YES_OPTION) {

                    patient.getDisplayDetails().setVisible(false);
                    patient.add(patient.getUpdatePatientPanel(),BorderLayout.CENTER);
                    patient.getUpdatePatientPanel().setVisible(true);

                    patientForm.setId(table.getValueAt(row, 0).toString());
                    patientForm.getTxtFirstName().setText(table.getValueAt(row, 1).toString());
                    patientForm.getTxtLastName().setText(table.getValueAt(row, 2).toString());

                    //Split DOB
                    String dob = table.getValueAt(row, 3).toString();
                    String[] dateParts = dob.split("-");
                    int year = Integer.parseInt(dateParts[0]);
                    int month = Integer.parseInt(dateParts[1]);
                    int day = Integer.parseInt(dateParts[2]);

                    UtilDateModel model = (UtilDateModel) patientForm.getDatePicker().getModel();
                    model.setDate(year, month, day);
                    model.setSelected(true);

                    patientForm.getComboGender().setSelectedItem(table.getValueAt(row, 4).toString());

                    patientForm.getTxtPhoneNumber().setText(table.getValueAt(row, 5).toString());
                    patientForm.getTxtEmail().setText(table.getValueAt(row, 6).toString());
                    patientForm.getTxtAddress().setText(table.getValueAt(row, 7).toString());
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
                        int status = patientDBC.deleteById(ID);

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



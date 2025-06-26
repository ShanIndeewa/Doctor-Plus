package DoctorPlus.Controllers.MedicineController;

import DoctorPlus.Controllers.PatientControll.PatientTable;
import DoctorPlus.DatabaseControllers.MedicineDBC;
import DoctorPlus.ObjectClasses.Medicine;
import DoctorPlus.ViewInterfaces.MedicineViews.AddMedicinePanel;
import DoctorPlus.ViewInterfaces.MedicineViews.DisplayMedicines;
import DoctorPlus.ViewInterfaces.MedicineViews.MedicineHomePanel;
import DoctorPlus.ViewInterfaces.MedicineViews.UpdateMedicinePanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class MediFormButtonEditor {

    MedicineHomePanel medicineHome;
    AddMedicinePanel addMedicinePanel;
    UpdateMedicinePanel updateMedicinePanel;
    DisplayMedicines displayMedicines;
    MedicineDBC medicineDBC;

    public MediFormButtonEditor(AddMedicinePanel addMedicinePanel, UpdateMedicinePanel updateMedicinePanel, DisplayMedicines displayMedicinesPanel, MedicineHomePanel medicineHomePanel) throws SQLException {

        this.medicineHome = medicineHomePanel;
        this.addMedicinePanel = addMedicinePanel;
        this.updateMedicinePanel = updateMedicinePanel;
        this.displayMedicines = displayMedicinesPanel;
        this.medicineDBC = new MedicineDBC();

        medicineHome.add(displayMedicines, BorderLayout.CENTER);

        displayMedicines.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayMedicines.setVisible(false);
                medicineHome.add(addMedicinePanel, BorderLayout.CENTER);
                addMedicinePanel.setVisible(true);
            }
        });

        addMedicinePanel.getFooterPanel().getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMedicinePanel.setVisible(false);
                medicineHome.add(displayMedicines, BorderLayout.CENTER);
                displayMedicines.setVisible(true);

                displayMedicines.getTablePanel().setVisible(false);

                try {
                    displayMedicines.add(new MedicineTable(medicineHome),BorderLayout.CENTER);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        updateMedicinePanel.getFooterPanel().getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMedicinePanel.setVisible(false);
                medicineHome.add(displayMedicines, BorderLayout.CENTER);
                displayMedicines.setVisible(true);

                displayMedicines.getTablePanel().setVisible(false);

                try {
                    displayMedicines.add(new MedicineTable(medicineHome),BorderLayout.CENTER);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }

        });

        addMedicinePanel.getFooterPanel().getFunctionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicine medicineObj = new Medicine();

                medicineObj.setName(addMedicinePanel.getFormMedicine().getTxtName().getText());
                medicineObj.setDescription(addMedicinePanel.getFormMedicine().getTxtDescription().getText());
                medicineObj.setDosage(addMedicinePanel.getFormMedicine().getTxtDosage().getText());

                try {
                    medicineDBC.addMedicine(medicineObj);
                    int response = JOptionPane.showConfirmDialog(
                            null,
                            "Insert successfully",
                            "Confirm Action",
                            JOptionPane.CLOSED_OPTION,
                            JOptionPane.CLOSED_OPTION
                    );
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        updateMedicinePanel.getFooterPanel().getFunctionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Medicine medicineObj = new Medicine();

                medicineObj.setMedicineId(updateMedicinePanel.getFormMedicine().getTxtMedicineId().getText());
                medicineObj.setName(updateMedicinePanel.getFormMedicine().getTxtName().getText());
                medicineObj.setDescription(updateMedicinePanel.getFormMedicine().getTxtDescription().getText());
                medicineObj.setDosage(updateMedicinePanel.getFormMedicine().getTxtDosage().getText());

                try {
                    medicineDBC.updateMedicine(medicineObj);
                    int response = JOptionPane.showConfirmDialog(
                            null,
                            "Update successfully",
                            "Confirm Action",
                            JOptionPane.CLOSED_OPTION,
                            JOptionPane.CLOSED_OPTION
                    );
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}


package DoctorPlus.Controllers.PatientControll;

import DoctorPlus.DatabaseControllers.PatientDBC;
import DoctorPlus.ObjectClasses.Patient;
import DoctorPlus.ViewInterfaces.PatientViews.AddPatientPanel;
import DoctorPlus.ViewInterfaces.PatientViews.DisplayDetails;
import DoctorPlus.ViewInterfaces.PatientViews.PatientHomePanel;
import DoctorPlus.ViewInterfaces.PatientViews.UpdatePatientPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class FormButtonEditor {

    PatientHomePanel patient;
    AddPatientPanel addPatient;
    UpdatePatientPanel updatePatient;
    DisplayDetails displayDetails;
    PatientDBC patientDBC;

    public FormButtonEditor(AddPatientPanel addPatientPanel, UpdatePatientPanel updatePatientPanel, DisplayDetails displayDetailsPanel, PatientHomePanel patient) {


        this.patient=patient;

        addPatient = addPatientPanel;
        updatePatient = updatePatientPanel;
        displayDetails = displayDetailsPanel;

        patient.add(displayDetails, BorderLayout.CENTER);

        displayDetails.getAddButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displayDetails.setVisible(false);
                patient.add(addPatient, BorderLayout.CENTER);
                addPatient.setVisible(true);
            }
        });

        addPatient.getFooterPanel().getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              addPatient.setVisible(false);

                JTable patientTable = new JTable();

                displayDetails.getTablePanel().setVisible(false);

                try {
                    displayDetails.add(new PatientTable(patient),BorderLayout.CENTER);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

                patient.add(displayDetails,BorderLayout.CENTER);
                displayDetails.setVisible(true);
            }
        });

        updatePatient.getFooterPanel().getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updatePatient.setVisible(false);
                patient.add(displayDetails,BorderLayout.CENTER);
                displayDetails.setVisible(true);

                displayDetails.getTablePanel().setVisible(false);

                try {
                    displayDetails.add(new PatientTable(patient),BorderLayout.CENTER);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });


        addPatient.getFooterPanel().getFunctionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    patientDBC =new PatientDBC();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Patient patientObj = new Patient();

                patientObj.setFirstName(addPatient.getFormPatient().getTxtFirstName().getText());
                patientObj.setLastName(addPatient.getFormPatient().getTxtLastName().getText());

                Object selectedDate = addPatient.getFormPatient().getDatePicker().getModel().getValue();
                patientObj.setDateOfBirth((Date) selectedDate);

                patientObj.setGender(addPatient.getFormPatient().getComboGender().getSelectedItem().toString());
                patientObj.setPhoneNumber(addPatient.getFormPatient().getTxtPhoneNumber().getText());
                patientObj.setEmail(addPatient.getFormPatient().getTxtEmail().getText());
                patientObj.setAddress(addPatient.getFormPatient().getTxtAddress().getText());

                System.out.println(patientObj.getFirstName());

                try {
                    patientDBC.addPatient(patientObj);
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

        updatePatient.getFooterPanel().getFunctionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    patientDBC =new PatientDBC();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
                Patient patientObj = new Patient();

                patientObj.setPatientId(updatePatient.getFormPatient().getId());
                patientObj.setFirstName(updatePatient.getFormPatient().getTxtFirstName().getText());
                patientObj.setLastName(updatePatient.getFormPatient().getTxtLastName().getText());

                Object selectedDate = updatePatient.getFormPatient().getDatePicker().getModel().getValue();
                patientObj.setDateOfBirth((Date) selectedDate);

                patientObj.setGender(updatePatient.getFormPatient().getComboGender().getSelectedItem().toString());
                patientObj.setPhoneNumber(updatePatient.getFormPatient().getTxtPhoneNumber().getText());
                patientObj.setEmail(updatePatient.getFormPatient().getTxtEmail().getText());
                patientObj.setAddress(updatePatient.getFormPatient().getTxtAddress().getText());

                try {
                    patientDBC.updatePatient(patientObj);
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

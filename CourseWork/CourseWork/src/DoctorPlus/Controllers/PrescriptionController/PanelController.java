package DoctorPlus.Controllers.PrescriptionController;

import DoctorPlus.Controllers.PatientControll.PatientTable;
import DoctorPlus.DatabaseControllers.PatientDBC;
import DoctorPlus.DatabaseControllers.PrescriptionDBC;
import DoctorPlus.ObjectClasses.Medicine;
import DoctorPlus.ObjectClasses.Patient;
import DoctorPlus.ObjectClasses.Prescription;
import DoctorPlus.ViewInterfaces.Prescription.DownPanel;
import DoctorPlus.ViewInterfaces.Prescription.PrescriptionTable;
import DoctorPlus.ViewInterfaces.Prescription.UpPanel;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class PanelController {
    UpPanel upPanel;
    DownPanel downPanel;
    Medicine medicine;
    Prescription prescription;
    String uname;

    public PanelController(UpPanel upPanel, DownPanel downPanel,String uname) {
        this.upPanel = upPanel;
        this.uname = uname;
        this.downPanel = downPanel;
        medicine = new Medicine();
        prescription = new Prescription();


        downPanel.getSearchButton().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = downPanel.getSearchField().getText().toString();
                downPanel.getTableSearch().filterTable(searchText);
            }
        });

        downPanel.getFooterPanel().getFunctionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int x=0,y=0;
                if(downPanel.getQty().getText().equals("")){
                    downPanel.getQty().setBorder(BorderFactory.createLineBorder(Color.red));
                    x=1;
                }
                else {
                    downPanel.getQty().setBorder(BorderFactory.createLineBorder(Color.black));
                }
                if(downPanel.getDuration().getText().equals("")){
                    downPanel.getDuration().setBorder(BorderFactory.createLineBorder(Color.red));
                    y=1;
                }
                else {
                    downPanel.getDuration().setBorder(BorderFactory.createLineBorder(Color.black));
                }

                if(x==0 && y==0)
                {
                    JTable table = downPanel.getTableSearch().getMedicineTable();
                    int selectedRow = table.getSelectedRow();
                    if (selectedRow != -1) {
                        String medicineName = table.getValueAt(selectedRow, 1).toString();
                        String dosage = downPanel.getQty().getText();
                        String duration = downPanel.getDuration().getText();

                        System.out.println("Selected Row Data: ");
                        System.out.println("Medicine Name: " + medicineName);
                        System.out.println("Dosage: " + dosage);
                        System.out.println("Duration: " + duration);

                        upPanel.getPrescriptionTable().addData(medicineName, dosage, duration);

                        downPanel.getQty().setText("");
                        downPanel.getDuration().setText("");

                        medicine.setMedicineId(table.getValueAt(selectedRow,0).toString());
                        medicine.setName(medicineName);
                        medicine.setDescription(table.getValueAt(selectedRow,2).toString());
                        medicine.setDosage(table.getValueAt(selectedRow,3).toString());

                        prescription.addMedicine(medicine);

                        System.out.println(medicine);

                    } else {
                        System.out.println("No row is selected.");

                        int response = JOptionPane.showConfirmDialog(
                                null,
                                "Please Select the medicine!",
                                "Confirm Action",
                                JOptionPane.CLOSED_OPTION,
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
                else {
                    System.out.println("error");
                }
            }
        });

        downPanel.getFooterPanel().getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upPanel.getPrescriptionTable().removeSelectedRow();
            }
        });

        upPanel.getFooterPanel().getCancelBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                upPanel.getPrescriptionTable().clearTable();
            }
        });

        upPanel.getFooterPanel().getFunctionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(downPanel.getpId().getText().toString().equals(""))
                {
                    System.out.println("bye");
                    int response = JOptionPane.showConfirmDialog(
                            null,
                            "Please Enter the Patient ID!",
                            "Confirm Action",
                            JOptionPane.CLOSED_OPTION,
                            JOptionPane.ERROR_MESSAGE
                    );
                }
                else {
                    prescription.setPatientID(downPanel.getpId().getText().toString());
                    PrescriptionTable p1 = upPanel.getPrescriptionTable();
                    try {
                        Patient patient = new PatientDBC().getPatientById(downPanel.getpId().getText().toString());
                        new PDFMaker(p1,uname,patient);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }


                }


            }
        });
    }


}

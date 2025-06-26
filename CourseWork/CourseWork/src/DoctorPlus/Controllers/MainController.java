package DoctorPlus.Controllers;

import DoctorPlus.ViewInterfaces.PatientViews.PatientHomePanel;
import DoctorPlus.ViewInterfaces.MainScreen.MainScreen;
import DoctorPlus.ViewInterfaces.MainScreen.SliderBar;
import DoctorPlus.ViewInterfaces.MedicineViews.MedicineHomePanel;
import DoctorPlus.ViewInterfaces.Prescription.PriscriptionHomePanel;
import DoctorPlus.ViewInterfaces.Settings.SetingsHomePanel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainController {
    MainScreen mainScreen;
    PatientHomePanel patientHomePanel;
    MedicineHomePanel medicineHomePanel;
    SliderBar sliderBar;
    PriscriptionHomePanel priscriptionHomePanel;
    SetingsHomePanel setingsHomePanel;

    public MainController(PatientHomePanel patientHomePanel, MedicineHomePanel medicineHomePanel, SliderBar sliderBar, PriscriptionHomePanel priscriptionHomePanel, MainScreen mainScreen,SetingsHomePanel setingsHomePanel) {
        this.mainScreen=mainScreen;
        this.patientHomePanel = patientHomePanel;
        this.medicineHomePanel = medicineHomePanel;
        this.sliderBar = sliderBar;
        this.patientHomePanel = patientHomePanel;
        this.setingsHomePanel = setingsHomePanel;

        sliderBar.getAddMedicine().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                patientHomePanel.setVisible(false);
                priscriptionHomePanel.setVisible(false);
                setingsHomePanel.setVisible(false);

                mainScreen.add(medicineHomePanel, BorderLayout.CENTER);

                medicineHomePanel.setVisible(true);
            }
        });

    sliderBar.getAddPatient().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            medicineHomePanel.setVisible(false);
            priscriptionHomePanel.setVisible(false);
            setingsHomePanel.setVisible(false);

            mainScreen.add(patientHomePanel,BorderLayout.CENTER);

            patientHomePanel.setVisible(true);
        }
    });

    sliderBar.getCreatePrescription().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            patientHomePanel.setVisible(false);
            medicineHomePanel.setVisible(false);
            setingsHomePanel.setVisible(false);

            mainScreen.add(priscriptionHomePanel,BorderLayout.CENTER);

            priscriptionHomePanel.setVisible(true);
        }
    });

    sliderBar.Settings().addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            patientHomePanel.setVisible(false);
            medicineHomePanel.setVisible(false);
            priscriptionHomePanel.setVisible(false);

            mainScreen.add(setingsHomePanel,BorderLayout.CENTER);

            setingsHomePanel.setVisible(true);
        }
    });

    }


}

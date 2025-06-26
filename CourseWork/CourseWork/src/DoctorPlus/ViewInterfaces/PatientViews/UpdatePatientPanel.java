package DoctorPlus.ViewInterfaces.PatientViews;

import DoctorPlus.ViewInterfaces.Components.FooterPanel;
import DoctorPlus.ViewInterfaces.Components.HeadPanel;

import javax.swing.*;
import java.awt.*;

public class UpdatePatientPanel extends JPanel {
    FormPatient formPatient;
    FooterPanel footerPanel;

    public FormPatient getFormPatient() {
        return formPatient;
    }

    public FooterPanel getFooterPanel() {
        return footerPanel;
    }

    public UpdatePatientPanel() {
        InitializedUI();
    }

    private void InitializedUI() {
        setLayout(new BorderLayout());

        formPatient = new FormPatient();
        add(formPatient,BorderLayout.CENTER);

        HeadPanel headPanel = new HeadPanel("Update Patients Details");
        add(headPanel,BorderLayout.NORTH);

        footerPanel = new FooterPanel("Update");
        add(footerPanel,BorderLayout.SOUTH);

        setVisible(true);
    }

}

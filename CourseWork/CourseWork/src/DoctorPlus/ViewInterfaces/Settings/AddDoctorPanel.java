package DoctorPlus.ViewInterfaces.Settings;

import DoctorPlus.ViewInterfaces.Components.FooterPanel;
import DoctorPlus.ViewInterfaces.Components.HeadPanel;

import javax.swing.*;
import java.awt.*;

public class AddDoctorPanel extends JPanel {

    FooterPanel footerPanel;
    private FormDoctor formDoctor;

    public FormDoctor getFormDoctor() {
        return formDoctor;
    }

    public void setFormDoctor(FormDoctor formDoctor) {
        this.formDoctor = formDoctor;
    }

    public FooterPanel getFooterPanel() {
        return footerPanel;
    }

    public AddDoctorPanel() {
        InitializedUI();
    }

    private void InitializedUI() {
        setLayout(new BorderLayout());

        HeadPanel headPanel = new HeadPanel("Add Doctors to the System");
        add(headPanel, BorderLayout.NORTH);

        formDoctor = new FormDoctor();
        add(formDoctor,BorderLayout.CENTER);

        footerPanel = new FooterPanel("Add");
        add(footerPanel, BorderLayout.SOUTH);

        setVisible(true);
    }
}
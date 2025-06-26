package DoctorPlus.ViewInterfaces.PatientViews;

import DoctorPlus.Controllers.PatientControll.FormButtonEditor;

import javax.swing.*;
import java.awt.*;

public class PatientHomePanel extends JPanel {


    AddPatientPanel addPatientPanel;
    UpdatePatientPanel updatePatientPanel;
    DisplayDetails displayDetails;

    public AddPatientPanel getAddPatientPanel() {
        return addPatientPanel;
    }

    public UpdatePatientPanel getUpdatePatientPanel() {
        return updatePatientPanel;
    }

    public DisplayDetails getDisplayDetails() {
        return displayDetails;
    }

    public PatientHomePanel() {
        InitializedUI();

        addPatientPanel=new AddPatientPanel();
        updatePatientPanel =new UpdatePatientPanel();
        displayDetails = new DisplayDetails(this);
        new FormButtonEditor(addPatientPanel,updatePatientPanel,displayDetails,this);
    }

    private void InitializedUI() {
        setLayout(new BorderLayout());

        setVisible(true);
    }

}

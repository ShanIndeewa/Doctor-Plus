package DoctorPlus.ViewInterfaces.PatientViews;

import DoctorPlus.Controllers.PatientControll.PatientTable;
import DoctorPlus.ViewInterfaces.Components.HeadPanel;
import DoctorPlus.ViewInterfaces.Components.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class DisplayDetails extends JPanel {
    PatientTable tablePanel;
    JButton AddButton;
    AddPatientPanel addPatientPanel;
    UpdatePatientPanel updatePatientPanel;
    PatientHomePanel patient;

    public DisplayDetails(PatientHomePanel patient) {
        try {
            tablePanel = new PatientTable(patient);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.patient=patient;
        InitializedUI();
        addPatientPanel = new AddPatientPanel();
        updatePatientPanel=new UpdatePatientPanel();
    }

    public PatientTable getTablePanel() {
        return tablePanel;
    }

    public JButton getAddButton() {
        return AddButton;
    }

    public AddPatientPanel getAddPatientPanel() {
        return addPatientPanel;
    }

    public UpdatePatientPanel getUpdatePatientPanel() {
        return updatePatientPanel;
    }

    public void setTablePanel(PatientTable tablePanel) {
        this.tablePanel = tablePanel;
    }

    private void InitializedUI() {
        setLayout(new BorderLayout());

        add(new HeadPanel("All Patients"),BorderLayout.NORTH);
        add(tablePanel,BorderLayout.CENTER);

        JPanel addBtn = new JPanel();
        AddButton = new RoundedButton("Add new Patient",new Color(31, 31, 31 ));
        AddButton.setBackground(new Color(31, 31, 31 ));
        AddButton.setForeground(Color.WHITE);
        AddButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        AddButton.setPreferredSize(new Dimension(180,30));
        addBtn.setBorder(new EmptyBorder(20,20,20,20));

        addBtn.add(AddButton);
        add(addBtn,BorderLayout.SOUTH);
    }
}

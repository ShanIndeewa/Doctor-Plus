package DoctorPlus.ViewInterfaces.Settings;

import DoctorPlus.Controllers.SettingsControll;
import DoctorPlus.DatabaseControllers.SettingsDBC;
import jdk.jfr.SettingControl;

import javax.swing.*;
import java.awt.*;

public class SetingsHomePanel extends JPanel {
    private AddDoctorPanel addDoctorPanel;



    public SetingsHomePanel() {
        addDoctorPanel = new AddDoctorPanel();
        InitializedUI();

        new SettingsControll(addDoctorPanel);
    }

    private void InitializedUI() {

        setLayout(new BorderLayout());
        add(addDoctorPanel,BorderLayout.CENTER);

        setVisible(true);
    }
}

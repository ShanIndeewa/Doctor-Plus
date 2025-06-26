package DoctorPlus.ViewInterfaces.Prescription;

import DoctorPlus.Controllers.PrescriptionController.PanelController;

import javax.swing.*;
import java.awt.*;

public class PriscriptionHomePanel extends JPanel {

    UpPanel upPanel;
    DownPanel downPanel;

    public PriscriptionHomePanel(String uname) {
        initializedUI();
        new PanelController(upPanel,downPanel,uname);
    }

    private void initializedUI() {

        setLayout(new BorderLayout());

        upPanel = new UpPanel();
        downPanel = new DownPanel();

        add(upPanel,BorderLayout.CENTER);
        add(downPanel,BorderLayout.SOUTH);

        setVisible(true);
    }
}

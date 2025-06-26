package DoctorPlus.ViewInterfaces.MedicineViews;

import DoctorPlus.ViewInterfaces.Components.FooterPanel;
import DoctorPlus.ViewInterfaces.Components.HeadPanel;

import javax.swing.*;
import java.awt.*;

public class UpdateMedicinePanel extends JPanel {
    FormMedicine formMedicine;
    FooterPanel footerPanel;

    public FormMedicine getFormMedicine() {
        return formMedicine;
    }

    public FooterPanel getFooterPanel() {
        return footerPanel;
    }

    public UpdateMedicinePanel() {
        initializedUI();
    }

    private void initializedUI() {
        setLayout(new BorderLayout());

        add(new HeadPanel("Update New Medicines"),BorderLayout.NORTH);

        footerPanel = new FooterPanel("Update");
        add(footerPanel,BorderLayout.SOUTH);

        formMedicine = new FormMedicine();
        add(formMedicine,BorderLayout.CENTER);

        setVisible(true);
    }
}

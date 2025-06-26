package DoctorPlus.ViewInterfaces.MedicineViews;

import DoctorPlus.ViewInterfaces.Components.FooterPanel;
import DoctorPlus.ViewInterfaces.Components.HeadPanel;

import javax.swing.*;
import java.awt.*;

public class AddMedicinePanel extends JPanel {
    FormMedicine formMedicine;
    FooterPanel footerPanel;

    public AddMedicinePanel() {
        initializedUI();
    }

    public FormMedicine getFormMedicine() {
        return formMedicine;
    }

    public FooterPanel getFooterPanel() {
        return footerPanel;
    }

    private void initializedUI() {
        setLayout(new BorderLayout());

        add(new HeadPanel("Add New Medicines"),BorderLayout.NORTH);

        footerPanel = new FooterPanel("Add");
        add(footerPanel,BorderLayout.SOUTH);

        formMedicine = new FormMedicine();
        add(formMedicine,BorderLayout.CENTER);

        setVisible(true);

    }
}

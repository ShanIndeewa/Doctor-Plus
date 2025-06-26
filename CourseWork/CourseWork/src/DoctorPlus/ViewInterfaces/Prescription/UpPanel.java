package DoctorPlus.ViewInterfaces.Prescription;

import DoctorPlus.ViewInterfaces.Components.FooterPanel;
import DoctorPlus.ViewInterfaces.Components.HeadPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class UpPanel extends JPanel {
    JTable table;
    FooterPanel footerPanel;
    PrescriptionTable prescriptionTable;

    public JTable getTable() {
        return table;
    }

    public FooterPanel getFooterPanel() {
        return footerPanel;
    }

    public PrescriptionTable getPrescriptionTable() {
        return prescriptionTable;
    }

    public UpPanel() {
        initializedUI();
    }

    private void initializedUI() {
        setLayout(new BorderLayout());
        setSize(new Dimension(700,200));

        add(new HeadPanel("Issuing Prescription"),BorderLayout.NORTH);

        JPanel pTable = new JPanel();
        prescriptionTable = new PrescriptionTable();
        pTable.add(prescriptionTable);
        pTable.setBorder(new EmptyBorder(0,20,0,20));
        add(pTable,BorderLayout.CENTER);

        footerPanel = new FooterPanel("Genarate");
        footerPanel.getCancelBtn().setText("Clear");
        add(footerPanel,BorderLayout.SOUTH);

    }
}

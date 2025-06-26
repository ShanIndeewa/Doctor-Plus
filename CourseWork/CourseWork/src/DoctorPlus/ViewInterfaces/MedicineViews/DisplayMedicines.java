package DoctorPlus.ViewInterfaces.MedicineViews;

import DoctorPlus.Controllers.MedicineController.MedicineTable;

import DoctorPlus.ViewInterfaces.Components.HeadPanel;
import DoctorPlus.ViewInterfaces.Components.RoundedButton;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.sql.SQLException;

public class DisplayMedicines extends JPanel {

    MedicineTable tablePanel;
    RoundedButton AddButton;
    MedicineHomePanel medicine;

    public DisplayMedicines(MedicineHomePanel medicine) {
        this.medicine=medicine;
        InitializedUI();

    }

    public MedicineTable getTablePanel() {
        return tablePanel;
    }

    public RoundedButton getAddButton() {
        return AddButton;
    }

    public MedicineHomePanel getMedicine() {
        return medicine;
    }

    private void InitializedUI() {
        setLayout(new BorderLayout());

        add(new HeadPanel("All Medicines"),BorderLayout.NORTH);

        try {
            tablePanel = new MedicineTable(medicine);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //assert tablePanel != null;
        add(tablePanel,BorderLayout.CENTER);

        JPanel addBtn = new JPanel();
        AddButton = new RoundedButton("Add new Medicines", new Color(31, 31, 31));
        AddButton.setBackground(new Color(31, 31, 31 ));
        AddButton.setForeground(Color.WHITE);
        AddButton.setFont(new Font(Font.SANS_SERIF,Font.BOLD,16));
        AddButton.setPreferredSize(new Dimension(180,30));
        addBtn.setBorder(new EmptyBorder(20,20,20,20));

        addBtn.add(AddButton);
        add(addBtn,BorderLayout.SOUTH);
    }
}

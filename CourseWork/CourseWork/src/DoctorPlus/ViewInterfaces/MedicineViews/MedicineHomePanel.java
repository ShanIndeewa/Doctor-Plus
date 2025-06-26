package DoctorPlus.ViewInterfaces.MedicineViews;

import DoctorPlus.Controllers.MedicineController.MediFormButtonEditor;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class MedicineHomePanel extends JPanel {

    AddMedicinePanel addMedicinePanel;
    UpdateMedicinePanel updateMedicinePanel;
    DisplayMedicines displayMedicines;

    public AddMedicinePanel getAddMedicinePanel() {
        return addMedicinePanel;
    }

    public UpdateMedicinePanel getUpdateMedicinePanel() {
        return updateMedicinePanel;
    }

    public DisplayMedicines getDisplayMedicines() {
        return displayMedicines;
    }

    public MedicineHomePanel() {

        addMedicinePanel = new AddMedicinePanel();
        updateMedicinePanel = new UpdateMedicinePanel();
        displayMedicines =new DisplayMedicines(this);

        InitializedUI();

        try {
            new MediFormButtonEditor(addMedicinePanel,updateMedicinePanel,displayMedicines,this);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private void InitializedUI() {
        setLayout(new BorderLayout());
        add(displayMedicines,BorderLayout.CENTER);

        setVisible(true);
    }
}

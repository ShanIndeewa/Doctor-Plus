package DoctorPlus.ViewInterfaces.MainScreen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SliderBar extends JPanel {
    JButton addMedicine;
    JButton addPatient;
    JButton createPrescription;
    JButton Settings;

    public JButton getAddMedicine() {
        return addMedicine;
    }

    public JButton getAddPatient() {
        return addPatient;
    }

    public JButton getCreatePrescription() {
        return createPrescription;
    }

    public JButton Settings() {
        return Settings;
    }



    public SliderBar() {
        InitializedUI();
    }

    private void InitializedUI() {
        setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));
        setPreferredSize(new Dimension(180,600));
        setBackground(new Color(76, 76, 76 ));

        ImageIcon pIcon = new ImageIcon(getClass().getResource("\\Icons\\BtnIcon1.png"));
        addPatient = new JButton("Patient",pIcon);
        addPatient.setBackground(new Color(141, 0, 19 ));
        addPatient.setForeground(Color.WHITE);
        addPatient.setFocusable(false);
        addPatient.setBorder(new EmptyBorder(15,15,15,63));
        addPatient.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        addPatient.setPreferredSize(new Dimension(180, 40));


        ImageIcon mIcon = new ImageIcon(getClass().getResource("\\Icons\\BtnIcon2.png"));
        addMedicine = new JButton("Medicine",mIcon);
        addMedicine.setBackground(new Color(141, 0, 19 ));
        addMedicine.setForeground(Color.WHITE);
        addMedicine.setFocusable(false);
        addMedicine.setBorder(new EmptyBorder(15,15,15,43));
        addMedicine.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        addMedicine.setPreferredSize(new Dimension(180, 40));


        ImageIcon prIcon = new ImageIcon(getClass().getResource("\\Icons\\BtnIcon3.png"));
        createPrescription = new JButton("Prescription",prIcon);
        createPrescription.setBackground(new Color(141, 0, 19 ));
        createPrescription.setForeground(Color.WHITE);
        createPrescription.setFocusable(false);
        createPrescription.setBorder(new EmptyBorder(15,15,15,12));
        createPrescription.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        createPrescription.setPreferredSize(new Dimension(180, 40));


        ImageIcon grIcon = new ImageIcon(getClass().getResource("\\Icons\\BtnIcon4.png"));
        Settings = new JButton("Settings",grIcon);
        Settings.setBackground(new Color(141, 0, 19 ));
        Settings.setForeground(Color.WHITE);
        Settings.setFocusable(false);
        Settings.setBorder(new EmptyBorder(15,15,15,51));
        Settings.setFont(new Font(Font.SANS_SERIF,Font.BOLD,20));
        Settings.setPreferredSize(new Dimension(180, 40));


        add(createPrescription);
        add(addPatient);
        add(addMedicine);
        add(Settings);

        setVisible(true);

    }
}


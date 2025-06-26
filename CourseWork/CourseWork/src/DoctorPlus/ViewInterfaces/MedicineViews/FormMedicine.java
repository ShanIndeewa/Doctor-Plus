package DoctorPlus.ViewInterfaces.MedicineViews;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormMedicine extends JPanel {
    private JLabel lblMedicineId, lblName, lblDescription, lblDosage;
    private JTextField txtMedicineId, txtName, txtDosage;
    private JTextArea txtDescription;

    public FormMedicine() {
        initializeUI();
    }

    public void setTxtMedicineId(JTextField txtMedicineId) {
        this.txtMedicineId = txtMedicineId;
    }

    public void setTxtName(JTextField txtName) {
        this.txtName = txtName;
    }

    public void setTxtDosage(JTextField txtDosage) {
        this.txtDosage = txtDosage;
    }

    public void setTxtDescription(JTextArea txtDescription) {
        this.txtDescription = txtDescription;
    }

    private void initializeUI() {
        setLayout(new GridBagLayout());
        setSize(new Dimension(300, 300));
        setBorder(new EmptyBorder(20, 20, 20, 20));

        lblMedicineId = new JLabel("Enter Medicine ID:");
        lblName = new JLabel("Enter Name:");
        lblDescription = new JLabel("Enter Description:");
        lblDosage = new JLabel("Enter Dosage:");

        txtMedicineId = new JTextField(10);
        txtName = new JTextField(100);
        txtDosage = new JTextField(10);
        txtDescription = new JTextArea(3, 30);
        txtDescription.setLineWrap(true);
        txtDescription.setWrapStyleWord(true);
        JScrollPane descriptionScrollPane = new JScrollPane(txtDescription);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(lblMedicineId, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 1.0;
        add(txtMedicineId, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.0;
        add(lblName, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 1.0;
        add(txtName, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblDosage, gbc);


        gbc.gridx = 1; gbc.gridy = 2;
        add(txtDosage, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(lblDescription, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        gbc.gridheight=5;
        add(descriptionScrollPane, gbc);

        setVisible(true);
    }

    public JTextField getTxtMedicineId() {
        return txtMedicineId;
    }

    public JTextField getTxtName() {
        return txtName;
    }

    public JTextArea getTxtDescription() {
        return txtDescription;
    }

    public JTextField getTxtDosage() {
        return txtDosage;
    }
}


package DoctorPlus.ViewInterfaces.Settings;

import javax.swing.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormDoctor extends JPanel {
        private JLabel lblDoctorId, lblFirstName, lblLastName, lblSpecialty, lblPhoneNumber, lblEmail;
        private JTextField txtDoctorId, txtFirstName, txtLastName, txtSpecialty, txtPhoneNumber, txtEmail;
        SetLogin setLogin = new SetLogin();

        public FormDoctor() {
            initializeUI();
        }

    public void setSetLogin(SetLogin setLogin) {
        this.setLogin = setLogin;
    }

    public SetLogin getSetLogin() {
        return setLogin;
    }

    public void setTxtDoctorId(JTextField txtDoctorId) {
            this.txtDoctorId = txtDoctorId;
        }

        public void setTxtFirstName(JTextField txtFirstName) {
            this.txtFirstName = txtFirstName;
        }

        public void setTxtLastName(JTextField txtLastName) {
            this.txtLastName = txtLastName;
        }

        public void setTxtSpecialty(JTextField txtSpecialty) {
            this.txtSpecialty = txtSpecialty;
        }

        public void setTxtPhoneNumber(JTextField txtPhoneNumber) {
            this.txtPhoneNumber = txtPhoneNumber;
        }

        public void setTxtEmail(JTextField txtEmail) {
            this.txtEmail = txtEmail;
        }

        private void initializeUI() {
            setLayout(new GridBagLayout());
            setSize(new Dimension(300, 300));
            setBorder(new EmptyBorder(20, 20, 20, 20));

            lblDoctorId = new JLabel("Enter Doctor ID:");
            lblFirstName = new JLabel("Enter First Name:");
            lblLastName = new JLabel("Enter Last Name:");
            lblSpecialty = new JLabel("Enter Specialty:");
            lblPhoneNumber = new JLabel("Enter Phone Number:");
            lblEmail = new JLabel("Enter Email:");

            txtDoctorId = new JTextField(10);
            txtFirstName = new JTextField(20);
            txtLastName = new JTextField(20);
            txtSpecialty = new JTextField(30);
            txtPhoneNumber = new JTextField(15);
            txtEmail = new JTextField(30);

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(5, 5, 5, 5);
            gbc.fill = GridBagConstraints.HORIZONTAL;

            gbc.gridx = 0; gbc.gridy = 0;
            add(lblDoctorId, gbc);

            gbc.gridx = 1; gbc.gridy = 0;
            gbc.weightx = 1.0;
            add(txtDoctorId, gbc);

            gbc.gridx = 0; gbc.gridy = 1;
            gbc.weightx = 0.0;
            add(lblFirstName, gbc);

            gbc.gridx = 1; gbc.gridy = 1;
            gbc.weightx = 1.0;
            add(txtFirstName, gbc);

            gbc.gridx = 0; gbc.gridy = 2;
            add(lblLastName, gbc);

            gbc.gridx = 1; gbc.gridy = 2;
            add(txtLastName, gbc);

            gbc.gridx = 0; gbc.gridy = 3;
            add(lblSpecialty, gbc);

            gbc.gridx = 1; gbc.gridy = 3;
            add(txtSpecialty, gbc);

            gbc.gridx = 0; gbc.gridy = 4;
            add(lblPhoneNumber, gbc);

            gbc.gridx = 1; gbc.gridy = 4;
            add(txtPhoneNumber, gbc);

            gbc.gridx = 0; gbc.gridy = 5;
            add(lblEmail, gbc);

            gbc.gridx = 1; gbc.gridy = 5;
            add(txtEmail, gbc);

            gbc.gridx = 0; gbc.gridy = 6;
            add(setLogin, gbc);

            setVisible(true);
        }

        public JTextField getTxtDoctorId() {
            return txtDoctorId;
        }

        public JTextField getTxtFirstName() {
            return txtFirstName;
        }

        public JTextField getTxtLastName() {
            return txtLastName;
        }

        public JTextField getTxtSpecialty() {
            return txtSpecialty;
        }

        public JTextField getTxtPhoneNumber() {
            return txtPhoneNumber;
        }

        public JTextField getTxtEmail() {
            return txtEmail;
        }


}

package DoctorPlus.ViewInterfaces.Settings;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class SetLogin extends JPanel {
    private JLabel lblUserId, lblPassword;
    private JTextField txtUserId;
    private JTextField txtPassword;

    public SetLogin() {
        initializedUI();
    }

    public void setTxtUserId(JTextField txtUserId) {
        this.txtUserId = txtUserId;
    }

    public void setTxtPassword(JPasswordField txtPassword) {
        this.txtPassword = txtPassword;
    }

    private void initializedUI() {
        setLayout(new GridBagLayout());
        setSize(new Dimension(300, 150));
        setBorder(new EmptyBorder(40, 0, 20, 20));

        lblUserId = new JLabel("Enter User ID:");
        lblPassword = new JLabel("Enter Password:");

        txtUserId = new JTextField(20);
        txtPassword = new JTextField(20);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 0, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        add(lblUserId, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 1.0;
        add(txtUserId, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.0;
        add(lblPassword, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 1.0;
        add(txtPassword, gbc);

        setVisible(true);
    }

    public JTextField getTxtUserId() {
        return txtUserId;
    }

    public JTextField getTxtPassword() {
        return txtPassword;
    }
}




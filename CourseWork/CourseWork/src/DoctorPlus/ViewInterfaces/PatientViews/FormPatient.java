package DoctorPlus.ViewInterfaces.PatientViews;

import DoctorPlus.ViewInterfaces.Components.DateLabelFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Properties;

public class FormPatient extends JPanel {
    private JLabel  lblFirstName, lblLastName, lblDateOfBirth, lblGender, lblPhoneNumber, lblEmail, lblAddress;
    private JTextField  txtFirstName, txtLastName,  txtPhoneNumber, txtEmail, txtAddress;
    private JComboBox<String> comboGender;
    JDatePickerImpl datePicker;

    String id;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public JLabel getLblFirstName() {
        return lblFirstName;
    }

    public JLabel getLblLastName() {
        return lblLastName;
    }

    public JLabel getLblDateOfBirth() {
        return lblDateOfBirth;
    }

    public JLabel getLblGender() {
        return lblGender;
    }

    public JLabel getLblPhoneNumber() {
        return lblPhoneNumber;
    }

    public JLabel getLblEmail() {
        return lblEmail;
    }

    public JLabel getLblAddress() {
        return lblAddress;
    }

    public JTextField getTxtFirstName() {
        return txtFirstName;
    }

    public JTextField getTxtLastName() {
        return txtLastName;
    }

    public JTextField getTxtPhoneNumber() {
        return txtPhoneNumber;
    }

    public JTextField getTxtEmail() {
        return txtEmail;
    }

    public JTextField getTxtAddress() {
        return txtAddress;
    }

    public JComboBox<String> getComboGender() {
        return comboGender;
    }

//    public Date getDatePickerDate() {
//        return datePicker.getModel();
//    }

    public JDatePickerImpl getDatePicker() {
        return datePicker;
    }

    public FormPatient() {
        InitializedUI();
    }

    private void InitializedUI() {
        setLayout(new GridBagLayout());
        setSize(new Dimension(300,300));
        setBorder(new EmptyBorder(20,20,20,20));

        lblFirstName = new JLabel("Enter First Name:");
        lblLastName = new JLabel("Enter Last Name:");
        lblDateOfBirth = new JLabel("Select Date of Birth:");
        lblGender = new JLabel("Select Gender:");
        lblPhoneNumber = new JLabel("Enter Phone Number:");
        lblEmail = new JLabel("Enter Email address:");
        lblAddress = new JLabel("Enter Address:");

        txtFirstName = new JTextField(50);
        txtLastName = new JTextField(50);
        txtPhoneNumber = new JTextField(20);
        txtEmail = new JTextField(100);
        txtAddress = new JTextField(255);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        String[] genderOptions = {"Male", "Female", "Other"};
        comboGender = new JComboBox<>(genderOptions);

        //date picker-------
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        p.put("text.today", "Today");
        p.put("text.month", "Month");
        p.put("text.year", "Year");
        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());


        gbc.gridx = 0; gbc.gridy = 0;
        add(lblFirstName, gbc);

        gbc.gridx = 1; gbc.gridy = 0;
        gbc.weightx = 1.0;
        add(txtFirstName, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        gbc.weightx = 0.0;
        add(lblLastName, gbc);

        gbc.gridx = 1; gbc.gridy = 1;
        gbc.weightx = 1.0;
        add(txtLastName, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        add(lblDateOfBirth, gbc);

        gbc.gridx = 1; gbc.gridy = 2;
        add(datePicker, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        add(lblGender, gbc);

        gbc.gridx = 1; gbc.gridy = 3;
        add(comboGender, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        add(lblPhoneNumber, gbc);

        gbc.gridx = 1; gbc.gridy = 4;
        add(txtPhoneNumber, gbc);

        gbc.gridx = 0; gbc.gridy = 5;
        add(lblEmail, gbc);

        gbc.gridx = 1; gbc.gridy = 5;
        add(txtEmail, gbc);

        gbc.gridx = 0; gbc.gridy = 6;
        add(lblAddress, gbc);

        gbc.gridx = 1; gbc.gridy = 6;
        add(txtAddress, gbc);

        setVisible(true);
    }
}

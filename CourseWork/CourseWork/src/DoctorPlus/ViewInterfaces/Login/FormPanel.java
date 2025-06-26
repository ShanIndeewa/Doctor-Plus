package DoctorPlus.ViewInterfaces.Login;

import DoctorPlus.Controllers.LoginControll.LoginBtnEditor;
import DoctorPlus.ViewInterfaces.Components.RoundedButton;
import DoctorPlus.ObjectClasses.UserLogin;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class FormPanel extends JPanel {
    JLabel unameLbl;
    JLabel pwordLbl;
    JLabel errUname;
    JLabel errPword;
    JTextField uname;
    JPasswordField pword = null;
    JButton loginBtn;
    LoginScreen logFrame;

    public JLabel getErrUname() {
        return errUname;
    }

    public JLabel getErrPword() {
        return errPword;
    }

    public JTextField getUname() {
        return uname;
    }

    public JPasswordField getPword() {
        return pword;
    }

    public JButton getLoginBtn() {
        return loginBtn;
    }

    public LoginScreen getLogFrame() {
        return logFrame;
    }

    public FormPanel(LoginScreen l1) {
        logFrame=l1;
        InitializedUI();
        new LoginBtnEditor(this);
    }

    private void InitializedUI() {


        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;

        //username-------------------------------------------------------------------
        gbc.gridx = 0;
        gbc.gridy = 0;
        unameLbl = new JLabel("Enter Username");
        unameLbl.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
        unameLbl.setBorder(new EmptyBorder(10, 20, 10, 20));
        add(unameLbl,gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        uname = new JTextField(10);
        uname.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        add(uname,gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        errUname = new JLabel("Please fil Username field");
        errUname.setForeground(Color.red);
        errUname.setBorder(new EmptyBorder(10, 20, 10, 20));
        add(errUname,gbc);
        errUname.setVisible(false);

        //password----------------------------------------------------------------------
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 1;
        pwordLbl = new JLabel("Enter Password");
        pwordLbl.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,12));
        pwordLbl.setBorder(new EmptyBorder(10, 20, 10, 20));
        add(pwordLbl,gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        pword = new JPasswordField(10);
        pword.setFont(new Font(Font.SANS_SERIF,Font.PLAIN,20));
        add(pword,gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        errPword = new JLabel("Please fil Password field");
        errPword.setForeground(Color.red);
        errPword.setBorder(new EmptyBorder(10, 20, 10, 20));
        add(errPword,gbc);
        errPword.setVisible(false);

        //login button-------------------------------------------------------------------
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridwidth = 1;

        loginBtn = new RoundedButton("Log In",new Color(81, 206, 76 ));
        loginBtn.setFont(new Font(Font.SANS_SERIF,Font.BOLD,15));
        loginBtn.setForeground(Color.white);
        loginBtn.setSize(20,10);
        loginBtn.setBackground(new Color(81, 206, 76 ));
        add(loginBtn,gbc);

    }

    public UserLogin getUser() {
        UserLogin user = new UserLogin();
        user.setUserName(uname.getText());
        user.setPassWord(new String(pword.getPassword()));

        return  user;
    }

}

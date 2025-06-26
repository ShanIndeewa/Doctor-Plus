package DoctorPlus.Controllers.LoginControll;

import DoctorPlus.DatabaseControllers.LoginDBC;
import DoctorPlus.ViewInterfaces.Login.FormPanel;
import DoctorPlus.ObjectClasses.UserLogin;
import DoctorPlus.ViewInterfaces.MainScreen.MainScreen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LoginBtnEditor {
    private final JButton loginBtn;

    public LoginBtnEditor(FormPanel loginPanel) {
        this.loginBtn=loginPanel.getLoginBtn();

        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                try {
                    LoginDBC logDBC = new LoginDBC();

                    String pwordField = new String(loginPanel.getPword().getPassword());
                    String unameField = loginPanel.getUname().getText();
                    UserLogin logObj = loginPanel.getUser();

                    String pword = logDBC.checkPw(logObj);

                    int x = 0;
                    int y=0;
                    if(unameField.equals(""))
                    {
                        loginPanel.getErrUname().setVisible(true);
                        loginPanel.getUname().setBorder(BorderFactory.createLineBorder(Color.red));
                        x = 1;
                    }
                    else {
                        loginPanel.getErrUname().setVisible(false);
                        loginPanel.getUname().setBorder(BorderFactory.createLineBorder(Color.darkGray));
                        x=0;
                    }
                    if(pwordField.equals(""))
                    {
                        loginPanel.getErrPword().setVisible(true);
                        loginPanel.getPword().setBorder(BorderFactory.createLineBorder(Color.red));
                        y=1;
                    }
                    else {
                        loginPanel.getErrPword().setVisible(false);
                        loginPanel.getPword().setBorder(BorderFactory.createLineBorder(Color.darkGray));
                        y=0;
                    }

                    if (x == 0 && y == 0) {
                        if (pword.equals(pwordField)) {

                            new MainScreen("Doctor+","Dr."+logDBC.getDoctorName(logObj));
                            loginPanel.getLogFrame().dispose();

                        } else {
                            int response = JOptionPane.showConfirmDialog(
                                    null,
                                    "password incorrect",
                                    "Emergency alert",
                                    JOptionPane.CLOSED_OPTION,
                                    JOptionPane.ERROR_MESSAGE

                            );
                        }
                    }
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }


}

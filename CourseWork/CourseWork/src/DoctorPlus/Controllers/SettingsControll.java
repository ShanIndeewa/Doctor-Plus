package DoctorPlus.Controllers;

import DoctorPlus.DatabaseControllers.LoginDBC;
import DoctorPlus.DatabaseControllers.SettingsDBC;
import DoctorPlus.ObjectClasses.Doctor;
import DoctorPlus.ObjectClasses.UserLogin;
import DoctorPlus.ViewInterfaces.Settings.AddDoctorPanel;
import DoctorPlus.ViewInterfaces.Settings.FormDoctor;
import DoctorPlus.ViewInterfaces.Settings.SetLogin;
import DoctorPlus.ViewInterfaces.Settings.SetingsHomePanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class SettingsControll {
    AddDoctorPanel addDoctorPanel;
    FormDoctor formDoctor;
    SetLogin setLogin;
    SetingsHomePanel setingsHomePanel;

    public SettingsControll(AddDoctorPanel addDoctorPanel) {
        this.addDoctorPanel = addDoctorPanel;
        this.formDoctor = addDoctorPanel.getFormDoctor();
        this.setLogin = addDoctorPanel.getFormDoctor().getSetLogin();

        addDoctorPanel.getFooterPanel().getFunctionBtn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Doctor doctor =new Doctor();
                SettingsDBC settingsDBC = new SettingsDBC();

                doctor.setDoctorId(formDoctor.getTxtDoctorId().getText());
                doctor.setFirstName(formDoctor.getTxtFirstName().getText());
                doctor.setLastName(formDoctor.getTxtLastName().getText());
                doctor.setEmail(formDoctor.getTxtEmail().getText());
                doctor.setPhoneNumber(formDoctor.getTxtPhoneNumber().getText());
                doctor.setSpecialty(formDoctor.getTxtSpecialty().getText());

                UserLogin userLogin = new UserLogin();

                userLogin.setID(formDoctor.getTxtDoctorId().getText());
                userLogin.setUserName(formDoctor.getSetLogin().getTxtUserId().getText());
                userLogin.setPassWord(formDoctor.getSetLogin().getTxtPassword().getText());

                try {
                    settingsDBC.addDoctor(doctor);
                    settingsDBC.addUser(userLogin);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }


}

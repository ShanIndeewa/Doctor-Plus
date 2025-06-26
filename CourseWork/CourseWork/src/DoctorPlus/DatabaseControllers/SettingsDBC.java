package DoctorPlus.DatabaseControllers;

import DoctorPlus.ObjectClasses.Doctor;
import DoctorPlus.ObjectClasses.UserLogin;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SettingsDBC {
    DBConnection dbconnection;

    public SettingsDBC() {
        try {
            dbconnection = new DBConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int addDoctor(Doctor doctorObj) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT INTO Doctor (doctor_id, first_name, last_name, specialty, phone_number, email) ");
        sql.append("VALUES(?,?,?,?,?,?)");

        PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql.toString());
        ps.setString(1, doctorObj.getDoctorId());
        ps.setString(2, doctorObj.getFirstName());
        ps.setString(3, doctorObj.getLastName());
        ps.setString(4, doctorObj.getSpecialty());
        ps.setString(5, doctorObj.getPhoneNumber());
        ps.setString(6, doctorObj.getEmail());

        System.out.println(sql);

        int status = ps.executeUpdate();
        if (status > 0) {
            System.out.println("Record inserted successfully");
        }

        ps.close();

        return status;
    }

    public int addUser(UserLogin userObj) throws SQLException {
        StringBuilder sql = new StringBuilder("INSERT INTO User (user_id, password, doctor_id) ");
        sql.append("VALUES(?,?,?)");

        PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql.toString());
        ps.setString(1, userObj.getUserName());
        ps.setString(2, userObj.getPassWord());
        ps.setString(3, userObj.getID());

        System.out.println(sql);

        int status = ps.executeUpdate();
        if (status > 0) {
            System.out.println("Record inserted successfully");
        }

        ps.close();

        return status;
    }


}

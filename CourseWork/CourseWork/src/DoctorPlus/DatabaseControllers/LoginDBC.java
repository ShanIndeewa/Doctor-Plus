package DoctorPlus.DatabaseControllers;

import DoctorPlus.ObjectClasses.Doctor;
import DoctorPlus.ObjectClasses.UserLogin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDBC {
    DBConnection dbConnection;
    public LoginDBC() throws SQLException {
        dbConnection = new DBConnection();
    }

    public String checkPw(UserLogin user) throws SQLException {
        String pw ="";
        String id = "";
        String uname = user.getUserName().toString();

        PreparedStatement ps = dbConnection.getConnection().prepareStatement("SELECT * FROM Login WHERE user_id = ?");
        ps.setString(1,uname);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
          pw = rs.getString("password");
          id = rs.getString("doctor_id");
        }

        user.setID(id);
        System.out.println(id);
        rs.close();

        return pw;

    }

    public String getDoctorName(UserLogin user) throws SQLException {
        String id = user.getID();
        String fname ="",lname ="";

        PreparedStatement ps = dbConnection.getConnection().prepareStatement("SELECT * FROM Doctor WHERE doctor_id = ?");
        ps.setString(1,id);

        ResultSet rs = ps.executeQuery();
        while (rs.next()) {
            fname = rs.getString("first_name");
            lname = rs.getString("last_name");
        }

        rs.close();

        return fname+" "+lname;
    }


    public Doctor getDoctorById(String doctorId) {
        Doctor doctor = null;

        String query = "SELECT * FROM Doctor WHERE doctor_id = '" + doctorId + "'";

        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                doctor = new Doctor();
                doctor.setDoctorId(rs.getString("doctor_id"));
                doctor.setFirstName(rs.getString("first_name"));
                doctor.setLastName(rs.getString("last_name"));
                doctor.setSpecialty(rs.getString("specialty"));
                doctor.setPhoneNumber(rs.getString("phone_number"));
                doctor.setEmail(rs.getString("email"));
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return doctor;
    }
}

package DoctorPlus.DatabaseControllers;

import DoctorPlus.ObjectClasses.Patient;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PatientDBC {

    DBConnection dbconnection;

    public PatientDBC() throws SQLException {
        this.dbconnection = new DBConnection();
    }

    public DefaultTableModel addDataToTable(DefaultTableModel model)
    {
        try {
            Statement statement = dbconnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Patient");

            while (rs.next())
            {
                model.addRow(new Object[]{
                        rs.getString("patient_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("date_of_birth"),
                        rs.getString("gender"),
                        rs.getString("phone_number"),
                        rs.getString("email"),
                        rs.getString("address")
                });
            }
            rs.close();
            statement.close();
            return model;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public int deleteById(String id) throws SQLException {

        String sql = "DELETE FROM Patient WHERE patient_id = ?";
        PreparedStatement preparedStatement = dbconnection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1, id);
        int status = preparedStatement.executeUpdate();
        if (status > 0) {
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("No record found with the given id.");
        }

        return status;

    }

    public String getLastPatientId() {
        String lastPatientId = null;

        String query = "SELECT MAX(patient_id) AS last_id FROM Patient";

        try (Statement stmt = dbconnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                lastPatientId = rs.getString("last_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastPatientId;
    }

    public int addPatient(Patient patientObj) throws SQLException {

            StringBuilder sql = new StringBuilder("INSERT INTO Patient (patient_id,first_name, last_name, date_of_birth, gender, phone_number, email, address) ");
            sql.append("VALUES(?,?,?,?,?,?,?,?)");


            PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql.toString());
            ps.setString(1, patientObj.getPatientId());
            ps.setString(2, patientObj.getFirstName().toString());
            ps.setString(3, patientObj.getLastName().toString());
            ps.setDate(4, patientObj.getDateOfBirth());
            ps.setString(5, patientObj.getGender().toString());
            ps.setString(6, patientObj.getPhoneNumber().toString());
            ps.setString(7, patientObj.getEmail().toString());
            ps.setString(8, patientObj.getAddress().toString());

        System.out.println(sql);

            int status = ps.executeUpdate();
            if (status > 0) {
                System.out.println("Record inserted successfully");
            }

            ps.close();

        return 0;
    }

    public int updatePatient(Patient patientObj) throws SQLException {

        StringBuilder sql = new StringBuilder("UPDATE Patient SET ");
        sql.append("first_name = ?, ");
        sql.append("last_name = ?, ");
        sql.append("date_of_birth = ?, ");
        sql.append("gender = ?, ");
        sql.append("phone_number = ?, ");
        sql.append("email = ?, ");
        sql.append("address = ? ");
        sql.append("WHERE patient_id = ?");

        PreparedStatement ps = dbconnection.getConnection().prepareStatement(sql.toString());


        ps.setString(1, patientObj.getFirstName());
        ps.setString(2, patientObj.getLastName());
        ps.setDate(3, patientObj.getDateOfBirth());
        ps.setString(4, patientObj.getGender());
        ps.setString(5, patientObj.getPhoneNumber());
        ps.setString(6, patientObj.getEmail());
        ps.setString(7, patientObj.getAddress());
        ps.setString(8, patientObj.getPatientId());

        System.out.println(sql);

        int status = ps.executeUpdate();
        if (status > 0) {
            System.out.println("Record updated successfully");
        }

        ps.close();

        return status;
    }

    public Patient getPatientById(String patientId) {
        Patient patient = null;

        String query = "SELECT * FROM Patient WHERE patient_id = '" + patientId + "'";

        try {
            Statement statement = dbconnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery(query);

            if (rs.next()) {
                patient = new Patient();
                patient.setPatientId(rs.getString("patient_id"));
                patient.setFirstName(rs.getString("first_name"));
                patient.setLastName(rs.getString("last_name"));

                patient.setGender(rs.getString("gender"));
                patient.setPhoneNumber(rs.getString("phone_number"));
                patient.setEmail(rs.getString("email"));
                patient.setAddress(rs.getString("address"));
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return patient;
    }

}

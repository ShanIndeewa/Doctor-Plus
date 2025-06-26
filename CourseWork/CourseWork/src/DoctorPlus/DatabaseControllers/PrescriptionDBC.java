package DoctorPlus.DatabaseControllers;

import DoctorPlus.ObjectClasses.Medicine;
import DoctorPlus.ObjectClasses.Prescription;

import javax.swing.table.DefaultTableModel;
import java.sql.*;

public class PrescriptionDBC {
    DBConnection dbconnection;

    public PrescriptionDBC() throws SQLException {
        dbconnection = new DBConnection();
    }

    public DefaultTableModel addDataToTable(DefaultTableModel model) throws SQLException {
        String query = "SELECT medicine_id, name, description, dosage FROM Medicine";
        Connection connection = dbconnection.getConnection();
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(query);

        while (rs.next()) {
            model.addRow(new Object[]{
                    rs.getString("medicine_id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getString("dosage")
            });
        }

        rs.close();
        statement.close();

        return model;
    }


    public String getLastPrescriptionId() {
        String lastPrescriptionId = null;

        String query = "SELECT MAX(prescription_id) AS last_id FROM Prescription";

        try (Statement stmt = dbconnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                lastPrescriptionId = rs.getString("last_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastPrescriptionId;
    }

    public void insertPrescription(Prescription prescription) throws SQLException {
        String query = "INSERT INTO DoctorAssign (doctor_id, patient_id, prescription_id) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = dbconnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, "D001");
            pstmt.setString(2, prescription.getPatientID());
            pstmt.setString(3, prescription.getPrescriptionId());

            pstmt.executeUpdate();
        }
    }

    public void insertMedicineAssign(Prescription prescription, Medicine medicine) throws SQLException {
        String query = "INSERT INTO MedicineAssign (prescription_id, medicine_id, quantity) VALUES (?, ?, ?)";

        try (PreparedStatement pstmt = dbconnection.getConnection().prepareStatement(query)) {
            pstmt.setString(1, prescription.getPrescriptionId());
            pstmt.setString(2, medicine.getMedicineId());
            pstmt.setString(3, medicine.getDosage());

            pstmt.executeUpdate();
        }
    }

}

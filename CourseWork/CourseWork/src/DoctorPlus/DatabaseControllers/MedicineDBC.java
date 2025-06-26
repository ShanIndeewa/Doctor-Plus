package DoctorPlus.DatabaseControllers;

import DoctorPlus.ObjectClasses.Medicine;

import javax.swing.table.DefaultTableModel;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MedicineDBC {

    DBConnection dbConnection;
    public MedicineDBC() throws SQLException {
        dbConnection = new DBConnection();
    }

    public DefaultTableModel addDataToTable(DefaultTableModel model) {
        try {
            Statement statement = dbConnection.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM Medicine");

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
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int deleteById(String id) throws SQLException {

        String sql = "DELETE FROM Medicine WHERE medicine_id = ?";
        PreparedStatement preparedStatement = dbConnection.getConnection().prepareStatement(sql);

        preparedStatement.setString(1, id);
        int status = preparedStatement.executeUpdate();
        if (status > 0) {
            System.out.println("Record deleted successfully");
        } else {
            System.out.println("No record found with the given id.");
        }

        return status;
    }

    public String getLastMedicineId() {
        String lastMedicineId = null;

        String query = "SELECT MAX(medicine_id) AS last_id FROM Medicine";

        try (Statement stmt = dbConnection.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            if (rs.next()) {
                lastMedicineId = rs.getString("last_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lastMedicineId;
    }


    public int addMedicine(Medicine medicineObj) throws SQLException {

        StringBuilder sql = new StringBuilder("INSERT INTO Medicine (medicine_id, name, description, dosage) ");
        sql.append("VALUES(?,?,?,?)");

        PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql.toString());
        ps.setString(1, medicineObj.getMedicineId());
        ps.setString(2, medicineObj.getName());
        ps.setString(3, medicineObj.getDescription());
        ps.setString(4, String.valueOf(medicineObj.getDosage()));

        System.out.println(sql);

        int status = ps.executeUpdate();
        if (status > 0) {
            System.out.println("Record inserted successfully");
        }

        ps.close();

        return status;
    }

    public int updateMedicine(Medicine medicineObj) throws SQLException {

        StringBuilder sql = new StringBuilder("UPDATE Medicine SET ");
        sql.append("name = ?, ");
        sql.append("description = ?, ");
        sql.append("dosage = ? ");
        sql.append("WHERE medicine_id = ?");

        PreparedStatement ps = dbConnection.getConnection().prepareStatement(sql.toString());

        ps.setString(1, medicineObj.getName());
        ps.setString(2, medicineObj.getDescription());
        ps.setString(3, String.valueOf(medicineObj.getDosage()));
        ps.setString(4, medicineObj.getMedicineId());

        int status = ps.executeUpdate();
        if (status > 0) {
            System.out.println("Record updated successfully");
        }

        ps.close();

        return status;
    }



}

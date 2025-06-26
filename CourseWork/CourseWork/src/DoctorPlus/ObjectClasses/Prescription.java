package DoctorPlus.ObjectClasses;

import DoctorPlus.DatabaseControllers.PrescriptionDBC;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class Prescription {
    private String prescriptionId;
    private String timePeriod;
    private String instructions;
    private java.util.Date prescriptionDate;
    private String patientID;
    ArrayList<Medicine> medicineList;

    public Prescription( String timePeriod, String instructions,String patientID) {
        try {
            this.prescriptionId = getNextPrescriptionId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        this.timePeriod = timePeriod;
        this.instructions = instructions;
        this.patientID = patientID;
        this.prescriptionDate = new java.util.Date(Calendar.getInstance().getTimeInMillis());
        medicineList = new ArrayList<>();
    }

    public Prescription() {
        try {
            this.prescriptionId = getNextPrescriptionId();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        this.prescriptionDate = new java.util.Date(Calendar.getInstance().getTimeInMillis());
        medicineList = new ArrayList<>();
    }

    public void setPrescriptionId(String prescriptionId) {
        this.prescriptionId = prescriptionId;
    }

    public void setTimePeriod(String timePeriod) {
        this.timePeriod = timePeriod;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }

    public String getPatientID() {
        return patientID;
    }

    public String getPrescriptionId() {
        return prescriptionId;
    }

    public String getTimePeriod() {
        return timePeriod;
    }

    public String getInstructions() {
        return instructions;
    }

    public Date getPrescriptionDate() {
        return prescriptionDate;
    }

    public static String getNextPrescriptionId() throws SQLException {
        PrescriptionDBC prescriptionDBC = new PrescriptionDBC();
        String nextId = null;
        String lastId = prescriptionDBC.getLastPrescriptionId();

        if (lastId != null && lastId.length() > 1) {
            String prefix = lastId.substring(0, 1);
            int numericPart = Integer.parseInt(lastId.substring(1));
            numericPart++;
            nextId = String.format("%s%03d", prefix, numericPart);
        } else {
            nextId = "PRE001";
        }

        return nextId;
    }

    public void addMedicine(Medicine medicine){
        medicineList.add(medicine);
    }

    public ArrayList getMedicineArray()
    {
        return medicineList;
    }

}

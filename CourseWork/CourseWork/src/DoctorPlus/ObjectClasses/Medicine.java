package DoctorPlus.ObjectClasses;

import DoctorPlus.DatabaseControllers.MedicineDBC;
import DoctorPlus.DatabaseControllers.PatientDBC;

import java.sql.SQLException;

public class Medicine {
    private String medicineId;
    private String name;
    private String description;
    private String dosage;

    public void setMedicineId(String medicineId) {
        this.medicineId = medicineId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public Medicine(String medicineId, String name, String description, String dosage) {
        this.medicineId = medicineId;
        this.name = name;
        this.description = description;
        this.dosage = dosage;
    }


    public Medicine() {
        setMedicineId();
    }

    public String getMedicineId() {
        return medicineId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getDosage() {
        return dosage;
    }


    public static String getNextId() throws SQLException {
        MedicineDBC medicineDBC = new MedicineDBC();
        String nextId = null;
        String lastId = medicineDBC.getLastMedicineId();

        if (lastId != null && lastId.length() > 3) {
            String prefix = lastId.substring(0, 3);
            int numericPart = Integer.parseInt(lastId.substring(3));
            numericPart++;
            nextId = String.format("%s%03d", prefix, numericPart);
        } else {
            nextId = "MED001";
        }

        return nextId;
    }


    public void setMedicineId()  {
        try {
            this.medicineId = getNextId();
        }
        catch (SQLException e)
        {
            throw new RuntimeException();
        }

    }

}

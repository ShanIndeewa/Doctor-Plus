package DoctorPlus.ObjectClasses;

import DoctorPlus.DatabaseControllers.PatientDBC;

import java.sql.SQLException;
import java.util.Date;

public class Patient {
    private String patientId;
    private String firstName;
    private String lastName;
    private java.util.Date dateOfBirth;
    private String gender;  //  'Male', 'Female', 'Other'
    private String phoneNumber;
    private String email;
    private String address;

    public Patient(String patientId, String firstName, String lastName, Date dateOfBirth, String gender, String phoneNumber, String email, String address) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.address = address;

    }

    public Patient() {
        setPatientId();
    }

    public void setPatientId()  {
        try {
            this.patientId = getNextId();
        }
        catch (SQLException e)
        {
            throw new RuntimeException();
        }

    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public java.sql.Date getDateOfBirth() {
        return new java.sql.Date(dateOfBirth.getTime());
    }

    public String getGender() {
        return gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public static String getNextId() throws SQLException {
        PatientDBC patientDBC = new PatientDBC();
        String nextId = null;
        String lastId = patientDBC.getLastPatientId();

            if (lastId != null && lastId.length() > 1) {
                String prefix = lastId.substring(0, 1);
                int numericPart = Integer.parseInt(lastId.substring(1));
                numericPart++;
                nextId = String.format("%s%03d", prefix, numericPart);
            } else {
                nextId = "P001";
            }

            return nextId;
    }


}

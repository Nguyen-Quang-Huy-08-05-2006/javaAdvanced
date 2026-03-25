package Sess13.Bai05;

public class Patient {
    private int patientId;
    private String fullName;
    private int age;
    private int bedId;
    private double advanceAmount;

    public Patient() {
    }

    public Patient(int patientId, String fullName, int age, int bedId, double advanceAmount) {
        this.patientId = patientId;
        this.fullName = fullName;
        this.age = age;
        this.bedId = bedId;
        this.advanceAmount = advanceAmount;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getBedId() {
        return bedId;
    }

    public void setBedId(int bedId) {
        this.bedId = bedId;
    }

    public double getAdvanceAmount() {
        return advanceAmount;
    }

    public void setAdvanceAmount(double advanceAmount) {
        this.advanceAmount = advanceAmount;
    }
}

package Sess13.Bai05;

public class FinanceRecord {
    private int recordId;
    private int patientId;
    private double amount;
    private String description;

    public FinanceRecord() {
    }

    public FinanceRecord(int recordId, int patientId, double amount, String description) {
        this.recordId = recordId;
        this.patientId = patientId;
        this.amount = amount;
        this.description = description;
    }

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
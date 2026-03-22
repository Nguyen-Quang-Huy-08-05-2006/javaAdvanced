package Sess11.Bai04;

public class Main {
    public static void main(String[] args) {
        PatientDAO dao = new PatientDAO();

        dao.findPatientByName("Nguyen Van A");

        dao.findPatientByName("' OR '1'='1");
    }
}
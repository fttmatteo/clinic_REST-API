package app.domain.model;

public class Billing {
    private String id;
    private String patientId;
    private double totalAmount;

    public Billing(String id, String patientId, double totalAmount) {
        this.id = id;
        this.patientId = patientId;
        this.totalAmount = totalAmount;
    }

    public String getId() { return id; }
    public String getPatientId() { return patientId; }
    public double getTotalAmount() { return totalAmount; }
}

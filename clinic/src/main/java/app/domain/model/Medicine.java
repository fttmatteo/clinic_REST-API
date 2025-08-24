package app.domain.model;

public class Medicine {
    private int orderId;
    private int medicineId;
    private int dose;
    private String treatmentDuration;
    private int item;
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getMedicineId() {
        return medicineId;
    }
    public void setMedicineId(int medicineId) {
        this.medicineId = medicineId;
    }
    public int getDose() {
        return dose;
    }
    public void setDose(int dose) {
        this.dose = dose;
    }
    public String getTreatmentDuration() {
        return treatmentDuration;
    }
    public void setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }
    public int getItem() {
        return item;
    }
    public void setItem(int item) {
        this.item = item;
    }
}

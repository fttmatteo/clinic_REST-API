package app.domain.model;

public class ProcedureMedication {
    private String orderProcedure;
    private int id;
    private int quantity;
    private String frequency;
    private boolean specialistRequired;
    private String specialtyId;
    private String itemId;
    public String getOrderProcedure() {
        return orderProcedure;
    }
    public void setOrderProcedure(String orderProcedure) {
        this.orderProcedure = orderProcedure;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    public String getFrequency() {
        return frequency;
    }
    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }
    public boolean isSpecialistRequired() {
        return specialistRequired;
    }
    public void setSpecialistRequired(boolean specialistRequired) {
        this.specialistRequired = specialistRequired;
    }
    public String getSpecialtyId() {
        return specialtyId;
    }
    public void setSpecialtyId(String specialtyId) {
        this.specialtyId = specialtyId;
    }
    public String getitemId() {
        return itemId;
    }
    public void setitemId(String itemId) {
        this.itemId = itemId;
    }
}

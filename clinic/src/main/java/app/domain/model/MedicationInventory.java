package app.domain.model;

public class MedicationInventory {
    private String id;
    private String name;
    private int quantity;

    public MedicationInventory(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
}

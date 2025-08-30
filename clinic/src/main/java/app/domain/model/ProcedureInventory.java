package app.domain.model;

public class ProcedureInventory {
    private String id;
    private String name;
    private int quantity;

    public ProcedureInventory(String id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public int getQuantity() { return quantity; }
}

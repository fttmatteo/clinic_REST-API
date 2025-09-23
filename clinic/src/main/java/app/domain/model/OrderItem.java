package app.domain.model;

public class OrderItem {
    private Long id;                  // identificador único del ítem dentro de la orden
    private String name;              // nombre del medicamento, procedimiento o ayuda diagnóstica
    private OrderItemType type;       // enum: MEDICINE, PROCEDURE, DIAGNOSTIC_AID
    private String dose;              // solo aplica si es medicamento
    private Integer quantity;         // cantidad de veces (puede aplicar a procedimientos o exámenes)
    private String frequency;         // ej: cada 8 horas (procedimiento, medicamento)
    private boolean specialistRequired; // true si requiere especialista
    private String specialistType;    // tipo de especialista si aplica
    private Double cost;              // costo del ítem

    // Constructor
    public OrderItem(Long id, String name, OrderItemType type, String dose, Integer quantity,
                     String frequency, boolean specialistRequired, String specialistType, Double cost) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dose = dose;
        this.quantity = quantity;
        this.frequency = frequency;
        this.specialistRequired = specialistRequired;
        this.specialistType = specialistType;
        this.cost = cost;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public OrderItemType getType() { return type; }
    public void setType(OrderItemType type) { this.type = type; }

    public String getDose() { return dose; }
    public void setDose(String dose) { this.dose = dose; }

    public Integer getQuantity() { return quantity; }
    public void setQuantity(Integer quantity) { this.quantity = quantity; }

    public String getFrequency() { return frequency; }
    public void setFrequency(String frequency) { this.frequency = frequency; }

    public boolean isSpecialistRequired() { return specialistRequired; }
    public void setSpecialistRequired(boolean specialistRequired) { this.specialistRequired = specialistRequired; }

    public String getSpecialistType() { return specialistType; }
    public void setSpecialistType(String specialistType) { this.specialistType = specialistType; }

    public Double getCost() { return cost; }
    public void setCost(Double cost) { this.cost = cost; }

    @Override
    public String toString() {
        return "Ítem de orden: " + name + " (Tipo: " + type + ")";
    }
}

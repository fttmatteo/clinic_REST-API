package app.domain.model;

import app.domain.model.enums.OrderItemType;

/**
 * Representa un ítem dentro de una orden médica. Dependiendo del tipo de
 * ítem (medicamento, procedimiento o ayuda diagnóstica) algunos campos
 * tendrán valor y otros no. Los números de ítem dentro de una orden deben
 * comenzar en 1 y ser únicos. Cuando el ítem corresponde a un procedimiento
 * o ayuda diagnóstica, puede requerir la intervención de un especialista y
 * asociarse a un tipo de especialidad.
 */
public class OrderItem {

    private long id;
    /** Número de ítem dentro de la orden (comienza en 1). */
    private int itemNumber;
    /** Tipo del ítem (MEDICINE, PROCEDURE, DIAGNOSTIC_AID). */
    private OrderItemType type;
    /** Nombre del medicamento, procedimiento o ayuda diagnóstica. */
    private String name;
    /** Dosis del medicamento (solo aplica a medicamentos). */
    private String dose;
    /** Duración del tratamiento (solo aplica a medicamentos). */
    private String treatmentDuration;
    /** Cantidad de veces que se repite el procedimiento o ayuda diagnóstica. */
    private Integer quantity;
    /** Frecuencia con la que se repite el procedimiento (solo aplica a procedimientos). */
    private String frequency;
    /** Costo unitario asociado al ítem. */
    private Double cost;
    /** Indica si se requiere asistencia de un especialista (aplica a procedimientos y ayudas diagnósticas). */
    private Boolean requiresSpecialist;
    /** Identificador del tipo de especialidad (en caso de requerirse). */
    private String specialistTypeId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getItemNumber() {
        return itemNumber;
    }

    public void setItemNumber(int itemNumber) {
        this.itemNumber = itemNumber;
    }

    public OrderItemType getType() {
        return type;
    }

    public void setType(OrderItemType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDose() {
        return dose;
    }

    public void setDose(String dose) {
        this.dose = dose;
    }

    public String getTreatmentDuration() {
        return treatmentDuration;
    }

    public void setTreatmentDuration(String treatmentDuration) {
        this.treatmentDuration = treatmentDuration;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Boolean getRequiresSpecialist() {
        return requiresSpecialist;
    }

    public void setRequiresSpecialist(Boolean requiresSpecialist) {
        this.requiresSpecialist = requiresSpecialist;
    }

    public String getSpecialistTypeId() {
        return specialistTypeId;
    }

    public void setSpecialistTypeId(String specialistTypeId) {
        this.specialistTypeId = specialistTypeId;
    }
}
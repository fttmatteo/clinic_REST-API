package app.domain.ports;

import app.domain.model.MedicationInventory;

public interface MedicationInventoryPort {
    void save(MedicationInventory medicationInventory);
}

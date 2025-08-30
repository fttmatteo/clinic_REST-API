package app.domain.services;

import app.domain.model.MedicationInventory;
import app.domain.ports.MedicationInventoryPort;

public class UpdateMedicationInventory {
    private final MedicationInventoryPort medicationInventoryPort;

    public UpdateMedicationInventory(MedicationInventoryPort medicationInventoryPort) {
        this.medicationInventoryPort = medicationInventoryPort;
    }
    public void update(MedicationInventory medication) throws Exception {
        if (medication.getId() == null || medication.getId().isEmpty()) {
            throw new Exception("El ID del medicamento es obligatorio");
        }
        if (medication.getName() == null || medication.getName().isEmpty()) {
            throw new Exception("El nombre del medicamento es obligatorio");
        }
        if (medication.getQuantity() < 0) {
            throw new Exception("La cantidad no puede ser negativa");
        }

        medicationInventoryPort.save(medication);
    }
}

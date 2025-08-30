package app.domain.services;

import app.domain.model.ProcedureInventory;
import app.domain.ports.ProcedureInventoryPort;

public class UpdateProcedureInventory {
    private final ProcedureInventoryPort procedureInventoryPort;

    public UpdateProcedureInventory(ProcedureInventoryPort procedureInventoryPort) {
        this.procedureInventoryPort = procedureInventoryPort;
    }
    public void update(ProcedureInventory procedure) throws Exception {
        if (procedure.getId() == null || procedure.getId().isEmpty()) {
            throw new Exception("El ID del procedimiento es obligatorio");
        }
        if (procedure.getName() == null || procedure.getName().isEmpty()) {
            throw new Exception("El nombre del procedimiento es obligatorio");
        }
        if (procedure.getQuantity() < 0) {
            throw new Exception("La cantidad no puede ser negativa");
        }

        procedureInventoryPort.save(procedure);
    }
}

package app.domain.services;

import app.domain.model.DiagnosticInventory;
import app.domain.ports.DiagnosticInventoryPort;

public class UpdateDiagnosticInventory {
    private final DiagnosticInventoryPort diagnosticInventoryPort;

    public UpdateDiagnosticInventory(DiagnosticInventoryPort diagnosticInventoryPort) {
        this.diagnosticInventoryPort = diagnosticInventoryPort;
    }
    public void update(DiagnosticInventory diagnostic) throws Exception {
        if (diagnostic.getId() == null || diagnostic.getId().isEmpty()) {
            throw new Exception("El ID de la ayuda diagnóstica es obligatorio");
        }
        if (diagnostic.getName() == null || diagnostic.getName().isEmpty()) {
            throw new Exception("El nombre de la ayuda diagnóstica es obligatorio");
        }
        if (diagnostic.getQuantity() < 0) {
            throw new Exception("La cantidad no puede ser negativa");
        }

        diagnosticInventoryPort.save(diagnostic);
    }
}

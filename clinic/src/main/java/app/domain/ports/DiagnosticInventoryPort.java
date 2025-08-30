package app.domain.ports;

import app.domain.model.DiagnosticInventory;

public interface DiagnosticInventoryPort {
    void save(DiagnosticInventory diagnosticInventory);
}

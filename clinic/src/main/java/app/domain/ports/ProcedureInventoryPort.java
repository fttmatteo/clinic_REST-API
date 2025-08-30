package app.domain.ports;

import app.domain.model.ProcedureInventory;

public interface ProcedureInventoryPort {
    void save(ProcedureInventory procedureInventory) throws Exception;
}

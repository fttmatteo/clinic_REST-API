package app.domain.ports;

import app.domain.model.ProcedureRecord;

public interface ProcedureRecordPort {
    void save(ProcedureRecord procedureRecord);
}

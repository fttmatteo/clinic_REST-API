package app.domain.services;

import app.domain.model.ProcedureRecord;
import app.domain.ports.ProcedureRecordPort;

public class RecordProcedure {
    private final ProcedureRecordPort procedureRecordPort;

    public RecordProcedure(ProcedureRecordPort procedureRecordPort) {
        this.procedureRecordPort = procedureRecordPort;
    }

    public void create(String patientId, String procedimiento) throws Exception {
        if (patientId == null || patientId.isEmpty()) {
            throw new Exception("El paciente es obligatorio");
        }
        if (procedimiento == null || procedimiento.isEmpty()) {
            throw new Exception("El procedimiento es obligatorio");
        }

        ProcedureRecord record = new ProcedureRecord(patientId, procedimiento);
        procedureRecordPort.save(record);
    }
}

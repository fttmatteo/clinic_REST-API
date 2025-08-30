package app.domain.services;

import app.domain.model.MedicationRecord;
import app.domain.ports.MedicationRecordPort;

public class ApplyMedication {
    private final MedicationRecordPort medicationRecordPort;

    public ApplyMedication(MedicationRecordPort medicationRecordPort) {
        this.medicationRecordPort = medicationRecordPort;
    }

    public void create(String patientId, String medicamento, String dosis) throws Exception {
        if (patientId == null || patientId.isEmpty()) {
            throw new Exception("El paciente es obligatorio");
        }
        if (medicamento == null || medicamento.isEmpty()) {
            throw new Exception("El nombre del medicamento es obligatorio");
        }
        if (dosis == null || dosis.isEmpty()) {
            throw new Exception("La dosis es obligatoria");
        }

        MedicationRecord record = new MedicationRecord(patientId, medicamento, dosis);
        medicationRecordPort.save(record);
    }
}

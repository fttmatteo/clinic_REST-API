package app.domain.ports;

import app.domain.model.MedicationRecord;

public interface MedicationRecordPort {
    void save(MedicationRecord medicationRecord);
}

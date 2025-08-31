package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class PatientService {
    private PatientPort patientPort;

    public PatientService(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void savePatient(Patient patient) throws Exception {
        patientPort.save(patient);
    }

    public Patient findPatientByDocument(Patient patient) throws Exception {
        return patientPort.findByDocument(patient);
    }
}

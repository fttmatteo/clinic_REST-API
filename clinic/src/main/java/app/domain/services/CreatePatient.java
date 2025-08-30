package app.domain.services;

import app.domain.model.Patient;
import app.domain.ports.PatientPort;

public class CreatePatient {
    private final PatientPort patientPort;

    public CreatePatient(PatientPort patientPort) {
        this.patientPort = patientPort;
    }

    public void create(Patient patient) throws Exception {

        if (patient.getId() <= 0) {
            throw new Exception("El ID del paciente es obligatorio");
        }


        if (patient.getDocument() <= 0) {
            throw new Exception("El número de documento es obligatorio");
        }

        if (patient.getFullName() == null || patient.getFullName().isEmpty()) {
            throw new Exception("El nombre completo es obligatorio");
        }

        if (patient.getAge() <= 0 || patient.getAge() > 150) {
            throw new Exception("La edad no es válida");
        }


        if (patient.getPhone() <= 0) {
            throw new Exception("El teléfono es obligatorio");
        }


        if (patient.getEmergencyPhone() <= 0) {
            throw new Exception("El teléfono de emergencia es obligatorio");
        }


        Patient existing = patientPort.findByDocument(patient);
        if (existing != null) {
            throw new Exception("Ya existe un paciente con este documento");
        }

        patientPort.save(patient);
    }
}

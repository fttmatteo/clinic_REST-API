package app.domain.services;

import app.domain.model.ClinicalOrder;
import app.domain.model.Patient;
import app.domain.model.User;
import app.domain.ports.ClinicalOrderPort;
import app.domain.ports.PatientPort;
import app.domain.ports.UserPort;

import java.sql.Date;

public class CreateClinicalOrder {
    private final UserPort userPort;
    private final PatientPort patientPort;
    private final ClinicalOrderPort clinicalOrderPort;

    public CreateClinicalOrder(UserPort userPort, PatientPort patientPort, ClinicalOrderPort clinicalOrderPort) {
        this.userPort = userPort;
        this.patientPort = patientPort;
        this.clinicalOrderPort = clinicalOrderPort;
    }

    public void create(ClinicalOrder clinicalOrder) throws Exception {
        User doctor = new User();
        doctor.setNationalId(clinicalOrder.getDoctorId());
        doctor = userPort.findByDocument(doctor);

        if (doctor == null || doctor.getRole() == null || !doctor.getRole().equalsIgnoreCase("DOCTOR")) {
            throw new Exception("Las órdenes solo las puede crear un usuario con rol DOCTOR");
        }

        Patient patient = new Patient();
        patient.searchByName(clinicalOrder.getFullName());
        patient = patientPort.findByDocument(patient);

        if (patient == null) {
            throw new Exception("La orden debe asociarse a un paciente registrado");
        }

        if (clinicalOrder.getCreatedAt() == null) {
            clinicalOrder.setCreatedAt(new Date(System.currentTimeMillis()));
        }

        clinicalOrderPort.save(clinicalOrder);
    }
}

package app.application.usecase;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.MedicalInsurance;
import app.domain.model.Patient;
import app.domain.services.AssignInsurance;
import app.domain.services.RegisterPatient;

@Service
public class AdministrativeUseCase {

    @Autowired
    private RegisterPatient registerPatient;

    @Autowired
    private AssignInsurance assignInsurance;

    public void registerPatient(Patient patient) throws Exception {
        registerPatient.create(patient);
    }

    public void assignInsurance(int patientDocument, MedicalInsurance medicalInsurance) throws Exception {
        assignInsurance.assign(patientDocument, medicalInsurance);
    }
}

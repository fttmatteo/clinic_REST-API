package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.PatientValidator;
import app.domain.model.MedicalInsurance;
import app.domain.model.Patient;

@Component
public class PatientBuilder {

    @Autowired private PatientValidator validator;

    public Patient build(
        String document,
        String fullName,
        String birthDate,
        String gender,
        String address,
        String phoneNumber,
        String email,
        String emergencyFirstName,
        String emergencyLastName,
        String relationShip,
        String emergencyPhone,
        MedicalInsurance insurance
    ) throws Exception {

        Patient patient = new Patient();
        patient.setDocument(validator.documentValidator(document));
        patient.setFullName(validator.fullNameValidator(fullName));
        patient.setBirthDate(validator.birthDateValidator(birthDate));
        patient.setGender(validator.genderValidator(gender));
        patient.setAddress(validator.addressValidator(address));
        patient.setPhoneNumber(validator.phoneNumberValidator(phoneNumber));
        patient.setEmail(validator.emailValidatorField(email));
        patient.setEmergencyFirstName(validator.emergencyFirstNameValidator(emergencyFirstName));
        patient.setEmergencyLastName(validator.emergencyLastNameValidator(emergencyLastName));
        patient.setRelationShip(validator.relationShipValidator(relationShip));
        patient.setEmergencyPhone(validator.emergencyPhoneValidator(emergencyPhone));
        patient.setInsurancePolicy(insurance);
        return patient;
    }
}

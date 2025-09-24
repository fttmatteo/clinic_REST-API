package app.adapter.in.builder;

import java.sql.Date;
import app.domain.model.MedicalInsurance;
import app.domain.model.Patient;

public class PatientBuilder {
    private Integer patientDocument;
    private String fullName;
    private Date birthDate;
    private String gender;
    private String address;
    private String phoneNumber;
    private String email;
    private String emergencyFirstName;
    private String emergencyLastName;
    private String relationShip;
    private Integer emergencyPhone;
    private MedicalInsurance insurancePolicy;

    public PatientBuilder withPatientDocument(Integer v){ this.patientDocument = v; return this; }
    public PatientBuilder withFullName(String v){ this.fullName = v; return this; }
    public PatientBuilder withBirthDate(Date v){ this.birthDate = v; return this; }
    public PatientBuilder withGender(String v){ this.gender = v; return this; }
    public PatientBuilder withAddress(String v){ this.address = v; return this; }
    public PatientBuilder withPhoneNumber(String v){ this.phoneNumber = v; return this; }
    public PatientBuilder withEmail(String v){ this.email = v; return this; }
    public PatientBuilder withEmergencyFirstName(String v){ this.emergencyFirstName = v; return this; }
    public PatientBuilder withEmergencyLastName(String v){ this.emergencyLastName = v; return this; }
    public PatientBuilder withRelationShip(String v){ this.relationShip = v; return this; }
    public PatientBuilder withEmergencyPhone(Integer v){ this.emergencyPhone = v; return this; }
    public PatientBuilder withInsurancePolicy(MedicalInsurance v){ this.insurancePolicy = v; return this; }

    public Patient build(){
        Patient x = new Patient();
        x.setPatientDocument(patientDocument);
        x.setFullName(fullName);
        x.setBirthDate(birthDate);
        x.setGender(gender);
        x.setAddress(address);
        x.setPhoneNumber(phoneNumber);
        x.setEmail(email);
        x.setEmergencyFirstName(emergencyFirstName);
        x.setEmergencyLastName(emergencyLastName);
        x.setRelationShip(relationShip);
        x.setEmergencyPhone(emergencyPhone);
        x.setInsurancePolicy(insurancePolicy);
        return x;
    }
}

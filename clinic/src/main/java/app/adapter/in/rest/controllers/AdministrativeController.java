package app.adapter.in.rest.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

import app.application.usecase.AdministrativeUseCase;
import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.builder.MedicalInsuranceBuilder;
import app.adapter.in.rest.request.PatientRequest;
import app.adapter.in.rest.request.InsuranceRequest;
import app.domain.model.Patient;
import app.domain.model.MedicalInsurance;
import app.application.exceptions.InputsException;
import app.application.exceptions.BusinessException;

@RestController
@RequestMapping("/api/administrative")
public class AdministrativeController {

    @Autowired private AdministrativeUseCase administrativeUseCase;
    @Autowired private PatientBuilder patientBuilder;
    @Autowired private MedicalInsuranceBuilder medicalInsuranceBuilder;

    @PostMapping("/patients")
    public ResponseEntity<?> registerPatient(@RequestBody PatientRequest req) {
        try {
            Patient p = patientBuilder.build(
                req.getDocument(), req.getFullName(), req.getBirthDate(), req.getGender(),
                req.getAddress(), req.getPhoneNumber(), req.getEmail(),
                req.getEmergencyFirstName(), req.getEmergencyLastName(),
                req.getRelationShip(), req.getEmergencyPhone(), null
            );
            administrativeUseCase.registerPatient(p);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/patients/{document}/insurance")
    public ResponseEntity<?> assignInsurance(@PathVariable int document, @RequestBody InsuranceRequest req) {
        try {
            MedicalInsurance mi = medicalInsuranceBuilder.build(
                req.getCompanyName(), req.getNumberPolicy(), req.getStatusPolicy(), req.getEndDatePolicy()
            );
            administrativeUseCase.assignInsurance(document, mi);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

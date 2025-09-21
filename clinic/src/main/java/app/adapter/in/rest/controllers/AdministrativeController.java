package app.adapter.in.rest.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

import app.application.usecase.AdministrativeUseCase;
import app.adapter.in.builder.PatientBuilder;
import app.adapter.in.builder.MedicalInsuranceBuilder;
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
    public ResponseEntity<?> registerPatient(
            @RequestParam String document,
            @RequestParam String fullName,
            @RequestParam String birthDate,
            @RequestParam String gender,
            @RequestParam String address,
            @RequestParam String phoneNumber,
            @RequestParam String email,
            @RequestParam String emergencyFirstName,
            @RequestParam String emergencyLastName,
            @RequestParam String relationShip,
            @RequestParam String emergencyPhone
    ) {
        try {
            Patient patient = patientBuilder.build(
                document, fullName, birthDate, gender, address, phoneNumber, email,
                emergencyFirstName, emergencyLastName, relationShip, emergencyPhone, null
            );
            administrativeUseCase.registerPatient(patient);
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
    public ResponseEntity<?> assignInsurance(
            @PathVariable int document,
            @RequestParam String companyName,
            @RequestParam String numberPolicy,
            @RequestParam String statusPolicy,
            @RequestParam String endDatePolicy
    ) {
        try {
            MedicalInsurance medicalInsurance = medicalInsuranceBuilder.build(
                companyName, numberPolicy, statusPolicy, endDatePolicy
            );
            administrativeUseCase.assignInsurance(document, medicalInsurance);
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

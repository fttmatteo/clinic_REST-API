package app.adapter.in.rest.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

import app.application.usecase.NurseUseCase;
import app.adapter.in.builder.VitalSignsBuilder;
import app.adapter.in.rest.request.VitalSignsRequest;
import app.domain.model.VitalSigns;
import app.application.exceptions.InputsException;
import app.application.exceptions.BusinessException;

@RestController
@RequestMapping("/api/nurse")
public class NurseController {

    @Autowired private NurseUseCase nurseUseCase;
    @Autowired private VitalSignsBuilder vitalSignsBuilder;

    @PostMapping("/vital-signs")
    public ResponseEntity<?> recordVitalSigns(@RequestBody VitalSignsRequest req) {
        try {
            VitalSigns v = vitalSignsBuilder.build(
                req.getPatientDocument(), req.getDate(), req.getBloodPressure(),
                req.getTemperature(), req.getPulse(), req.getOxygenSaturation()
            );
            nurseUseCase.recordVitalSigns(v);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/vital-signs/patient/{patientDocument}")
    public ResponseEntity<?> listVitalSignsByPatient(@PathVariable int patientDocument) {
        try {
            List<VitalSigns> list = nurseUseCase.listVitalSignsByPatient(patientDocument);
            return ResponseEntity.ok(list);
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

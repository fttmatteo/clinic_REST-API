package app.adapter.in.rest.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

import app.application.usecase.EmployeeUseCase;
import app.adapter.in.builder.EmployeeBuilder;
import app.adapter.in.rest.request.EmployeeRequest;
import app.domain.model.Employee;
import app.domain.services.DeleteEmployee;
import app.application.exceptions.InputsException;
import app.application.exceptions.BusinessException;

@RestController
@RequestMapping("/api/admin")
public class EmployeeController {

    @Autowired private EmployeeUseCase employeeUseCase;
    @Autowired private EmployeeBuilder employeeBuilder;
    @Autowired private DeleteEmployee deleteEmployee;

    @PostMapping("/employees/doctor")
    public ResponseEntity<?> createDoctor(@RequestBody EmployeeRequest req) {
        try {
            Employee e = employeeBuilder.build(
                req.getFullName(), req.getDocument(), req.getEmail(), req.getPhoneNumber(),
                req.getBirthDate(), req.getAddress(), req.getUsername(), req.getPassword()
            );
            employeeUseCase.createDoctor(e);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/employees/nurse")
    public ResponseEntity<?> createNurse(@RequestBody EmployeeRequest req) {
        try {
            Employee e = employeeBuilder.build(
                req.getFullName(), req.getDocument(), req.getEmail(), req.getPhoneNumber(),
                req.getBirthDate(), req.getAddress(), req.getUsername(), req.getPassword()
            );
            employeeUseCase.createNurse(e);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/employees/administrative")
    public ResponseEntity<?> createAdministrative(@RequestBody EmployeeRequest req) {
        try {
            Employee e = employeeBuilder.build(
                req.getFullName(), req.getDocument(), req.getEmail(), req.getPhoneNumber(),
                req.getBirthDate(), req.getAddress(), req.getUsername(), req.getPassword()
            );
            employeeUseCase.createAdministrative(e);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/employees/human-resources")
    public ResponseEntity<?> createHumanResources(@RequestBody EmployeeRequest req) {
        try {
            Employee e = employeeBuilder.build(
                req.getFullName(), req.getDocument(), req.getEmail(), req.getPhoneNumber(),
                req.getBirthDate(), req.getAddress(), req.getUsername(), req.getPassword()
            );
            employeeUseCase.createHR(e);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/employees/information-support")
    public ResponseEntity<?> createInformationSupport(@RequestBody EmployeeRequest req) {
        try {
            Employee e = employeeBuilder.build(
                req.getFullName(), req.getDocument(), req.getEmail(), req.getPhoneNumber(),
                req.getBirthDate(), req.getAddress(), req.getUsername(), req.getPassword()
            );
            employeeUseCase.createIS(e);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/employees/{document}")
    public ResponseEntity<?> deleteEmployeeByDocument(@PathVariable int document) {
        try {
            deleteEmployee.deleteByDocument(document);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}

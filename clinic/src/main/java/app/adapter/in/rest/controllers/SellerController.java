package app.adapter.in.rest.controllers;

import java.util.List;
import java.sql.Date;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.*;
import org.springframework.beans.factory.annotation.Autowired;

import app.application.usecase.SellerUseCase;
import app.adapter.in.builder.InvoiceBuilder;
import app.adapter.in.validators.InvoiceValidator;
import app.domain.model.Invoice;
import app.domain.model.ClinicalOrder;
import app.application.exceptions.InputsException;
import app.application.exceptions.BusinessException;

@RestController
@RequestMapping("/api/seller")
public class SellerController {

    @Autowired private SellerUseCase sellerUseCase;
    @Autowired private InvoiceBuilder invoiceBuilder;
    @Autowired private InvoiceValidator invoiceValidator;

    @PostMapping("/invoices")
    public ResponseEntity<?> createInvoice(
            @RequestParam String patientDocument,
            @RequestParam String doctorName,
            @RequestParam String serviceDescription,
            @RequestParam String totalService, 
            @RequestParam String invoiceDate   
    ) {
        try {
            Invoice invoice = invoiceBuilder.build(patientDocument, doctorName, serviceDescription);
            long total = invoiceValidator.totalServiceValidator(totalService);
            Date date = invoiceValidator.invoiceDateValidator(invoiceDate);
            sellerUseCase.createInvoice(invoice, total, date);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (InputsException ie) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ie.getMessage());
        } catch (BusinessException be) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(be.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/orders/patient/{patientDocument}")
    public ResponseEntity<?> findClinicalOrdersByPatient(@PathVariable int patientDocument) {
        try {
            List<ClinicalOrder> list = sellerUseCase.findClinicalOrdersByPatient(patientDocument);
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

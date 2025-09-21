package app.application.usecase;

import java.util.List;
import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalOrder;
import app.domain.model.Invoice;
import app.domain.ports.ClinicalOrderPort;
import app.domain.services.GenerateInvoice;

@Service
public class SellerUseCase {

    @Autowired
    private GenerateInvoice generateInvoice;

    @Autowired
    private ClinicalOrderPort clinicalOrderPort;

    public void createInvoice(Invoice invoice, long totalService, Date invoiceDate) throws Exception {
        generateInvoice.generate(invoice, totalService, invoiceDate);
    }

    public List<ClinicalOrder> findClinicalOrdersByPatient(int patientDocument) throws Exception {
        return clinicalOrderPort.findByPatient(patientDocument);
    }
}

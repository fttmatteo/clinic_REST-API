package app.domain.services;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.Invoice;
import app.domain.model.MedicalInsurance;
import app.domain.model.Patient;
import app.domain.ports.InvoicePort;
import app.domain.ports.PatientPort;

@Service
public class GenerateInvoice {

    @Autowired private PatientPort patientPort;
    @Autowired private InvoicePort invoicePort;

    public Invoice generate(Invoice invoice, long totalService,Date invoiceDate) throws Exception {
        Patient patient = patientPort.findByPatient(invoice.getPatientDocument());
        if (p == null) throw new app.application.exceptions.BusinessException("el paciente no existe");

        // Snapshot de datos del paciente
        invoice.setPatientName(p.getFullName());
        invoice.setPatientAge(calcAge(p.getBirthDate()));

        // Datos de la póliza (si existe y está activa)
        MedicalInsurance mi = p.getInsurancePolicy();
        boolean active = (mi != null && mi.isStatusPolicy());
        if (active) {
            invoice.setCompanyName(mi.getCompanyName());
            // en tu modelo numberPolicy es long
            invoice.setNumberPolicy(mi.getNumberPolicy());
            invoice.setEndDatePolicy(mi.getEndDatePolicy());
            // calcular días de vigencia restantes al momento de la factura
            invoice.setValidityDaysPolicy(daysBetween(invoiceDate, mi.getEndDatePolicy()));
        }

        long copay;
        long totalPatient;
        long totalInsurance;

        if (active) {
            copay = 50_000L;
            totalPatient = copay;
            totalInsurance = Math.max(0L, totalService - copay);
        } else {
            copay = totalService;
            totalPatient = totalService;
            totalInsurance = 0L;
        }

        invoice.setCopay(copay);
        invoice.setTotalPatient(totalPatient);
        invoice.setTotalInsurance(totalInsurance);

        return invoicePort.save(invoice);
    }

    private int calcAge(java.sql.Date birthDate) {
        if (birthDate == null) return 0;
        Calendar b = Calendar.getInstance(); b.setTime(birthDate);
        Calendar now = Calendar.getInstance();
        int age = now.get(Calendar.YEAR) - b.get(Calendar.YEAR);
        if (now.get(Calendar.DAY_OF_YEAR) < b.get(Calendar.DAY_OF_YEAR)) age--;
        return Math.max(age, 0);
    }

    private int daysBetween(java.sql.Date from, java.sql.Date to) {
        if (from == null || to == null) return 0;
        long ms = to.getTime() - from.getTime();
        return (int) Math.max(ms / (1000L*60*60*24), 0);
    }
}

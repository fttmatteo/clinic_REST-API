package app.domain.services;

import app.domain.model.Billing;
import app.domain.ports.BillingPort;

public class RegisterBilling {
    private final BillingPort billingPort;

    public RegisterBilling(BillingPort billingPort) {
        this.billingPort = billingPort;
    }

    public void register(Billing billing) throws Exception {
        if (billing.getId() == null || billing.getId().isEmpty()) {
            throw new Exception("El ID de la factura es obligatorio");
        }
        if (billing.getPatientId() == null || billing.getPatientId().isEmpty()) {
            throw new Exception("El paciente es obligatorio");
        }
        if (billing.getTotalAmount() <= 0) {
            throw new Exception("El monto de la factura debe ser mayor a 0");
        }

        Billing existing = billingPort.findById(billing.getId());
        if (existing != null) {
            throw new Exception("Ya existe una factura con este ID");
        }

        billingPort.save(billing);
    }
}

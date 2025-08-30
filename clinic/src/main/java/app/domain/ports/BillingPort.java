package app.domain.ports;

import app.domain.model.Billing;
import java.util.List;

public interface BillingPort {
    public Billing findById(String id) throws Exception;
    public List<Billing> findByPatient(String patientId) throws Exception;
    public void save(Billing billing) throws Exception;
}

package app.application.usecase;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.domain.model.ClinicalHistory;
import app.domain.model.ClinicalOrder;
import app.domain.model.OrderDiagnosticAidItem;
import app.domain.model.OrderMedicationItem;
import app.domain.model.OrderProcedureItem;
import app.domain.ports.ClinicalOrderPort;
import app.domain.services.AddOrderDiagnosticAidItem;
import app.domain.services.AddOrderMedicationItem;
import app.domain.services.AddOrderProcedureItem;
import app.domain.services.CreateClinicalOrder;
import app.domain.services.RecordClinicalHistory;

@Service
public class DoctorUseCase {

    @Autowired private CreateClinicalOrder createClinicalOrder;
    @Autowired private AddOrderMedicationItem addOrderMedicationItem;
    @Autowired private AddOrderProcedureItem addOrderProcedureItem;
    @Autowired private AddOrderDiagnosticAidItem addOrderDiagnosticAidItem;
    @Autowired private RecordClinicalHistory recordClinicalHistory;
    @Autowired private ClinicalOrderPort clinicalOrderPort;

    public void createOrder(ClinicalOrder clinicalOrder) throws Exception {
        createClinicalOrder.create(clinicalOrder);
    }

    public void addMedicationItem(OrderMedicationItem orderMedicationItem) throws Exception {
        addOrderMedicationItem.add(orderMedicationItem);
    }

    public void addProcedureItem(OrderProcedureItem orderProcedureItem) throws Exception {
        addOrderProcedureItem.add(orderProcedureItem);
    }

    public void addDiagnosticAidItem(OrderDiagnosticAidItem orderDiagnosticAidItem) throws Exception {
        addOrderDiagnosticAidItem.add(orderDiagnosticAidItem);
    }

    public void recordClinicalHistory(ClinicalHistory clinicalHistory) throws Exception {
        recordClinicalHistory.create(clinicalHistory);
    }

    public List<ClinicalOrder> findOrdersByPatient(int patientDocument) throws Exception {
        return clinicalOrderPort.findByPatient(patientDocument);
    }
}

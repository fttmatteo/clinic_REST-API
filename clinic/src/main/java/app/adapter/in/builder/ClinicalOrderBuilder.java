package app.adapter.in.builder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import app.adapter.in.validators.ClinicalOrderValidator;
import app.domain.model.ClinicalOrder;

@Component
public class ClinicalOrderBuilder {

    @Autowired private ClinicalOrderValidator validator;

    public ClinicalOrder build(
        String numberOrder,
        String patientDocument,
        String professionalDocument,
        String creationDate
    ) throws Exception {

        ClinicalOrder clinicalOrder = new ClinicalOrder();
        clinicalOrder.setId(validator.numberOrderValidator(numberOrder));
        clinicalOrder.setPatientDocument(validator.patientDocumentValidator(patientDocument));
        clinicalOrder.setDoctorDocument(validator.professionalDocumentValidator(professionalDocument));
        clinicalOrder.setDateCreation(validator.creationDateValidator(creationDate));
        return clinicalOrder;
    }
}

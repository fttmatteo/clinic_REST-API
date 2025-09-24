package app.adapter.in.builder;

import java.sql.Date;
import app.domain.model.ClinicalOrder;

public class ClinicalOrderBuilder {
    private Long numberOrder;
    private Integer patientDocument;
    private Integer doctorDocument;
    private Date creationDate;

    public ClinicalOrderBuilder withNumberOrder(Long v){ this.numberOrder = v; return this; }
    public ClinicalOrderBuilder withPatientDocument(Integer v){ this.patientDocument = v; return this; }
    public ClinicalOrderBuilder withDoctorDocument(Integer v){ this.doctorDocument = v; return this; }
    public ClinicalOrderBuilder withCreationDate(Date v){ this.creationDate = v; return this; }

    public ClinicalOrder build(){
        ClinicalOrder x = new ClinicalOrder();
        x.setNumberOrder(numberOrder);
        x.setPatientDocument(patientDocument);
        x.setDoctorDocument(doctorDocument);
        x.setCreationDate(creationDate);
        return x;
    }
}
